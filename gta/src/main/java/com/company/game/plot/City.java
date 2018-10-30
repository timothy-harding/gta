package com.company.game.plot;

import com.company.game.config.Config;
import com.company.game.domain.Player;
import com.company.game.utils.DisplayUtil;
import com.company.game.utils.InputReaderUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * City class will have methods to City related operations
 */
public class City implements Serializable {
    private Map<Integer, Place> mapOfPlaces = new HashMap<>();
    private Player player;

    public City(Player player) {
        mapOfPlaces = Config.getInstance().loadCity(player);
        this.player = player;
    }


    public City playGame() {

        boolean isExit = false;
        while (!isExit) {
            DisplayUtil.printPlayGameMsg();
            DisplayUtil.space();
            int placeId = InputReaderUtil.getValidIntegerInput();

            if (placeId == 6) {
                isExit = true;
            } else {
                Place place = mapOfPlaces.get(placeId);
                place.engage();
            }
        }
        return this;
    }

    public Map<Integer, Place> getMapOfPlaces() {
        return mapOfPlaces;
    }

    public Player getPlayer() {
        return player;
    }
}
