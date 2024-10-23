package com.aston.lessonTwo.entity.hero.ability;

import lombok.Builder;

@Builder
public record Ability(
        String name,
        int modifier,
        AbilityType type,
        boolean canMiss
) {
}
