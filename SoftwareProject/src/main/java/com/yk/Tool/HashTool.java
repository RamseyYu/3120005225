package com.yk.Tool;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

import com.hankcs.hanlp.HanLP;
import com.yk.Exception.ShortException;

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

        try{
            if(string.length() < 200) throw new ShortException("该文本过短！请更换更长的文本进行比对");
        }catch (ShortException e){
            e.printStackTrace();
            return null;
        }

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

            //判断文本自身重复度是否合理
            try{
                if(size < 5) throw new ShortException("该文本冗余过多或者文本过短！请修改文本再进行比对");
            }catch (ShortException e){
                e.printStackTrace();
                return null;
            }

            // 3、加权、合并
            for (int j = 0; j < v.length; j++) {
                // 对keywordHash的每一位与'1'进行比较
                if (keywordHash.charAt(j) == '1') {
                    v[j] += (5 - (i / (size / 5)));
                } else {
                    v[j] -= (5 - (i / (size / 5)));
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
