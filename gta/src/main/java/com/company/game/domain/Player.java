package com.company.game.domain;

import com.company.game.constants.Constants;
import com.company.game.constants.Weapon;
import com.company.game.utils.DisplayUtil;

import java.util.Random;

/**
 * Tha Player class holds the functions and properties of Player
 */
public final class Player extends GameActor {

    private boolean quit;
    private int coins;
    private final int maxHealth;
    private int medicines;
    private int grade;


    public Player(String name, int maxHealth,
                  int medicines, int grade, int coins) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.medicines = medicines;
        this.health = maxHealth;
        this.grade = grade;
        this.coins = coins;
    }


    public void addWeapon(Weapon weapon) {
        getWeaponList().add(weapon);
    }

    public void consumeCoins(int value) {
        coins -= value;
    }

    public void addCoins(int value) {
        coins += value;
    }

    public String getStatus() {
        return "Player HEALTH: " + health;
    }

    public void attack() {
        if(health > 0) {
            health=  health - 10;
        }
    }
    /**
     * receives command and delegates method to attack player and display fight stats
     */
    public void processCommand(Opponent opponent) {
        opponent.attack();
        if(isAlive()) {
            DisplayUtil.printToConsole(name + " is hit with damage and health decreased to " +
                    getStatus());
        }
        else {
            downgrade();
            consumeCoins(Constants.LOSER_COINS);
            DisplayUtil.printToConsole(name + " has been defeated. User downgraded to level : " + grade + " and money left is " + coins);
        }
    }

    /**
     * escape method used to quit the fight and downgrade player skills and health
     */
    public void escape() {
        downgrade();
        restoreHealth();
        quit=true;
    }

    /**
     * restoreHealth consumes medicines and increase health of the player
     */
    private void restoreHealth() {
        if (medicines > 0) {
            health = Math.min(maxHealth, health + 10);
            medicines--;
            DisplayUtil.printToConsole(name + "  Consumed medicines. Health increased to " +getStatus() + " and Total Medicines left is " +
                    medicines);
        } else {
            DisplayUtil.printToConsole("You've no more Medicines!");
        }
    }

    private void downgrade() {
        if(this.grade>0) {
            this.grade = (Math.max(0,this.getGrade() -1));
        }
    }


    public void addHealth(int value) {
        this.health += value;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCoins() {
        return coins;
    }

    public boolean isQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }


    /**
     * Util function to display stats of Player
     */
    public void display() {
        DisplayUtil.printToConsole("######Player Stats###########");
        DisplayUtil.printToConsole("Name " + name);
        DisplayUtil.printToConsole("Health " + health);
        DisplayUtil.printToConsole("Coins " + coins);
        if (!getWeaponList().isEmpty()) {
            DisplayUtil.printToConsole("Weapon List");
            getWeaponList().stream().forEach(weapon -> DisplayUtil.printToConsole(weapon.getName()));
        }
        DisplayUtil.printToConsole("################################");

    }
}
