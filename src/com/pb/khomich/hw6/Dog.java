package com.pb.khomich.hw6;

public class Dog extends Animal{
    private String pedigree; //среда обитания
    private String vaccinated; //вакцинированная (Y/N)

    public Dog(){
        super("Собака");
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
}
