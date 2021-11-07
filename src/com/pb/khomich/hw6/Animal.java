package com.pb.khomich.hw6;


/*
+ 1) В пакете hw6 создайте класс Animal и расширяющие его классы Dog, Cat, Horse.
+ 2) Класс Animal содержит переменные food, location +
+ и методы makeNoise, eat, sleep.
+ Метод sleep, например, может выводить на консоль "Такое-то животное спит".
+ Dog, Cat, Horse переопределяют методы makeNoise, eat.
+ Добавьте переменные (поля) в классы Dog, Cat, Horse, характеризующие только этих животных.
+Создайте класс Veterinarian (Ветеринар),
+в котором определите метод void treatAnimal(Animal animal).
+Пусть этот метод печатает на экран food и location пришедшего на прием животного.
+Создайте класс VetСlinic
+в его методе main создайте массив типа Animal, в который
+запишите животных всех имеющихся у вас типов.
+В цикле отправляйте животных на прием к ветеринару.
+В классах Dog, Cat, Horse переопределить методы toString, equals, hashCode.

Объект класса Veterinarian создайте с помощью рефлексии.*/


public class Animal {
    private String food;
    private String location;
    private String name;

    public Animal (String name,String food, String location){
        this.name = name;
        this.food = food;
        this.location = location;
    }

//    public Animal (String food, String location){
//        this.food = food;
//        this.location = location;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void makeNoise() {
        System.out.println(name + " издает звук...");
    }

    public void eat() {
        System.out.println(name + " есть...");
    }

    public void sleep() {
        System.out.println(name + " спит...");
    }

}
