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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    //***********************************************************************
    // implements Runnable чтобы запускать в отдельном потоке
    static class Producer implements Runnable {
        // Общая очередь
        private final List<Integer> sharedList;
        // Максимальный размер
        private final int SIZE;

        // Конструктор
        public Producer(List<Integer> sharedList, int size) {
            this.sharedList = sharedList;
            this.SIZE = size;
        }

        @Override
        public void run() {
            // Цикл бесконечен
          //  while (true) {
            for (int i = 0; i < 15; i++) {
                try {
                    // В цикле вызывается метод produce
                    System.out.println("Производим: " + produce());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private Integer produce() throws InterruptedException {
            synchronized (sharedList) { // обязательно synchronized
                while (sharedList.size() == SIZE) {
                    // Если очередь полна, то ждём
                    System.out.println("Ждем когда купят");
                    sharedList.wait();
                }

                // Добавили элемент в очередь.
                Random random = new Random();
                Integer newValue = random.nextInt(1000); //загаданное число программой
                sharedList.add(newValue);


                // Уведомили другой поток на случай, если он ждет
                sharedList.notify();
                //Thread.sleep(1000);
                return newValue;
            }
        }
    }

    // implements Runnable чтобы запускать в отдельном потоке
    static class Consumer implements Runnable {
        // Общая очередь
        private final List<Integer> sharedList;

        public Consumer(List<Integer> sharedQueue) {
            this.sharedList = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {

                try {
                    System.out.println("Покупаем: " + consume());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        // Метод, извлекающий элементы из общей очереди
        private Integer consume() throws InterruptedException {
            synchronized (sharedList) {
                if (sharedList.isEmpty()) { // Если пуста, надо ждать
                    sharedList.wait();
                    System.out.println("Ждем когда произведут");
                }

                Integer position = sharedList.get(0);
                sharedList.remove(0);

                sharedList.notifyAll();
                Thread.sleep(1000); //ВОПРОС если закоментить этот вариант, почему-то местами покупает раньше, чем вывелось произведено, почему

                return position;
            }
        }
    }
    public static void main(String[] strings) throws InterruptedException {
        List<Integer> sharedList = new ArrayList<Integer>();
        int size = 5;
        Thread prodThread = new Thread(new Producer(sharedList, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedList), "Consumer");
        System.out.println("Запуск");
        prodThread.start();
        consThread.start();
    }
}