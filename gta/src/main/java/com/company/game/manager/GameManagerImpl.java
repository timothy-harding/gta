package com.company.game.manager;

import com.company.game.domain.Player;
import com.company.game.plot.City;
import com.company.game.utils.DisplayUtil;
import com.company.game.utils.InputReaderUtil;

/**
 * GameManagerImpl method implements user selection in the game
 */
public class GameManagerImpl implements IGameManager {

    private IActionManager actionManager;

    private Player player;

    private City city;

    public GameManagerImpl() {
        actionManager = new ActionManagerImpl();
    }

    @Override
    public void startGame() {

        while (true) {

            DisplayUtil.space();
            DisplayUtil.printInitialMsg();

            switch (InputReaderUtil.getValidIntegerInput()) {
                case 1:
                    player = actionManager.createPlayer();
                    city = null;
                    break;
                case 2:
                    if (player != null) {
                        city = actionManager.playGame(player);
                    } else {
                        DisplayUtil.printToConsole("Create player before playing game!");
                    }
                    break;
                case 3:
                    if (city != null) {
                        actionManager.saveGame(city);
                    } else {
                        DisplayUtil.printToConsole("Play the game first!");
                    }
                    break;
                case 4:
                    city = actionManager.resumeGame();
                    if (city != null) {
                        city.playGame();
                    }
                    break;
                case 5:
                    actionManager.exitGame();
                    break;
                default:
                    break;

            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public City getCity() {
        return city;
    }
}
