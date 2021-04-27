package com.horstmann.ch4;

//        Воспользуйтесь примером кода из раздела 4.5.1 для перечисления всех
//        методов из класса типа int[] . В качестве дополнительного задания можете выявить
//        один метод, обсуждавшийся в этой главе, как неверно описанный.

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) {
        printMethods("[I"); // int[] class
    }


//    Class<?> cl = Class.forName(com.horstmann.ch2.Task10);
//        while(cl!=null)
//
//    {
//        for (Method m : cl.getDeclaredMethods()) {
//            System.out.println(
//                    Modifier.toString(m.getModifiers()) + " " +
//                            m.getReturnType().getCanonicalName() + " " +
//                            m.getName() + Arrays.toString(m.getParameters()));
//        }
//        cl = cl.getSuperclass();
//    }

    public static void printMethods(String className) {
        Class<?> cl = null;
        try {
            cl = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }

        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " + m.getReturnType().getCanonicalName()
                                + " " + m.getName() + Arrays.toString(m.getParameters()));
            }
            cl = cl.getSuperclass();
        }
    }
}


