package com.horstmann.ch8;

//Определите все символьные строки максимальной длины в заданном конечном
//        потоке символьных строк.

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Task10 {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        words.add("abcdefg");
        words.add("abc");
        words.add("abcd");
        words.add("abcdefghijklmop");
        words.add("edklfdfkdfkdsfp");
        words.add("abcdefghijk");
        words.add("abcdefghijklm");
        words.add("abcde");

        Integer maxLen = words.stream().max(Comparator.comparingInt(String::length)).get().length();
        Stream<String> filtered = words.stream().filter((s) -> s.length() == maxLen);

        filtered.forEach(System.out::println);
    }
}
