package com.company.game.plot;

import com.company.game.constants.Constants;
import com.company.game.constants.Location;
import com.company.game.domain.Player;
import com.company.game.utils.InputReaderUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class CityTest {

    private City city;


    @Before
    public void setUp() {

        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN) ;
        city = new City( player);
    }

    @Test
    public void cityNotNullTest() {
        Assert.assertNotNull(city);
    }

    @Test
    public void cityPlaceNotNullTest() {
        Assert.assertNotNull(city.getMapOfPlaces());
    }

    @Test
    public void playGameExitTest() {

        int coins = city.getPlayer().getCoins();
        ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();
        city.playGame();
        Assert.assertTrue(coins == city.getPlayer().getCoins());
    }

    @Test
    public void playGameGunShoppingTest() {

        int coins = city.getPlayer().getCoins();
        ByteArrayInputStream in = new ByteArrayInputStream("3\n2\n5\n6\n".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();
        city.playGame();
        Assert.assertFalse(coins == city.getPlayer().getCoins());
    }

}
