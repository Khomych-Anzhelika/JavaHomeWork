package com.pb.khomich.hw7;
/*+Создать класс Atelier с методом main, и еще двумя статическими методами:
+dressMan(Clothes[] clothes)
+dressWomen(Clothes[] clothes)
+на вход которых будет поступать массив, содержащий все типы одежды.
+В методе main создать массив, содержащий все типы одежды,
и вызвать методы dressMan
и dressWomen передав туда этот массив.

Метод dressWomen выводит на консоль всю информацию о женской одежде.
Метод dressMan выводит на консоль всю информацию о мужской одежде.
В методах dressWomen и dressMan использовать оператор instanceof
для определения мужская это одежда или женская.*/

public class Atelier {
    public static void main(String[] args) {
        Pants  pants  = new Pants();
        Skirt  skirt  = new Skirt();
        Tshirt tshirt = new Tshirt();
        Tie    tie    = new Tie();

        Clothes[] notebooks = new Clothes[] {pants, skirt, tshirt, tie};
        makeCallToEmergency(notebooks);
    }

    public static void dressMan(Clothes[] clothes) {

    }

    public static void dressWomen(Clothes[] clothes) {

    }

}
