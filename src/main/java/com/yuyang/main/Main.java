package com.yuyang.main;

import com.yuyang.utils.Hamming;
import com.yuyang.utils.IOtext;
import com.yuyang.utils.SimHash;

public class Main {
    public static void main(String[] args) {

        //��ȡ�ļ���
        String originTxtName = IOtext.getTxtName(args[0]);
        String copyTxtName = IOtext.getTxtName(args[1]);
        String ansTxt = IOtext.getTxtName(args[2]);
        // �������������·������ȡ��Ӧ���ļ������ļ�������ת��Ϊ��Ӧ���ַ���
        String str0 = IOtext.read(args[0]);
        String str1 = IOtext.read(args[1]);

        // ���ַ����ó���Ӧ��SimHashֵ
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);

        // ��SimHashֵ������ƶ�
        double similarity = Hamming.getSimilarity(simHash0, simHash1);

        // �����ƶ�д�����Ľ���ļ���
        IOtext.write(args[2], IOtext.printout(originTxtName, copyTxtName, similarity));

        System.out.println("���ؽ����д��" + ansTxt);

        // �˳�����
        System.exit(0);
    }
}