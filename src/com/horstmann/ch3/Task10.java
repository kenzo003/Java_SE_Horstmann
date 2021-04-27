package com.horstmann.ch3;

import java.io.File;
import java.io.FileFilter;
import java.util.Objects;

import static com.horstmann.ch3.PrintUtil.print;

// Используя методы listFiles(FileFilter) и isDirectory из класса java.io.File,
//         напишите метод, возвращающий все подкаталоги из заданного каталога.
//         Воспользуйтесь для этой цели лямбда-выражением вместо объекта типа
//         FileFilter. Сделайте то же самое, используя ссылку на метод и анонимный
//         внутренний класс.

public class Task10 {
    public static void main(String[] args) throws Exception {
        String classpath = System.getProperty("user.dir");

//        String classpath = Task10.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        System.out.println("---With method reference:");
        print(getSubdirectories(classpath));
        System.out.println("---With lambda expression:");
        print(getSubdirectoriesLambda(classpath));
        System.out.println("---With anonymous inner class:");
        print(getSubdirectoriesInnerClass(classpath));

    }



    private static File[] getSubdirectories(String path) {
        File[] dirs = new File(path).listFiles(File::isDirectory);
        return dirs == null ? new File[0] : dirs;
    }

    private static File[] getSubdirectoriesInnerClass(String path) {
        File[] dirs = new File(path).listFiles(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory();
            }
        });
        return dirs == null ? new File[0] : dirs;
    }

    private static File[] getSubdirectoriesLambda(String path) {
        File[] dirs = new File(path).listFiles(f -> f.isDirectory());
        return dirs == null ? new File[0] : dirs;
    }
}

class PrintUtil {
    public static <T> void print(T[] values) {
        Objects.requireNonNull(values);
        for (T v : values) {
            System.out.println(v);
        }
    }
}
