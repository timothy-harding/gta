package com.company.game.utils;

import com.company.game.constants.OpponentConfig;
import com.company.game.utils.InputReaderUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class InputReaderUtilTest {

    @Before
    public void setUp() {
    }

    @Test
    public void getValidIntegerInputNotNullTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        Assert.assertNotNull(InputReaderUtil.getValidIntegerInput());
    }

    @Test(expected = NullPointerException.class)
    public void getValidIntegerInputNullTest() {
        ByteArrayInputStream in = new ByteArrayInputStream(null);
        System.setIn(in);

        InputReaderUtil.getValidIntegerInput();
    }

    @Test
    public void getValidStringInputNotNullTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("test".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        Assert.assertNotNull(InputReaderUtil.getValidStringInput());
    }

    @Test(expected = NullPointerException.class)
    public void getValidStringInputNullTest() {
        ByteArrayInputStream in = new ByteArrayInputStream(null);
        System.setIn(in);

        InputReaderUtil.getValidStringInput();
    }

    @Test
    public void chooseOpponentValidTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        Assert.assertTrue(InputReaderUtil.chooseOpponent().getName().equals(OpponentConfig.TOM.getName()));

    }

    @Test
    public void chooseOpponentDefaultTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("8".getBytes());
        System.setIn(in);
        InputReaderUtil.resetIn();

        Assert.assertTrue(InputReaderUtil.chooseOpponent().getName().equals(OpponentConfig.TIM.getName()));

    }

}
