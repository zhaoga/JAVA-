package com.p9;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class FileDisplay {
    public static void main(String[] args) {
        Frame frame = new Frame("test for filedialog");
        TextArea textArea = new TextArea(40,40);
        frame.add(textArea);
        frame.setSize(600,500);
        frame.setVisible(true);

        FileDialog fileDialog = new FileDialog(frame,"文件对话框",FileDialog.LOAD);
        fileDialog.setVisible(true);
        String fpath = fileDialog.getDirectory();
        String fname = fileDialog.getFile();
        String si = fpath + fname;

        File file = new File(si);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String s;
            s = in.readLine();
            while (s!=null){
                textArea.append(s+"\n");
                s=in.readLine();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
