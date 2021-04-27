package com.horstmann.ch5;

//Напишите рекурсивный метод factorial(), выводящий все кадры стека перед
//        возвратом значения. Постройте (но не генерируйте) объект исключения любо
//        го типа и получите результат трассировки его стека, как пояснялось в разделе 5.1.8.
//

public class Task10 {
    public static void main(String[] args) {
        factorial(6);
    }

    private static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater 0");
        } else if (n <= 1) {
            return 1;
        }
        new Exception("Factorial exception").printStackTrace();
        return n * factorial(n - 1);
    }
}
