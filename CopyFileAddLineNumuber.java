package com.p9;

import java.io.*;

public class CopyFileAddLineNumuber {
    public static void main(String[] args) {
        String infname = "CopyFileAddLineNumber.java";
        String outfname = "CopyFileAddLineNumber.txt";
        if (args.length>=1) infname = args[0];
        if (args.length>=2) outfname = args[1];

        try {
            File fin = new File(infname);
            File fout = new File(outfname);

            BufferedReader in = new BufferedReader(new FileReader(fin));
            PrintWriter out = new PrintWriter(new FileWriter(fout));

            int cnt = 0;
            String s = in.readLine();
            while (s!=null) {
                cnt++;
                s=deleteCommeents(s);
                out.println(cnt+":\t" + s);
                s=in.readLine();
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    static String deleteCommeents(String s) {
        if (s==null) return s;
        int pos = s.indexOf("//");
        if (pos<0) return s;
        return s.substring(0,pos);
    }
}
