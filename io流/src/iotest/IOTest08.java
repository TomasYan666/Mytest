package iotest;

import java.io.*;

/**
 * 节点流的对接
 * 文件转字节流
 * 字节流转文件
 */
public class IOTest08 {

    /**
     * 利用节点流对接的形式进行文件的复制
     *
     * @param inPath
     * @param outPath
     */
    private void iotest(String inPath, String outPath) {
        File file = new File(inPath); //创建源
        InputStream inputStream = null;
        OutputStream outputStream = null;
        InputStream byteArrayInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); //选择流 字节数组输出流
        int len = -1;
        byte[] flush = new byte[1024 * 10];
        if (file.exists()) {
            try {
                inputStream = new FileInputStream(file); //选择流 文件字节输入流 分段读取
                while ((len = inputStream.read(flush)) != -1) { //读取文件生成字节流
                    byteArrayOutputStream.write(flush, 0, len); //这里在循环过程中会对它内部的缓存数组进行自动扩容 对象没被释放会追加写入
                    byteArrayOutputStream.flush(); //刷新字节数组输出流缓存
                }
                byte[] flush2 = byteArrayOutputStream.toByteArray(); //将字节数组输出流转成字节数组
                byteArrayInputStream = new ByteArrayInputStream(flush2); //选择流 字节数组输入流
                outputStream = new FileOutputStream(outPath); //选择流 文件字节输出流
                while ((len = byteArrayInputStream.read(flush2)) != -1) {
                    outputStream.write(flush2, 0, len); //对象没被释放会追加写入
                }
                outputStream.flush(); //刷新文件字节输出流缓存
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if ((inputStream != null) && (outputStream != null)) {
                    try {
                        outputStream.close();
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * try ...with...resource
     * 实现复制，并且自动释放资源，这个是在jdk1.7之后才有的功能
     */
    public static void copy(String srcPath, String destPath) {
        //1、创建源
        File src = new File(srcPath); //源头
        File dest = new File(destPath);//目的地
        //2、选择流
        try (InputStream is = new BufferedInputStream(new FileInputStream(src));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));) {
            //3、操作 (分段读取)
            byte[] flush = new byte[1024]; //缓冲容器
            int len = -1; //接收长度
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len); //分段写出
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IOTest08 ioTest08 = new IOTest08();
        ioTest08.iotest("E:\\IDEA\\Mytest\\io流\\IO.png", "E:\\IDEA\\Mytest\\io流\\IO3.png");
    }
}
