package com.aston.lessonTwo;

import com.aston.lessonTwo.entity.hero.HeroType;
import com.aston.lessonTwo.services.Battleground;
import com.aston.lessonTwo.services.TrainingGround;

public class Lesson2Application {
    public static void main(String[] args) {
        new TrainingGround().tests();

        Battleground battleground = new Battleground(HeroType.WARRIOR, 2);
        battleground.main();
    }
}
