package com.aston.lessonTwo.entity.enemy;

import com.aston.lessonTwo.entity.Unit;
import com.aston.lessonTwo.services.EnemyService;

import java.text.MessageFormat;

public abstract class Enemy extends Unit {
    protected static final EnemyService enemyService = new EnemyService();
    protected Enemy(String name, int damage, int health) {
        super(name, damage, health);
    }

    @Override
    public void attackEnemy(Unit target) {
        String message = MessageFormat.format(
                "{0} attacks. {1} lose {2} hp",
                getName(), target.getName(), getDamage()
        );
        System.out.println(message);
        target.takeDamage(this.getDamage());
    }
}
