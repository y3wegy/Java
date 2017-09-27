package com.algorithm;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShortUrl {

    private static final Logger logger = Logger.getLogger(ShortUrl.class);
    final String[] dic = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "field", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3",
            "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};
    /**
     * @param args
     */
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ShortUrl su = new ShortUrl();
        logger.info(su.generate("http://sports.sina.com.cn/nba"));
    }

    public String generate(String keyword) throws NoSuchAlgorithmException, UnsupportedEncodingException {



        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        md5Digest.reset();
        md5Digest.update(keyword.getBytes("UTF-8"));
        byte[] encryptedTextBytes = md5Digest.digest();
        if(ArrayUtils.isEmpty(encryptedTextBytes)){
            return null;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            String hex1 = Integer.toHexString(0xff & encryptedTextBytes[i * 2]);
            String hex2 = Integer
                    .toHexString(0xff & encryptedTextBytes[i * 2 + 1]);

            hex1 = hex1.length() == 1 ? "0" + hex1 : hex1;
            hex2 = hex2.length() == 1 ? "0" + hex2 : hex2;
            int index = (int) Long.parseLong(hex1 + hex2, 16)
                    % dic.length;
            result.append(dic[index]);
        }

        return result.toString();
    }
}