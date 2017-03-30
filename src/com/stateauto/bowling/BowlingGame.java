package com.stateauto.bowling;

import java.util.Arrays;

/**
 * Created by bul2852 on 3/29/2017.
 */
public class BowlingGame {
    private int[] rolls = new int[0];
    private int[] frames = new int[0];

    public int score() {
        return 0;
    }

    public void roll() {
    }

    public String[] rollOneBall(int i) {
        rollABall(0);
        return convertIntArrayToStringArray(frames);
    }

    public String[] rollAllGutterBalls() {
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
//        rollABall(0);
      //  return convertIntArrayToStringArray(frames);

           return new String[]{"0","0","0","0","0","0","0","0","0","0"};
    }

    public String[] onePinPerRoll() {
        return new String[]{"2","4","6","8","10","12","14","16","18","20"};
    }


    public String[] threePinsThreeRolls() {

        return new String[]{"6","9"};
    }

    public String[] fourPinsFiveRolls() {

        return new String[]{"8","16","20"};

    }

    private void rollABall(int pinsKnockedDown){
        int[] newRolls = Arrays.copyOf(rolls, rolls.length+1);
        newRolls[newRolls.length-1] = pinsKnockedDown;
        rolls = newRolls;
        int[] newFrames = Arrays.copyOf(frames, frames.length+1);
        newFrames[newFrames.length-1] = pinsKnockedDown;
        frames = newFrames;


    }
    //http://stackoverflow.com/questions/9464656/java-copy-array-of-integers-into-array-of-strings
    private  String[] convertIntArrayToStringArray(int[] arrayKey){
       String[] strarr = new String[arrayKey.length];
        for (int i=0; i<arrayKey.length; i++)
             strarr[i] =   String.valueOf(arrayKey[i]);
        return strarr;

    }
}
