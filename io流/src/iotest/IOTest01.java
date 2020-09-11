package iotest;

import java.io.*;

public class IOTest01 {
    public static void main(String[] args) {
        String path = "io流\\io.txt";
        File src = new File(path);
        System.out.println(src.getAbsolutePath());
        InputStream inputStream = null;
        int temp;
        try {
            if (src != null && src.exists()) {
                inputStream = new FileInputStream(src);
                while ((temp=inputStream.read()) != -1){
                    System.out.println((char)temp);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null!=src){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
