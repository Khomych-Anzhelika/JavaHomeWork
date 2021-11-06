package com.pb.khomich.hw6;

public class Veterinarian {
    public static void treatAnimal(Animal animal){
        System.out.println(animal.getName() + ": еда - " + animal.getFood() +
                " , место проживания - " + animal.getLocation());
    }
}
