package com.djcao.sell.zk.zkreadwritelock;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import lombok.Getter;
import org.I0Itec.zkclient.IZkDataListener;
import org.apache.commons.lang3.StringUtils;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/5/13
 */
public class ZKLock implements IZKLock{

    private MyZkClient client;
    private String lockPath;
    public ZKLock(String hostUrl,String lockPath) {
        if (client == null){
            synchronized (ZKLock.class){
                if (client == null){
                    client = new MyZkClient(hostUrl);
                    this.lockPath = lockPath;
                    if (!client.exists(lockPath)){
                        client.createPersistent(lockPath);
                    }
                }
            }
        }
    }

    private static String apply(String o) {return o.split("-")[1];}

    @Override
    public ZKNode getReadLock() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String lockPrefix = lockPath + "/" + LockTypeEnum.READ.getLockType() + "-";
        String lockName = client.createEphemeralSequential(lockPrefix, System.currentTimeMillis());
        Integer lockIndex = Integer.parseInt(lockName.split("/")[2].split("-")[1]);
        A1:
        while (true){
            List<String> children = client.getChildren(lockPath);
            sort(children);
            children.forEach(System.out::println);
            for (int i = children.size() - 1 ; i >= 0 ; i--){
                if (LockTypeEnum.WRITR.getLockType().equals(children.get(i).split("-")[0])
                    && Integer.parseInt(children.get(i).split("-")[1] ) < lockIndex){
                    try {
                        client.subscribeChildChanges((lockPath + "/" + children.get(i)),((parentPath, currentChilds) -> countDownLatch.countDown()));
                    }catch (Exception ex){
                        ex.printStackTrace();
                        continue A1;
                    }
                    countDownLatch.await();
                }
            }
            break;
        }

        return new ZKNode(lockName);
    }

    public ZKNode getWriteLock() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String lockPrefix = lockPath + "/" + LockTypeEnum.WRITR.getLockType() + "-";
        String lockName = client.createEphemeralSequential(lockPrefix, System.currentTimeMillis());
        Integer lockIndex = Integer.parseInt(lockName.split("/")[2].split("-")[1]);
        A1:
        while (true){
            List<String> children = client.getChildren(lockPath);
            sort(children);
            children.forEach(System.out::println);
            for (int i = children.size() - 1 ; i >= 0 ; i--){
                if (Integer.parseInt(children.get(i).split("-")[1] ) == lockIndex){
                    if (i == 0){
                        break;
                    }
                    try {
                        client.subscribeChildChanges((lockPath + "/" + children.get(i - 1)), (parentPath, currentChilds) -> countDownLatch.countDown());
                    }catch (Throwable throwable){
                        throwable.printStackTrace();
                        continue A1;
                    }
                    countDownLatch.await();
                }
            }
            break ;
        }

        return new ZKNode(lockName);
    }

    @Override
    public boolean releaseLock(ZKNode zkNode) {
        if (zkNode != null && StringUtils.isNotBlank(zkNode.getLockName()) && lockPath.contains(zkNode.getLockName().split("/")[2])){
            if (client.exists(zkNode.getLockName())){
                return client.delete(zkNode.getLockName());
            }
        }
        return true;
    }

    @Getter
    public enum LockTypeEnum{
        READ("READ"),
        WRITR("WRITE");
        private String lockType;

        LockTypeEnum(String lockType) {
            this.lockType = lockType;
        }
    }

    private void sort(List<String> nodeList){
        nodeList.sort(Comparator.comparing(ZKLock::apply));
    }

    public static void main(String[] args) {
        ZKLock zkLock = new ZKLock("192.168.79.138:2181","/lock");
        try {
            ZKNode readLock = zkLock.getReadLock();
            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean c = zkLock.releaseLock(readLock);
                System.out.println("release read lock,result="+c);
            }).start();
            new Thread(() -> {
                try {
                    ZKNode writeLock = zkLock.getWriteLock();
                    System.out.println("我获取到了锁");
                    boolean b = zkLock.releaseLock(writeLock);
                    System.out.println("我释放了写锁："+b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }
}
