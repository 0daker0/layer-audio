package com.layer.audio.utils;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * 加密工具
 *
 * @author cdyangyang18
 */

@UtilityClass
public class EncryptUtils {

    private final static Logger LOG= LoggerFactory.getLogger(EncryptUtils.class);

    /**
     * 用MD5算法进行加密
     *
     * @param str 需要加密的字符串
     * @return MD5加密后的结果
     */
    public static String md5(String str) {
        return encodeWithMethod(str, "md5");
    }

    /**
     * 用SHA算法进行加密
     *
     * @param str 需要加密的字符串
     * @return SHA加密后的结果
     */
    public static String sha(String str) {
        return encodeWithMethod(str, "sha");
    }

    public static String urlEncode(String key) {
        try {
            return URLEncoder.encode(key, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.error("EncryptKit Exception - UrlEncode", e);
            return "";
        }
    }

    public static String urlDncode(String key) {
        try {
            return URLDecoder.decode(key, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.error("EncryptKit Exception - UrlEncode", e);
            return "";
        }
    }

    /**
     * 加密服务
     *
     * @param str    需要加密的字符串
     * @param method 加密的方法
     * @return 加密后的字符串
     */
    private static String encodeWithMethod(String str, String method) {
        try {
            MessageDigest md = MessageDigest.getInstance(method);
            md.update(str.getBytes("UTF-8"));
            BigInteger bigInteger = new BigInteger(1, md.digest());
            StringBuilder hashText = new StringBuilder(bigInteger.toString(16));
            while (hashText.length() < 32) {
                hashText.insert(0, "0");
            }
            return hashText.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            LOG.error("EncryptKit Exception - encodeWithMethod", e);
        }
        return "";
    }

    /**
     * hashMacSha1 加密
     *
     * @param data      加密的数据
     * @param secretKey 密钥
     * @return 加密后的字符串
     */
    public static String hmacSHA1(String data, String secretKey) {
        try {
            byte[] decodedKey = secretKey.getBytes("UTF-8");
            SecretKeySpec keySpec = new SecretKeySpec(decodedKey, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(keySpec);
            byte[] dataBytes = data.getBytes("UTF-8");
            byte[] signatureBytes = mac.doFinal(dataBytes);
            return toHexString(signatureBytes);
        } catch (Exception e) {
            LOG.error("EncryptKit Exception - hashMacSha1", e);
            return "";
        }
    }

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static class Base64 {

        /**
         * 用base64算法进行加密
         *
         * @param str 需要加密的字符串
         * @return base64加密后的结果
         */
        public static String encode(String str) {
            String result = "";
            if (StringUtils.isNotEmpty(str)) {
                try {
                    result = java.util.Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    LOG.error("EncryptKit Exception - encode", e);
                }
            }
            return result;
        }

        /**
         * 用base64算法进行解密
         *
         * @param str 需要解密的字符串
         * @return base64解密后的结果
         */
        public static String decode(String str) {
            String result = "";
            if (StringUtils.isNotEmpty(str)) {
                try {
                    result = new String(java.util.Base64.getDecoder().decode(str));
                } catch (Exception e) {
                    LOG.error("EncryptKit Exception - decode", e);
                }
            }
            return result;
        }
    }

}
