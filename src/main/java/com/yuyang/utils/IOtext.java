package com.yuyang.utils;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;


public class IOtext {
    /**
     * ��ȡĿ���ļ�
     * �����ļ��ľ���·�������ļ�����ת��ΪString�ַ������
     * @param filePath
     */
    public static String read(String filePath) {
        StringBuilder str = new StringBuilder();
        String strLine;
        // �� txt�ļ����ж��� str��
        File file = new File(filePath);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // �ַ���ƴ��
            while ((strLine = bufferedReader.readLine()) != null) {
                str.append(strLine);
            }
            // �ر���Դ
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    /**
     * ���ļ�д������
     * �������ݺ��ļ��ľ���·��
     * @param filePath �ļ�����·��
     * @param newTxt ����
     */
    public static void write(String filePath,String newTxt) {

        Writer writer = null;
        try {
            //1.���������ļ��������ַ����������
            File file = new File(filePath);
            writer = new FileWriter(file);
            //2.д����
            writer.write(newTxt);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.�ر���Դ
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ��ȡ�ļ���
     * @param filePath �ļ�����·��
     * @return �ļ���
     */
    public static String getTxtName(String filePath) {
        File tempFile =new File( filePath.trim());
        String fileName = tempFile.getName();
        return fileName;
    }

    public static String printout(String originName, String copyName, double Similarity) {
        BigDecimal bigDecimal = new BigDecimal((Similarity * 100) + "");
        // �Բ����ʽ��б���С�������λ�������봦��
        BigDecimal res = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return "ԭ�ģ�" + originName + "�ͳ�Ϯ�����ģ�" + copyName  + "���ظ���Ϊ��" + res + "%";
    }
}

