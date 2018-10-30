package com.company.game.plot;

import com.company.game.domain.Opponent;
import com.company.game.domain.Player;

import java.io.Serializable;
/**
 * Place class will have abstraction class and holds common methods for places
 */
public abstract class Place implements Serializable {

    private final String description;
    private final Player player;
    private Opponent opponent;

    public Place(String description, Player player) {
        this.description = description;
        this.player = player;
        this.opponent = null;
    }

    public String getDescription() {
        return description;
    }

    public Player getPlayer() {
        return player;
    }

    public Opponent getOpponent() {
        return opponent;
    }

    public void setOpponent(Opponent opponent) {
        this.opponent = opponent;
    }

    public abstract void engage();

}
