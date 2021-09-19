package com.yuyang.utilsTest;

import com.yuyang.utils.IOtext;
import com.yuyang.utils.Hamming;
import com.yuyang.utils.SimHash;
import org.junit.Test;


import static com.yuyang.utils.SimHash.getHash;
import static com.yuyang.utils.SimHash.getSimHash;

public class SimHashTest {
    @Test
    public void testHash(){
        //获取文件内容并转为字符串
        String str0 = IOtext.read("D:\\测试文本\\orig.txt");
        String str1 = IOtext.read("D:\\测试文本\\orig_0.8_add.txt");
        //获取文件的hash值并输出
        System.out.println("str0的hash值："+getHash(str0));
        System.out.println("str0的hash值："+getHash(str1));
    }

    @Test
    public void testSimHash(){
        //获取文件内容并转为字符串
        String str0 = IOtext.read("D:\\测试文本\\orig.txt");
        String str1 = IOtext.read("D:\\测试文本\\orig_0.8_add.txt");
        //获取文件的SimHash值并输出
        System.out.println("str0的SimHash值："+getSimHash(str1));
        System.out.println("str0的SimHash值："+getSimHash(str1));
    }
}
