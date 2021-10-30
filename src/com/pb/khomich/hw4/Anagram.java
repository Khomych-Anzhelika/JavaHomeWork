//2. Создайте класс Anagram в пакете hw4.
//Напишите программу, которая определяет, является ли одна строка анаграммой другой строки.
//Обе строки вводит пользователь.
//Анаграмма - это слово или фраза, сделанная путем переноса букв другого слова или фразы.
//Программа должна игнорировать пробелы и знаки препинания.
//Пример анаграмм:
//Аз есмь строка, живу я, мерой остр. -> За семь морей ростка я вижу рост.
//Я в мире — сирота. -> Я в Риме — Ариост.
//При выполнении задания использовать метод(ы).
//австралопитек - ватерполистка

package com.pb.khomich.hw4;

import java.util.Arrays;
import java.util.Scanner;


    public class Anagram {

        private static String delNoDigOrLet (String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetterOrDigit(s.charAt(i))) //charAt() — возвращает символ, расположенный по указанному индексу строки.
                                                             //isLetterOrDigit - Вказує, чи відноситься вказаний символ Unicode до категорії літери чи десяткової цифри.
                                                             //Character - класс обертка над char
                sb.append(s.charAt(i)); //append() — обновляет значение объекта, который вызвал метод.
            }
            return sb.toString();
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите строку 1: ");
            String str1 = scan.nextLine(); //значение пользователя
            str1 = delNoDigOrLet(str1);//удаляем все что не буквы или цифры
            str1 = str1.toLowerCase();//приводим все к строчной букве

            char[] ar1 = str1.toCharArray(); //приводим к массиву строку
            Arrays.sort(ar1); //сортируем массив
            String sorted1 = String.valueOf(ar1); //преобразуем в нужный тип данных (String)

            //System.out.println(sorted1) ;

            System.out.println("Введите строку 2: ");
            String str2 = scan.nextLine(); //значение пользователя
            str2 = delNoDigOrLet(str2);
            str2 = str2.toLowerCase();

            char[] ar2 = str2.toCharArray();
            Arrays.sort(ar2);
            String sorted2 = String.valueOf(ar2);

            //System.out.println(sorted2) ;
            if (sorted1.equals(sorted2)) {
                System.out.println("Введенные предложения анаграмма!");
            }else{
                System.out.println("Введенные предложения не являются анаграммой");
            }
        }
    }



