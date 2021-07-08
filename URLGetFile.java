package com.p11;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLGetFile extends Applet {
    URL url;
    TextArea showarea = new TextArea("下载的数据:");
    public void init() {
        String strurl = "http://www.pku.edu.cn";
        try {
            url=new URL(strurl);
        }catch (MalformedURLException e) {
            System.out.println("URL格式错误");
        }
        add(showarea);
    }
    public void start() {
        InputStream filecon = null;
        BufferedReader filedata = null;
        String line;
        try {
            filecon = url.openStream();
            filedata = new BufferedReader(new InputStreamReader(filecon));
            while ((line=filedata.readLine()) != null){
                showarea.append(line+"\n");
            }
        } catch (IOException e) {
            System.out.println("Error in I/O:" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Frame frame = new Frame("URL Test");
        Applet ap = new URLGetFile();
        ap.init();
        frame.add(ap);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setSize(400,300);
        frame.show();
        ap.start();
    }
}
