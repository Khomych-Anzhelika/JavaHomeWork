package com.pb.khomich.hw8;
/*WrongPasswordException и WrongLoginException
- пользовательские классы исключения с двумя конструкторами
– один по умолчанию, второй принимает сообщение и передает его в конструктор класса Exception.*/

public class WrongPasswordException extends Exception {
    private String info;

    public WrongPasswordException() {
        info = "Некорректный пароль!";
    }

    public WrongPasswordException(String message) {
        super(message);
        info = message;
    }

    @Override
    public String toString() {
        return info;
    }
}
