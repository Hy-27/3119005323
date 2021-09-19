package com.yuyang.utils;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

public class SimHash{

    /**
     * 计算出hash值
     * @param str
     * @return 返回str的hash值
     */
    public static String getHash(String str){
        try{
            // 使用MD5获得hash值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }

    /**
     * 获取SimHash值
     * @param str
     * @return 返回str的simHash值
     */
    public static String getSimHash(String str){
        // 特征向量,128位,数字越大位数越低
        int[] vector = new int[128];
        // 1.分词（使用了外部依赖hankcs包提供的接口）
        List<String> keywordList = HanLP.extractKeyword(str, str.length());//取出所有关键词
        int size = keywordList.size();  //取得关键词词数
        int i = 0;//以i做外层循环
        for(String keyword : keywordList){
            // 2.获取hash值
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < 128) {
                // 当hash值少于128位时补0
                int sum = 128 - keywordHash.length();
                for (int j = 0; j < sum; j++) {
                    keywordHash += "0";
                }
            }
            // 3、加权、合并
            for (int k = 0; k < vector.length; k++) {
                // 对keywordHash的每一位与'1'进行比较
                if (keywordHash.charAt(k) == '1') {
                    //权重分10级，由词频从高到低，取权重10~0
                    vector[k] += (10 - (i / (size / 10)));
                } else {
                    vector[k] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        // 4.降维
        String simHash = "";// 储存返回的simHash值
        for (int t = 0; t < vector.length; t++) {
            //遍历
            if (vector[t] > 0) {
                simHash += "1";
            } else {
                simHash += "0";
            }
        }
        return simHash;
    }

}