package com.yuyang.utils;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;


public class IOtext {
    /**
     * 读取目标文件
     * 传入文件的绝对路径，将文件内容转化为String字符串输出
     * @param filePath
     */
    public static String read(String filePath) {
        StringBuilder str = new StringBuilder();
        String strLine;
        // 将 txt文件按行读入 str中
        File file = new File(filePath);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 字符串拼接
            while ((strLine = bufferedReader.readLine()) != null) {
                str.append(strLine);
            }
            // 关闭资源
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    /**
     * 向文件写入内容
     * 传入内容和文件的绝对路径
     * @param filePath 文件绝对路径
     * @param newTxt 内容
     */
    public static void write(String filePath,String newTxt) {

        Writer writer = null;
        try {
            //1.创建创建文件对象与字符输出流对象
            File file = new File(filePath);
            writer = new FileWriter(file);
            //2.写数据
            writer.write(newTxt);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源
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
     * 获取文件名
     * @param filePath 文件绝对路径
     * @return 文件名
     */
    public static String getTxtName(String filePath) {
        File tempFile =new File( filePath.trim());
        String fileName = tempFile.getName();
        return fileName;
    }

    public static String printout(String originName, String copyName, double Similarity) {
        BigDecimal bigDecimal = new BigDecimal((Similarity * 100) + "");
        // 对查重率进行保留小数点后两位四舍五入处理
        BigDecimal res = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return "原文：" + originName + "和抄袭版论文：" + copyName  + "的重复率为：" + res + "%";
    }
}

