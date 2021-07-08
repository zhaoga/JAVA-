package com.p9;

import jdk.jshell.execution.JdiDefaultExecutionControl;

import java.io.File;

public class ListAllFiles {
    public static void main(String[] args) {
        ListFile(new File("F://code/java_code/p1"));
    }
    public static void ListFile(File dir) {
        if (!dir.exists() || !dir.isDirectory()) return;

        String[] files = dir.list();
        for (int i=0; i< files.length; i++) {
            File file = new File(dir,files[i]);
            if (file.isFile()) {
                System.out.println(
                        dir + "\\" + file.getName() + "\t" + file.length()
                );
            }else {
                System.out.println(dir + "\\" + file.getName() + "\t<dir>");
                ListFile(file);
            }
        }
    }
}
