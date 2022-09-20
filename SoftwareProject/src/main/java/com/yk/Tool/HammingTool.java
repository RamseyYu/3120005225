package com.yk.Tool;

public class HammingTool {

    /*

     * @param simHash值
     * @description: 根据simHash值，计算海明距离
     * @author:      yk
     * @return:      海明距离distance
    */

    public static int getHammingDistance(String simHash1, String simHash2) {
        int distance = 0;
        if (simHash1.length() != simHash2.length()) {
            // 出错，返回-1
            distance = -1;
        } else {
            for (int i = 0; i < simHash1.length(); i++) {
                // 每一位进行比较
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    distance++;
                }
            }
        }
        return distance;
    }

    /*

     * @param simHash值
     * @description: 先通过传入的simHash值计算出海明距离，再由海明距离计算出相似度
     * @author:      yk
     * @return:      相似度similarity
    */

    public static double getSimilarity(String simHash1, String simHash2) {
        // 通过 simHash1 和 simHash2 获得它们的海明距离
        int distance = getHammingDistance(simHash1, simHash2);
        int intersection = simHash1.length() - distance;
        int union = distance + simHash1.length();
        double similarity = 0.01 * (100 * intersection / union);
        // 通过海明距离计算出相似度，并返回
        return  similarity;


    }
}
