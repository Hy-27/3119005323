package com.yuyang.utilsTest;

import com.yuyang.utils.Hamming;
import com.yuyang.utils.IOtext;
import com.yuyang.utils.SimHash;
import org.junit.Test;

public class IOtextTest {
    @Test
    public void testRead(){
        //·����ȷ����ȡ����
        String str = IOtext.read("D:\\�����ı�\\orig.txt");
        System.out.println(str);
        }

    @Test
    public void testWrite(){
        //·����ȷ��д������
        String str = "·����ȷ��д������";
        IOtext.write("D:\\�����ı�\\newtxt.txt",str);
    }

    @Test
    public void testReadFail(){
        //·�����󣬶�ȡ����
        String str = IOtext.read("D:\\�����ı�\\txt1.txt");
        System.out.println(str);
    }

    @Test
    public void testGetName(){
        //��ȡ�ļ���
        String name = IOtext.getTxtName("D:\\�����ı�\\orig.txt");
        System.out.println("�ļ���Ϊ��"+name);//����ļ���
    }

    @Test
    public void testPrintOut(){
        //��ȡ�ļ���
        String originTxtName = IOtext.getTxtName("D:\\�����ı�\\orig.txt");
        String copyTxtName = IOtext.getTxtName("D:\\�����ı�\\orig_0.8_add.txt");

        //��ȡ�ļ����ݲ�תΪ�ַ���
        String str0 = IOtext.read("D:\\�����ı�\\orig.txt");
        String str1 = IOtext.read("D:\\�����ı�\\orig_0.8_add.txt");

        // ��ȡSimHashֵ
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);

        // ��SimHashֵ������ƶ�
        double similarity = Hamming.getSimilarity(simHash0, simHash1);

        // �����ƶ�д�����Ľ���ļ���
        IOtext.write("D:\\�����ı�\\RepetitionRate.txt",IOtext.printout(originTxtName,copyTxtName,similarity));
    }

}