package com.company.game.plot.casino.games;

import com.company.game.constants.Games;
import com.company.game.domain.Player;
import com.company.game.utils.DisplayUtil;
import com.company.game.utils.InputReaderUtil;

import java.util.Random;
/**
 * JackPot class will have methods to play jackpot
 */
public class JackPot {

    private Player player;
    private Random random;

    public JackPot(Player player) {
        this.player = player;
        this.random = new Random();
    }

    /**
     * play method will take user input and try to match with random generated number to win the game
     */
    public void play() {

        boolean isExit = false;
        DisplayUtil.printJackPotMsg();
        while (!isExit) {
            DisplayUtil.printToConsole("Please provide a 3 digit number to play!");
            DisplayUtil.printToConsole("Press x to exit");
            String input = InputReaderUtil.getValidStringInput();
            if (validate(input)) {

                int firstNum = getRandom(9);
                int secondNum = getRandom(9);
                int thirdNum = getRandom(9);

                DisplayUtil.simulateLoading();
                DisplayUtil.space();
                DisplayUtil.printToConsole("Jackpot Number " + firstNum + ' ' + secondNum + ' ' + thirdNum);
                DisplayUtil.space();

                if (firstNum == Integer.valueOf(input.charAt(0) - 48) && secondNum == Integer.valueOf(input.charAt(1) - 48) && thirdNum == Integer.valueOf(input.charAt(2) - 48)) {
                    DisplayUtil.printToConsole("Congratulations. You won 50 coins.");
                    player.addCoins(Games.JACKPOT.getCoinsWon());
                    player.display();
                } else {
                    DisplayUtil.printToConsole("You lost. Better luck next time.");
                    player.consumeCoins(Games.JACKPOT.getPrice());
                    player.display();
                }

            } else {
                if (input.equals("x")) {
                    isExit = true;
                } else {
                    DisplayUtil.printToConsole("Input is not valid.");
                }

            }

        }
    }

    public Player getPlayer() {
        return player;
    }

    private int getRandom(int inbound) {
        return random.nextInt(inbound);
    }

    private boolean validate(String input) {
        if (input != null && input.length() == 3 && input.matches("-?\\d+(\\.\\d+)?")) {
            return true;
        }
        return false;
    }
}
