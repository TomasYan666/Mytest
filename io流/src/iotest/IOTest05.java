package iotest;

import java.io.*;

/**
 * 文件字节流
 */
public class IOTest05 {
    /**
     * 往指定文件内写入指定内容
     *
     * @param path 指定文件路径名称
     * @param str  为指定写入的内容
     * @param BE   为指定写入形式是接续还是覆盖
     * @return 写入成功则返回true 失败则返回false
     */
    public Boolean output(String path, String str, Boolean BE) {
        //创建源
        File file = new File(path); //根据输入的path生成file对象
        OutputStream outputStream = null; //当文件不存在会自动创建一个，可以直接传入path，也可以传入file
        //选择流+操作
        try {
            outputStream = new FileOutputStream(file, BE); //选择流，从文件末尾开始写入
            byte[] flush = str.getBytes(); // 转码：字符转字节 缓存数组
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

        if (file.exists() && (file.length() > 0)) {
            return true;
        } else {
            System.out.println(file);
            return false;
        }
    }

    /**
     * @param path 指定要读取文件的路径名称
     * @return 返回从文件里读取到的字符, 没有读到则返回null
     */
    public String input(String path) {
        File file = new File(path); //创建源 使用path生成file对象
        InputStream inputStream = null; //选择流
        String string = null; //返回读取到的值
        if (file.exists()) { //判断源是否创建成功
            try {
                inputStream = new FileInputStream(file); //生成流对象
                byte[] flush = new byte[1024 * 10]; //添加缓存数组
                int len = -1; //读取到流生成字节长度
                while ((len = inputStream.read(flush)) != -1) { //将字节存到缓存数组，分段读取
                    string = new String(flush, 0, len); //转码：字节转字符
                    System.out.println(string);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != inputStream) {
                    try {
                        inputStream.close(); //释放资源
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return string;
    }

    /**
     * 复制文件
     *
     * @param inPath  源文件路径名称
     * @param outPath 复制出的新文件路径名称
     * @return 成功返回 true   失败返回 false
     */
    public boolean copy(String inPath, String outPath) {
        File inFile = new File(inPath); //创建输入源file对象
        File outFile = new File(outPath); //创建输出源file对象
        InputStream inputStream = null;
        OutputStream outputStream = null;
        if (inFile.exists()) { //判断输入文件是否存在
            try {
                inputStream = new FileInputStream(inFile); //创建输入流
                outputStream = new FileOutputStream(outFile); //创建输出流
                byte[] flush = new byte[1024]; //设置缓存数组
                int len = -1; //设置读取到的字节长度
                while ((len = inputStream.read(flush)) != -1) { //从输入文件中读取字节存到字节数组中，分段读取
                    outputStream.write(flush, 0, len); //从缓存数组中取字节，向目标文件中输出，分段输出
                }
                outputStream.flush(); //刷新缓存
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {  //释放资源，原则：先打开的后释放
                if (null != outputStream) {
                    try {
                        outputStream.close(); //释放输出资源
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (null != inputStream) {
                    try {
                        inputStream.close();  //释放输入资源
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (outFile.exists() && outFile.length() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 复制文件夹下的所有内容，到指定的文件夹下
     * @param inPath
     * @param outPath
     */
    public void copyDir(String inPath, String outPath) {
        File inFile = new File(inPath); //创建输入源file对象
        File outFile = new File(outPath); //创建输出源file对象
            if (inFile.isDirectory()) { //判断是否是文件夹
                for (File file : inFile.listFiles()) {
                    outFile.mkdirs(); //如果传入的是文件夹，就将这个文件夹生成
                    copyDir(file.getPath(), outFile.getPath()+"\\"+file.getName());
                }
            } else {
                InputStream inputStream = null;
                OutputStream outputStream = null;
                try {
                    inputStream = new FileInputStream(inFile); //创建输入流
                    outputStream = new FileOutputStream(outFile); //创建输出流
                    byte[] flush = new byte[1024]; //设置缓存数组
                    int len = -1; //设置读取到的字节长度
                    while ((len = inputStream.read(flush)) != -1) { //从输入文件中读取字节存到字节数组，分段读取
                        outputStream.write(flush, 0, len); //向目标文件中输出字节，分段写入
                    }
                    outputStream.flush(); //刷新缓存
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {  //释放资源，原则：先打开的后释放
                    if (null != outputStream) {
                        try {
                            outputStream.close(); //释放输出资源
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != inputStream) {
                        try {
                            inputStream.close();  //释放输入资源
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    }

    public static void main(String[] args) {
        IOTest05 ioTest05 = new IOTest05();
//        String input = ioTest05.input("E:\\IDEA\\Mytest\\io流\\io.txt");
//        Boolean output = ioTest05.output("io流/io3.txt",input,true);
//        System.out.println(output);

//        System.out.println(ioTest05.copy("E:\\IDEA\\Mytest\\io流\\IO.png", "io流\\IO2.png"));

        ioTest05.copyDir("E:\\IDEA\\Mytest\\io流\\dir","E:\\IDEA\\Mytest\\io流\\dir2");
    }
}
