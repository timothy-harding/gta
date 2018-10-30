package com.company.game.config;

import com.company.game.constants.Constants;
import com.company.game.domain.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigTest {

    private Config config;


    @Before
    public void setUp() {
        config = Config.getInstance();
    }

    @Test
    public void getInstanceTest() {

        Assert.assertNotNull(config);
    }

    @Test
    public void loadCityTest() {
        Assert.assertNotNull(config.loadCity(new Player("Test", Constants.MAX_HEALTH, Constants.MED_KITS, Constants.EXPERIENCE, Constants.DEFAULT_COIN)));
    }
}
