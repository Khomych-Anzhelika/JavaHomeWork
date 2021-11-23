package com.pb.khomich.hw9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class FileNumbers {
    
    public static void main(String[] args) {
        createNumbersFile();
        //  createOddNumbersFile();

        //Path path = Paths.get("C:/Users/User/Desktop/Java/JavaHomeWork/hw9_file.txt");
        int[] array = new int[100];

        // Creates a reader using the FileReader
        try (Reader reader = new FileReader("C:/Users/User/Desktop/Java/JavaHomeWork/hw9_file.txt")) {

            // Checks if reader is ready
            System.out.println("Is there data in the stream?  " + reader.ready());

            // Reads characters
            reader.read(array);
            System.out.println("Data in the stream:");
            System.out.println(array);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void createNumbersFile() {

        int[][] array = new int[10][10];
        Random random = new Random();

        int x = random.nextInt(101);
        // Заполнение массива
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = random.nextInt(100);
            }
        }

        Path path = Paths.get("C:/Users/User/Desktop/Java/JavaHomeWork/hw9_file.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    writer.write(" " + array[i][j]);
                }
                writer.newLine();
            }
        } catch (Exception ex) {
            System.out.println("Error with file write: " + ex);
        }
        System.out.println("Write to file \"" + path.toAbsolutePath() + "\" done!");
    }

    /*- createOddNumbersFile - читает файл "numbers.txt",
    и создает на основе него новый файл "odd-numbers.txt"
    в который входят все числа из "numbers.txt" только все четные заменены на 0.
     */
//    private static void createOddNumbersFile() {
//
//        Path path = Paths.get("C:/Users/User/Desktop/Java/JavaHomeWork/hw9_file.txt");
//
//        try (BufferedReader reader = Files.newBufferedReader(path)) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                int[] numArr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
//                for (int i = 0; i< numArr.length; i++) {
//                    if (numArr[i]%2==0) {
//                        numArr[i] = 0;
//                    }
//                }
//                String sorted1 = String.valueOf(numArr); //преобразуем в нужный тип данных (String)
//                System.out.println(sorted1);
//            }
//
//        } catch (Exception ex) {
//            System.out.println("Error with file read: " + ex);
//        }
//        System.out.println("Read from file done!");
//    }
}