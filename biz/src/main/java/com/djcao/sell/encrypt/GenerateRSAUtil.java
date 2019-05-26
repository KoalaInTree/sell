package com.djcao.sell.encrypt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/10/11
 */
public class GenerateRSAUtil {

    private static final String ALGORITHM = "RSA";

    private static final int initSize = 1024;

    public static void generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);

        keyPairGenerator.initialize(initSize);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        System.out.println("publickey:"+ new BASE64Encoder().encode(publicKey.getEncoded()));
        System.out.println();
        System.out.println("privatekey:"+ new BASE64Encoder().encode(privateKey.getEncoded()));
    }

    public static PublicKey loadPublicKeyByStr(String publicKeyStr)
        throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
        byte[] decode = (new BASE64Decoder()).decodeBuffer(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decode);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    public static PrivateKey loadPrivateKeyByStr(String privateKeyStr)
        throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        byte[] decode = (new BASE64Decoder()).decodeBuffer(privateKeyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decode);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static String  encrypt(String source)
        throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException,
        BadPaddingException, IllegalBlockSizeException, IOException {

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        PublicKey publicKey = loadPublicKeyByStr(GenerateRSAUtil.publicKey);
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] bytes = cipher.doFinal(source.getBytes());
        return new BASE64Encoder().encode(bytes);
    }

    public static String decrypt(String source)
        throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException,
        BadPaddingException, IllegalBlockSizeException, IOException {
        //Cipher cipher = Cipher.getInstance(ALGORITHM);
        //PrivateKey privateKey = loadPrivateKeyByStr(GenerateRSAUtil.privateKey);
        //cipher.init(Cipher.DECRYPT_MODE,privateKey);
        //byte[] bytes = cipher.doFinal(source.getBytes());
        byte[]data = source.getBytes();
         byte[] keyBytes = Base64.decodeBase64(privateKey.getBytes());
         PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
         KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
         Key key = keyFactory.generatePrivate(pKCS8EncodedKeySpec);
         // 解密数据，分段解密
         Cipher cipher = Cipher.getInstance(ALGORITHM);
         cipher.init(Cipher.DECRYPT_MODE, key);
         int inputLength = data.length;
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         int offset = 0;
         byte[] cache;
         int i = 0;
         byte[] tmp;
         while (inputLength - offset > 0) {
         if (inputLength - offset > 100) {
         cache = cipher.doFinal(data, offset, 100);
         } else {
         cache = cipher.doFinal(data, offset, inputLength - offset);
         }
         //            out.write(cache, 0, cache.length);
         out.write(cache);
         i++;
         offset = i * 100;
         }
         byte[] decryptedData = out.toByteArray();
         out.close();
         return new BASE64Encoder().encode(decryptedData);


        //return new BASE64Encoder().encode(bytes);
    }

    public static void main(String[] args)
        throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException,
        InvalidKeySpecException, NoSuchPaddingException, IOException {
        //generateKeyPair();
        String s = "i m  aaaa";
        String encrypt = encrypt(s);
        System.out.println("加密后:"+encrypt);
        String decrypt = decrypt(s);
        System.out.println(decrypt);
    }


    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCU"
        + "/KYiblmvWVnKJhlZ7BuOAqD62NZrF0486HyC"
        + "4o08iaVuitBXRQmn8R74P6PeyiRlTsjM0JZBTLLazBjGPDUBGPCanmTUO28aYaBBJqMQi0qjrA1D"
        + "hQFMSfPdjKBnvwe/m60Mst8nKUnAzWkWXakCcERPyCiEtn74+f6RTS0PyQIDAQAB";

    private static final String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJT8piJuWa9ZWcomGVnsG44CoPrY\n"
        + "1msXTjzofILijTyJpW6K0FdFCafxHvg/o97KJGVOyMzQlkFMstrMGMY8NQEY8JqeZNQ7bxphoEEm"
        + "oxCLSqOsDUOFAUxJ892MoGe/B7+brQyy3ycpScDNaRZdqQJwRE/IKIS2fvj5/pFNLQ/JAgMBAAEC"
        + "gYBAb/mG4MVnYrTECrBiRQ0x4Y8wj0JFtSHAlCjuDwBZE4t6gQ1VAWYIve/QHO5KOJF/Q5DzjK+/"
        + "9GVS3n1El9uwQZt6OuN+htB7/MxwQmhPbrVDdSaBS2PiU56rtFxZG2fH14T4eqTTDMVzwT/13uIe"
        + "NPn4/cMLMhYfHjyo3N62pQJBAM7Up2C985ekk9i5SqZJutTasRSmGzxvdciWhg7K72XFAHtbiB/Q"
        + "ZsoRqDz0kx9LugGRmaKfoIP0dhcIbyTpjBsCQQC4Z7n+0loMaaw2QmqFugTvH0j+JYC4uy/gk1Rg"
        + "F6iGe5tuRYrBafke+RZBQDNg+TZXYH9TzZzv5zpCq8srXYnrAkAFBJfC+xjL1wxXN7ed7TABNgUR"
        + "0S3b+4BKC4zZEwdX2r22QHQ/AVldEayZPf3LxpSOsS+fCGxmhynOSUAZDyl9AkAR7St8pTBR0pgG"
        + "MlCurVW7dTwgUL8BtljCKTBjowkkAbIrdyE1CjtIkohiUX5tJ+zrc5sNJ4jhHYZhYtf+YDp/AkA0"
        + "6uzWOwtu/e6jOqxvCpu5ElpNHjWFWcCtXpFKr3c0B44vFUuGkCpPgSOWpzEkWacuEWDsCcX+Pkr2"
        + "qZ8tG9f6";
}
