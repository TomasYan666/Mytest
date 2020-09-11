package iotest;

import java.io.*;

public class IOTest04 {
    public static void main(String[] args) {
        //创建源
        String path = "io流/io2.txt";
        File file = new File(path);
        OutputStream outputStream = null; //当文件不存在会自动创建一个，可以直接传入path，也可以传入file

        //选择流+操作
        try {
            outputStream = new FileOutputStream(file,true); //选择流，true为从文件末尾开始写入 ，false和不传是清除文件覆盖写
            String str = "hello IO world 2";  //字符串
            byte[] flush = str.getBytes(); // 转码：字符转字节
            outputStream.write(flush, 0, flush.length); //写入
            outputStream.flush(); //刷新缓存
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close(); //释放资源
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
