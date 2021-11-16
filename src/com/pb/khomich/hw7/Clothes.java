package com.pb.khomich.hw7;
//Создать абстрактный класс Clothes (одежда) содержащий
// переменные размер (типа Size), стоимость, цвет.
public abstract class Clothes {
      private float price;
      private String color;
      private Size size;

      public Clothes(float price, String color, Size size) {
            this.price = price;
            this.color = color;
            this.size = size;

      }

      public float getPrice() {
            return price;
      }

      public void setPrice(float price) {
            this.price = price;
      }

      public String getColor() {
            return color;
      }

      public void setColor(String color) {
            this.color = color;
      }

      public Size getSize() {
            return size;
      }

      public void setSize(Size size) {
            this.size = size;
      }
}
