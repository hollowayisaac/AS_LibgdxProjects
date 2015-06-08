package com.isaac.gameobjects.fruits;

import com.isaac.gamemodes._GameMode;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 11/16/2014.
 */
public class Apple extends Fruit {

    public Apple(_GameMode gameMode){
        super(
                gameMode,
                GameValues.APPLE_WIDTH,
                GameValues.APPLE_WIDTH,
                GameValues.APPLE_ADDITIONAL_WEIGHT,
                AssetLoader.trApple,
                GameValues.SMALL_PEAK,
                GameValues.APPLE_SCORE_VALUE);
    }
}
