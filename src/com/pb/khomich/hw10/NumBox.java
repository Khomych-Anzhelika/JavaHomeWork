package com.pb.khomich.hw10;

public class NumBox <T extends Number> {

    private final T[] numbers;

    @SuppressWarnings("unchecked")
    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    //- метод T get(int index) возвращающий число по индексу.
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
            System.out.println("Вы превысили длину массива");
        }
    }

    public int length() {
        return numbers.length;
    }

    // метод double  - сумма всех элементов массива.
    public double sum(){
        double sum = 0.0;
        for (T num : numbers){
            sum += num.doubleValue();
        }
        return sum;
    }
    //- метод double average() - подсчет среднего арифметического среди элементов массива.
    public double average() {
        return sum() / length();
    }

     //- метод T max() - максимальный элемент массива.
    public T max() {
        T maxEl = numbers[0];
        for (T number : numbers) {
            if (number.doubleValue() > maxEl.doubleValue()) {
                maxEl = number;
            }
        }
        return maxEl;
    }
}
