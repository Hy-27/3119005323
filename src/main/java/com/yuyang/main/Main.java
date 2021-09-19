package com.yuyang.main;

import com.yuyang.utils.Hamming;
import com.yuyang.utils.IOtext;
import com.yuyang.utils.SimHash;

public class Main {
    public static void main(String[] args) {

        //获取文件名
        String originTxtName = IOtext.getTxtName(args[0]);
        String copyTxtName = IOtext.getTxtName(args[1]);
        String ansTxt = IOtext.getTxtName(args[2]);
        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        String str0 = IOtext.read(args[0]);
        String str1 = IOtext.read(args[1]);

        // 由字符串得出对应的SimHash值
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);

        // 由SimHash值求出相似度
        double similarity = Hamming.getSimilarity(simHash0, simHash1);

        // 把相似度写入最后的结果文件中
        IOtext.write(args[2], IOtext.printout(originTxtName, copyTxtName, similarity));

        System.out.println("查重结果已写入" + ansTxt);

        // 退出程序
        System.exit(0);
    }
}