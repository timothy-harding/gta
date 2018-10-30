package com.company.game.constants;

/**
 * Tha OpponentConfig enum holds values to opponent stats  in the game and more can be added here
 */
public enum OpponentConfig {

    TIM(1, "TIM", 50, 5),
    TOM(2, "TOM", 45,  4),
    HARRY(3, "HARRY", 40,  3),
    VERONIKA(4, "VERONIKA", 35, 2),
    DASHA(5, "DASHA", 30, 1);

    private int id;
    private String name;
    private int health;
    private int taskBonus;

    OpponentConfig(int id, String name, int health, int taskBonus) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.taskBonus = taskBonus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getHealth() {
        return health;
    }

    public int getTaskBonus() {
        return taskBonus;
    }
}
