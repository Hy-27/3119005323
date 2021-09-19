package com.yuyang.utils;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

public class SimHash{

    /**
     * �����hashֵ
     * @param str
     * @return ����str��hashֵ
     */
    public static String getHash(String str){
        try{
            // ʹ��MD5���hashֵ
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }

    /**
     * ��ȡSimHashֵ
     * @param str
     * @return ����str��simHashֵ
     */
    public static String getSimHash(String str){
        // ��������,128λ,����Խ��λ��Խ��
        int[] vector = new int[128];
        // 1.�ִʣ�ʹ�����ⲿ����hankcs���ṩ�Ľӿڣ�
        List<String> keywordList = HanLP.extractKeyword(str, str.length());//ȡ�����йؼ���
        int size = keywordList.size();  //ȡ�ùؼ��ʴ���
        int i = 0;//��i�����ѭ��
        for(String keyword : keywordList){
            // 2.��ȡhashֵ
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < 128) {
                // ��hashֵ����128λʱ��0
                int sum = 128 - keywordHash.length();
                for (int j = 0; j < sum; j++) {
                    keywordHash += "0";
                }
            }
            // 3����Ȩ���ϲ�
            for (int k = 0; k < vector.length; k++) {
                // ��keywordHash��ÿһλ��'1'���бȽ�
                if (keywordHash.charAt(k) == '1') {
                    //Ȩ�ط�10�����ɴ�Ƶ�Ӹߵ��ͣ�ȡȨ��10~0
                    vector[k] += (10 - (i / (size / 10)));
                } else {
                    vector[k] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        // 4.��ά
        String simHash = "";// ���淵�ص�simHashֵ
        for (int t = 0; t < vector.length; t++) {
            //����
            if (vector[t] > 0) {
                simHash += "1";
            } else {
                simHash += "0";
            }
        }
        return simHash;
    }

}