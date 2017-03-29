package com.stateauto.test;


import com.stateauto.bowling.BowlingGame;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by bul2852 on 3/29/2017.
 */
public class bowlingTest {

    private BowlingGame bg;
    private void printGame(String gameTitle, String[] frames) {
        System.out.println(gameTitle);
        for (int i=0; i<frames.length; i++) {
            System.out.println("Frame " + String.valueOf(i+1) + ": " + frames[i]);
        }
        System.out.println();
    }

    @Before
    public void setUp() throws Exception {
        bg = new BowlingGame();
    }

    @Test
    public void canCreateBowlingGameTest() {
        assertTrue(bg != null);
    }

    @Test
    public void rollOneGutterBallTest() throws Exception {
        String ret[] = bg.rollOneBall(0);
        assertEquals("0", ret[0]);
        printGame("Roll one gutter ball test",ret );
    }

    @Test
    public void rollAllGutterBallsTest() throws Exception {
        String[] ret = bg.rollAllGutterBalls();
        assertTrue(ret.length == 10);
        printGame("All gutter balls test", ret);
    }

    @Test
    public void onePinPerRollTest() throws Exception {
        String[] ret =  bg.onePinPerRoll();
        assertTrue(ret.length == 10);
        assertEquals("20", ret[9]);
        printGame("One pin per roll test", ret);
    }

    
}
