package com.company.game.plot;

import com.company.game.constants.WorkOut;
import com.company.game.domain.Player;
import com.company.game.utils.DisplayUtil;
import com.company.game.utils.InputReaderUtil;

public class Gym extends Place {

    public Gym(String description, Player player) {
        super(description, player);
    }

    @Override
    public void engage() {
        DisplayUtil.printToConsole("You are in " + this.getDescription());
        //Exercise and increase your stamina

        boolean isExit = false;
        while (!isExit) {

            DisplayUtil.printGymMsg();
            DisplayUtil.space();
            int gymId = InputReaderUtil.getValidIntegerInput();

            switch (gymId) {
                case 1:
                    getPlayer().addHealth(WorkOut.BEGINNER_WORKOUT.getEnergyValue());
                    simulateWorkOut();
                    break;
                case 2:
                    getPlayer().addHealth(WorkOut.INTERMEDIATE_WORKOUT.getEnergyValue());
                    simulateWorkOut();
                    break;
                case 3:
                    getPlayer().addHealth(WorkOut.EXTENSIVE_WORKOUT.getEnergyValue());
                    simulateWorkOut();
                    break;
                case 4:
                    isExit = true;
                    break;
                default:
                    break;
            }
        }
    }

    private void simulateWorkOut() {
        DisplayUtil.printToConsole("Working out.......");
        DisplayUtil.simulateLoading();
        DisplayUtil.space();
        getPlayer().display();
    }
}
