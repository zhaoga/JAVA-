package com.p7;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Vector;

interface Compare{
    boolean lessThan(Object lhs, Object rhs);
    boolean lessThanOrEqual(Object lhs, Object rhs);
}

class SortVector extends Vector {
    private Compare compare;

    public SortVector(Compare compare) {
        this.compare = compare;
    }

    public void sort() {
        quickSort(0,size()-1);
    }

    private void quickSort(int left, int right) {
        if (right>left) {
            Object o1 = elementAt(right);
            int i = left-1;
            int j = right;
            while (true) {
                while (compare.lessThan(elementAt(++i),o1));
                while (j>0)
                    if (compare.lessThanOrEqual(elementAt(--j),o1))
                        break;
                    if (i>j)
                        break;
                    swap(i,j);
            }
            swap(i,right);
            quickSort(left,i-1);
            quickSort(i+1,right);
        }
    }
    private void swap(int loc1, int loc2) {
        Object tmp = elementAt(loc1);
        setElementAt(elementAt(loc2),loc1);
        setElementAt(tmp,loc2);
    }
}

public class QuickSortTest {
    static class StringCompare implements Compare {

        @Override
        public boolean lessThan(Object lhs, Object rhs) {
            return ((String) lhs).toLowerCase().compareTo(
                    ((String) rhs).toLowerCase()) < 0;
        }

        @Override
        public boolean lessThanOrEqual(Object lhs, Object rhs) {
            return ((String) lhs).toLowerCase().compareTo(
                    ((String) rhs).toLowerCase()) <= 0;
        }
    }
    public static void main(String[] args) {
        SortVector sv = new SortVector(new StringCompare());
        sv.addElement("d");
        sv.addElement("A");
        sv.addElement("C");
        sv.addElement("c");
        sv.addElement("b");
        sv.addElement("B");
        sv.addElement("D");
        sv.addElement("a");
        sv.sort();
        Enumeration e = sv.elements();
        while (e.hasMoreElements())
            System.out.println(e.nextElement());
    }
}
