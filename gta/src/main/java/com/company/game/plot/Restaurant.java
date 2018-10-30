package com.company.game.plot;

import com.company.game.constants.Food;
import com.company.game.domain.Player;
import com.company.game.utils.DisplayUtil;
import com.company.game.utils.InputReaderUtil;

/**
 * Restaurant class will have methods to Restaurant related operations
 */
public class Restaurant extends Place {

    public Restaurant(String description, Player player) {
        super(description, player);
    }

    @Override
    public void engage() {
        DisplayUtil.printToConsole("You are in " + this.getDescription());
        boolean isExit = false;
        while (!isExit) {

            DisplayUtil.printRestaurantMsg();
            DisplayUtil.space();
            int restaurantId = InputReaderUtil.getValidIntegerInput();

            switch (restaurantId) {
                case 1:
                    if (checkIfPlayerHasEnoughCredits(Food.PIZZA)) {
                        getPlayer().addHealth(Food.PIZZA.getEnergyValue());
                        getPlayer().consumeCoins(Food.BURGER.getPrice());
                        simulateEating();
                    }
                    break;
                case 2:
                    if (checkIfPlayerHasEnoughCredits(Food.BURGER)) {
                        getPlayer().addHealth(Food.BURGER.getEnergyValue());
                        getPlayer().consumeCoins(Food.BURGER.getPrice());
                        simulateEating();
                    }
                    break;
                case 3:
                    if (checkIfPlayerHasEnoughCredits(Food.CAKE)) {
                        getPlayer().addHealth(Food.CAKE.getEnergyValue());
                        getPlayer().consumeCoins(Food.BURGER.getPrice());
                        simulateEating();
                    }
                    break;
                case 4:
                    isExit = true;
                    break;
                default:
                    break;
            }
        }
    }

    private void simulateEating() {
        DisplayUtil.printToConsole("Feast mode on.......");
        DisplayUtil.simulateLoading();
        DisplayUtil.space();
        getPlayer().display();
    }

    private boolean checkIfPlayerHasEnoughCredits(Food food) {

        if (getPlayer().getCoins() > food.getPrice()) {
            return true;
        }
        DisplayUtil.printToConsole("Sorry, you don't have enough money to buy " + food.getName());
        return false;
    }
}
