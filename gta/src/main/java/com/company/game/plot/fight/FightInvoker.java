package com.company.game.plot.fight;

import com.company.game.plot.fight.operation.Operation;

/*
Invokes the command
 */
public class FightInvoker {

    public static void invoke(Operation operation){
        operation.operate();
    }


}
