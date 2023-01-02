package com.access.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

public class AccessUtils {

    public static String loginCtxDecrypt(String tenantName, String attrDecryptValue) throws Exception {
        String attrDecrypt = attrDecryptValue;
        final String SHA_256_ALG = "SHA-256";
        final String ENCRYPTION_ALG = "AES/CBC/PKCS5Padding";
        final String SECRET_KEY_ALG = "AES";
        String data = null;
        MessageDigest md = null;
        byte[] keyBytes = new byte[16];
        try {
            md = MessageDigest.getInstance(SHA_256_ALG);
            byte[] digest = md.digest(tenantName.toLowerCase().getBytes("UTF-8"));
            System.arraycopy(digest, 0, keyBytes, 0, 16);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        Cipher decipher = null;
        try {
            decipher = Cipher.getInstance(ENCRYPTION_ALG);
            SecretKey secretKey = new SecretKeySpec(keyBytes, SECRET_KEY_ALG);
            decipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(new byte[16]));
            byte[] decryptedData = decipher.doFinal(Base64.getDecoder().decode(attrDecrypt.getBytes("UTF-8")));
            data = new String(decryptedData);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            throw new Exception();
        }
        return data;
    }

    public static String errorCtxDecrypt(String tenantName, String attrDecryptValue) throws Exception {
        String attrDecrypt = attrDecryptValue;
        final String SHA_256_ALG = "SHA-256";
        final String ENCRYPTION_ALG = "AES/CBC/PKCS5Padding";
        final String SECRET_KEY_ALG = "AES";
        String data = null;
        MessageDigest md = null;
        byte[] keyBytes = new byte[16];
        try {
            md = MessageDigest.getInstance(SHA_256_ALG);
            byte[] digest = md.digest(tenantName.toLowerCase().getBytes("UTF-8"));
            System.arraycopy(digest, 0, keyBytes, 0, 16);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        // encrypt the data
        Cipher decipher = null;
        try {
            decipher = Cipher.getInstance(ENCRYPTION_ALG);
            SecretKey secretKey = new SecretKeySpec(keyBytes, SECRET_KEY_ALG);
            decipher.init(Cipher.DECRYPT_MODE,
                    secretKey, new IvParameterSpec(new byte[16]));
            byte[] decryptedData = decipher.doFinal(Base64.getDecoder().decode(attrDecrypt.getBytes("UTF-8")));
            data = new String(decryptedData);
            System.out.println("" + data);        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return data;
    }

}
