//Создайте класс Bingo в пакете hw3.
//Программа должна загадать целое число в диапазоне от 0 до 100 и
// предложить пользователю его отгадать.
//При вводе числа пользователем, программа проверяет на соответствие
// с загаданным число и если числа совпали вывести сообщение о том, что число отгадано.
//Если числа не совпали, тогда следует вывести надпись о том, что
// задуманное число является больше или меньше вводимого.
//Также программа ведет подсчет попыток, и выводит это количество после
// того как число угадали.
//Предусмотреть возможность досрочного завершения программы, в случае
// если пользователь не желает продолжать угадывать число.

package com.pb.khomich.hw3;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        System.out.println("Угадайте задуманное число в диапазоне от 0 до 100.");
        System.out.println("Для выхода из программы введите отрицательное число.");

        Random random = new Random();

        int x = random.nextInt(101); //загаданное число программой
         System.out.println("rand x: " + x);
        System.out.println("Введи свою цифру: ");
        Scanner scan = new Scanner(System.in);

        int operand1 = scan.nextInt(); //значение пользователя

        for (int i = 1; ; i++) {

            if (x > operand1 && operand1 >= 0) {
                System.out.println("Загаданное число > твоего ");
                System.out.println("Попробуй еще раз: ");
                operand1 = scan.nextInt();
            } else if (x < operand1 && operand1 <= 100) {
                System.out.println("Загаданное число < твоего ");
                System.out.println("Попробуй еще раз:");
                operand1 = scan.nextInt();
            } else if (operand1 > 100) {
                System.out.println("Ты должен ввести число не больше 100!");
                System.out.println("Попробуй еще раз: ");
                operand1 = scan.nextInt();
            } else if (operand1 < 0) {
                System.out.println("Ну раз ты хочешь выйти, то прощай!");
                break;
            } else {
                System.out.println("Ты выиграл! Было загадано число " + x + ". Ты отгадал его за " + i + " попыток.");
                break;
            }
        }
            System.out.println("Конец игры!");
    }
}