package com.pb.khomich.hw6;

public class Cat extends Animal{
    private String breed; //порода
    private int purrLevel; //уровень мурчания

    public Cat(){
        super("Кошка");
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


}
