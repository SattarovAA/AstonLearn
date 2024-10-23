package com.aston.lessonTwo.entity.enemy;

import com.aston.lessonTwo.entity.Unit;

import java.text.MessageFormat;

public class Vampire extends Enemy {
    private static final int DEFAULT_DAMAGE = 2;
    private static final int DEFAULT_HEALTH = 10;

    public Vampire(String name) {
        super(name, DEFAULT_DAMAGE, DEFAULT_HEALTH);
    }

    public Vampire() {
        super(
                enemyService.getRandomSecondName(Vampire.class.getSimpleName()),
                DEFAULT_DAMAGE,
                DEFAULT_HEALTH
        );
    }

    @Override
    public void attackEnemy(Unit target) {
        super.attackEnemy(target);
        restoreHealth(getDamage());
        String message = MessageFormat.format(
                "{0} gain {1} hp",
                getName(), getDamage()
        );
        System.out.println(message);
    }
}
