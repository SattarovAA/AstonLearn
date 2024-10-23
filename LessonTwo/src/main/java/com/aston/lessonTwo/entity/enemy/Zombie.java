package com.aston.lessonTwo.entity.enemy;

public class Zombie extends Enemy {
    private static final int CHANCE_TO_SURVIVE = 600;
    private static final int SEED_MAX_VALUE = 1000;
    private static final int DEFAULT_DAMAGE = 3;
    private static final int DEFAULT_HEALTH = 5;

    public Zombie(String name) {
        super(name, DEFAULT_DAMAGE, DEFAULT_HEALTH);
    }

    public Zombie() {
        super(
                enemyService.getRandomSecondName(Zombie.class.getSimpleName()),
                DEFAULT_DAMAGE,
                DEFAULT_HEALTH
        );
    }

    @Override
    public boolean isAlive() {
        if (!super.isAlive()) {
            return tryToSurvive();
        }
        return true;
    }
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (super.isAlive()){
            return;
        }
        if (tryToSurvive()) {
            resurrect();
        }
    }

    private boolean tryToSurvive() {
        return CHANCE_TO_SURVIVE > (Math.random() * SEED_MAX_VALUE);
    }
}
