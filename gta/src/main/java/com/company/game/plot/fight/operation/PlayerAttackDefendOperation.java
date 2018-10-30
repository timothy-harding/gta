package com.company.game.plot.fight.operation;

import com.company.game.domain.Opponent;
import com.company.game.domain.Player;
/*
Operation attack is carried out
 */
public class PlayerAttackDefendOperation implements Operation {

    private Player player;
    private Opponent opponent;

    public PlayerAttackDefendOperation(Player player, Opponent opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    @Override
    public void operate() {
        player.processCommand(opponent);
    }

}
