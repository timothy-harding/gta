package com.company.game.constants;
/**
 * Tha Location enum holds values to available places to explore in the game and more can be added here
 */
public enum Location {

    CASINO(1, "CASINO"),
    FIGHT_ARENA(2, "FIGHT ARENA"),
    GUN_SHOP(3, "GUN SHOP"),
    GYM(4, "GYM"),
    RESTAURANT(5, "RESTAURANT");

    private int id;
    private String name;

    Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
