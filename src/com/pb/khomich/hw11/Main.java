package com.pb.khomich.hw11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

public class Main {
    /*
    редактирование элемента
    запись в файл всех данных
    загрузка из файла всех данных
    */
    static int ChoiceMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n");
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

        List<String> phons1 = Arrays.asList("0638812381");
        List<String> phons2 = Arrays.asList("0994015432", "0662547896");
        List<String> phons3 = Arrays.asList("0567655702");
        contacts.add(new Contact("Хомич Анжелика Александровна", LocalDate.of(1992, 8, 20), phons1, "г.Днепр"));
        contacts.add(new Contact("Сидоров С.С.", LocalDate.of(1987, 5, 15), phons2, "г.Харьков"));
        contacts.add(new Contact("Гаврильченко Андрей", LocalDate.of(1988, 7, 15), phons3, "г. Обуховка"));

        while (start == 0) {
            int menu = ChoiceMenu();

            if (menu == 1) {
                System.out.println("Ну что создадим пользователя?");
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
                System.out.println("Кол-во контактов в телефонной книге:" + contacts.size());
            }
            if (menu == 2) {
                try {
                    Scanner scanAdd = new Scanner(System.in);
                    System.out.println("Удаление по ФИО, введите данные:");
                    String delFio = scanAdd.nextLine();
                    if (contacts.removeIf(cs -> Objects.equals(cs.getFIO(), delFio))
                    ) {
                        System.out.println("Удаление выполнено.");
                    } else System.out.println("Контакты для удаления не найдены.");
                    System.out.println("Кол-во контактов в телефонной книге:" + contacts.size());

                } catch (Exception ex) {
                    System.out.println("Ошибка удаления данных." + ex);
                }
                continue;
            }
            if (menu == 3) {
                try{
                Scanner scanAdd = new Scanner(System.in);
                System.out.println("Поиск по ФИО, введите данные:");
                String foundFio = scanAdd.nextLine();
                int qtyElem = 0;

                for (int i = 0; i < contacts.size(); i++) {
                    boolean res = foundFio.equals(contacts.get(i).getFIO());
                        if (res == true) {
                            qtyElem++;
                            contacts.get(i).info();
                        } else System.out.println("Контакты не найдены.");
                    }
                } catch (Exception ex) {
                    System.out.println("Ошибка поиска данных." + ex);
                }
                continue;
            }
            if (menu == 4) {
                try {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Вывод всех записей с сортировкой");
                    System.out.println("По дате рождения - 1");
                    System.out.println("По ФИО - 2");
                    System.out.println("Выберете нужный вид сортировки:");
                    int sort = scan.nextInt(); //значение нужного действия
                    if (sort == 1) {
                        contacts.sort(Comparator.comparing(c -> c.getDateOfBirth()));
                        System.out.println("Список контактов по дате рождения:");
                        for (int i = 0; i < contacts.size(); i++) {
                            contacts.get(i).info();
                        }
                        continue;
                    }
                    if (sort == 2){
                        contacts.sort(Comparator.comparing(c -> c.getFIO()));
                        System.out.println("Список контактов по ФИО:");
                        for (int i = 0; i < contacts.size(); i++) {
                            contacts.get(i).info();
                        }
                        continue;
                    }
                    if (sort > 2) {
                        System.out.println("Выбран неверный код сортировки");
                    }
                }catch (Exception ex) {
                    System.out.println("Ошибка сортировки данных." + ex);
                }
                continue;
            } else if (menu == 5) {
                System.out.println("Редактирование котакта");
                if (contacts.isEmpty()) {
                    System.out.println("Ваша телефонная книга пуста");
                } else {
                    for (int i = 0; i < contacts.size(); i++) {

                        //System.out.println("#" + (i + 1) + " " + contacts.get(i).info());
                        //System.out.println("Старое имя " + contacts.get(i-1).getFirstName());

                    }
                    System.out.println();
                }


            } else if (menu == 6) {
                try{
                System.out.println("Выгрузка");
                File file = Paths.get("C:/Users/User/Desktop/Java/JavaHomeWork/Contact.data").toFile();
                FileOutputStream outputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                // сохраняем в файл
                objectOutputStream.writeObject(contacts);

                //закрываем поток и освобождаем ресурсы
                objectOutputStream.close();
                }
                catch (Exception ex) {
                    System.out.println("Ошибка выгрузки данных" + ex);
                }
                continue;
            } else if (menu == 7) {
                System.out.println("Загрузка");
            } else if (menu == 8) {
                System.out.println("До новых встреч");
                break;
            } else if (menu > 8)
                System.out.println("Ошибка выбора. Данное меню недоступно");

        }
    }

    }

