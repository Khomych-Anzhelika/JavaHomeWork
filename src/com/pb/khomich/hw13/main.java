package com.pb.khomich.hw13;

/*Создать пакет hw13.
Написать программу решающую классическую задачу производитель и потребитель.

Два потока разделяют общий буфер данных, размер которого ограничен, например не больше 5
элементов.


Производитель генерирует некоторые данные (можно выбрать любые, числа, символы, строки)
и помещает их в буфер.


Потребитель «потребляет» их из буфера - выводит на печать в консоль и очищает буфер.
Если буфер пуст, потребитель должен ждать, пока там появятся данные.
Если буфер заполнен полностью, производитель должен ждать, пока потребитель заберёт
данные и место освободится.
В качестве буфера можно выбрать, например Queue или List, но реализация не должна
быть потокобезопасная (например LinkedList).*/

/*public class main {

        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;



    //Дано два потока — производитель и потребитель.
    static class СonsumerFlow extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
//                try {
//                    //Приостанавливает поток на 1 секунду максимум
//                    sleep(rand.nextInt(1000));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println("Потребляю!");
            }
            //Слово «яйцо» сказано 5 раз
        }
    }


    public static void main(String[] args) {
        // Создание потока
        СonsumerFlow consFlow = new СonsumerFlow();

        // Запуск потока
        consFlow.start();

        for (int i = 0; i < 5; i++) {
            try {
                // Приостанавливает поток на 1 секунду максимум
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("курица!");
        }

        // Слово «курица» сказано 5 раз
        // Если оппонент еще не сказал последнее слово
        if (consFlow.isAlive()) {
            try {
                // Подождать пока оппонент закончит высказываться.
                consFlow.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Первым появилось яйцо!");

        } else {
            //если оппонент уже закончил высказываться
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }
}*/