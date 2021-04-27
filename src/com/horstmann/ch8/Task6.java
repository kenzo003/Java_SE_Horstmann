package com.horstmann.ch8;

import java.util.stream.IntStream;

// Воспользуйтесь методом String.codePoints() для реализации метода, прове-
//         ряющего, является ли символьная строка словом, состоящим только из букв.
//         (Подсказка: воспользуйтесь методом Character.isAlphabetic().) Реализуйте
//         тем же самым способом метод, проверяющий, является ли символьная строка
//         достоверным в Java идентификатором.

public class Task6 {
    public static void main(String[] args) {
        System.out.println(isWord("abacaba"));
        System.out.println(isWord("abacab1a"));
    }

    public static boolean isWord(String s) {
        IntStream codePoints = s.codePoints();
        return codePoints.allMatch(Character::isAlphabetic);
    }
}
