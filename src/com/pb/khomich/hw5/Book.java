//Класс Book хранит такую информацию о книге:
//- название
//- автор книги
//- год издания

package com.pb.khomich.hw5;

public class Book {
    private String[] name;
    private String[] author;
    private int[] year;


    public Book(String[] name, String[] author, int[] year){
        this.name = name;
        this.author = author;
        this.year = year;
    }


    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public String[] getAuthor() {
        return author.clone();
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public int[] getYear() {
        return year;
    }

    public void setYear(int[] year) {
        this.year = year;
    }

//    String getInfoBook() {
//        return "[название:" + name + ", автор: " + author +", год издания:" + year + "]";
//    }

}