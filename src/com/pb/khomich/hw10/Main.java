package com.pb.khomich.hw10;

import static jdk.nashorn.internal.objects.Global.print;

/*Создать пакет hw10.
Реализовать параметризованный класс NumBox, T - параметр типа.
Параметром должен быть любой класс-наследник Number
(задать необходимое условие при объявлении класса NumBox).

Класс содержит:
- массив из объектов класса T, инициализировать массив в конструкторе.
- конструктор принимающий параметр - максимальную длину массива.
- метод void add(T num) добавляющий число в массив. В случае если массив полон - выбросить исключение.
- метод T get(int index) возвращающий число по индексу.
- метод int length() возвращает текущее количество элементов.

- метод double average() - подсчет среднего арифметического среди элементов массива.
- метод double sum() - сумма всех элементов массива.
- метод T max() - максимальный элемент массива.
При подсчете воспользоваться тем, что у любого из объектов подклассов Number есть
методы intValue, doubleValue, floatValue и другие.

Создать класс Main с методом main где протестировать полученный класс на примере
NumBox<Float> и NumBox<Integer>.*/
public class Main {
    public static void main(String[] args) {
        NumBox<Integer> box = new NumBox<>(3);

        box.add(0, 39);
        box.add(1, 18);
        box.add(2, 65);
        box.add(3, 11); //пример выпадения в ошибку излишнего элемента

        System.out.println(box.get(1)); //показываем элемент массива
        System.out.println(box.length()); //показываем длину массива
        System.out.println(box.average()); //показываем среднее
        System.out.println(box.sum()); //показываем сумму
        System.out.println(box.max()); //показываем максимальное значение в массиве

        System.out.println("/******************************/");
        NumBox<Float> box1 = new NumBox<>(5);

        box1.add(0, (float) 39.15);
        box1.add(1, (float) 18.01);
        box1.add(2, (float) 65.89);
        box1.add(3, (float) 17.09);
        box1.add(4, (float) 89.89);

        System.out.println(box1.get(1)); //показываем элемент массива
        System.out.println(box1.length()); //показываем длину массива
        System.out.println(box1.average()); //показываем среднее
        System.out.println(box1.sum()); //показываем сумму
        System.out.println(box1.max()); //показываем максимальное значение в массиве

    }

}
