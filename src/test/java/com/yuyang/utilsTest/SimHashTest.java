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
        //��ȡ�ļ����ݲ�תΪ�ַ���
        String str0 = IOtext.read("D:\\�����ı�\\orig.txt");
        String str1 = IOtext.read("D:\\�����ı�\\orig_0.8_add.txt");
        //��ȡ�ļ���hashֵ�����
        System.out.println("str0��hashֵ��"+getHash(str0));
        System.out.println("str0��hashֵ��"+getHash(str1));
    }

    @Test
    public void testSimHash(){
        //��ȡ�ļ����ݲ�תΪ�ַ���
        String str0 = IOtext.read("D:\\�����ı�\\orig.txt");
        String str1 = IOtext.read("D:\\�����ı�\\orig_0.8_add.txt");
        //��ȡ�ļ���SimHashֵ�����
        System.out.println("str0��SimHashֵ��"+getSimHash(str1));
        System.out.println("str0��SimHashֵ��"+getSimHash(str1));
    }
}
