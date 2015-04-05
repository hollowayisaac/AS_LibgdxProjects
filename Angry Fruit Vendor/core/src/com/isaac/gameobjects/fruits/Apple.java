package com.isaac.gameobjects.fruits;

import com.isaac.environment.EnvironmentValues;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 11/16/2014.
 */
public class Apple extends Fruit {

    public Apple(GameWorld world){
        super(
                world,
                EnvironmentValues.APPLE_WIDTH,
                EnvironmentValues.APPLE_WIDTH,
                EnvironmentValues.APPLE_ADDITIONAL_WEIGHT,
                AssetLoader.trApple,
                EnvironmentValues.SMALL_PEAK,
                EnvironmentValues.APPLE_SCORE_VALUE);
    }
}
