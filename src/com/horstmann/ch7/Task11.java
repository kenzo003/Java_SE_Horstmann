package com.horstmann.ch7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Напишите программу для чтения предложения в списочный массив. Затем
//        перетасуйте в массиве все слова, кроме первого и последнего, используя метод
//        Collections. shuffle(), но не копируя слова в другую коллекцию.

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.hasNextLine() ? scanner.nextLine() : null;
        if (line != null) {
            List<String> words = Arrays.asList(line.split(" "));
            if (words.size() > 1) {
                Collections.shuffle(words.subList(1, words.size() - 1));
            }
            for (String word : words) {
                System.out.print(word + " ");
            }
        }
    }
}
