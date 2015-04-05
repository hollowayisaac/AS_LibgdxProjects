package com.isaac.gameobjects.fruits;

import com.isaac.environment.EnvironmentValues;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 12/12/2014.
 */
public class Orange extends Fruit {

    public Orange(GameWorld world){
        super(
                world,
                EnvironmentValues.ORANGE_WIDTH,
                EnvironmentValues.ORANGE_WIDTH,
                EnvironmentValues.ORANGE_ADDITIONAL_WEIGHT,
                AssetLoader.trOrange,
                EnvironmentValues.MEDIUM_PEAK,
                EnvironmentValues.ORANGE_SCORE_VALUE);
    }
}
