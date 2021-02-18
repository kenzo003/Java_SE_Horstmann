package com.horstmann.ch2;

//Реализуйте полностью класс Invoice, представленный в разделе 2.6.1. Предоставьте метод, выводящий счет-фактуру,
//        и демонстрационную версию программы, составляющей и выводящей образец счета-фактуры.

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Task15 {
    public static void main(String[] args) {

        var inv = new Invoice();
        inv.add(new Invoice.Item("itemA", 2, 10.2));
        inv.add(new Invoice.Item("itemB", 20, 1.2));
        inv.add(new Invoice.Item("itemC", 100, 20.2));
        inv.printDemo();
        inv.print();
    }

    public static class Invoice {
        private final ArrayList<Item> items = new ArrayList<>();

        public void add(Item item) {
            items.add(item);
        }

        public void print() {
            for (Item item : items) {
                System.out.println(item.description + " " + item.quantity + " " + item.unitPrice);
            }
        }

        public void printDemo() {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }

        public static class Item {
            private String description;
            private int quantity;
            private double unitPrice;

            public Item(String description, int quantity, double unitPrice) {
                this.description = description;
                this.quantity = quantity;
                this.unitPrice = unitPrice;
            }

            public double price() {
                return quantity * unitPrice;
            }

            public String toString() {
                return "Item{" +
                        "description='" + description + '\'' +
                        ", quantity=" + quantity +
                        ", unitPrice=" + unitPrice +
                        "}";
            }
        }
    }

}
