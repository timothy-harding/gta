package com.company.game.plot;

import com.company.game.constants.Constants;
import com.company.game.constants.Location;
import com.company.game.domain.Player;
import com.company.game.utils.InputReaderUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class RestaurantTest {

    private Restaurant restaurant;


    @Before
    public void setUp() {
        System.setIn(null);
        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN) ;
        restaurant = new Restaurant(Location.RESTAURANT.getName(), player);
    }

    @Test
    public void restaurantNullTest() {
        Assert.assertNotNull(restaurant);
    }

    @Test
    public void engageExitTest() {

        int coins = restaurant.getPlayer().getCoins();
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        restaurant.engage();
        Assert.assertTrue(coins == restaurant.getPlayer().getCoins());
    }

    @Test
    public void engageConsumeFoodTest() {

        int coins = restaurant.getPlayer().getCoins();
        ByteArrayInputStream in = new ByteArrayInputStream("1\n4\n".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        restaurant.engage();
        Assert.assertFalse(coins == restaurant.getPlayer().getCoins());
    }


}
