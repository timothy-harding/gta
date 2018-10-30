package com.company.game.config;

import com.company.game.constants.Location;
import com.company.game.domain.Player;
import com.company.game.plot.*;
import com.company.game.plot.fight.FightArena;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Config implements Serializable {

    /**
     * Tha Config class holds location to different places in the plot
     */
    private static Config instance;

    private Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public Map<Integer, Place> loadCity(Player player) {
        Map<Integer, Place> mapOfPlaces = new HashMap<Integer, Place>();
        mapOfPlaces.put(Location.CASINO.getId(), new Casino(Location.CASINO.getName(), player));
        mapOfPlaces.put(Location.FIGHT_ARENA.getId(), new FightArena(Location.FIGHT_ARENA.getName(), player));
        mapOfPlaces.put(Location.GUN_SHOP.getId(), new GunShop(Location.GUN_SHOP.getName(), player));
        mapOfPlaces.put(Location.GYM.getId(), new Gym(Location.GYM.getName(), player));
        mapOfPlaces.put(Location.RESTAURANT.getId(), new Restaurant(Location.RESTAURANT.getName(), player));

        return mapOfPlaces;
    }

}
