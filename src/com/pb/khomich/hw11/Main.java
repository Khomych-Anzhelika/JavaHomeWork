package com.pb.khomich.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;



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
        contacts.add(new Contact("Смирнов Александр Аркадьевич", LocalDate.of(1987, 5, 15), phons2, "г.Харьков"));
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
                    DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE;
                    LocalDate addDateBD = LocalDate.parse(addDate, format);
                    System.out.print("Адрес: ");
                    String addAddress = scanAdd.nextLine();
                    System.out.print("Телефон: ");
                    String phoneValue = scanAdd.nextLine();
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
                try {
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
                    if (sort == 2) {
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
                } catch (Exception ex) {
                    System.out.println("Ошибка сортировки данных." + ex);
                }
                continue;
            }
            if (menu == 5) {
                try {
                    System.out.println("Редактирование контакта");
                    if (contacts.isEmpty()) {
                        System.out.println("Ваша телефонная книга пуста");
                    } else {
                        System.out.println("Контакты, которые можно изменить:");
                        for (int i = 0; i < contacts.size(); i++) {
                            System.out.println((i + 1) + " " + contacts.get(i).getFIO());
                        }
                        System.out.println("Выберете номер контакта, который хотите отредактировать");
                        Scanner scan = new Scanner(System.in);
                        int redCont = scan.nextInt()-1; //значение нужного контакта

                        System.out.println("\n");
                        System.out.println("Выберете какое поле хотите отредактировать");
                        System.out.println("ФИО           - 1");
                        System.out.println("Дата рождения - 2");
                        System.out.println("Телефон       - 3");
                        System.out.println("Адрес         - 4");
                        int redCol = scan.nextInt(); //что редактируем
                        if (redCol == 1){
                            System.out.println("Старое ФИО: " + contacts.get(redCont).getFIO());
                            Scanner scanAdd = new Scanner(System.in);
                            System.out.println("Введите новый вариант ФИО: ");
                            String redFio = scanAdd.nextLine(); //Новый вариант ФИО
                            Contact addRed = new Contact(redFio,
                                                        contacts.get(redCont).getDateOfBirth(),
                                                        contacts.get(redCont).getPhone(),
                                                        contacts.get(redCont).getAdres());
                            contacts.remove(redCont);
                            // добавление элемента в определеную позицию на позицию redCont
                            contacts.add(redCont, addRed);
                        }
                        if (redCol == 2){
                            System.out.println("Старая дата рождения: " + contacts.get(redCont).getDateOfBirth());
                            Scanner scanAdd = new Scanner(System.in);
                            System.out.println("Введите новый вариант даты рождения: ");
                            String redDate = scanAdd.nextLine();//Новый вариант даты рождения
                            DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE;
                            LocalDate redDateBD = LocalDate.parse(redDate, format);
                            Contact addRed = new Contact(contacts.get(redCont).getFIO(),
                                                        redDateBD,
                                                        contacts.get(redCont).getPhone(),
                                                        contacts.get(redCont).getAdres());
                            contacts.remove(redCont);
                            // добавление элемента в определеную позицию на позицию redCont
                            contacts.add(redCont, addRed);
                        }
                        if (redCol == 3){
                            System.out.println("Старые номера телефонов " + contacts.get(redCont).getPhone());
                            Scanner scanAdd = new Scanner(System.in);
                            System.out.println("Введите новые: ");
                            String phoneValue = scanAdd.nextLine();//Новые варианты телефонов
                            List<String> redPhone = Arrays.asList(phoneValue);

                            Contact addRed = new Contact(contacts.get(redCont).getFIO(),
                                                         contacts.get(redCont).getDateOfBirth(),
                                                         redPhone,
                                                         contacts.get(redCont).getAdres());
                            contacts.remove(redCont);
                            // добавление элемента в определеную позицию на позицию redCont
                            contacts.add(redCont, addRed);
                        }
                        if (redCol == 4){
                            System.out.println();
                            System.out.println("Старый адрес: " + contacts.get(redCont).getAdres());
                            Scanner scanAdd = new Scanner(System.in);
                            System.out.println("Введите новый адрес: ");
                            String redAdres = scanAdd.nextLine(); //Новый вариант адреса
                            Contact addRed = new Contact(contacts.get(redCont).getFIO(),
                                                        contacts.get(redCont).getDateOfBirth(),
                                                        contacts.get(redCont).getPhone(),
                                                        redAdres);
                            contacts.remove(redCont);
                            // добавление элемента в определеную позицию на позицию redCont
                            contacts.add(redCont, addRed);
                        }
                        if (redCol > 4){
                            System.out.println("Выбрано некорректное поле для редактирования");
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Ошибка редактирования." + ex);
                }
                continue;
            }
            if (menu == 6) {
                ObjectMapper mapper = new ObjectMapper();
                // pretty printing (json с отступами)
                mapper.enable(SerializationFeature.INDENT_OUTPUT);

                // для работы с полями типа LocalDate
                SimpleModule module = new SimpleModule();
                module.addSerializer(LocalDate.class, new LocalDateSerializer());
                module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
                mapper.registerModule(module);

                String contactsJsonWrite = mapper.writeValueAsString(contacts);
                mapper.readValue(contactsJsonWrite, new TypeReference<List<Contact>>() {});
                //Локальный путь к файлу в проекте для выгрузки данных
                Path pathWrite = Paths.get("C:/Users/User/Desktop/Java/JavaHomeWork/export.json");

                try (BufferedWriter writer = Files.newBufferedWriter(pathWrite)) {
                    writer.write(contactsJsonWrite);
                } catch (Exception ex) {
                    System.out.println("Ошибка выгрузки данных: " + ex);
                }
                  System.out.println("Выгрузка успешно завершена.");
                continue;
                }
            if (menu == 7) {
                ObjectMapper mapper = new ObjectMapper();
                // pretty printing (json с отступами)
                mapper.enable(SerializationFeature.INDENT_OUTPUT);

                // для работы с полями типа LocalDate
                SimpleModule module = new SimpleModule();
                module.addSerializer(LocalDate.class, new LocalDateSerializer());
                module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
                mapper.registerModule(module);

                //Локальный путь к файлу в проекте для загрузки данных
                Path pathLoad = Paths.get("files/import.json");
                String contactsJsonRead = new String();

                try (BufferedReader reader = Files.newBufferedReader(pathLoad)) {
                    String line = null;
                    StringBuilder stringBuilder = new StringBuilder();
                    String ls = System.getProperty("line.separator");
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                        stringBuilder.append(ls);
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    contactsJsonRead = stringBuilder.toString();

                } catch (Exception ex) {
                    System.out.println("Ошибка загрузки данных: " + ex);
                }
                //Преобразовываем String в Contact
                ArrayList<Contact> contactsImport = mapper.readValue(contactsJsonRead, new TypeReference<ArrayList<Contact>>() {});
                System.out.println("Загрузка успешно завершена.");

                for (int i = 0; i < contactsImport.size(); i++) {
                    Contact addContact = new Contact(contactsImport.get(i).getFIO(),
                                                    contactsImport.get(i).getDateOfBirth(),
                                                    contactsImport.get(i).getPhone(),
                                                    contactsImport.get(i).getAdres());
                    contacts.add(addContact);
                }
            }
                if (menu == 8) {
                    System.out.println("До новых встреч");
                    break;}
                if (menu > 8)
                    System.out.println("Ошибка выбора. Данное меню недоступно");

            }
        }
    }


