package com.yk.Tool;

import java.math.BigInteger;
import java.security.MessageDigest;

public class HashTool {
    /*

     * @param String 用以计算的字符串
     * @description: 传入字符串，根据MD5算法计算得出哈希值
     * @author:      yk
     * @return:      String形式的哈希值
    */

    public static String getHash(String string) {
        try{
            //使用MD5算法获取该字符串的哈希值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(string.getBytes("UTF-8"))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return string;
        }
    }
}
