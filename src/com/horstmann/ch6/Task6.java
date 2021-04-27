package com.horstmann.ch6;

//        Реализуйте обобщенный метод, присоединяющий все элементы из одного
//        списочного массива к другому. Воспользуйтесь метасимволом подстановки для
//        обозначения одного из аргументов типа. Предоставьте два равнозначных решения:
//         одно с подстановочным типом ? extendsЕ, другое — с подстановочным
//        типом ? super Е.

import java.util.ArrayList;

public class Task6 {
    public static void main(String[] args) {
        ArrayList<String> arr1 = new ArrayList<String>();
        arr1.add("1");
        arr1.add("2");
        arr1.add("3");

        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);


        System.out.println(arr1.toString());
        System.out.println(arr2.toString());
        System.out.println(join1(arr1, arr2));
        System.out.println(join2(arr2, arr2));

    }

    /*
    Мы не знаем какой точно тип расширяет тип Т, поэтому проще всего
    сохранить в общем супертипе Т.
     */
    public static <T> ArrayList<T> join1(ArrayList<? extends T> a,
                                         ArrayList<? extends T> b) {
        ArrayList<T> arrayList = new ArrayList<>();
        arrayList.addAll(a);
        arrayList.addAll(b);
        return arrayList;
    }

    /*
    Т.к. мы не знаем какой супертип типа Т хранится в полученных элементах
    (к слову в массивах могут быть разные супертипы!), проще всего сохранить
    списочный массив Object.
     */
    public static <T> ArrayList join2(ArrayList<? super T> a,
                                      ArrayList<? super T> b) {
        ArrayList arrayList = new ArrayList<>();
        arrayList.addAll(a);
        arrayList.addAll(b);
        return arrayList;
    }
}
