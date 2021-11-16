package com.pb.khomich.hw7;

public class Skirt extends Clothes implements WomenClothes{

    public Skirt(float price, String color, Size size) {
        super(price, color, size);
    }

    @Override
    public String toString() {
        return "юбку {" +
                getSize() +
                ", ціна = " + getPrice() + " грн" +
                ", колір = " + getColor() +
                "}";
    }

    @Override
    public void dressWomen() {
        System.out.println("Одеваем на женщину "+ toString());
    }



}
