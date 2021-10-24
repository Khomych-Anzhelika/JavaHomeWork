//2. Создайте класс Array в пакете hw3.Программа должна позволить
//+пользователю ввести одномерный массив целых чисел размерностью 10 элементов.
//+Вывести на экран введенный массив.
//+Подсчитать сумму всех элементов массива и вывести ее на экран.
//+Подсчитать и вывести на экран количество положительных элементов.
//Произвести сортировку этого массива от меньшего к большему по алгоритму сортировки пузырьком. (https://en.wikipedia.org/wiki/Bubble_sort)
//Вывести на экран отсортированный массив.

package com.pb.khomich.hw3;
import java.util.Scanner;

public class Array {
    public static void sort(int[] array) {
        // i - номер прохода
        for (int i = 0; i < array.length - 1; i++) {
            // внутренний цикл прохода
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] array = new int[9];
        int x = array.length;

        // Заполнение массива.
        for (int i = 0; i < x; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введи " + (i + 1) + "  элемент массива:");
            array[i] = scan.nextInt();
        }
        // Вывод на экран значений элементов массива.
        System.out.println("Вами введен массив: {" + array[0] + "," + array[1] + "," + array[2] + "," + array[3] + "," + array[4] + "," + array[5] + "," + array[6] + "," + array[7] + "," + array[8] + "}");

        int sum = 0;
        for (int num : array) {
            sum = sum + num;
        }
        System.out.println("Сумма элементов массива равна: " + sum);

        //Подсчитать и вывести на экран количество положительных элементов.
        int cnt = 0;
        for (int i = 0; i < x; i++) {
            if (array[i] > 0) {
                cnt = cnt + 1;
            } else {
                cnt = cnt;
            }
        }
        System.out.println("Количество положительных элементов массива равна: " + cnt);

        System.out.print("Отсортированный массив: ");
        sort(array);
        for(int i = 0; i <  x; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
