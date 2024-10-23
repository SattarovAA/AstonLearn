package com.aston.lessonTwo.services;

import com.aston.lessonTwo.entity.Unit;
import com.aston.lessonTwo.entity.enemy.*;
import com.aston.lessonTwo.entity.hero.*;
import com.aston.lessonTwo.entity.hero.ability.Ability;
import com.aston.lessonTwo.entity.hero.ability.AbilityType;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Battleground {
    private static final EnemyService enemyService = new EnemyService();
    private static final HeroService heroService = new HeroService();
    private final List<Enemy> enemies;
    private final Hero mainHero;
    private final boolean isPlayable;
    private static final int HERO_AMOUNT = 1;

    public Battleground(HeroType heroType, int enemyAmount) {
        this(heroType, enemyAmount, true);
    }

    public Battleground(HeroType heroType, int enemyAmount, boolean isPlayable) {
        mainHero = heroService.create(heroType);
        enemies = enemyService.getRandomEnemies(enemyAmount);
        this.isPlayable = isPlayable;
    }

    public void main() {
        battle();
    }

    private void battle() {
        while (mainHero.isAlive() && isEnemiesAlive()) {
            if (isPlayable) {
                playerScreen();
            }

            Ability ability = isPlayable
                    ? abilitySelection()
                    : randomAbility();

            List<Unit> targets = getTargetsForAbilityType(ability.type());

            attackTargets(targets, ability);

            enemyAttacks();
        }
        System.out.println("Game over!");
    }

    private boolean isEnemiesAlive() {
        for (Enemy e : enemies) {
            if (e.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private void playerScreen() {
        System.out.println("Your turn:");
        System.out.println("MainHero: ");
        String heroMessage = MessageFormat.format(
                "{0} with {1} hp",
                mainHero.getName(), mainHero.getHealth()
        );
        System.out.println(heroMessage);
        System.out.println("Enemy:");
        for (Enemy enemy : enemies) {
            String message = MessageFormat.format(
                    "{0} with {1} hp",
                    enemy.getName(), enemy.getHealth()
            );
            System.out.println(message);
        }
        System.out.println("Ability:");
        for (Ability ability : mainHero.getAbilities()) {
            System.out.println(ability.name());
        }
    }

    private Ability abilitySelection() {
        int minValue = 0;
        int maxValue = mainHero.getAbilities().size() - 1;

        String correctCommandMessage =
                "Choose ability:\n0 to " + maxValue + " - ability";

        int abilityNumber = getIntCommandFromScanner(
                correctCommandMessage,
                minValue,
                maxValue
        );
        return mainHero.getAbilities().get(abilityNumber);
    }

    private Unit targetSelection() {
        int minValue = 0;
        int maxValue = enemies.size();

        String correctCommandMessage =
                "Choose target:\n0 - yourself, 1 to " + maxValue + " - enemy";

        int targetNumber = getIntCommandFromScanner(
                correctCommandMessage,
                minValue,
                HERO_AMOUNT + maxValue
        );
        if (targetNumber == 0) {
            return mainHero;
        }
        return enemies.get(targetNumber - 1);
    }

    private int getIntCommandFromScanner(String correctCommandMessage, int min, int max) {
        String wrongInputMessage = "bad command! Correct command value:\n"
                + min + " to " + max;

        while (true) {
            System.out.println(correctCommandMessage);

            String command = new Scanner(System.in).next();
            if (!command.matches("\\d+")) {
                System.out.println(wrongInputMessage);
                continue;
            }

            int intCommand = Integer.parseInt(command);
            boolean uncorrectedCommand =
                    intCommand > max || intCommand < min;
            if (uncorrectedCommand) {
                System.out.println(wrongInputMessage);
                continue;
            }
            return intCommand;
        }
    }

    private List<Unit> getTargetsForAbilityType(AbilityType abilityType) {
        List<Unit> targets = new ArrayList<>();
        if (abilityType == AbilityType.AOE_DAMAGE) {
            targets.addAll(enemies);
        } else {
            Unit target = isPlayable
                    ? targetSelection()
                    : randomTarget();
            targets.add(target);
        }
        return targets;
    }

    private void attackTargets(List<Unit> targets, Ability ability) {
        for (Unit target : targets) {
            mainHero.attackEnemy(target, ability);

            if (!target.isAlive()) {
                printDeadMessage(target);
                enemies.remove(target);
            }
        }
    }

    private void enemyAttacks() {
        for (Enemy e : enemies) {
            if (e.isAlive()){
                e.attackEnemy(mainHero);
            }
        }
        if (!mainHero.isAlive()) {
            printDeadMessage(mainHero);
        }
    }

    private void printDeadMessage(Unit deadUnit) {
        System.out.println(deadUnit.getName() + " is dead");
    }

    private Ability randomAbility() {
        int abilityNumber = (int) (Math.random() * mainHero.getAbilities().size());
        return mainHero.getAbilities().get(abilityNumber);
    }

    private Unit randomTarget() {
        int targetNumber = (int) (Math.random() * enemies.size());
        return enemies.get(targetNumber);
    }
}
