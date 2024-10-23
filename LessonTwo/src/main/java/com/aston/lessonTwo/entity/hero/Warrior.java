package com.aston.lessonTwo.entity.hero;

import com.aston.lessonTwo.entity.Unit;
import com.aston.lessonTwo.entity.hero.ability.Ability;

public class Warrior extends Hero{
    static final int DEFAULT_DAMAGE = 3;
    static final int DEFAULT_HEALTH = 250;

    public Warrior() {
        super("Warrior", DEFAULT_DAMAGE, DEFAULT_HEALTH);
    }

    @Override
    public void attackEnemy(Unit target, Ability ability) {
        printMessage(target, ability);
        super.attackEnemy(target, ability);
    }
}
