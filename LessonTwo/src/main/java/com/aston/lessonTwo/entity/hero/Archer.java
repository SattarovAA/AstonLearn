package com.aston.lessonTwo.entity.hero;

import com.aston.lessonTwo.entity.Unit;
import com.aston.lessonTwo.entity.hero.ability.Ability;

public class Archer extends Hero {
    static final int DEFAULT_DAMAGE = 3;
    static final int DEFAULT_HEALTH = 15;

    public Archer() {
        super("Archer", DEFAULT_DAMAGE, DEFAULT_HEALTH);
    }

    @Override
    public void attackEnemy(Unit target, Ability ability) {
        printMessage(target, ability);
        super.attackEnemy(target, ability);
    }
}
