package com.pb.khomich.hw8;
import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите логин:");
        String log = scan.nextLine(); //логин пользователя

        System.out.println("Введите пароль:");
        String pas = scan.nextLine(); //пароль пользователя

        System.out.println("Продублируйте пароль:");
        String confPas = scan.nextLine(); //пароль пользователя

        Auth auths = new Auth (log, pas, confPas);

        System.out.println(auths.getCheckLogin());

        // Auth.signUp();


    }
}
