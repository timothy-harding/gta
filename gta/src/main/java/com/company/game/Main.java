package com.company.game;


import com.company.game.manager.GameManagerImpl;
import com.company.game.manager.IGameManager;
import com.company.game.utils.DisplayUtil;
import com.company.game.utils.InputReaderUtil;

import java.io.IOException;

/**
 * Tha main class starts the game
 */
public class Main {

    public static void main(String[] args) {

        IGameManager gameManager = new GameManagerImpl();
        while (true) {
            DisplayUtil.space();
            DisplayUtil.printWelcomeMsg();

            switch (InputReaderUtil.getValidIntegerInput()) {
                case 1:
                    try {
                        gameManager.startGame();
                    } catch (IOException e) {
                        DisplayUtil.printToConsole("Oops, that was not expected. Its taken care!");
                    }
                    return;
                case 2:
                    return;
                default:
                    break;

            }
        }
    }
}
