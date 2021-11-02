//Класс Library используется как демонстрация работы классов Book и Reader.
//Имеет метод main() в котором создается массивы объектов Book и Reader, по 3 или более элементов в каждом.
//Выполняются такие действия:
//- печатаются все книги.
//- печатаются все читатели.
//- демонстрируется работа всех вариантов методов takeBook() и returnBook().

package com.pb.khomich.hw5;

import java.util.Arrays;

public class Library {
    public static void main(String[] args) {
//        Book book1 = new Book();
//        book1.setAuthor("Пушкин");
//        book1.setName("Сказка о золотой рыбке");
//        Reader reader1 = new Reader();
//        reader1.setFIO("Хомич Анжелика Александровна");
//        reader1.setFacultet("Физ-тех");
        Book[] bookArray = new Book[]{new Book("Приключения", "Иванов И.И.", 2000),
                                      new Book("Словарь", "Сидоров А.В.", 1980),
                                      new Book("Энциклопедия", "Гусев К.В.", 2010)};

        for(int i = 0; i< bookArray.length; i++)
            System.out.println(bookArray[i].getInfoBook());

        System.out.println("\n");
        Reader[] readerArray = new Reader[]{new Reader("Петров О.К","BB25468","Физико-технический","2000-12-20","0638647593"),
                                           new Reader("Кремень У.П","BB58623","Математический","2000-10-15","0632223569"),
                                           new Reader("Трактор Ж.М","BB00831","Юридический","2009-09-01","0662879632")};

        for(int i = 0; i<bookArray.length; i++) {
            System.out.println(readerArray[i].getInfoReader());
        }
        System.out.println("\n");
        Reader.takeBook(3, readerArray[2].getFIO());
        Reader.takeBook(1, readerArray[0].getFIO());
        System.out.println("\n");
        Reader.returnBook(3, readerArray[2].getFIO());
        Reader.returnBook(1, readerArray[0].getFIO());

        System.out.println("\n");

        String[] arrayName = new String[bookArray.length];

        for(int i = 0; i<bookArray.length; i++){
            arrayName[i] = bookArray[i].getName();
        }
        String nameBook = Arrays.toString(arrayName);
        Reader.takeBook(nameBook,readerArray[2].getFIO());
        Reader.returnBook(nameBook,readerArray[2].getFIO());
        System.out.println("\n");

        String[] arr = new String[bookArray.length];
        for(int i = 0; i< bookArray.length; i++){
            arr[i] = bookArray[i].getInfoBook1();
        }
        //String arrBook = Arrays.toString(arr);
        Reader.takeBook(arr,readerArray[1].getFIO());
        Reader.returnBook(arr,readerArray[1].getFIO());


    }
}
