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

    public String[] score() {
        updateFrames();
        return convertIntArrayToStringArray(frames);
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

        rollABall(4);
        rollABall(4);
        rollABall(4);
        rollABall(4);
        rollABall(4);
        return convertIntArrayToStringArray(frames);

    }

    private void rollABall(int pinsKnockedDown) {
        int[] newRolls = Arrays.copyOf(rolls, rolls.length+1);
        newRolls[newRolls.length-1] = pinsKnockedDown;
        rolls = newRolls;

        updateFrames();
    }

    private void updateFrames() {
        // carry over from previous frame (if necessary)
        int previousFrameScore;
        if (frames.length > 1) {
            previousFrameScore = frames[frames.length-1];
        } else {
            previousFrameScore = 0;
        }

        addNewFrameIfNecessary();
        // Add last roll to current new Frame
        frames[frames.length-1] = rolls[rolls.length-1] + previousFrameScore;
        computeFrames();
    }

    // looks ahead if strike or spare occured
    private void computeFrames() {
        int newFramesLength = rolls.length/2 + rolls.length %2;
        int[] newFrames = new int[newFramesLength ];
        for (int i = 0; i < newFramesLength; i++) {
            int firstRollIndex = i*2;
            int secondRollIndex = firstRollIndex + 1;
            int firstRollScore = rolls[firstRollIndex];
            int secondRollScore = rolls.length>secondRollIndex ? rolls[secondRollIndex] : 0;
            boolean isPreviousFrameSpare = i-1 >= 0 ? isFrameSpare(i-1) : false;
            if (isFrameSpare(i)) {
                boolean isSpare = firstRollScore + secondRollScore == 10;
                int followingRollIndex = secondRollIndex + 1;
                int followingRollScore = rolls.length>followingRollIndex ? rolls[followingRollIndex] : 0;
                int frameScore = i>0 ? (newFrames[i-1] + firstRollScore + secondRollScore) : (firstRollScore + secondRollScore);
                frameScore += isSpare ? followingRollScore : 0;
                newFrames[i] = frameScore;
                // newFrames[i] = isSpare ? frameScore += followingRollScore : frameScore;
            } else if (isPreviousFrameSpare) {
                int frameScore;
                frameScore = newFrames[i-1] + firstRollScore + secondRollScore;
                newFrames[i] = frameScore;
            }
            else {
                int frameScore;
                //If we're past the first frame we add in current frame score with previous frame score
                frameScore = i>0 ? newFrames[i-1] + firstRollScore + secondRollScore : firstRollScore + secondRollScore;
                newFrames[i] = frameScore;
            }
        }
        frames = newFrames;
    }

    private boolean isFrameSpare(int frameNumber) {
        int firstRollIndex = frameNumber*2;
        int secondRollIndex = firstRollIndex + 1;
        int firstRollScore = rolls[firstRollIndex];
        int secondRollScore = rolls.length>secondRollIndex ? rolls[secondRollIndex] : 0;
        return (firstRollScore + secondRollScore == 10);
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
