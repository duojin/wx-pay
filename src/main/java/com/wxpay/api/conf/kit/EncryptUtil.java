package com.wxpay.api.conf.kit;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @author Administrator
 *
 */
public class EncryptUtil{
     
    public static void main(String ...arg){
        String plaintext = "aaa";
        String key = "cscc#";
        String ciphertext = "";
        
        System.out.println("--AES--");
        ciphertext = EncryptUtil.getInstance().AESencode(plaintext,key);
        System.out.println(ciphertext);
        //System.out.println(EncryptUtil.getInstance().AESdecode(ciphertext, key));
 
    }
 
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String HmacMD5 = "HmacMD5";
    public static final String HmacSHA1 = "HmacSHA1";
    public static final String DES = "DES";
    public static final String AES = "AES";
 
    /**编码格式；默认null为GBK*/
    public String charset = null;
    /**DES*/
    public int keysizeDES = 0;
    /**AES*/
    public int keysizeAES = 128;
    public static EncryptUtil me;
 
    private EncryptUtil(){
        //单例
    }
 
    public static EncryptUtil getInstance(){
        if (me==null) {
            me = new EncryptUtil();
        }
        return me;
    }
    
    /**使用KeyGenerator双向加密，DES/AES，注意这里转化为字符串的时候是将2进制转为16进制格式的字符串，不是直接转，因为会出错*/
    private String keyGeneratorES(String res,String algorithm,String key,int keysize,boolean isEncode){
        try {
            KeyGenerator kg = KeyGenerator.getInstance(algorithm);
            if (keysize == 0) {
                byte[] keyBytes = charset==null?key.getBytes():key.getBytes(charset);
                kg.init(new SecureRandom(keyBytes));
            }else if (key==null) {
                kg.init(keysize);
            }else {
                byte[] keyBytes = charset==null?key.getBytes():key.getBytes(charset);
                kg.init(keysize, new SecureRandom(keyBytes));
            }
            SecretKey sk = kg.generateKey();
            SecretKeySpec sks = new SecretKeySpec(sk.getEncoded(), algorithm);
            Cipher cipher = Cipher.getInstance(algorithm);
            if (isEncode) {
                cipher.init(Cipher.ENCRYPT_MODE, sks);
                byte[] resBytes = charset==null?res.getBytes():res.getBytes(charset);
                return parseByte2HexStr(cipher.doFinal(resBytes));
            }else {
                cipher.init(Cipher.DECRYPT_MODE, sks);
                return new String(cipher.doFinal(parseHexStr2Byte(res)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   
    /**将二进制转换成16进制 */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);  
            if (hex.length() == 1) {
                hex = '0' + hex;  
            }
            sb.append(hex.toUpperCase());  
        }
        return sb.toString();  
    }
    /**将16进制转换为二进制*/
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
            result[i] = (byte) (high * 16 + low);  
        }
        return result;  
    }
 
    public String DESencode(String res, String key) {
        return keyGeneratorES(res, DES, key, keysizeDES, true);
    }
 
    
    public String DESdecode(String res, String key) {
        return keyGeneratorES(res, DES, key, keysizeDES, false);
    }
 
    
    public String AESencode(String res, String key) {
        return keyGeneratorES(res, AES, key, keysizeAES, true);
    }
 
    
    public String AESdecode(String res, String key) {
        return keyGeneratorES(res, AES, key, keysizeAES, false);
    }
 
    
    public String XORencode(String res, String key) {
        byte[] bs = res.getBytes();
        for (int i = 0; i < bs.length; i++) {
            bs[i] = (byte) ((bs[i]) ^ key.hashCode());
        }
        return parseByte2HexStr(bs);
    }
 
    
    public String XORdecode(String res, String key) {
        byte[] bs = parseHexStr2Byte(res);
        for (int i = 0; i < bs.length; i++) {
            bs[i] = (byte) ((bs[i]) ^ key.hashCode());
        }
        return new String(bs);
    }
 
    
    public int XOR(int res, String key) {
        return res ^ key.hashCode();
    }
     
}
