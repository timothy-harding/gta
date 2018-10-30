package com.company.game.plot.fight.operation;

import com.company.game.domain.Player;

/*
Operation escape is carried out
 */
public class PlayerEscapeOperation implements Operation {

    private Player player;

    public PlayerEscapeOperation(Player player){
        this.player = player;
    }

    @Override
    public void operate() {
        player.escape();
    }
}
