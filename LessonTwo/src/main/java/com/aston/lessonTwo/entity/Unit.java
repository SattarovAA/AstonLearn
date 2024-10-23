package com.aston.lessonTwo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Unit implements Mortal {

    static final int MINIMAL_HEALTH_FOR_SURVIVE = 0;
    static final int RESURRECT_HEALTH = 1;
    private String name;
    private int damage;
    private int health;

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void restoreHealth(int value) {
        takeDamage(-(int) value);
    }

    public void resurrect() {
        health = MINIMAL_HEALTH_FOR_SURVIVE + RESURRECT_HEALTH;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public abstract void attackEnemy(Unit target);

    @Override
    public boolean isAlive() {
        return health > MINIMAL_HEALTH_FOR_SURVIVE;
    }
}
