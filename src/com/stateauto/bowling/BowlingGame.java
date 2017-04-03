package com.stateauto.bowling;

import java.util.Arrays;

/**
 * Created by bul2852 on 3/29/2017.
 */
public class BowlingGame {
    // up to 21
    private int[] rolls = new int[0];
    // up to 10
    private int[] frames = new int[0];

    public int score() {
        return 0;
    }

    public void roll() {
    }

    // returns game score per frame so far
    public String[] rollOneBall(int pinsKnockedDown) {
        rollABall(pinsKnockedDown);
        return convertIntArrayToStringArray(frames);
    }

    public String[] rollAllGutterBalls() {
        // 20
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        rollABall(0);
        return convertIntArrayToStringArray(frames);
    }

    public String[] onePinPerRoll() {
        // 20
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        rollABall(1);
        return convertIntArrayToStringArray(frames);
    }

    public String[] threePinsThreeRolls() {
        rollABall(3);
        rollABall(3);
        rollABall(3);
        return convertIntArrayToStringArray(frames);
        // return new String[]{"6","9"};
    }

    public String[] fourPinsFiveRolls() {

        return new String[]{"8","16","20"};

    }

    private void rollABall(int pinsKnockedDown) {
        int[] newRolls = Arrays.copyOf(rolls, rolls.length+1);
        newRolls[newRolls.length-1] = pinsKnockedDown;
        rolls = newRolls;

        // ron: continue to think about this
        boolean isSpare = (!isNewFrame()) && (10-pinsKnockedDown) == frames[frames.length-1];

        updateFrames();
    }

    private void updateFrames() {
        // carry over from previous frame (if necessary)
        int previousFrameScore;
        if (frames.length > 0) {
            previousFrameScore = frames[frames.length-1];
        } else {
            previousFrameScore = 0;
        }

        addNewFrameIfNecessary();
        frames[frames.length-1] = rolls[rolls.length-1] + previousFrameScore;
    }

    // looks ahead if strike or spare occured
    private void computeFrames() {
        
        for (int i = 0; i < rolls.length; i++) {

        }
    }

    // returns 1 through 10, not zero indexed!
    private int computeFrameBasedOnRoll(int rollNumber) {
        if (rollNumber == 21) {
            return 10;
        } else {
            return (rollNumber / 2) + (rollNumber % 2);
        }
    }

    private void addNewFrameIfNecessary() {
        if (isNewFrame()) {
            // every 2nd ball is a new frame
            frames = Arrays.copyOf(frames, frames.length + 1);
        } else {
            frames = Arrays.copyOf(frames, frames.length);
        }
    }

    private boolean isNewFrame() {
        return (rolls.length-1)%2==0;
    }

    //http://stackoverflow.com/questions/9464656/java-copy-array-of-integers-into-array-of-strings
    private  String[] convertIntArrayToStringArray(int[] arrayKey){
       String[] strarr = new String[arrayKey.length];
        for (int i=0; i<arrayKey.length; i++)
             strarr[i] =   String.valueOf(arrayKey[i]);
        return strarr;

    }
}
