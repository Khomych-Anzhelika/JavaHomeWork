package com.pb.khomich.hw7;

public class Tie extends Clothes implements ManClothes{
    public Tie(float price, String color, Size size) {
        super(price, color, size);
    }

    @Override
    public String toString() {
        return "галстук {" +
                getSize() +
                ", ціна = " + getPrice() + " грн" +
                ", колір = " + getColor() +
                "}";
    }

    @Override
    public void dressMan() {
            System.out.println("Одеваем на мужчину "+ toString());
    }
}
