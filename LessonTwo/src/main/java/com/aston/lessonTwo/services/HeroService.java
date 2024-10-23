package com.aston.lessonTwo.services;

import com.aston.lessonTwo.entity.hero.*;
import com.aston.lessonTwo.entity.hero.ability.Ability;
import com.aston.lessonTwo.utils.AbilityUtils;
import com.aston.lessonTwo.entity.hero.ability.HeroAbility;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class HeroService {
    private final AbilityUtils abilityUtils;
    private final List<HeroAbility> archerStartAbilities;
    private final List<HeroAbility> warriorStartAbilities;
    private final List<HeroAbility> mageStartAbilities;

    public HeroService() {
        abilityUtils = new AbilityUtils();

        archerStartAbilities = List.of(
                HeroAbility.ACCURATE_SHOOT,
                HeroAbility.STRONG_SHOOT);

        warriorStartAbilities = List.of(
                HeroAbility.WHIRLWIND,
                HeroAbility.SLAM);

        mageStartAbilities = List.of(
                HeroAbility.WHITE_MAGIC,
                HeroAbility.FIREBALL);
    }
    public Hero create(HeroType heroType) {
        Hero hero;
        switch (heroType) {
            case MAGE -> hero = new Mage();
            case ARCHER -> hero = new Archer();
            case WARRIOR -> hero = new Warrior();
            default -> hero = new Warrior();
        }
        hero.setAbilities(getStartAbility(heroType));
        return hero;
    }

    public Hero create(HeroType heroType, String heroName) {
        Hero hero = create(heroType);
        hero.changeName(heroName);
        return hero;
    }
    public List<Ability> getStartAbility(HeroType heroType) {
        List<HeroAbility> heroAbilityList = new ArrayList<>();
        switch (heroType) {
            case ARCHER -> heroAbilityList = archerStartAbilities;
            case WARRIOR -> heroAbilityList = warriorStartAbilities;
            case MAGE -> heroAbilityList = mageStartAbilities;
        }

        return heroAbilityList
                .stream()
                .map(abilityUtils::from)
                .toList();
    }
}
