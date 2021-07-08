package com.p8;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ThreadDownload {
    public static void main(String[] args) throws Exception {
        final URL[] urls= {
                new URL("http://www.pku.edu.cn"),
                new URL("http://www.baidu.com"),
                new URL("http://www.sina.com.cn"),
                new URL("http://www.dstang.com")
        };
        final String[] files = {
                "pku.htm",
                "baidu.htm",
                "sina.com",
                "study.htm"
        };

        for (int i = 0; i<urls.length;i++) {
            final int idx = i;
            new Thread(()->{
                try {
                    System.out.println(urls[idx]);
                    download(urls[idx],files[idx]);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }).start();
        }
    }

    static void download(URL url, String file) throws Exception{
        try (InputStream inputStream = url.openStream();
             OutputStream outputStream = new FileOutputStream(file))
        {
            byte[] data = new byte[1024];
            int length;
            while ((length=inputStream.read(data)) != -1) {
                outputStream.write(data,0,length);
            }
        }
    }
}
