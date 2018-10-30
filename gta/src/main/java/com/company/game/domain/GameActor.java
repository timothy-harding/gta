package com.company.game.domain;

import com.company.game.constants.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Tha GameActor class holds the absraction for Opponent and player and has common functions
 */
public abstract class GameActor implements Serializable {

    String name;
    int health;
    List<Weapon> weaponList = new ArrayList<>();

    public abstract void display();

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isCritical() {
        return health > 0 && health <=10;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
