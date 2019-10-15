package com.wxpay.api.internal.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.Security;
import java.util.Base64;

/**
 * @Description: AES/ECB/PKCS7Padding 解密 为微信退款通知
 * @Author ajoe
 * @Date 2019/10/15 11:24
 */
public class AESUtil {

    private static final String UTF_8 = "UTF-8";
    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS7Padding";
    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    /**
     * AES解密
     * @param base64Data
     * @param lowerMd5Key
     * @return UTF-8编码的字符串
     * @throws Exception
     */
    public static String decryptData(String base64Data,String lowerMd5Key) throws Exception {
        SecretKeySpec key = new SecretKeySpec(lowerMd5Key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        try{
            cipher.init(Cipher.DECRYPT_MODE, key);
        }catch (InvalidKeyException e){
            System.err.println("尝试解决：下载对应JDK版本的Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files,JCE 8的下载地址:https://www.oracle.com/java/technologies/jce8-downloads.html,替换local_policy.jar 和 US_export_policy.jar到%jre%/lib/security");
            throw e;
        }
        return new String(cipher.doFinal(Base64.getDecoder().decode(base64Data)), UTF_8);
    }
    private static String md5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes(UTF_8));
        StringBuilder sb = new StringBuilder();
        byte[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            byte item = var4[var6];
            sb.append(Integer.toHexString(item & 255 | 256).substring(1, 3));
        }

        return sb.toString().toLowerCase();
    }

    public static void main(String[] args) throws Exception {
        String a = "s7JyYfGc3kz3vKHonrmZZ0cWy8MKNpYBZDynbWZSYsHuqgAIsCs7MhOr0LcFY4PzSKrRGnDN9bRXjcejcDxvrhC6wyo9nVz/imgouy6XUSCQqcFC29gqeo87ZZgjWP2YFzNkVEpzqHuDTpc72s66TFWwZN+ZZUxpVaUHJXFGUTkJQ1zS23nzU4riKkqfiuFbjpffT4btSIFS4Bboca25kZnax0f2wBbHJIgaJ0nmFm4vb2ychaUsxue24VU3oXYPVZ7vx0TMHXQhddr/9rTAI+EmdD9FUqBClzFe1WzVTyGl028UGWnNIKyXPcE5YwAxG4SRFgJ33z/1JIoCNgqu/6B1McJEqJhd7+hhLJIf6LOY5aka9n8SBcXN1XF7gJx7f1HN++DpaLgHJ/ClnnIhfCRlpmsDkuDoZMu/swNQQ1oPWGHW2/Lg3qRrhrnjerzncs6jUIr3H7HKanDN8Sz769c+FgkUHKU4bSY6ssZDal79wRaATWYQE9qv1eD/jj+zB9YWbKI5RE2jlySCrIzdt0xZ7mWLi0AA7FVbPnQPSDSUE1SJSYOkAFlcE+7eWsm1ZSGcL5BWG0eRB+VkXpROwyxVOamTDsYVuUKyAFKmGEeGi1RIrnY2snRosr/RciG6oa0Xc/MWGAR+jxP7KbwGOW5NjoUI9mZUpAyodiGCpe1CKCEikzEz+OLIYy+gR9K2DjLusFKzPcKW83FOdUlUSwP+AgjgNq7OJGiqmhagyLkGN6UzvBbJy0+34mUYE6uy9+gBCEIjzIQ/9RvDHQGaYLIIqk/EyIvC8UgVElihD7Ci4Szbg5bzqZMkLXSakE9XyznnG9H0yE+Y4k8Szg128qdatHGpRKgmuGHkdG9QKIhson3P3jfcV+QhXhQO3Sxnh6EJK+pCNHLc/iSr6OxwxwklEGfWyGCS3ttbsxG3ZIFTMlITQ2U14pOvLi4UVl8aoRGvEMoJQDE0FAL/flagxEE216zP6SmEtFw/qkn2sdqfGi/wFDNhhfL4m8Laqc8ygqUKyAbAC/CG2Cu713Qpvs2kdoL+23uUAIsAKYeNNdk7gNPQYwtOPmx4kQdE7BoUsm5oSoSvVZm1HGgWXGH4+g==";
        String ab = AESUtil.decryptData(a,AESUtil.md5("mch秘钥"));
        System.out.println(ab);
    }
}
