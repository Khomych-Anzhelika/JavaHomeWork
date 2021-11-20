package com.pb.khomich.hw8;
/*Создать пакет hw8.
+Создать класс Auth,
+который содержит поля login и password
+и методы:
+ signUp (регистрация на сайте) принимающий login, password, и confirmPassword.

Проверяет параметр login, длинна должна быть от 5 до 20 символов.
Login должен содержать только латинские буквы и цифры.
Если логин не соответствует требованиям нужно выбросить WrongLoginException.


Проверяет параметр password, длинна более 5, только латинские буквы и цифры и знак подчеркивания.
Также password и confirmPassword должны совпадать.
Если password не соответствует требованиям нужно выбросить WrongPasswordException.
Если проверки все пройдены успешно записать в свои поля значение login и password.
Так сохраняем пользователя :)

+ signIn (вход на сайт) принимающий login и password.
Проверяет что login и password соответствуют значениям из полей класса.
Если нет - выбрасывает исключение WrongLoginException.

WrongPasswordException и WrongLoginException
- пользовательские классы исключения с двумя конструкторами
– один по умолчанию, второй принимает сообщение и передает его в конструктор класса Exception.

Создать класс OnlineShop с методом main.
В main создать один объект класса Auth.
Предложить пользователю сперва зарегистрироваться (signUp) потом войти на сайт (signIn).
Обработать исключения методов signUp signIn с помощью блоков try-catch.*/
public class Auth {
    /*содержит поля login и password*/
    private String login;
    private String password;
    private String confirmPassword;

    private String checkLogin;
    private String checkPassword;
    private String checkConfirmPassword;

    public Auth(String checkLogin, String checkPassword, String checkConfirmPassword) {
        this.checkLogin = checkLogin;
        this.checkPassword = checkPassword;
        this.checkConfirmPassword = checkConfirmPassword;
    }

    //нет понимания когда метод должен быть static, а когда нет...задать вопрос
//    public static void signUp() throws WrongLoginException, WrongPasswordException {
            StringBuilder checkLogin = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                if (Character.isLetterOrDigit(s.charAt(i))) //charAt() — возвращает символ, расположенный по указанному индексу строки.
//                    //isLetterOrDigit - Вказує, чи відноситься вказаний символ Unicode до категорії літери чи десяткової цифри.
//                    //Character - класс обертка над char
//                    sb.append(s.charAt(i)); //append() — обновляет значение объекта, который вызвал метод.
//            }
//
//
//
//        if(checkLogin ) {
//
//
//
//
//        } else {
//            throw new WrongLoginException;
//        }

        /*Проверяет параметр login, длинна должна быть от 5 до 20 символов.
          Login должен содержать только латинские буквы и цифры.
          Если логин не соответствует требованиям нужно выбросить WrongLoginException.*/




        /*Проверяет параметр password, длинна более 5, только латинские буквы и цифры и знак подчеркивания.
        Также password и confirmPassword должны совпадать.
        Если password не соответствует требованиям нужно выбросить WrongPasswordException.
        Если проверки все пройдены успешно записать в свои поля значение login и password.
        Так сохраняем пользователя :)*/
    //}


    public String getCheckLogin() {
        return checkLogin;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public String getCheckConfirmPassword() {
        return checkConfirmPassword;
    }

    private void signIn (String login, String password)
            throws WrongLoginException, WrongPasswordException{

    }

//    public void withdraw(double amount) throws InsufficientFundsException {
//        if(amount <= balance) {
//            balance -= amount;
//        } else {
//            double needs = amount - balance;
//            throw new InsufficientFundsException(needs);
//        }
//    }
//
//
//    private static String delNoDigOrLet (String s) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isLetterOrDigit(s.charAt(i))) //charAt() — возвращает символ, расположенный по указанному индексу строки.
//                //isLetterOrDigit - Вказує, чи відноситься вказаний символ Unicode до категорії літери чи десяткової цифри.
//                //Character - класс обертка над char
//                sb.append(s.charAt(i)); //append() — обновляет значение объекта, который вызвал метод.
//        }
//        return sb.toString();
//    }
}
