package com.company.game.domain;

import com.company.game.constants.Constants;
import com.company.game.constants.Weapon;
import com.company.game.utils.DisplayUtil;

import java.util.Random;
/**
 * Tha Opponent class holds the functions and properties of opponent
 */
public final class Opponent extends GameActor {

    private int taskBonus;

    public Opponent(String name, int health, int taskBonus) {
        this.name = name;
        this.health = health;
        this.taskBonus = taskBonus;
    }

    public String getStatus() {
        return "Opponent HEALTH: " + health;
    }

    /**
     * attack method invades players health
     */
    public void attack() {
        if(health > 0) {
            health=  health - 10;
        }
    }

    /**
     * receives command and delegates method to attack opponent and earn reward if opponent is killed
     */
    public void processCommand(Player player) {
        player.attack();
        if(isAlive()) {
            DisplayUtil.printToConsole(name + "  hit " + player.getName() + " and damages the health to " +  getStatus());
        }
        else {
            upgrade(player);
            earnReward(player);
            DisplayUtil.printToConsole("  " + player.getName() + " has defeated " + name);
        }
    }

    /**
     * earnReward method adds bounty to the coin bank
     * @param player
     */
    private void earnReward(Player player) {
        player.addCoins(Constants.WINNER_COINS);
    }

    /**
     * upgrade method adds bonus to players grade scale
     * @param player
     */
    private void upgrade(Player player) {
        player.setGrade(player.getGrade() + taskBonus);
    }


    /**
     * Util function to display stats of opponent
     */
    public void display() {
        DisplayUtil.printToConsole("######Opponent####################");
        DisplayUtil.printToConsole("Name " + name);
        DisplayUtil.printToConsole("Health " + health);
        if (!getWeaponList().isEmpty()) {
            DisplayUtil.printToConsole("Weapon List: ");
            getWeaponList().stream().forEach(weapon -> DisplayUtil.printToConsole(weapon.getName()));
        }

        DisplayUtil.printToConsole("################################");

    }

}
