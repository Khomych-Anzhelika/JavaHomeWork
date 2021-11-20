package com.pb.khomich.hw8;

public class WrongLoginException extends Exception {
    private String info;

    public WrongLoginException() {
        info = "Некорректный логин!";
    }

    public WrongLoginException(String message) {
        super(message);
        info = message;
    }

    @Override
    public String toString() {
        return info;
    }
}
