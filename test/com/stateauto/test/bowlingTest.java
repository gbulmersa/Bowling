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
        assertEquals(10, ret.length);
        assertEquals("0", ret[9]);
        printGame("All gutter balls test", ret);
    }

    @Test
    public void onePinPerRollTest() throws Exception {
        String[] ret = bg.onePinPerRoll();
        assertTrue(ret.length == 10);
        assertEquals("20", ret[9]); // 2 points per frame * 10 frames
        printGame("One pin per roll test", ret);

    }

    @Test
    public void threePinsThreeRolls() throws Exception {
       String[] ret = bg.threePinsThreeRolls();

       assertTrue(ret.length==2);
       assertEquals("9", ret[1]);
       printGame("Three Pins Three Rolls",ret);
    }

    @Test
    public void fourPinsFiveRolls() throws Exception {
        String [] ret = bg.fourPinsFiveRolls();
        assertTrue(ret.length==3);
        assertEquals("20", ret[2]);
        printGame("Four Pins Five Rolls",ret);
    }

    @Test
    public void rollOnlyOneBall() throws Exception {
        String[] ret = bg.rollOneBall(5);
        assertTrue(ret.length==1);
        assertEquals("5", ret[0]);
    }

    @Test
    public void rollOneSpare() throws Exception {
        String[] temp = bg.rollOneBall(3);
        String[] ret = bg.rollOneBall(7);
        assertTrue(ret.length==1);
        assertEquals("10", ret[0]);
    }

    @Test
    public void rollOneSparePlusBall() throws Exception {
        bg.rollOneBall(3);
        bg.rollOneBall(7);
        String[] ret = bg.rollOneBall(1);
        assertTrue(ret.length==2);
        assertEquals("11", ret[0]);
        assertEquals("12", ret[1]);
        printGame("Roll One Spare plus One",ret);
    }

    @Test  @Ignore
    public void oneSpareTwoBalls() throws Exception {
        bg.rollOneBall(3);
        bg.rollOneBall(7);

        bg.rollOneBall(1);
        String[] ret = bg.rollOneBall(1);

        assertTrue(ret.length==2);
        assertEquals("11", ret[1]);
        // assertEquals("13", ret[3]);
        // printGame("one spare two balls",ret);
    }

    @Ignore
    @Test
    public void rollThreeSpares() throws Exception {
        bg.rollOneBall(3);
      bg.rollOneBall(7);
   //     bg.rollOneBall(8);
   //   bg.rollOneBall(2);
//        bg.rollOneBall(5);
//        bg.rollOneBall(5);
        String[] ret =bg.rollOneBall(1);
        assertTrue(ret.length==4);
        assertEquals("45", ret[3]);
        printGame("Three Spares and One",ret);
    }
}
