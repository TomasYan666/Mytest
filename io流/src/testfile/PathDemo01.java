package testfile;

import java.io.File;
import java.io.IOException;

public class PathDemo01 {
    public static void main(String[] args) throws IOException {
        String path = "IO.png";
        System.out.println(File.separatorChar);
        path = "E:/IDEA/Mytest/io流/IO.png";
        String path2 = "E:/IDEA/Mytest/io流";
        System.out.println(path);

        File src = new File(path);
        System.out.println(src.length() );

        //绝对路径
        System.out.println(src.getAbsolutePath());

        //相对路径
        System.out.println(System.getProperty("user.dir"));
        src = new File("IO.png");
        System.out.println(src.getAbsolutePath());

        //构建一个不存在的文件
        src = new File("aaa/IO2.png");
        System.out.println(src);
        System.out.println(src.getAbsolutePath());

        //基本信息
        System.out.println("名称:"+src.getName());
        System.out.println("路径:"+src.getPath());
        System.out.println("绝对路径:"+src.getAbsolutePath());
        System.out.println("父路径:"+src.getParent());
        System.out.println("父对象:"+src.getParentFile().getName());


        //检查文件是否存在
        System.out.println(src.getAbsolutePath());
        System.out.println("是否存在:"+src.exists());
        System.out.println("是否文件:"+src.isFile());
        System.out.println("是否文件夹:"+src.isDirectory());

        src = new File(path);
        System.out.println(src.getAbsolutePath());
        System.out.println("----------");
        System.out.println("是否存在:"+src.exists());
        System.out.println("是否文件:"+src.isFile());
        System.out.println("是否文件夹:"+src.isDirectory());

        src = new File("D:\\java300\\IO_study01");
        System.out.println("----------");
        System.out.println("是否存在:"+src.exists());
        System.out.println("是否文件:"+src.isFile());
        System.out.println("是否文件夹:"+src.isDirectory());

        //文件状态
        src = new File(path);
        if(null == src || !src.exists()) {
            System.out.println("文件不存在");
        }else {
            if(src.isFile()) {
                System.out.println("文件操作");
            }else {
                System.out.println("文件夹操作");
            }
        }

        //文件长度
        System.out.println("长度:"+ src.length());
        src = new File("E:/IDEA/Mytest/io流");
        System.out.println("长度:"+ src.length());

        src = new File("D:/java300/IO_study02");
        System.out.println("长度:"+ src.length());

        System.out.println("------------------");
        /**
         * 其他信息:
         * createNewFile()  : 不存在才创建，存在创建成功
         * delete():删除已经存在的文件
         * */
        src = new File("E:/IDEA/Mytest/io流/io.txt");
        boolean flag =src.createNewFile();
        System.out.println(flag);
        flag = src.delete();
        System.out.println(flag);

        System.out.println("----------");
        //不是文件夹
        src = new File("E:/IDEA/Mytest/io流1");
        flag =src.createNewFile();
        System.out.println(flag);

        flag = src.delete();
        System.out.println(flag);

        //补充:  con com3... 操作系统的设备名，不能正确创建
        src = new File("E:/IDEA/Mytest/io流/con");
        src.createNewFile();


        /**
         * 创建目录
         * 1、mkdir() : 确保上级目录存在，不存在创建失败
         * 2、mkdirs(): 上级目录可以不存在，不存在一同来创建
         * @author 裴新
         *
         */
        System.out.println("===========");
        //创建目录 mkdirs()
        File dir = new File(path2+"/dir/test");
        flag = dir.mkdirs();
        System.out.println(flag);
        //创建目录 mkdir()
        dir = new File(path2+"/dir/test2");
        flag = dir.mkdirs();
        System.out.println(flag);
        System.out.println();

        /**
         * 列出下一级
         * 1、list() :列出下级名称
         * 2、listFiles():列出下级File对象
         *
         * 列出所有的盘符: listRoots()
         * @author 裴新
         *
         */
        System.out.println("下级名称\n");

        dir = new File(path2);
        //下级名称  list 返回字符串数组
        String[] subNames = dir.list();
        for(String s:subNames) {
            System.out.println(s);
        }
        System.out.println("下级对象\n");
        //下级对象  listFiles() 返回对象数组
        File[] subFiles = dir.listFiles();
        for(File s:subFiles) {
            System.out.println(s.getAbsolutePath());
        }

        System.out.println("所有盘符\n");
        //所有盘符 返回对象数组
        File[] roots = dir.listRoots();
        for(File r:roots) {
            System.out.println(r.getAbsolutePath());
        }
        System.out.println();

        /**
         *  递归: 方法自己调用自己
         *  打印子孙级目录和文件的名称
         * @author 裴新
         *
         */
        System.out.println("打印子孙级目录和文件的名称\n");
        printName(dir,0);

        System.out.println();

        System.out.println("统计文件夹的大小");
        count(dir);
        System.out.println(len);
    }

    //打印打印子孙级目录和文件的名称
    public static void printName(File src,int deep) {
        //控制前面层次
        for(int i=0;i<deep;i++) {
            System.out.print("-");
        }
        System.out.println(src.getName()); //打印名称
        if(null ==src || !src.exists()) {  //递归头
            return ;
        }else if(src.isDirectory()) { //是文件夹吗
            for(File s:src.listFiles()) {
                printName(s,deep+1); //递归体
            }
        }
    }


    /**
     *  统计文件夹的大小
     * @author 裴新
     *
     */

    private static long len =0;
    public static void count(File src) {
        //获取大小
        if(null!=src && src.exists()) {
            if(src.isFile()) {  //大小
                len+=src.length();
            }else { //子孙级 如果不是文件那就进入文件夹里面
                for(File src1:src.listFiles()) {
                    count(src1); //递归调用
                }
            }
        }

    }

}
