package org.aston.lessonthree.demo.entity;

public class Dog extends Animal implements Comparable<Animal> {
    public Dog(int value) {
        super(value);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "value=" + value +
                '}';
    }
}
