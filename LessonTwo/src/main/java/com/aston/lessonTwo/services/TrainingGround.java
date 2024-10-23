package com.aston.lessonTwo.services;

import com.aston.lessonTwo.entity.hero.HeroType;

public class TrainingGround {
    public void tests() {
        System.out.println("test starts\n");
        Battleground battleground =
                new Battleground(HeroType.ARCHER, 2, false);
        battleground.main();

        System.out.println("test is over\n");

    }
}
