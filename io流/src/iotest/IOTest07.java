package iotest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组流
 */
public class IOTest07 {

    /**
     * 四个步骤:字节数组输入流 将字节
     * 1、创建源  : 字节数组 不要太大 因为会将数据存在内存上
     * 2、选择流
     * 3、操作
     * 4、释放资源: 可以不用处理
     *
     * 字节数组输入流
     * @param str 打印输入的字符串
     */
    private void inputByteArray(String str){
        byte[] bytes = str.getBytes(); //创建源 源和之前的不一样了不再是file对象
        InputStream inputStream = null;
        inputStream = new ByteArrayInputStream(bytes); //选择流
        byte[] flush = new byte[5]; //缓冲容器，对内存进行操作，不要太大
        int len = -1; //接收到的字节长度
        try {
            while ((len = inputStream.read(flush)) !=-1){ //操作，分段读取数据
                String string = new String(flush,0,len); //转码：字节转字符
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != inputStream){
                try {
                    inputStream.close();  //释放资源，可以去除，在字节数组流当中，这个方法是由垃圾回收机制资信调用的，这个方法是空的
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 字节数组输出流 ByteArrayOutputStream
     *1、创建源  : 内部维护
     *2、选择流  : 不关联源
     *3、操作(写出内容)
     *4、释放资源 :可以不用处理
     * 获取数据:  toByteArray()
     *
     * 将指定的字符串采用字节数组流进行输出操作
     * @param msg 指定的字符串
     */
    private void outputByteArray(String msg){
        byte[] bytes = null; //创建源，可以不创建 字节输出输出流的内部会自动根据输出的内容大小去创建源
        ByteArrayOutputStream byteOut = null;
        byteOut = new ByteArrayOutputStream(); //不可使用多态了，这里要使用的是这个子类的新增方法
        /*使用多态就可以调用子类重写的方法。，当使用多态方式调用方法时，首先检查父类中是否有该方法，如果有，再去调用子类的同名方法；如果没有，则编译错误。*/
        byte[] flush = msg.getBytes(); //转码：字符串转字节
        try {
            byteOut.write(flush); //操作
            byteOut.flush(); //刷新缓存
            bytes = byteOut.toByteArray(); //获取字节数组流的数据
            System.out.println(bytes.length+"-->"+new String(bytes,0,byteOut.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                byteOut.close();  //释放资源，可以去除，在字节数组流当中，这个方法是由垃圾回收机制资信调用的，这个方法是空的
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        IOTest07 ioTest07 = new IOTest07();
        ioTest07.inputByteArray("hello every coder");
        ioTest07.outputByteArray("hello every coder");
    }
}
