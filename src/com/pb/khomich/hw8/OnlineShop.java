package com.pb.khomich.hw8;
import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        Auth auths = new Auth ();
        int num;
        Scanner scan = new Scanner(System.in);

        do {
            num = 0;
            try {
                System.out.println("Введите логин:");
                String log = scan.nextLine(); //логин пользователя

                System.out.println("Введите пароль:");
                String pas = scan.nextLine(); //пароль пользователя

                System.out.println("Продублируйте пароль:");
                String confPas = scan.nextLine(); //пароль пользователя

                auths.signUp(log, pas, confPas);
            } catch (WrongLoginException | WrongPasswordException ex) {
                System.out.println(ex);
                num = 1;
            }
        } while (num == 1);

        System.out.println();
        do {
            num = 0;
            try {
                System.out.println("Для входа введите логин:");
                String log = scan.nextLine(); //логин пользователя

                System.out.println("Введите пароль:");
                String pas = scan.nextLine(); //пароль пользователя

                auths.signIn(log, pas);
            } catch (WrongLoginException ex) {
                System.out.println(ex);
                num = 1;
            }
        } while (num == 1);

    }
}
