package com.company.game.plot;

import com.company.game.constants.Constants;
import com.company.game.constants.Location;
import com.company.game.domain.Player;
import com.company.game.utils.InputReaderUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class GymTest {

    private Gym gym;


    @Before
    public void setUp() {

        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN) ;
        gym = new Gym(Location.GYM.getName(), player);
    }

    @Test
    public void gymNullTest() {
        Assert.assertNotNull(gym);
    }

    @Test
    public void engageExitTest() {

        int health = gym.getPlayer().getCoins();
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        gym.engage();
        Assert.assertTrue(health == gym.getPlayer().getCoins());
    }

    @Test
    public void engageWorkOutTest() {

        int health = gym.getPlayer().getHealth();
        ByteArrayInputStream in = new ByteArrayInputStream("1\n4\n".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        gym.engage();
        Assert.assertFalse(health == gym.getPlayer().getHealth());
    }

}
