//1. Создайте класс CapitalLetter в пакете hw4.
//Напишите программу, которая принимает строку и переводит первую букву слова в верхний регистр.
//Строку должен ввести пользователь.
//Пример работы:
//Истина — это то, что выдерживает проверку опытом. Эйнштейн А.
//Истина — Это То, Что Выдерживает Проверку Опытом. Эйнштейн А.
//При выполнении задания использовать метод(ы).

package com.pb.khomich.hw4;
import java.util.Scanner;

public class CapitalLetter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите строку: ");
        String operand1 = scan.nextLine(); //значение пользователя
        String capitalizeStr = capitalizeString(operand1); //используем метод возведения в заглавную первую букву
        System.out.println(capitalizeStr);
    }

    public static String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray(); //приводим полученное значение в массив и к строчному значение
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {  //перебираем весь массив
            if (!found && Character.isLetter(chars[i])) { // Character.isLetter определяет, является ли указанное значение типа char буквой.
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'' || chars[i]==',' || chars[i]=='?'
                    || chars[i]=='!'|| chars[i]=='-') {
                found = false;
            }
        }
        return String.valueOf(chars);
    }
}
