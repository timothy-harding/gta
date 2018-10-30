package com.company.game.plot.fight;

import com.company.game.constants.OpponentConfig;
import com.company.game.domain.Opponent;
/**
 * OpponentFactory class will have factory of opponents which are provided by factory based on selection
 */
public class OpponentFactory {

    public static Opponent getOpponent(OpponentConfig opponentConfig) {
        if (opponentConfig == null) {
            return null;
        }

        if (opponentConfig.getId() == OpponentConfig.TIM.getId()) {
            return new Opponent(OpponentConfig.TIM.getName(), OpponentConfig.TIM.getHealth(), OpponentConfig.TIM.getTaskBonus());
        } else if (opponentConfig.getId() == OpponentConfig.TOM.getId()) {
            return new Opponent(OpponentConfig.TOM.getName(), OpponentConfig.TOM.getHealth(), OpponentConfig.TOM.getTaskBonus());
        }else if (opponentConfig.getId() == OpponentConfig.HARRY.getId()) {
            return new Opponent(OpponentConfig.HARRY.getName(), OpponentConfig.HARRY.getHealth(), OpponentConfig.HARRY.getTaskBonus());
        }else if (opponentConfig.getId() == OpponentConfig.VERONIKA.getId()) {
            return new Opponent(OpponentConfig.VERONIKA.getName(), OpponentConfig.VERONIKA.getHealth(), OpponentConfig.VERONIKA.getTaskBonus());
        }else if (opponentConfig.getId() == OpponentConfig.DASHA.getId()) {
            return new Opponent(OpponentConfig.DASHA.getName(), OpponentConfig.DASHA.getHealth(), OpponentConfig.DASHA.getTaskBonus());
        }

        return null;
    }

}
