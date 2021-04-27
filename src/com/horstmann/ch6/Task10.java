package com.horstmann.ch6;

import java.util.ArrayList;

import com.horstmann.ch6.Arrays;

import java.util.Comparator;
import java.util.List;

public class Task10 {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("8");
        strings.add("2");
        strings.add("7");
        Arrays.min(strings);
        System.out.println(Arrays.min(strings));
        System.out.println(Arrays.max(strings));
    }

}

