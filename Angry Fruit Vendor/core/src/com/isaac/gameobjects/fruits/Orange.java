package com.isaac.gameobjects.fruits;

import com.isaac.gameworld.GameValues;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 12/12/2014.
 */
public class Orange extends Fruit {

    public Orange(GameWorld world){
        super(
                world,
                GameValues.ORANGE_WIDTH,
                GameValues.ORANGE_WIDTH,
                GameValues.ORANGE_ADDITIONAL_WEIGHT,
                AssetLoader.trOrange,
                GameValues.MEDIUM_PEAK,
                GameValues.ORANGE_SCORE_VALUE);
    }
}
