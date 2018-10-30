package com.company.game.plot;

import com.company.game.constants.Games;
import com.company.game.domain.Player;
import com.company.game.plot.casino.games.JackPot;
import com.company.game.utils.DisplayUtil;
import com.company.game.utils.InputReaderUtil;
/**
 * Casino class will have methods to casino related operations
 */
public class Casino extends Place {

    public Casino(String description, Player player) {
        super(description, player);
    }

    @Override
    public void engage() {
        DisplayUtil.printToConsole("You are in " + this.getDescription());
        boolean isExit = false;
        while (!isExit) {

            DisplayUtil.printCasinoMsg();
            DisplayUtil.space();
            int gameId = InputReaderUtil.getValidIntegerInput();

            switch (gameId) {
                case 1:
                    if (checkIfPlayerHasEnoughCredits(Games.JACKPOT)) {
                        JackPot jackPot = new JackPot(getPlayer());
                        jackPot.play();
                        getPlayer().display();
                    }
                    break;
                case 2:
                    isExit = true;
                    break;
                default:
                    break;
            }
        }
    }

    private boolean checkIfPlayerHasEnoughCredits(Games game) {

        if (getPlayer().getCoins() > game.getPrice()) {
            return true;
        }
        DisplayUtil.printToConsole("Sorry, you dont have enough money to play " + game.getName());
        return false;
    }
}
