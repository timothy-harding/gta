package com.company.game.plot.fight;

import com.company.game.constants.Constants;
import com.company.game.constants.Location;
import com.company.game.domain.Player;
import com.company.game.plot.GunShop;
import com.company.game.utils.InputReaderUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class FightArenaTest {
    private FightArena fightArena;


    @Before
    public void setUp() {

        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN) ;
        fightArena = new FightArena(Location.FIGHT_ARENA.getName(), player);
    }

    @Test
    public void fightArenaNotNullTest() {
        Assert.assertNotNull(fightArena);
    }

    @Test
    public void engageFightTest() {

        int health = fightArena.getPlayer().getHealth();
        ByteArrayInputStream in = new ByteArrayInputStream("1\nn\n".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        fightArena.engage();
        Assert.assertFalse(health == fightArena.getPlayer().getHealth());
    }

}
