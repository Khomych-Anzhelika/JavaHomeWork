package com.pb.khomich.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private String pedigree; //среда обитания
    private String vaccinated; //вакцинированная (Y/N)

    public Dog(){
        super("Собака","мясо","будка");
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    public String getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(String vaccinated) {
        this.vaccinated = vaccinated;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Лает!");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Конечно мяско!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(pedigree, dog.pedigree) && Objects.equals(vaccinated, dog.vaccinated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedigree, vaccinated);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "pedigree='" + pedigree + '\'' +
                ", vaccinated='" + vaccinated + '\'' +
                '}';
    }
}
