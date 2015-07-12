package com.isaac.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Isaac Holloway on 7/5/2015.
 */
public class UserData {
    private static Preferences prefs;

    /***/
    public static void loadPreferences(){
        // Create (or retrieve existing) preferences file
        prefs = Gdx.app.getPreferences("AngryFruitVendor");

        // Highest Level Completed
        if (!prefs.contains("highestLevelCompleted")) {
            prefs.putInteger("highestLevelCompleted", 0);
        }

        // Endless Score
        if (!prefs.contains("Endless_Score")) {
            prefs.putInteger("Endless_Score", 0);
        }

        // Endless Baskets Score
        if (!prefs.contains("EndlessBaskets_Score")) {
            prefs.putInteger("EndlessBaskets_Score", 0);
        }

        // Sound
        if (!prefs.contains("sound")) {
            prefs.putBoolean("sound", true);
        }
    }

    //// SET ////
    /***/
    public static void setHighestLevelCompleted(int levelCompleted) {
        // Only update if the incoming levelCompleted is higher than the saved level
        if(levelCompleted > getHighestLevelCompleted()) {
            prefs.putInteger("highestLevelCompleted", levelCompleted);
            prefs.flush();
        }
    }

    /***/
    public static void setEndlessScore(int score) {
        prefs.putInteger("Endless_Score", score);
        prefs.flush();
    }

    /***/
    public static void setEndlessBasketsScore(int score) {
        prefs.putInteger("EndlessBaskets_Score", score);
        prefs.flush();
    }

    /***/
    public static void setSound(boolean isSoundOn) {
        prefs.putBoolean("sound", isSoundOn);
        prefs.flush();
    }

    //// GET ////
    /***/
    public static int getHighestLevelCompleted() {
        return prefs.getInteger("highestLevelCompleted");
    }

    /***/
    public static int getEndlessScore() {
        return prefs.getInteger("Endless_Score");
    }

    /***/
    public static int getEndlessBasketsScore() {
        return prefs.getInteger("EndlessBaskets_Score");
    }

    /***/
    public static boolean getSound() {
        return prefs.getBoolean("sound");
    }
}
