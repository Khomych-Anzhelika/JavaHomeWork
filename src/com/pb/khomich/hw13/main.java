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
    public static void main(String[] strings) throws InterruptedException {
        List<Integer> sharedList = new ArrayList<Integer>();
        int size = 5;
        Thread prodThread = new Thread(new Producer(sharedList, size), "Producer");
        //  sharedList.add(2);
       // System.out.println("Запуск потока Производитель");
        prodThread.start();

        Thread consThread = new Thread(new Consumer(sharedList, size), "Consumer");
       // System.out.println("Запуск потока Покупатель");
        consThread.start(); //ВОПРОС если закоментить, то сначала наполняеются все элементы массива....а если раскоментить, то по одному выполнению, почему так что упускаю?

    }

    public class ConsoleColors {
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
    }
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
            while (true) {
               //  for (int i = 0; i < 15; i++) {
                try {
                    // В цикле вызывается метод produce
                    System.out.println(ConsoleColors.ANSI_RED + "Производим: " + produce() +  ConsoleColors.ANSI_RESET);
                    System.out.println(ConsoleColors.ANSI_YELLOW + sharedList + ConsoleColors.ANSI_RESET);
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
                    sharedList.notify(); //версия 2.0 теперь отрабатывает все ок
                    sharedList.wait();
                }

                // Добавили элемент в очередь.
                Random random = new Random();
                Integer newValue = random.nextInt(1000); //загаданное число программой
                sharedList.add(newValue);

                // Уведомили другой поток на случай, если он ждет
                //sharedList.notify(); //версия 2.0
                //Thread.sleep(1000);  //версия 2.0
                return newValue;
            }
        }
    }

    // implements Runnable чтобы запускать в отдельном потоке
    static class Consumer implements Runnable {
        // Общая очередь
        private final List<Integer> sharedList;
        private final int SIZE;


        public Consumer(List<Integer> sharedList, int size){
            this.sharedList = sharedList;
            this.SIZE = size;

        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(ConsoleColors.ANSI_BLUE + "Покупаем: " + consume() + ConsoleColors.ANSI_RESET);
                    System.out.println(ConsoleColors.ANSI_YELLOW + sharedList + ConsoleColors.ANSI_RESET);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        // Метод, извлекающий элементы из общей очереди
        private Integer consume() throws InterruptedException {
            synchronized (sharedList) {
                while (sharedList.isEmpty()) { // Если пуста, надо ждать
                    System.out.println("Ждем когда произведут");
                    sharedList.notify();//версия 2.0
                    sharedList.wait();
                }

                Integer position = sharedList.get(0);
                sharedList.remove(0);

                //sharedList.notify(); //версия 2.0
                //Thread.sleep(1000); //версия 2.0, ВОПРОС если закоментить этот вариант, почему-то местами покупает раньше, чем вывелось произведено, почему

                return position;
            }
        }
    }
}