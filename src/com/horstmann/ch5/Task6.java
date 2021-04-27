package com.horstmann.ch5;

//В разделе 5.1.6 приведен пример ошибочного внедрения блока операторов
//        catch и finally в блок кода оператора try . Исправьте этот код, во-первых,
//        перехватив исключение в операторе finally , во-вторых, внедрив блок операторов
//         try/finally в блок операторов try/catch , и в-третьих, применив оператор
//        try с ресурсами вместе с оператором catch

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task6 {
    public static void main(String[] args) {

//        Path path = Paths.get("user.dir");
        Path path = Paths.get("C:\\Users\\alexa\\OneDrive\\Рабочий стол\\1.txt");


        BufferedReader in = null;
        //Catching in finally
        try {
            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            //            Читать из стандартного потока ввода in
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException exception) {
                    System.err.println(exception.getMessage());
                }
            }
        }


        //Try/finally in try/catch
        try {
            try {
                in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }

//        Try with resources
        try (BufferedReader in1 = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            //
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }

/**
 BufferedReader in = null;
 try {
 in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
 //            Читать из стандартного потока ввода in
 } catch (IOException ex) {
 System.err.println("Caught IOException: " + ex.getMessage());
 } finally {
 if (in != null) {
 in.close(); // ВНИМАНИЕ: может быть сгенерировано исключение!
 }
 }
 */
    }
}
