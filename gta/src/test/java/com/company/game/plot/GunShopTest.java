package com.company.game.plot;

import com.company.game.constants.Constants;
import com.company.game.constants.Location;
import com.company.game.domain.Player;
import com.company.game.utils.InputReaderUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class GunShopTest {

    private GunShop gunShop;


    @Before
    public void setUp() {

        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN) ;
        gunShop = new GunShop(Location.GUN_SHOP.getName(), player);
    }

    @Test
    public void casinoNullTest() {
        Assert.assertNotNull(gunShop);
    }

    @Test
    public void engageExitTest() {

        int coins = gunShop.getPlayer().getCoins();
        ByteArrayInputStream in = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        gunShop.engage();
        Assert.assertTrue(coins == gunShop.getPlayer().getCoins());
    }

    @Test
    public void engageBuyGunTest() {

        int coins = gunShop.getPlayer().getCoins();
        ByteArrayInputStream in = new ByteArrayInputStream("2\n5\n".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        gunShop.engage();
        Assert.assertFalse(coins == gunShop.getPlayer().getCoins());
    }



}
