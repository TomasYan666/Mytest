package iotest;

import java.io.*;

public class IOTest03 {
    public static void main(String[] args) {
        String path = "E:\\IDEA\\Mytest\\io流\\io.txt";
        File file = new File(path); //创建源
        InputStream inputStream = null;
        if (file.exists()) {
            try {
                inputStream = new FileInputStream(file); //选择流
                byte[] flush = new byte[1024*10]; //操作分段读取用缓存数组
                int len = -1; //读取到的字节长度
                while ((len = inputStream.read(flush)) != -1){ //操作 分段读取
                    System.out.println("len: "+len);
                    System.out.println();
                    String string = new String(flush,0,len); //解吗：字节转字符
                    System.out.println(string);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (null != inputStream){ //释放资源
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
