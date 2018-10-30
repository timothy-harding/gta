package com.company.game.domain;

import com.company.game.constants.Constants;
import com.company.game.constants.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;


    @Before
    public void setUp() {
        player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN);
    }

    @Test
    public void playerNotNull() {
        Assert.assertNotNull(player);
    }

    @Test
    public void addWeaponTest() {

        player.addWeapon(Weapon.GUN);

        Assert.assertTrue(player.getWeaponList().size() > 0);
    }

    @Test
    public void consumeCoinTest(){
        int coin = player.getCoins();
        player.consumeCoins(1);

        Assert.assertFalse(coin == player.getCoins());
    }

    @Test
    public void addCoinTest(){
        int coin = player.getCoins();
        player.addCoins(1);

        Assert.assertFalse(coin == player.getCoins());
    }

    @Test
    public void attackTest(){
        int health = player.getHealth();
        player.attack();

        Assert.assertFalse(health == player.getHealth());
    }

    @Test
    public void addHealth(){
        int health = player.getHealth();
        player.addHealth(1);

        Assert.assertFalse(health == player.getHealth());
    }

    @Test
    public void processCommandTest(){
        Opponent opponent = new Opponent("Test", Constants.MAX_HEALTH, Constants.DEFAULT_COIN);

        player.processCommand(opponent);

        Assert.assertFalse(opponent.getHealth() == Constants.MAX_HEALTH);
    }

    @Test
    public void escapeTest(){
        player.escape();
        Assert.assertTrue(player.isQuit());
    }

}
