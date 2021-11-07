package com.pb.khomich.hw6;

import java.util.Objects;

public class Cat extends Animal{
    private String breed; //порода
    private int purrLevel; //уровень мурчания

    public Cat(){
        super("Кошка","рыбка","дом");
    }

    public int getPurrLevel() {
        return purrLevel;
    }

    public void setPurrLevel(int purrLevel) {
        this.purrLevel = purrLevel;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Мурлычет!");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Конечно рыбку!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return purrLevel == cat.purrLevel && Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, purrLevel);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", purrLevel=" + purrLevel +
                '}';
    }
}
