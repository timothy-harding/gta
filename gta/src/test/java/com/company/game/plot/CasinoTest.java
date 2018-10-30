package com.company.game.plot;

import com.company.game.constants.Constants;
import com.company.game.constants.Location;
import com.company.game.domain.Player;
import com.company.game.utils.InputReaderUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class CasinoTest {

    private Casino casino;


    @Before
    public void setUp() {

        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN) ;
        casino = new Casino(Location.CASINO.getName(), player);
    }

    @Test
    public void casinoNullTest() {
        Assert.assertNotNull(casino);
    }

    @Test
    public void engageTest() {

        int coins = casino.getPlayer().getCoins();
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();
        casino.engage();
        Assert.assertTrue(coins == casino.getPlayer().getCoins());
    }


}


