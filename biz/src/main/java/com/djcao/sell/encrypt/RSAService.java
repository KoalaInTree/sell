package com.djcao.sell.encrypt;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.WeakHashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/15
 */
public class RSAService {

    private static final String RSA = "RSA";
    private Key privateKey;
    private Key publicKey;
    private static final int MAX_ENCODE_LENGTH = 117;
    private static final int MAX_DECODE_LENGTH = 50;

    /**
     * rsa加解密时用到的公钥和私钥
     * @param privateKeyPath 私钥
     * @param publicKeyPath 公钥
     */
    public void init(String privateKeyPath,String publicKeyPath) throws IOException, ClassNotFoundException {

        ObjectInputStream privateKeyOIS = new ObjectInputStream(new FileInputStream(new File(privateKeyPath)));
        privateKey = (Key)privateKeyOIS.readObject();
        privateKeyOIS.close();

        ObjectInputStream publicKeyOIS = new ObjectInputStream(new FileInputStream(new File(publicKeyPath)));
        publicKey = (Key)publicKeyOIS.readObject();
        publicKeyOIS.close();
    }

    /**
     * RSA加密
     * @param source  原始数据
     * @return 加密后的数据
     */
    public byte[] encode(byte[] source)
        throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
        IllegalBlockSizeException, IOException {

        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] cache;
        int offset = 0;
        int i = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while (source.length - offset > 0){
            if (source.length - offset > MAX_ENCODE_LENGTH){
                cache = cipher.doFinal(source,offset,MAX_ENCODE_LENGTH);
            }else {
                cache = cipher.doFinal(source,offset,source.length-offset);
            }
            out.write(cache,0,cache.length);
            i++;
            offset = i * MAX_ENCODE_LENGTH;
        }
        byte[] byteArray = out.toByteArray();
        out.flush();
        out.close();
        return byteArray;
    }

    public byte[] decode(byte[] encryptData)
        throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
        IllegalBlockSizeException, IOException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);

        int offset = 0;
        int i = 0;
        byte[] cache;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while (encryptData.length - offset > 0 ){
            if (encryptData.length - offset > MAX_DECODE_LENGTH){
                cache = cipher.doFinal(encryptData,offset,MAX_DECODE_LENGTH);
            }else {
                cache = cipher.doFinal(encryptData,offset,encryptData.length - offset);
            }
            out.write(cache,0,cache.length);
            i++;
            offset = i * MAX_DECODE_LENGTH;
        }
        byte[] byteArray = out.toByteArray();
        out.flush();
        out.close();
        return byteArray;
    }

    public String encryptString(String encryptStr)
        throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException,
        InvalidKeyException, IOException {
        byte[] encode = encode(encryptStr.getBytes());
        return Base64.encodeBase64String(encode);
    }

    public String decryptString(String decryptStr)
        throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException,
        InvalidKeyException, IOException {
        byte[] decode = decode(decryptStr.getBytes());
        return Base64.encodeBase64String(decode);
    }

    public static void main(String[] args) throws Exception {
        RSAService service = new RSAService();
        String privateKeyPath = "D:\\privateKey.store";
        String publicKeyPath = "D:\\publicKey.store";
        RSAGeneratorUtil.create(privateKeyPath,publicKeyPath);
        service.init(privateKeyPath,publicKeyPath);
        String data = "hello rsa";
        String encryptString = service.encryptString(data);
        System.out.println("这是加密后的字符串:"+encryptString);

        data = "hello rsa";
        encryptString = service.encryptString(data);
        System.out.println("这是加密后的字符串:"+encryptString);
        String decryptString = service.decryptString(encryptString);
        System.out.println("这个是解密后的字符串:"+decryptString);
    }
}
