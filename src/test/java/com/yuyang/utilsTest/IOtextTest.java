package com.yuyang.utilsTest;

import com.yuyang.utils.Hamming;
import com.yuyang.utils.IOtext;
import com.yuyang.utils.SimHash;
import org.junit.Test;

public class IOtextTest {
    @Test
    public void testRead(){
        //路径正确，读取正常
        String str = IOtext.read("D:\\测试文本\\orig.txt");
        System.out.println(str);
        }

    @Test
    public void testWrite(){
        //路径正确，写入正常
        String str = "路径正确，写入正常";
        IOtext.write("D:\\测试文本\\newtxt.txt",str);
    }

    @Test
    public void testReadFail(){
        //路径错误，读取错误
        String str = IOtext.read("D:\\测试文本\\txt1.txt");
        System.out.println(str);
    }

    @Test
    public void testGetName(){
        //读取文件名
        String name = IOtext.getTxtName("D:\\测试文本\\orig.txt");
        System.out.println("文件名为："+name);//输出文件名
    }

    @Test
    public void testPrintOut(){
        //获取文件名
        String originTxtName = IOtext.getTxtName("D:\\测试文本\\orig.txt");
        String copyTxtName = IOtext.getTxtName("D:\\测试文本\\orig_0.8_add.txt");

        //获取文件内容并转为字符串
        String str0 = IOtext.read("D:\\测试文本\\orig.txt");
        String str1 = IOtext.read("D:\\测试文本\\orig_0.8_add.txt");

        // 获取SimHash值
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);

        // 由SimHash值求出相似度
        double similarity = Hamming.getSimilarity(simHash0, simHash1);

        // 把相似度写入最后的结果文件中
        IOtext.write("D:\\测试文本\\RepetitionRate.txt",IOtext.printout(originTxtName,copyTxtName,similarity));
    }

}