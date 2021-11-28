package com.pb.khomich.hw10;

public class NumBox <T extends Number> {

    private final T[] numbers;

    @SuppressWarnings("unchecked")
    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    public T get(int index) {
        return numbers[index];
    }

    //- метод void add(T num) добавляющий число в массив. В случае если массив полон - выбросить исключение.
    public void add(int index, T num) throws ArrayIndexOutOfBoundsException {
        try {
            if (index > numbers.length) {
                throw new ArrayIndexOutOfBoundsException();
            } else
                this.numbers[index] = num;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Вы превысили длину массива");// + length());
        }
    }


}
