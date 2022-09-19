package com.yk.Tool;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import com.hankcs.hanlp.HanLP;

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

    /*

     * @param String 待处理的文本字符串
     * @description: 根据词频的不同，对词语的哈希值分别进行加权再相加，之后将大于0的位取1，小于0的位取0，得到simhash值
     * @author:      yk
     * @return:      String simhash值
    */

    public static String getSimHash(String string){

        // 用数组表示特征向量,取128位,从 0 1 2 位开始表示从高位到低位
        int[] v = new int[128];
        // 1、分词
        List<String> keywordList = HanLP.extractKeyword(string, string.length());//取出所有关键词

        int size = keywordList.size();
        int i = 0;//以i做外层循环
        for(String keyword : keywordList){
            // 2、获取hash值
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < 128) {
                // hash值可能少于128位，在低位以0补齐
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) {
                    keywordHash += "0";
                }
            }
            // 3、加权、合并
            for (int j = 0; j < v.length; j++) {
                // 对keywordHash的每一位与'1'进行比较
                if (keywordHash.charAt(j) == '1') {
                    //权重分10级，由词频从高到低，取权重10~0
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        // 4、降维
        String simHash = "";// 储存返回的simHash值
        for (int j = 0; j < v.length; j++) {
            // 从高位遍历到低位
            if (v[j] <= 0) {
                simHash += "0";
            } else {
                simHash += "1";
            }
        }
        return simHash;
    }
}
