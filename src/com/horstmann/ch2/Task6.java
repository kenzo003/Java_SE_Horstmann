package com.horstmann.ch2;

//5. Реализуйте неизменяемый класс P o in t , описывающий точку на плоскости.
//        Предоставьте его конструктор, чтобы задать конкретную точку; конструктор
//        без аргументов, чтобы задать точку в начале координат; а также методы g e t X (),
//        g e tY (), t r a n s l a t e ( ) и s c a l e ( ) . В частности, метод t r a n s l a t e () должен пере­
//        мещать точку на определенное расстояние в направлении координат х и у, а
//        метод s c a le () — изменять масштаб по обеим координатам на заданный коэф­
//        фициент. Реализуйте эти методы таким образом, чтобы они возвращали новые
//        точки в качестве результата. Например, в следующей строке кода:
//        Point р = new Point(3, 4).translate(1, 3).scale(0.5);
//        в переменной р должна быть установлена точка с координатами (2, 3, 5) .
//
//        6. Повторите предыдущее упражнение, но на этот раз сделайте методы t r a n s
//        la t e () и s c a le () модифицирующими.

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nВведите координаты x и y (через пробел): ");

        String temp = scan.nextLine();
        double[] arrPoint = Arrays.stream(temp.replace(',', '.').split(" ")).mapToDouble(Double::parseDouble).toArray();
        Point point = new Point(arrPoint[0], arrPoint[1]);

        System.out.print("Введите координаты x и y для перемещения точки координат (через пробел): ");
        temp = scan.nextLine();
        arrPoint = Arrays.stream(temp.replace(',', '.').split(" ".replace(',', '.'))).mapToDouble(Double::parseDouble).toArray();
        point.translate(arrPoint[0], arrPoint[1]);

        System.out.print("Введите коэффициент изменения масштаба: ");
        temp = scan.next();
        temp = temp.replace(',', '.');
        double scale = Double.parseDouble(temp);
        point.scale(scale);

        System.out.println("\t\tРезультат: (" + point.getX() + "; " + point.getY() + ")");
    }

    public static class Point {
        //    поле для координаты X
        private double x;
        //    поле для координаты Y
        private double y;

        //    конструктор, задающий конкретную точку
        public Point(double X, double Y) {
            this.x = X;
            this.y = Y;
        }

        //    конструтор, задающий точку в начале координат
        public Point() {
            this(0, 0);
        }

        //    модифицирующий метод, перемещающий точку на определенное расстояние в направлении координат X и Y
        public void translate(double X, double Y) {
            this.x += X;
            this.y += Y;
        }

        //    модифицирующий метод, позволяющий изменить масштаб по обеим координатам на задданный коэффициент
        public void scale(double scale) {
            this.x *= scale;
            this.y *= scale;
        }

        public double getX() {
            return this.x;
        }

        public double getY() {
            return this.y;
        }

    }
}
