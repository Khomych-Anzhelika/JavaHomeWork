package com.pb.khomich.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {

    public Tshirt(float price, String color, Size size) {
        super(price, color, size);
    }

    @Override
    public String toString() {
        return "футболку {" +
                getSize() +
                ", ціна = " + getPrice() + " грн" +
                ", колір = " + getColor() +
                "}";
    }

    @Override
    public void dressMan() {
        System.out.println("Одеваем на мужчину "+ toString());
    }

    @Override
    public void dressWomen() {
        System.out.println("Одеваем на женщину "+ toString());
    }
}
