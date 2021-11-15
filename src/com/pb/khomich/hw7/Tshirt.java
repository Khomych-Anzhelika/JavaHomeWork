package com.pb.khomich.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    //Эти методы не принимают параметров, а только выводят информацию о одежде
    // (название, размер, цену, цвет).

    @Override
    public void dressMan() {
        System.out.println("LOGO TOSHIBA");
    }

    @Override
    public void dressWomen() {
        System.out.println("LOGO TOSHIBA");
    }
}
