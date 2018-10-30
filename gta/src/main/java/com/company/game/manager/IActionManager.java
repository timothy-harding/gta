package com.company.game.manager;

import com.company.game.domain.Player;
import com.company.game.plot.City;

public interface IActionManager {

    Player createPlayer();

    City playGame(Player player);

    void saveGame(City city);

    City resumeGame();

    void exitGame();
}
