package com.aston.lessonTwo.entity.hero;

import com.aston.lessonTwo.entity.Mortal;
import com.aston.lessonTwo.entity.Unit;
import com.aston.lessonTwo.entity.hero.ability.Ability;
import com.aston.lessonTwo.utils.AbilityUtils;
import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public abstract class Hero extends Unit implements Mortal {
    private List<Ability> abilities;

    protected Hero(String name, int damage, int health) {
        super(name, damage, health);
    }

    @Override
    public void attackEnemy(Unit target) {
        target.takeDamage(this.getDamage());
    }

    public void attackEnemy(Unit target, Ability ability) {
        if (ability.canMiss()) {
            if (new Random().nextBoolean()) {
                System.out.println("miss");
                return;
            }
        }
        int damage = getDamage() * ability.modifier() / AbilityUtils.ABILITY_BASE_SCALE;
        target.takeDamage(damage);
    }
    protected void printMessage(Unit target, Ability ability) {
        int power = getDamage() * ability.modifier() / AbilityUtils.ABILITY_BASE_SCALE;
        String message = MessageFormat.format(
                "{0} use {1}. {2} lose {3} hp",
                getName(), ability.name(),
                target.getName(), power
        );
        System.out.println(message);
    }
}
