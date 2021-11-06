package com.pb.khomich.hw6;
//Добавьте переменные (поля) в классы Dog, Cat, Horse, характеризующие только этих животных.
public class Horse extends Animal{
    private int speed; //Скорость
    private int age; //Возраст

    public Horse(){
        super("Лошадь");
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
        System.out.println("Конечно овес!");
    }
}
