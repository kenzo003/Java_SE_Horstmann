package com.horstmann.ch6;

import java.util.ArrayList;

public class Arrays {

    public static <T extends Comparable<T>> T max(ArrayList<T> list) {
        T max = null;
        if (list.size() > 0) {
            max = list.get(0);
            for (T t : list) {
                if (t.compareTo(max) > 0) {
                    max = t;
                }
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T min(ArrayList<T> list) {
        T min = null;
        if (list.size() > 0) {
            min = list.get(0);
            for (T t : list) {
                if (t.compareTo(min) < 0) {
                    min = t;
                }
            }
        }
        return min;
    }
}
