package com.isaac.gameobjects.fruits;

import com.isaac.environment.EnvironmentValues;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 11/17/2014.
 */
public class Watermelon extends Fruit {

    public Watermelon (GameWorld world){
        super(
                world,
                EnvironmentValues.WATERMELON_WIDTH,
                EnvironmentValues.WATERMELON_HEIGHT,
                EnvironmentValues.WATERMELON_ADDITIONAL_WEIGHT,
                AssetLoader.trWatermelon,
                EnvironmentValues.LARGE_PEAK,
                EnvironmentValues.WATERMELON_SCORE_VALUE);
    }
}

/*

    */
/**
     * CONSTRUCTOR
     *
     * @param x
     * @param y
     *//*

    public Watermelon(float x, float y, GameWorld world) {
        super(x,
                y,
                EnvironmentValues.WATERMELON_WIDTH,
                EnvironmentValues.WATERMELON_HEIGHT,
                EnvironmentValues.WATERMELON_ADDITIONAL_WEIGHT,
                world
        );

        // Set apple Image
        this.fruitImage = AssetLoader.trWatermelon;

        // Set peak height
        this.peakHeight = EnvironmentValues.MEDIUM_PEAK;
    }
}
*/