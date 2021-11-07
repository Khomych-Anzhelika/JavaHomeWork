package com.pb.khomich.hw6;
/*Создайте класс VetСlinic
в его методе main создайте массив типа Animal, в который
запишите животных всех имеющихся у вас типов.
В цикле отправляйте животных на прием к ветеринару.*/

public class VetСlinic {
    public static void main(String[] args) throws Exception {
        Animal[] animals = new Animal[]{new Dog(),
                                        new Cat(),
                                        new Horse()};
//        Без рефлексии
//        for(Animal c: animals ) {
//            Veterinarian.treatAnimal(c);
//        }

//        С рефлексией
        Class Clazz = Class.forName("com.pb.khomich.hw6.Veterinarian");
        Object obj = Clazz.newInstance();
        for(Animal c: animals ) {
            if (obj instanceof Veterinarian) {
                ((Veterinarian) obj).treatAnimal(c);
            }
        }




    }
}