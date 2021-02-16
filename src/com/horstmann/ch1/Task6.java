package com.horstmann.ch1;

//Напишите программу, вычисляющую факториал п ! = 1 х 2 * . . . х п,
// используя класс Biglnteger. Вычислите факториал числа 1000.

import java.math.BigInteger;

public class Task6 {
    public static void main(String[] args) {
        System.out.println("Результат: " + factorial(1000));

    }

    private static BigInteger factorial(int value) {

        BigInteger result = new BigInteger("1");

//        Факториал от 0
        if (value == 0) {
            return result;
        }
//        Факториал отриц. чисел
        else if (value < 0) {
            return null;
        }
//Факториал от натурального числа
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
