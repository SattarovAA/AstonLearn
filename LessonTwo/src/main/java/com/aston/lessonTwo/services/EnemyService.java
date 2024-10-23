package com.aston.lessonTwo.services;

import com.aston.lessonTwo.entity.enemy.*;

import java.util.ArrayList;
import java.util.List;

public class EnemyService {
    public String getRandomSecondName(String startName) {
        int randomAdjectiveNumber = (int) (Math.random() * EnemySecondName.values().length);
        EnemySecondName[] values = EnemySecondName.values();
        EnemySecondName randomAdjective = values[randomAdjectiveNumber];
        return randomAdjective.name()
                .concat(" ")
                .concat(startName);
    }

    public List<Enemy> getRandomEnemies(int enemyAmount) {
        List<Enemy> enemyList = new ArrayList<>();
        for (int i = 0; i < enemyAmount; i++) {
            enemyList.add(createRandomEnemy());
        }
        return enemyList;
    }

    public Enemy createRandomEnemy() {
        int enemyTypeNumber = (int) (Math.random() * EnemyType.values().length);
        EnemyType[] enemyTypes = EnemyType.values();
        Enemy enemy;
        switch (enemyTypes[enemyTypeNumber]) {
            case ZOMBIE -> enemy = new Zombie();
            case VAMPIRE -> enemy = new Vampire();
            case SKELETON -> enemy = new Skeleton();
            default -> enemy = new Skeleton();
        }
        return enemy;
    }
}
