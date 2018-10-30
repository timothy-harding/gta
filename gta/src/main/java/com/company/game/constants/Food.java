package com.company.game.constants;
/**
 * Tha Food enum holds values to available food at restaurant and more can be added here
 */
public enum Food {

    PIZZA(1, "PIZZA", 20, 3),
    BURGER(2, "BURGER", 10, 4),
    CAKE(3, "CAKE", 5, 7);

    private int id;
    private String name;
    private int energyValue;
    private int price;

    Food(int id, String name, int energyValue, int price) {
        this.id = id;
        this.name = name;
        this.energyValue = energyValue;
        this.price = price;
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

    public int getPrice() {
        return price;
    }
}
