package com.horstmann.ch2;

import java.util.List;
import java.util.Random;

//Предоставьте в классе RandomNumbers два статических метода типа random
//        Element, получающих произвольный элемент из обычного или списочного
//        массива целочисленных значений. (Если обычный или списочный массив пуст,
//        должен быть возвращен нуль.) Почему эти методы нельзя сделать методами
//        экземпляра типа t[] или ArrayList<Integer> ?

public class Task10 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> arr2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(RandomNumbers.randomElement(arr));
        System.out.println(RandomNumbers.randomElement(arr2));
    }

    public static class RandomNumbers {

        public static int randomElement(int[] data) {
            Random random = new Random();
            return data[random.nextInt(data.length)];
        }


        public static int randomElement(List<Integer> data) {
            Random random = new Random();
            if (data.isEmpty()) {
                return 0;
            } else
                return data.get(random.nextInt(data.size()));
        }
    }
}
