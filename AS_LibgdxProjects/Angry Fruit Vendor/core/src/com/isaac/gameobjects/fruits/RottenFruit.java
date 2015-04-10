package com.isaac.gameobjects.fruits;

import com.isaac.environment.EnvironmentValues;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 12/17/2014.
 */
public class RottenFruit extends Fruit {

    public RottenFruit(GameWorld world) {
        super(
                world,
                EnvironmentValues.ROTTEN_WIDTH,
                EnvironmentValues.ROTTEN_WIDTH,
                EnvironmentValues.ROTTEN_ADDITIONAL_WEIGHT,
                AssetLoader.trRottenFruit,
                EnvironmentValues.LARGE_PEAK,
                EnvironmentValues.ROTTEN_SCORE_VALUE);
    }

    @Override
    protected void collisionBounce(boolean didFruitBounce) {
        if (didFruitBounce) {
            world.getTrampoline().stun();

            // TODO: Here is where we should not only remove the rotten fruit, but SPLAT it on the trampoline.
            alive = false;
        }
    }

    /**
     * collisionHitGround
     */
    @Override
    protected void collisionHitGround() {
        //      *** HIT GROUND ***      //
        if (getY() <= EnvironmentValues.DROPPED_Y_LOC &&
                fruitState == FruitState.Dropped) {

            // Destroy/Remove Fruit, by setting the alive = false.
            alive = false;
        }
    }

    @Override
    protected void clearStreak(){
        // Don't clear the streak...
    }
}
