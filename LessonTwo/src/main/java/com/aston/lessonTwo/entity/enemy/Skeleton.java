package com.aston.lessonTwo.entity.enemy;

public class Skeleton extends Enemy {
    private static final int DEFAULT_DAMAGE = 2;
    private static final int DEFAULT_HEALTH = 5;

    public Skeleton(String name) {
        super(name, DEFAULT_DAMAGE, DEFAULT_HEALTH);
    }

    public Skeleton() {
        super(
                enemyService.getRandomSecondName(Skeleton.class.getSimpleName()),
                DEFAULT_DAMAGE,
                DEFAULT_HEALTH
        );
    }

}
