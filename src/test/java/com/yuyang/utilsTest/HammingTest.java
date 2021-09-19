package com.yuyang.utilsTest;

import com.yuyang.utils.IOtext;
import com.yuyang.utils.Hamming;
import com.yuyang.utils.SimHash;

import org.junit.Test;


public class HammingTest {

    @Test
    public void testgetHammingDistance(){
        //读取对应的文件，将文件的内容转化为对应的字符串
        String str0 = IOtext.read("D:\\测试文本\\orig.txt");
        String str1 = IOtext.read("D:\\测试文本\\orig_0.8_add.txt");
        //计算Hamming距离
        int distance = Hamming.getHammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("海明距离：" + distance);
    }

    @Test
    public void testgetSimilarity(){
        //读取对应的文件，将文件的内容转化为对应的字符串
        String str0 = IOtext.read("D:\\测试文本\\orig.txt");
        String str1 = IOtext.read("D:\\测试文本\\orig_0.8_add.txt");
        //计算相似度
        double similarity = Hamming.getSimilarity(SimHash.getSimHash(str0),SimHash.getSimHash(str1));
        System.out.println("orig.txt和orig_0.8_add.txt的相似度:" + similarity);
    }
}
