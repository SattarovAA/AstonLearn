package com.aston.lessonTwo.utils;

import com.aston.lessonTwo.entity.hero.ability.Ability;
import com.aston.lessonTwo.entity.hero.ability.HeroAbility;

public class AbilityUtils {
    public static final int ABILITY_BASE_SCALE = 1000;
    public Ability from(HeroAbility heroAbility) {
        return Ability.builder()
                .name(heroAbility.getName())
                .type(heroAbility.getAbilityType())
                .modifier(heroAbility.getModifier())
                .canMiss(heroAbility.isCanMiss())
                .build();
    }
}
