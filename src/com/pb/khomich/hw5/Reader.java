//Класс Reader хранит такую информацию о пользователе библиотеки:
//- ФИО
//- номер читательского билета
//- факультет
//- дата рождения
//- телефон
//Типы полей выбирать на свое усмотрение.

package com.pb.khomich.hw5;

import java.util.Arrays;

public class Reader {
    private String FIO;
    private String numBilet;
    private String facultet;
    private String birthday;
    private String phone;

    public Reader(String FIO, String numBilet, String facultet,String birthday,String phone){
        this.FIO = FIO;
        this.numBilet = numBilet;
        this.facultet = facultet;
        this.birthday = birthday;
        this.phone    = phone;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getNumBilet() {
        return numBilet;
    }

    public void setNumBilet(String numBilet) {
        this.numBilet = numBilet;
    }

    public String getFacultet() {
        return facultet;
    }

    public void setFacultet(String facultet) {
        this.facultet = facultet;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String getInfoReader() {
        return "[ФИО:" + FIO + ", номер читательского билета: " + numBilet +
                ", факультет:" + facultet + ", дата рождения:"+ birthday+ ", номер телефона:"+ phone+"]";
    }

    //- takeBook, который будет принимать количество взятых книг.
    //Выводит на консоль сообщение
    //"Петров В. В. взял 3 книги".
    public static void takeBook(int countBook, String FIO) {
        if (countBook > 1 && countBook <= 4) {
        System.out.println(FIO + " взял " + countBook + " книги.");
        }   else if (countBook > 4){
            System.out.println(FIO + " взял " + countBook + " книг");
        } else if (countBook == 1){
            System.out.println(FIO + " взял " + countBook + " книгу");
        }
    }

    //- takeBook, который будет принимать переменное количество названий книг.
    //Выводит на консоль сообщение
    //"Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".

    public static void takeBook(String name, String FIO) {
        System.out.println(FIO + " взял книги: "+ name);
    }

    //- takeBook, который будет принимать переменное количество объектов класса Book.
    //Выводит на консоль сообщение
    //"Петров В. В. взял книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
    public static void takeBook(String[]book,String FIO) {
        String arrBook = Arrays.toString(book);
        System.out.println(FIO + " взял книги: "+ arrBook);
    }

    //Аналогичным образом перегрузить метод returnBook().
    //Должно быть 3 метода returnBook() которые выводит на консоль сообщения:
    //- "Петров В. В. вернул 3 книги"
    public static void returnBook(int countBook, String FIO) {
        if (countBook > 1 && countBook <= 4) {
            System.out.println(FIO + " вернул " + countBook + " книги.");
        }   else if (countBook > 4){
            System.out.println(FIO + " вернул " + countBook + " книг");
        } else if (countBook == 1){
            System.out.println(FIO + " вернул " + countBook + " книгу");
        }
    }
//- "Петров В. В. вернул книги: Приключения, Словарь, Энциклопедия".
        public static void returnBook(String name, String FIO) {
            System.out.println(FIO + " вернул книги: "+ name);
        }
//- "Петров В. В. вернул книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
        public static void returnBook(String[]book,String FIO) {
            String arrBook = Arrays.toString(book);
            System.out.println(FIO + " взял книги: "+ arrBook);
        }

}
