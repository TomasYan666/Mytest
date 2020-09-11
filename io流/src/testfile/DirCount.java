package testfile;

import java.io.File;

/**
 *  使用面向对象: 统计文件夹的大小
 * @author 裴新
 *
 */
public class DirCount {
    //文件夹大小
    private long len;
    //文件夹路径
    private String path;
    //文件的个数
    private int fileSize;
    //文件夹的个数 （真的个数应该减一，他把自己也算上了）
    private int dirSize;
    //源
    private File src;
    public DirCount(String path) {
        this.path = path;
        this.src = new File(path);
        count(this.src);
    }

    //统计文件夹的大小
    private  void count(File src) {
        //获取大小
        if(null!=src && src.exists()) {
            if(src.isFile()) {  //大小 如果是文件就获取长度
                len+=src.length();
                this.fileSize++;
            }else { //子孙级 如果这是文件夹就递归
                this.dirSize++;
                for(File s:src.listFiles()) {
                    count(s);
                }
            }
        }
    }

    public long getLen() {
        return len;
    }

    public int getFileSize() {
        return fileSize;
    }

    public int getDirSize() {
        return dirSize;
    }

    public static void main(String[] args) {
        String path = "E:/IDEA/Mytest/io流";
        String path2 = "E:/IDEA/Mytest/io流/src";
        DirCount dir = new DirCount(path);
        System.out.println("文件夹大小:"+dir.getLen()+"-->文件个数："+dir.getFileSize()+"-->文件夹个数:"+dir.getDirSize());

        DirCount dir2 = new DirCount(path2);
        System.out.println("文件夹大小"+dir2.getLen()+"-->文件个数:"+dir2.getFileSize()+"-->文件夹个数"+dir2.getDirSize());

    }





}