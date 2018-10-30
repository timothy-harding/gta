package com.company.game.plot;

import com.company.game.constants.Constants;
import com.company.game.constants.Games;
import com.company.game.constants.Location;
import com.company.game.domain.Player;
import com.company.game.plot.casino.games.JackPot;
import com.company.game.utils.InputReaderUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class JackPotTest {

    private JackPot jackPot;


    @Before
    public void setUp() {
        System.setIn(null);
        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN) ;
        jackPot = new JackPot(player);
    }

    @Test
    public void JackPotNullTest() {
        Assert.assertNotNull(jackPot);
    }

    @Test
    public void playExitTest() {

        int coins = jackPot.getPlayer().getCoins();
        ByteArrayInputStream in = new ByteArrayInputStream("x\n".getBytes());

        System.setIn(in);
        InputReaderUtil.resetIn();
        jackPot.play();
        Assert.assertTrue(coins == jackPot.getPlayer().getCoins());
    }

    @Test
    public void playJackPotTest() {

        int coins = jackPot.getPlayer().getCoins();
        ByteArrayInputStream in = new ByteArrayInputStream("123\nx\n".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();
        jackPot.play();
        Assert.assertFalse(coins == jackPot.getPlayer().getCoins());
    }
}
