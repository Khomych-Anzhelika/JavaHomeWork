package com.pb.khomich.hw9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileNumbers {

    public static void main(String[] args) {
        createNumbersFile();
        createOddNumbersFile();
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

        Path path = Paths.get("C:/Users/User/Desktop/Java/JavaHomeWork/numbers.txt");

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
    private static void createOddNumbersFile() {
        int [][] arr = new int[10][10];

        try
        {
            Scanner sc = new Scanner(new File("C:/Users/User/Desktop/Java/JavaHomeWork/numbers.txt"));
            for (int i = 0; i < 10; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    arr[i][j] = sc.nextInt();
                    System.out.println(arr[i][j]);

                }
            }
            sc.close();
            System.out.println("read()'s ending");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Sorry, File not found!");
        }
        catch (InputMismatchException e)
        {
            System.out.println("Sorry, InputMismatchException");
        }

        //заменяем четное число на 0
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] % 2 == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        //выводим в файл массив
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/User/Desktop/Java/JavaHomeWork/odd-numbers.txt"));
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    bw.write(String.valueOf(arr[i][j]));
                    bw.write(" ");
                }
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



