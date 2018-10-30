package com.company.game.manager;

import com.company.game.constants.Constants;
import com.company.game.domain.Player;
import com.company.game.plot.City;
import com.company.game.utils.InputReaderUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class ActionManagerImplTest {

    private ActionManagerImpl actionManager;


    @Before
    public void setUp() {
        actionManager = new ActionManagerImpl();
    }

    @Test
    public void createPlayerTestNotNull() {

        ByteArrayInputStream in = new ByteArrayInputStream("test".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        Assert.assertNotNull(actionManager.createPlayer());
    }

    @Test(expected = NullPointerException.class)
    public void createPlayerTestNull() {

        ByteArrayInputStream in = new ByteArrayInputStream(null);
        System.setIn(in);
        InputReaderUtil.resetIn();

        actionManager.createPlayer();
    }

    @Test
    public void playGameTest() {

        ByteArrayInputStream in = new ByteArrayInputStream("6\n".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN) ;
        actionManager.playGame(player);
    }

    @Test
    public void saveGameTest() {

        ByteArrayInputStream in = new ByteArrayInputStream("6\n".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN) ;
        City city = new City(player);
        actionManager.saveGame(city);

    }

    @Test
    public void resumeGameTest() {

        ByteArrayInputStream in = new ByteArrayInputStream("6\n".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN) ;
        City city = new City(player);
        actionManager.saveGame(city);

        Assert.assertNotNull(actionManager.resumeGame());

    }

}
