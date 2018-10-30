package com.company.game.constants;

/**
 * Tha WorkOut enum holds values to WorkOut stats  in the game and more can be added here
 */
public enum WorkOut {

    BEGINNER_WORKOUT(1, "BEGINNER WORKOUT", 5),
    INTERMEDIATE_WORKOUT(2, "INTERMEDIATE WORKOUT", 10),
    EXTENSIVE_WORKOUT(3, "EXTENSIVE WORKOUT", 15);

    private int id;
    private String name;
    private int energyValue;

    WorkOut(int id, String name, int energyValue) {
        this.id = id;
        this.name = name;
        this.energyValue = energyValue;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEnergyValue() {
        return energyValue;
    }
}