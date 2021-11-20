package com.pb.khomich.hw8;
import java.util.regex.Pattern;

/*Создать класс OnlineShop с методом main.
В main создать один объект класса Auth.
Предложить пользователю сперва зарегистрироваться (signUp) потом войти на сайт (signIn).
Обработать исключения методов signUp signIn с помощью блоков try-catch.*/
public class Auth {
    /*содержит поля login и password*/
    private String login;
    private String password;
    private String confirmPassword;

    public Auth() {
    }

    //нет понимания когда метод должен быть static, а когда нет...задать вопрос

    public void signUp(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        /*Проверяет параметр login, длинна должна быть от 5 до 20 символов.
        Login должен содержать только латинские буквы и цифры.
        Если логин не соответствует требованиям нужно выбросить WrongLoginException.*/
        if (Pattern.matches("[a-zA-Z0-9]{5,20}", login)) {
            this.login = login;
        } else {
            throw new WrongLoginException("Логин не соответствует требованиям!");
        }

        /*Проверяет параметр password, длинна более 5, только латинские буквы и цифры и
        знак подчеркивания.
        Также password и confirmPassword должны совпадать.
        Если password не соответствует требованиям нужно выбросить WrongPasswordException.*/

        if (Pattern.matches("[a-zA-Z0-9_]{5,}", password)) {
        } else {
            throw new WrongPasswordException("Пароль не соответствует требованиям! ");
        }

        if (password.equals(confirmPassword)) {
            this.password = password;
        } else {
            throw new WrongPasswordException("Пароль не совпадает");
        }
        System.out.println("Вы успешно зарегистрированы!");
    }
        /*signIn (вход на сайт) принимающий login и password.
        Проверяет что login и password соответствуют значениям из полей класса.
        Если нет - выбрасывает исключение WrongLoginException.*/
        public void signIn (String loginIn, String passwordIn)
            throws WrongLoginException {
            if (login.equals(loginIn)&&password.equals(passwordIn)) {
                System.out.println("Вход осуществлен!");
            } else {
                throw new WrongLoginException("Некорректные имя пользователя и пароль");
            }
        }

}
