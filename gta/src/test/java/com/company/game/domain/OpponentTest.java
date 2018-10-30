package com.company.game.domain;

import com.company.game.constants.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpponentTest {

    private Opponent opponent;


    @Before
    public void setUp() {
        opponent = new Opponent("Test", Constants.MAX_HEALTH, Constants.DEFAULT_COIN);
    }

    @Test
    public void opponentNotNull() {
        Assert.assertNotNull(opponent);
    }


    @Test
    public void attackTest() {
        int health = opponent.getHealth();
        opponent.attack();

        Assert.assertFalse(health == opponent.getHealth());
    }

    @Test
    public void processCommandTest() {
        Player player = new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN);

        opponent.processCommand(player);

        Assert.assertFalse(player.getHealth() == Constants.MAX_HEALTH);
    }

}
