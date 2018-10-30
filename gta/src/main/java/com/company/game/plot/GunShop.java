package com.company.game.plot;

import com.company.game.constants.Weapon;
import com.company.game.domain.Player;
import com.company.game.utils.DisplayUtil;
import com.company.game.utils.InputReaderUtil;
/**
 * GunShop class will have methods to GunShop related operations
 */
public class GunShop extends Place {

    public GunShop(String description, Player player) {
        super(description, player);
    }

    @Override
    public void engage() {
        DisplayUtil.printToConsole("You are in " + this.getDescription());
        //Shop guns and lose money
        boolean isExit = false;
        while (!isExit){

            DisplayUtil.printGunShopMsg();
            DisplayUtil.space();
            int itemId = InputReaderUtil.getValidIntegerInput();

            switch (itemId) {
                case 1:
                    if(checkIfPlayerHasEnoughCredits(Weapon.GUN)){
                        getPlayer().addWeapon(Weapon.GUN);
                        getPlayer().consumeCoins(Weapon.GUN.getPrice());
                        getPlayer().display();
                    }
                    break;
                case 2:
                    if(checkIfPlayerHasEnoughCredits(Weapon.BOMB)){
                        getPlayer().addWeapon(Weapon.BOMB);
                        getPlayer().consumeCoins(Weapon.BOMB.getPrice());
                        getPlayer().display();
                    }
                    break;
                case 3:
                    if(checkIfPlayerHasEnoughCredits(Weapon.BULLET)){
                        getPlayer().addWeapon(Weapon.BULLET);
                        getPlayer().consumeCoins(Weapon.BULLET.getPrice());
                        getPlayer().display();
                    }
                    break;
                case 4:
                    if(checkIfPlayerHasEnoughCredits(Weapon.ROCKET_LAUNCHER)){
                        getPlayer().addWeapon(Weapon.ROCKET_LAUNCHER);
                        getPlayer().consumeCoins(Weapon.ROCKET_LAUNCHER.getPrice());
                        getPlayer().display();
                    }
                    break;
                case 5:
                    isExit = true;
                    break;
                default:
                    break;
            }
        }
    }

    private boolean checkIfPlayerHasEnoughCredits(Weapon weapon) {

        if(getPlayer().getCoins() > weapon.getPrice()){
            return true;
        }
        DisplayUtil.printToConsole("Sorry, you dont have enough money to buy "+ weapon.getName());
        return false;
    }
}
