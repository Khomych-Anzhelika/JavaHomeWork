package com.pb.khomich.hw11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    Обеспечить следующий функционал:
    добавление элемента
    удаление элемента
    поиск элементов
    вывод всех записей с сортировкой по указанному полю (можно ограничиться двумя на выбор)
    редактирование элемента
    запись в файл всех данных
    загрузка из файла всех данных
    */
    static int ChoiceMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Для добавления контакта нажмите         - 1");
        System.out.println("Для удаления контакта нажмите           - 2");
        System.out.println("Для поиска нажмите                      - 3");
        System.out.println("Для просмотра контактов нажмите         - 4");
        System.out.println("Для редактирования контакта нажмите     - 5");
        System.out.println("Для выгрузки контактов в файл нажмите   - 6");
        System.out.println("Для загрузки контактов из файла нажмите - 7");
        System.out.println("Для выхода из приложения нажмите        - 0");
        System.out.println("\n");
        System.out.println("Сделайте ваш выбор");
        int menu = scan.nextInt(); //значение нужного действия
        return menu;
    }

    public static void main(String[] args) throws Exception {
        int start = 0;
        ArrayList<Contact> contacts = new ArrayList<>();
        System.out.println("Добро пожаловать в телефонную книгу:");
        while (start == 0) {
            int menu = ChoiceMenu();

            if (menu == 1) {
                System.out.println("Ну что создадим пользователя?");
                List<String> phone1 = Arrays.asList("0638812381", "0994015432");
                Contact person = new Contact("Смирнов Артур Петрович", LocalDate.of(2000, 2, 12), phone1, "Днепр, улица Красная 119");
                try {
                    //Вывод данных
                    Scanner scanAdd = new Scanner(System.in);
                    System.out.println("Создадим новый контакт:");
                    System.out.print("ФИО: ");
                    String addFio = scanAdd.nextLine();
                    System.out.print("Дату рождения (в формате \"yyyy-MM-dd\"): ");
                    String addDate = scanAdd.nextLine();
                    System.out.print("Адрес: ");
                    String addAddress = scanAdd.nextLine();
                    System.out.print("Телефон: ");
                    String phoneValue = scanAdd.nextLine();

                    DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE;
                    LocalDate addDateBD = LocalDate.parse(addDate, format);

                    List<String> addPhone = Arrays.asList(phoneValue);
                    Contact addNew = new Contact(addFio, addDateBD, addPhone, addAddress);

                    System.out.println(addNew);
                    contacts.add(addNew);
                } catch (Exception ex) {
                    System.out.println("Ошибка добавления данных." + ex);
                }
                System.out.println("Кол-во контактов:" + contacts.size());
               // System.out.println(contacts);
            }
            if (menu == 2) {
                System.out.println("Удалим контакт");



            } else if (menu == 3) {
                System.out.println("Поиск");
            } else if (menu == 4) {
                System.out.println("Вывод всех записей с сортировкой");
                System.out.println("По номеру телефона - 1");
                System.out.println("По номеру телефона - 1");


                //вывод всех записей с сортировкой по указанному полю (можно ограничиться двумя на выбор)

            } else if (menu == 5) {
                System.out.println("Редактирование");
            } else if (menu == 6) {
                System.out.println("Выгрузка");
            } else if (menu == 7) {
                System.out.println("Загрузка");
            } else if (menu == 8) {
                System.out.println("Выход");
            } else if (menu > 8)
                System.out.println("Ошибка выбора. Данное меню недоступно");

        }
    }

    }

                //File file = Paths.get("files/person.data").toFile();
                //FileOutputStream outputStream = new FileOutputStream(file);
                //ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            /*Contact person = new Contact("Семенов Андрей Константинович",
                                         LocalDate.of(1987,07,14),
                                         ["0638812381","0951689632"], "Днепр, ул. Красная 8")   ;*/
          /*  person.setDog(new Dog("Rex"));
            List<Person> list = new ArrayList<>();
            list.add(person);
            list.add(new Person("Jack", "0991244566", LocalDate.now()));


            // сохраняем в файл
            objectOutputStream.writeObject(list);

            //закрываем поток и освобождаем ресурсы
            objectOutputStream.close();*/

