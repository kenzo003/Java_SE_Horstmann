package com.horstmann.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Напишите программу, вводящую двумерный массив целочисленных значений
//        и определяющую, содержится ли в нем магический квадрат (т.е. одинаковая
//        сумма значений во всех строках, столбцах и диагоналях). Принимая строки
//        вводимых данных, разбивайте их на отдельные целочисленные значения, пре­
//        кратив этот процесс, когда пользователь введет пустую строку. Например, на
//        следующие вводимые данные:
//        16 3 2 13
//        3 10 11 8
//        9 6 7 12
//        4 15 14 1
//        (Пустая строка)

public class Task14 {
    public static void main(String[] args) {
        int[][] magicArray = MagicSquare.input();

        System.out.println("\t\tРезультат: Массив");
        for (int[] itemN : magicArray) {
            System.out.println("\t\t" + Arrays.toString(itemN));
        }

        System.out.println("\t\tЯвляется магическим квадратом: " + MagicSquare.validate(magicArray));
    }

    public static class MagicSquare {
        public static int[][] input() {
            Scanner scanner = new Scanner(System.in);
            String arrayString = "";
            ArrayList<String> array = new ArrayList<>();

            do {
                System.out.println("Введите строку массива: ");
                arrayString = scanner.nextLine();
                if (!arrayString.equals(""))
                    array.add(arrayString);
            } while (!arrayString.equals(""));

            int[][] resArray = new int[array.size()][];

            for (int i = 0; i < array.size(); i++) {
                resArray[i] = Arrays.stream(array.get(i).split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            return resArray;
        }
        public static boolean validate(int[][] value) {
            int status[] = new int[4];
            Arrays.fill(status, 0); // 0 - строки, 1 - столбцы, 2 - глав. диаг, 3 - втор. диаг.
            ArrayList<Integer> result = new ArrayList<>();

            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    //Если матрица не квадратная возвращаем false
                    if (value.length != value[i].length) {
                        return false;
                    } else {
                        status[0] += value[i][j];
                        status[1] += value[j][i];
                        if (i == j)
                            status[2] += value[j][i];
                        if (i + j == value.length - 1)
                            status[3] += value[i][j];
                    }
                }
                if (status[0] != status[1]) {
                    return false;
                } else {
                    result.add(status[0]);
                    status[0] = status[1] = 0;
                }
            }
            result.add(status[2]);
            result.add(status[3]);

            //проверка сумм

            int current = result.get(0);
            for (int item : result) {
                if (item != current){
                    return false;
                }
            }
            return true;
        }
    }
}

