package iotest;

import java.io.*;

/**
 * 文件字符流
 */
public class IOTest06 {
    /**
     *指定要读取文件的路径，得到读取到的字符串，没有读到则返回一个空的字符串
     * @param path 输入要读取的文件的路径
     * @return 返回读取到的字符串
     */
    private String reade(String path){
        File file = new File(path); //创建源
        Reader reader = null;
        StringBuilder str = new StringBuilder(); //建立一个StringBuild对象，用于拼接字符串
        if (file.exists()){ //检查文件是否存在
            try {
                reader = new FileReader(file); //选择流
                char[] flush = new char[2]; //建立缓存字符数组
                int len = -1; //读到的字符长度
                while ((len = reader.read(flush)) != -1){ //将字符读取到缓存数组,分段接收
                    //字符数组-->字符串
                    str.append(new String(flush,0,len)); //将每次读取到的字符拼接成一个完整的字符串
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (null != reader){
                    try {
                        reader.close(); //释放资源
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println( str.toString());
        return  str.toString();
    }

    /**
     * 向指定文本文件里写入指定的字符串，不支持追加
     * @param path 指定的路径名称
     * @param str 指定的输入内容
     */
    private void write(String path,String str){
        File file = new File(path); //创建源
        Writer writer = null;

        try {
            writer = new FileWriter(file); //选择流
            writer.write(str); //操作，输出指定内容到文件，会全覆盖，文件不存在会自动创建一个新的

            //写法一
/*			String msg ="IO is so easy\r\n尚学堂欢迎你";
			char[] datas =msg.toCharArray(); // 字符串-->字符数组
			writer.write(datas,0,datas.length);*/

            //写法二：这样写可以在原有内容后面追加内容
/*            String msg ="IO is so easy\r\n尚学堂欢迎你";
			writer.write(msg);
			writer.write("add");*/

            //写法三
            /*writer.append("IO is so easy\r\n").append("尚学堂欢迎你");*/

            writer.flush(); //刷新缓存
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != writer){
                try {
                    writer.close(); //释放资源
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 将一个文本文件复制到指定位置
     * @param outPath 指定输出路径和文件名
     * @param inPath  指定输入路径和文件名
     * @return 成功返回true 失败返回false
     */
    private boolean copy (String outPath,String inPath){
        write(outPath,reade(inPath));
        File file =new File(outPath);
        if (file.exists()&&file.length()>0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IOTest06 ioTest06 = new IOTest06();
//        ioTest06.write("E:\\IDEA\\Mytest\\io流\\io4.txt","hello 12356");
//        ioTest06.reade("E:\\IDEA\\Mytest\\io流\\io4.txt");
        ioTest06.copy("E:\\IDEA\\Mytest\\io流\\io5.txt","E:\\IDEA\\Mytest\\io流\\io4.txt");
    }

}
