package com.company.game.utils;

import com.company.game.constants.OpponentConfig;
import com.company.game.domain.Opponent;
import com.company.game.plot.fight.OpponentFactory;

import java.io.Serializable;
import java.util.Scanner;

/**
 * InputReaderUtil class will have methods to process user inputs
 */
public class InputReaderUtil implements Serializable {

    private static Scanner scanner = new Scanner(System.in);

    public static int getValidIntegerInput() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        return scanner.nextInt();
    }


    public static String getValidStringInput() {
        String value = scanner.next();
        while (value == null || value.trim().equals("")) {
            value = scanner.next();
        }
        return value;
    }

    /**
     * chooseOpponent will select opponents base on user input
     * @return
     */
    public static Opponent chooseOpponent() {
        DisplayUtil.printToConsole("Choose your opponent!");
        DisplayUtil.printOpponentList();
        while (true) {
            switch (InputReaderUtil.getValidIntegerInput()) {
                case 1:
                    return OpponentFactory.getOpponent(OpponentConfig.TIM);
                case 2:
                    return  OpponentFactory.getOpponent(OpponentConfig.TOM);
                case 3:
                    return OpponentFactory.getOpponent(OpponentConfig.HARRY);
                case 4:
                    return  OpponentFactory.getOpponent(OpponentConfig.VERONIKA);
                case 5:
                    return OpponentFactory.getOpponent(OpponentConfig.DASHA);
                default:
                    DisplayUtil.printToConsole("Default opponent is set as TIM");
                    return  OpponentFactory.getOpponent(OpponentConfig.TIM);
            }
        }
    }

    public static void resetIn(){
        scanner = new Scanner(System.in);
    }
}
