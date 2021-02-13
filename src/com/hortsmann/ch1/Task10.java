package com.hortsmann.ch1;

//Напишите программу, составляющую произвольную символьную строку из букв и цифр, генерируя произвольное значение типа long
//        и выводя его по основанию 36.

import java.util.Random;

public class Task10 {
    public static void main(String[] args) {
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            result += Long.toUnsignedString(random.nextLong(), 36);

        }
        System.out.println("Результат: " + result);
    }
}
