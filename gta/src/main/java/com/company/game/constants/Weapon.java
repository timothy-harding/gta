package com.company.game.constants;
/**
 * Tha Weapon enum holds values to Weapon stats  in the game and more can be added here
 */
public enum Weapon {

    GUN(1, "GUN", 5),
    BOMB(2, "BOMB", 10),
    BULLET(3, "BULLET", 1),
    ROCKET_LAUNCHER(4, "ROCKET LAUNCHER", 15);

    private int id;
    private String name;
    private int price;

    Weapon(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
