//Класс Library используется как демонстрация работы классов Book и Reader.
//Имеет метод main() в котором создается массивы объектов Book и Reader, по 3 или более элементов в каждом.
//Выполняются такие действия:
//- печатаются все книги.
//- печатаются все читатели.
//- демонстрируется работа всех вариантов методов takeBook() и returnBook().

package com.pb.khomich.hw5;

public class Library {
    public static void main(String[] args) {
//        Book book1 = new Book();
//        book1.setAuthor("Пушкин");
//        book1.setName("Сказка о золотой рыбке");
//        Reader reader1 = new Reader();
//        reader1.setFIO("Хомич Анжелика Александровна");
//        reader1.setFacultet("Физ-тех");

//        Book book[] = {new Book("Приключения", "Иванов И.И.", 2000),
//                        new Book("Словарь", "Сидоров А.В.", 1980),
//                        new Book("Энциклопедия", "Гусев К.В.", 2010)};

        Book book = new Book(new String[]{"Приключения","Словарь","Энциклопедия"},
                              new String[]{"Иванов И.И.","Сидоров А.В.","Гусев К.В."},
                              new int[]{2000,1980,2010});


        //System.out.println(book1[0]);
        book.getAuthor();

//        Book[] bookArray = new Book[3];
//        bookArray[0] = new Book("Приключения", "Иванов И.И.", 2000);
//        bookArray[1] = new Book("Словарь", "Сидоров А.В.", 1980);
//        bookArray[2] = new Book("Энциклопедия", "Гусев К.В.", 2010);

        //for(int i = 0; i<3; i++)
           // System.out.println(bookArray[0]);



        //System.out.println(book.author);
        //System.out.println(book1.getInfoBook());
//        System.out.println(reader1.getInfoReader());
//
//        reader1.takeBook(6,reader1.getFIO());
//        reader1.returnBook(0,reader1.getFIO());
//        phone1.setModel("iphone");
//        phone1.setNumber("0991234567");
//        phone2.setModel("pixel");
//
//
//        System.out.println(phone1.getInfo());
//    создавать массив примерно так:
//    Reader[] readerArray = new Reader[4];
//
//    получать свойства и методы так:
//    bookArray[1].getTitle()
//    readerArray[3].takeBook(3);  - взять 3 книги

    }
}
