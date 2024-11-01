package org.aston.lessonthree.demo.entity;

public class Cat extends Animal implements Comparable<Animal> {
    int someValue;

    public Cat(int value) {
        super(value);
        someValue++;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "value=" + value +
                '}';
    }
}
