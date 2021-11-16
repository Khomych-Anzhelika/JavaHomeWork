package com.pb.khomich.hw7;
/*
Эти методы не принимают параметров, а только выводят информацию о одежде (название, размер, цену, цвет).
+Создать абстрактный класс Clothes (одежда) содержащий переменные размер (типа Size), стоимость, цвет.

Создать классы наследники Clothes:
- Tshirt (футболка) реализует интерфейсы ManClothes и WomenClothes,
- Pants (штаны) реализует интерфейсы ManClothes и WomenClothes,
- Skirt (юбка) реализует интерфейс WomenClothes,
- Tie (галстук) реализует интерфейс ManClothes.


+Создать класс Atelier с методом main, и еще двумя статическими методами:
+dressMan(Clothes[] clothes)
+dressWomen(Clothes[] clothes)
+на вход которых будет поступать массив, содержащий все типы одежды.
+В методе main создать массив, содержащий все типы одежды,
+и вызвать методы dressMan и dressWomen передав туда этот массив.

Метод dressWomen выводит на консоль всю информацию о женской одежде.
Метод dressMan выводит на консоль всю информацию о мужской одежде.
В методах dressWomen и dressMan использовать оператор instanceof
для определения мужская это одежда или женская.

По желанию можно использовать внутренние классы.*/
import java.util.Arrays;

public class Atelier {

    public static void main(String[] args) {
        System.out.println(Size.L.toString());
        System.out.println(Size.XXS.toString());
        System.out.println();

        Clothes[] clothes = {
                new Tshirt(600, "малиновый", Size.L),
                new Tshirt(900, "белый", Size.L),
                new Pants(500, ",бордовый", Size.XXS),
                new Pants(1500, "сине-черный", Size.L),
                new Skirt(620, "черный", Size.L),
                new Skirt(700, "синий", Size.XS),
                new Tie(250, "малиновый", Size.M),
                new Tie(1200, "черный", Size.L),
        };

        dressMan(clothes);
        System.out.println();
        dressWomen(clothes);
    }


    public static void dressMan(Clothes[] clothes) {
        System.out.println("Можем одеть на мужчину:");
        for (Clothes clothe : clothes) {
            if (clothe instanceof ManClothes) {
                System.out.println(clothe);
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        System.out.println("Можем одеть на женщину:");
        for (Clothes clothe : clothes) {
            if (clothe instanceof WomenClothes) {
                System.out.println(clothe);
            }
        }
    }
}
