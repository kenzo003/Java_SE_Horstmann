package com.hortsmann.ch1;

import java.util.Scanner;
import static java.lang.Math.abs;
import static java.lang.Math.floorMod;

//Напишите программу, вводящую целочисленное (как положительное, так и
//        отрицательное) значение угла и нормализующую его в пределах от 0 до 359
//        градусов. Попробуйте сделать это сначала с помощью операции %, а затем метода floorMod().


public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение угла: ");
        int angle = scanner.nextInt();
        int result = abs(angle % 360);
        System.out.println("Результат (%): " + result);
        System.out.println("Результат (floorMod): " + floorMod(angle, 360));
    }
}
