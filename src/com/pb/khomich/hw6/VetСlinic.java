package com.pb.khomich.hw6;
/*Создайте класс VetСlinic
в его методе main создайте массив типа Animal, в который
запишите животных всех имеющихся у вас типов.
В цикле отправляйте животных на прием к ветеринару.*/

public class VetСlinic {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Dog(),
                                        new Cat(),
                                        new Horse()};

        for(Animal c: animals ) {
            Veterinarian.treatAnimal(c);
        }
    }
}
