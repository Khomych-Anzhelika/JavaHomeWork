//2) Напишите программу определения интервала.
//Создайте класс Interval в пакете hw2.
//Предложите пользователю ввести целое число и сохраните его в переменную с произвольным именем.
//Программа должна выяснить в какой промежуток попадает введенное число [0 -14] [15 - 35] [36 - 50] [51 - 100].
//Вывести на экран сообщение с подходящим промежутком.
//Если введенное число не попадает в один из имеющихся промежутков, то вывести соответствующее сообщение.

package com.pb.khomich.hw2;
import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите целое значение:");
        int x = scan.nextInt();

        if (x>=0 && x <= 14)
            System.out.println("[0 -14]");
        if (x>=15 && x <= 35)
            System.out.println("[15 - 35]");
        if (x>=36 && x <= 50)
            System.out.println("[36 - 50]");
        if (x>=51 && x <= 100)
            System.out.println("[51 - 100]");
        if (x<0 || x>100)
            System.out.println("Значение не входит ни в один из известных промежутков!");
    }
}


