package com.djcao.sell.zk;

import java.util.List;
import java.util.Random;

import javax.swing.event.HyperlinkEvent.EventType;

import com.alibaba.fastjson.JSON;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/1/29
 */

public class zkClientTest {
    private final static String hosts = "10.63.98.153:2181";
    @Test
    public void testCreate() {
        ZkClient zk = init();
        zk.delete("/test2");
        String path = "/test2";
        try {
            zk.subscribeStateChanges(new IZkStateListener() {
                @Override
                public void handleStateChanged(KeeperState state) throws Exception {
                    System.out.println("*************");
                    System.out.println(KeeperState.fromInt(state.getIntValue()));
                    System.out.println("*************");
                }

                @Override
                public void handleNewSession() throws Exception {
                    System.out.println("new session");
                }
            });
            zk.subscribeDataChanges("/test2", new IZkDataListener() {
                @Override
                public void handleDataChange(String dataPath, Object data) throws Exception {
                    System.out.println("##################");
                    System.out.println("change="+dataPath);
                    System.out.println("##################");
                }

                @Override
                public void handleDataDeleted(String dataPath) throws Exception {
                    System.out.println("##################");
                    System.out.println("delete="+dataPath);
                    System.out.println("##################");
                }
            });
            zk.createEphemeral(path, "hi,zookeeper");
            zk.delete(path);
        }catch (Exception ex){
            while (true){
                try {
                    boolean exists = zk.exists(path);
                    if (exists){
                        //watch
                    }
                    zk.createEphemeral(path, "hi,zookeeper");
                }catch (Exception e){

                }

            }
        }
        System.out.println("create test node, path=" + path);
        if (zk.exists(path)){
            System.out.println("zk exists path,path="+path);
            Object readData = zk.readData(path);
            System.out.println(String.format("get zk path(%s)'s data = %s",path, JSON.toJSONString(readData)));
            String childPath = zk.createPersistentSequential(path+"/child", "hello,i'm child");
            List<String> children = zk.getChildren(path);
            System.out.println(String.format("the path(%S) 's children list = $s",path,JSON.toJSONString(children)));
        }
    }

    private ZkClient init(){
        return new ZkClient(hosts,30000,30000);
    }

    public void testWatch(){
        ZkClient zk = init();
        String value = String.valueOf(generateRandom());
        String path = zk.createEphemeralSequential("/test-lock", value);

    }

    public int generateRandom(){
        Random random = new Random(47);
        return random.nextInt();
    }
}
