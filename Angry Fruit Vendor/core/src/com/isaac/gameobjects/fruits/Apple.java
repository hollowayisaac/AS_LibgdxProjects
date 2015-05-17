package com.isaac.gameobjects.fruits;

import com.isaac.gameworld.GameValues;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 11/16/2014.
 */
public class Apple extends Fruit {

    public Apple(GameWorld world){
        super(
                world,
                GameValues.APPLE_WIDTH,
                GameValues.APPLE_WIDTH,
                GameValues.APPLE_ADDITIONAL_WEIGHT,
                AssetLoader.trApple,
                GameValues.SMALL_PEAK,
                GameValues.APPLE_SCORE_VALUE);
    }
}
