package com.company.game.constants;

/**
 * Tha Games enum holds values to available games at casino and more can be added here
 */
public enum Games {

    JACKPOT(1, "JACKPOT", 50, 10);

    private int id;
    private String name;
    private int coinsWon;
    private int price;

    Games(int id, String name, int coinsWon, int price) {
        this.id = id;
        this.name = name;
        this.coinsWon = coinsWon;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCoinsWon() {
        return coinsWon;
    }

    public int getPrice() {
        return price;
    }

}
