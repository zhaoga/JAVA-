package com.p7;

import java.util.Enumeration;
import java.util.Vector;

class Photo {
    private int PhotoNumber;

    public Photo(int photoNumber) {
        PhotoNumber = photoNumber;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "PhotoNumber=" + PhotoNumber +
                '}';
    }
}
class  Printer {
    static void printAll(Enumeration enumeration) {
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());
    }
}

public class PhotoAlbum {
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 3; i++)
            v.addElement(new Photo(i));
        Printer.printAll(v.elements());
    }
}
