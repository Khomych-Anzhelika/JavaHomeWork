package com.pb.khomich.hw6;

import java.util.Objects;

//Добавьте переменные (поля) в классы Dog, Cat, Horse, характеризующие только этих животных.
public class Horse extends Animal{
    private int speed; //Развиваемая скорость
    private int age; //Возраст

    public Horse(){
        super("Лошадь","овес","загон");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Ржет!");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Конечно сено!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return speed == horse.speed && age == horse.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, age);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "speed=" + speed +
                ", age=" + age +
                '}';
    }
}
