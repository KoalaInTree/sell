package com.djcao.sell.encrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import com.google.common.collect.Lists;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/15
 */
public class RSAGeneratorUtil {

    private static final String RSA = "RSA";

     static ExecutorService executorService = new ThreadPoolExecutor(10, 20, 2000, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<>(50), (r, executor) -> {
        try {
            executor.getQueue().put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    public static void create(String privateKeyPath,String publicKeyPath)
        throws NoSuchAlgorithmException, IOException {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        keyPairGenerator.initialize(1024,secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey keyPairPrivate = keyPair.getPrivate();
        PublicKey keyPairPublic = keyPair.getPublic();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(publicKeyPath)));
        objectOutputStream.writeObject(keyPairPublic);
        objectOutputStream.flush();
        objectOutputStream.close();
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream(new File(privateKeyPath)));
        objectOutputStream1.writeObject(keyPairPrivate);
        objectOutputStream1.flush();
        objectOutputStream1.close();
    }

    private static int x = 1;
    public static void main(String[] args) throws ParseException {
        String date = "2018-10-10 10:10:10";
        String  ssss = date.substring(0,10)+" "+"11:11:11";
        System.out.println(ssss);
        //String time = "2004-07-02T00:00:00+08:00";
        //String pattern = "yyyy-MM-dd";
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //Date parse = simpleDateFormat.parse(time);
        //String now  = simpleDateFormat.format(parse);
        //System.out.println(now);
/*        String hotelName = "暗红色的客"
            + "户萨达可视"
            + "电话卡萨丁"
            + "我垃圾袋连我";
        if (hotelName.length() > 20){
            hotelName = hotelName.substring(0,17);
            hotelName += "...";
        }
        System.out.println(hotelName);

        System.out.println(JSON.toJSONStringWithDateFormat(new Date(),"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat));
        System.out.println((new Date()).toString());*/
        for (int i = 0;i<100;i++){
            executorService.execute(() -> {
                int increment = increment();
                System.out.println(increment);
            });
        }
    }

    public static int increment(){
        return x ++;
    }
}
