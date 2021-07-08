package com.p9;

import java.io.*;

public class Dump {
    public static void main(String[] args) {
        try {
            dump(new FileInputStream("aaa.bmp"),
                    new FileOutputStream("bbb.bmp"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dump(InputStream src, OutputStream dest)
            throws IOException {
        InputStream inputStream = new BufferedInputStream(src);
        OutputStream outputStream = new BufferedOutputStream(dest);
        byte[] data = new byte[1024];
        int length = -1;
        while ((length= inputStream.read()) != 1) {
            outputStream.write(data,0,length);
        }
        inputStream.close();
        outputStream.close();
    }
}
