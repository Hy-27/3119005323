package com.yuyang.utilsTest;

import com.yuyang.utils.IOtext;
import com.yuyang.utils.Hamming;
import com.yuyang.utils.SimHash;

import org.junit.Test;


public class HammingTest {

    @Test
    public void testgetHammingDistance(){
        //��ȡ��Ӧ���ļ������ļ�������ת��Ϊ��Ӧ���ַ���
        String str0 = IOtext.read("D:\\�����ı�\\orig.txt");
        String str1 = IOtext.read("D:\\�����ı�\\orig_0.8_add.txt");
        //����Hamming����
        int distance = Hamming.getHammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("�������룺" + distance);
    }

    @Test
    public void testgetSimilarity(){
        //��ȡ��Ӧ���ļ������ļ�������ת��Ϊ��Ӧ���ַ���
        String str0 = IOtext.read("D:\\�����ı�\\orig.txt");
        String str1 = IOtext.read("D:\\�����ı�\\orig_0.8_add.txt");
        //�������ƶ�
        double similarity = Hamming.getSimilarity(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        System.out.println("orig.txt��orig_0.8_add.txt�����ƶ�:" + similarity);
    }
}
