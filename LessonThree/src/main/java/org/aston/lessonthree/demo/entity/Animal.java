package org.aston.lessonthree.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class Animal implements Comparable<Animal> {
    int value;

    public Animal(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Animal o) {
        return this.value - o.value;
    }
}
