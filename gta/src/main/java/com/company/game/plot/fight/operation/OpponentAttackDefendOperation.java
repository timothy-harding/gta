package com.company.game.plot.fight.operation;

import com.company.game.domain.Opponent;
import com.company.game.domain.Player;
/*
Operation attack or defend is carried out
 */
public class OpponentAttackDefendOperation implements Operation {

    private Player player;
    private Opponent opponent;

    public OpponentAttackDefendOperation(Player player, Opponent opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    @Override
    public void operate() {
        opponent.processCommand(player);
    }

}
