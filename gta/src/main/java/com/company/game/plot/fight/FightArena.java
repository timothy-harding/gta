package com.company.game.plot.fight;

import com.company.game.domain.Player;
import com.company.game.plot.Place;
import com.company.game.plot.fight.operation.OpponentAttackDefendOperation;
import com.company.game.plot.fight.operation.PlayerAttackDefendOperation;
import com.company.game.plot.fight.operation.PlayerEscapeOperation;
import com.company.game.utils.DisplayUtil;
import com.company.game.utils.InputReaderUtil;

/**
 * FightArena class will have methods to fight opponent
 */
public class FightArena extends Place {

    public FightArena(String description, Player player) {
        super(description, player);
    }


    /**
     * engage method commands system to attach and defend unless user interaction overrides it
     */
    @Override
    public void engage() {
        setOpponent(InputReaderUtil.chooseOpponent());
        //display players details
        displayGameStats();
        //initialising
        this.getPlayer().setQuit(false);
        //display progress
        simulateFight();
        while (!gameOver()) {
            if (this.getPlayer().isCritical()) {
                //warn player to quit
                warnPlayer();
                String action = InputReaderUtil.getValidStringInput();
                //based on user action either quit or continue fight
                processUserAction(action);
            } else {
                //attack opponent
                FightInvoker.invoke(new OpponentAttackDefendOperation(getPlayer(), getOpponent()));
            }
            if (this.getOpponent().isAlive() && !this.getPlayer().isQuit()) {
                //attack player
                FightInvoker.invoke(new PlayerAttackDefendOperation(getPlayer(), getOpponent()));
            }
        }
    }

    private void simulateFight() {
        DisplayUtil.printToConsole("Fight mode on.......");
        DisplayUtil.simulateLoading();
        DisplayUtil.space();
        getPlayer().display();
    }

    private void displayGameStats() {
        DisplayUtil.printToConsole("Battle Begins " + this.getDescription());
        this.getPlayer().display();
        DisplayUtil.space();
        this.getOpponent().display();
        DisplayUtil.printToConsole("You have encountered " + ": " + this.getOpponent().getName() + "\n");
        DisplayUtil.printToConsole("Fight with " + this.getOpponent().getName() + " starts (" + this.getPlayer().getStatus() + " / " + this.getOpponent().getStatus() + ")");
    }

    private void processUserAction(String action) {
        if (action.equalsIgnoreCase("y")) {
            FightInvoker.invoke(new PlayerEscapeOperation(getPlayer()));
        } else {
            FightInvoker.invoke(new OpponentAttackDefendOperation(getPlayer(), getOpponent()));
        }
    }

    private void warnPlayer() {
        DisplayUtil.printToConsole("Health is critically low. To recover drive home. Escape? (y) or (n)");
    }

    /**
     * gameOver methos holds condition for fight end
     * @return
     */
    private boolean gameOver() {
        return !this.getPlayer().isAlive() || !this.getOpponent().isAlive() || this.getPlayer().isQuit();
    }
}