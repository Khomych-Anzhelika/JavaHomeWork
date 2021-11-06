package com.pb.khomich.hw6;
/*Создайте класс VetСlinic
в его методе main создайте массив типа Animal, в который
запишите животных всех имеющихся у вас типов.
В цикле отправляйте животных на прием к ветеринару.*/

public class VetСlinic {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Dog(),new Cat(), new Horse()};
        //Animal[1] = new Dog();
//        animals.setName("Кошка");
//        animals.eat();
        for(Animal c: animals ) {
           // Veterinarian.treatAnimal(c);
            //System.out.println(animals[i].getName());
            c.makeNoise();
        }

        //Veterinarian.treatAnimal(animals[1]);
        //Dog dogs = new Dog();
        //Animal[1] = "Кошка";
        //dogs.setName("Собака");
        //dogs.eat();

//        Veterinarian.treatAnimal();

        //Animal[1] = "Кошка";
//        animals.setName("Лошадь");
//        animals.eat();
    }
}
