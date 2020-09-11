package iotest;

import java.io.*;

public class IOtest2 {
    public static void main(String[] args) {
        test01();
        System.out.println();
        test02();
        System.out.println();
        IOtest2 iOtest2 =new IOtest2();
        iOtest2.test03();
        System.out.println();
        iOtest2.test04();
        System.out.println();
        iOtest2.test05();
    }

    private static void test01() {
        String path = "E:\\IDEA\\Mytest\\io流\\io.txt";
        File file = new File(path);
        InputStream inputStream = null;
        int temp;
        if (null != file) {
            try {
                inputStream = new FileInputStream(file);
                while ((temp = inputStream.read()) != -1) {
                    System.out.println((char) temp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void test02() {
        String path = "E:\\IDEA\\Mytest\\io流\\io.txt";
        File file = new File(path);
        InputStream inputStream = null;
        int temp;
        if (null != file) {
            try {
                inputStream = new FileInputStream(file);
                while ((temp = inputStream.read()) != -1){
                    System.out.println((char) temp);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void test03(){
        String path = "E:\\IDEA\\Mytest\\io流\\io.txt";
        File file = new File(path);
        int temp;
        InputStream inputStream = null;
        if (null!=file){
            try {
                inputStream = new FileInputStream(file);
                while ((temp = inputStream.read()) != -1){
                    System.out.println((char) temp);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void test04(){
        String path = "E:\\IDEA\\Mytest\\io流\\io.txt";
        File file = new File(path);
        int temp;
        InputStream inputStream = null;
        if (null != file){
            try {
                inputStream = new FileInputStream(file);
                while ((temp = inputStream.read()) != -1){
                    System.out.println((char) temp);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void test05(){
        String path = "E:\\IDEA\\Mytest\\io流\\io.txt";
        File file = new File(path);
        int temp;
        InputStream inputStream = null;
        if (null != file){
            try {
                inputStream = new FileInputStream(file);
                while ((temp = inputStream.read()) != -1){
                    System.out.println((char)temp);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
