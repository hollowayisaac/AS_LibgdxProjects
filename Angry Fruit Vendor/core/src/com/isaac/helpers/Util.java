package com.isaac.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.isaac.gameworld.GameValues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isaac Holloway on 11/18/2014.
 */
public class Util {

    public static float roundToHalf(float x) {
        return (float) (Math.ceil(x * 20) / 20);
    }

    /**
     * @param d = Distance
     * @param a = Acceleration/Gravity
     * @return
     */
    public static float timeUntil(float d, float a){
        float time;
        time = (float) Math.sqrt(Math.abs(d)/(.5*Math.abs(a)));
        return time;
    }

    /**
     * Returns the Distance traveled by an object if we know
     * the <b>Initial Velocity</b>
     * @param vi = Initial Belocity
     * @param a = Gravity
     * @return
     */
    public static float howHigh(float vi, float a){
		/*
		 * [EX.]

						[FIND DISTANCE TRAVELED]
				EQUATION:  vf^2 = vi^2 + 2*a*d
				GIVEN:  				           vi = 26.2 m/s
												   vf = 0 m/s 		(this the point in which the ball reaches its peak and it has no velocity)
												   a = -9.8 m/s2

				[SOLVE]

				(0 m/s)2 = (26.2 m/s)2 + 2*(-9.8m/s2)*d
				0 m2/s2 = 686.44 m2/s2 + (-19.6 m/s2)*d
				(-19.6 m/s2)*d = 0 m2/s2 -686.44 m2/s2
				(-19.6 m/s2)*d = -686.44 m2/s2
				d = (-686.44 m2/s2)/ (-19.6 m/s2)
				d = 35.0 m
		 */

        float d = Math.abs(vi*vi) / Math.abs(a*2);
        return d;
    }

    public static float getMiddle(float width){
        return width/2;
    }

    /**
     * Receives a list of numbers, and 1 is randomly chosen and returned.
     * @param numSet
     * @return
     */
    public static Integer randomNumberSet(List<Integer> numSet){
        int r = MathUtils.random(0, (numSet.size() - 1));
        return numSet.get(r);
    }

    public static float unScaleX(float x){
        float scaleX = (float)Gdx.graphics.getWidth() / (float) GameValues.GAMEUNIT_WIDTH;
        x *= scaleX;
        return x;
    }
    public static float unScaleY(float y){
        float scaleY = (float)Gdx.graphics.getHeight() / (float) GameValues.GAMEUNIT_HEIGHT;
        y *= scaleY;
        return y;
    }

    public static int flipY(int i){
        return Gdx.graphics.getHeight() - i;
    }

    public static int randomViaPercentage(List<Integer> percentages){
        List<Integer> newPercentages = new ArrayList<Integer>();
        int percSum = 0;

		/*
		 * We iterate through the percentages List and += so we can later
		 * start from the top and if, else if to sort out the percentages.
		 */
        newPercentages.add(percSum);
        for (int i = 0; i < percentages.size()-1; i++) {
            percSum += percentages.get(i);
            newPercentages.add(percSum);
        }

        int r = MathUtils.random(1, 100);

		/*
		 * Cycle through the new Percentages (starting from last to first).
		 * Once we see if the random int is > the cascading percentage, we return.
		 */
        int size = newPercentages.size();
        for(int i = size; --i >= 0;){
            if (r > newPercentages.get(i)) {
                return i;
            }
        }
        return -1;
    }
}