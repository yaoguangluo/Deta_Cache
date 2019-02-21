package org.lyg.common.utils;

import java.io.*;

public class FileReader {

    public static String readTxtFile(String filePath){
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    System.out.println(lineTxt); // 一行一行的读
                    return lineTxt;
                }

            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return "该文件无内容";
    }

    public static void writeTxtFile(String filePath){
        try {
            String encoding="GBK";
            File writename = new File(".\\result\\en\\output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write("写入文件\r\n"); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (Exception e) {
            System.out.println("写入文件内容出错");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        readTxtFile("/Users/sunybert/CMakeCache.txt");
    }
}
