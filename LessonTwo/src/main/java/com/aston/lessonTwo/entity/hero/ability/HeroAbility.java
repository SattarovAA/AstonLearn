package com.aston.lessonTwo.entity.hero.ability;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HeroAbility {
    STRONG_SHOOT(AbilityType.TARGET_DAMAGE, "STRONG_SHOOT", 2000,true),
    ACCURATE_SHOOT(AbilityType.TARGET_DAMAGE, "ACCURATE_SHOOT", 1000),

    WHITE_MAGIC(AbilityType.TARGET_HEAL, "WHITE_MAGIC", -1000),
    FIREBALL(AbilityType.TARGET_DAMAGE, "FIREBALL", 1000),

    WHIRLWIND(AbilityType.AOE_DAMAGE, "WHIRLWIND", 700),
    SLAM(AbilityType.TARGET_DAMAGE, "SLAM", 1000);

    private final AbilityType abilityType;
    private final String name;
    private final int modifier;
    private final boolean canMiss;

    HeroAbility(AbilityType abilityType, String name, int modifier) {
        this.abilityType = abilityType;
        this.name = name;
        this.modifier = modifier;
        this.canMiss = false;
    }
}
