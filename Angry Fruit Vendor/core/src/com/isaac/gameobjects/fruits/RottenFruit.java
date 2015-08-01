package com.isaac.gameobjects.fruits;

import com.isaac.gamemodes._GameMode;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 12/17/2014.
 */
public class RottenFruit extends Fruit {

    public RottenFruit(_GameMode gameMode){
        super(
                gameMode,
                GameValues.ROTTEN_WIDTH,
                GameValues.ROTTEN_WIDTH,
                GameValues.ROTTEN_ADDITIONAL_WEIGHT,
                AssetLoader.trRottenFruit,
                GameValues.LARGE_PEAK,
                GameValues.ROTTEN_SCORE_VALUE);
    }

    @Override
    protected void collisionHitTrampoline(boolean didFruitBounce) {
        if (didFruitBounce) {
            gameMode.getTrampoline().stun();

            // TODO: Here is where we should not only remove the rotten fruit, but SPLAT it on the trampoline.
            isAlive = false;
        }
    }

    /**
     * collisionHitGround
     */
    @Override
    protected void collisionHitGround() {
        //      *** HIT GROUND ***      //
        if (getY() <= GameValues.DROPPED_Y_LOC &&
                fruitState == FruitState.Dropped) {

            // Destroy/Remove Fruit, by setting the alive = false.
            isAlive = false;
        }
    }

    @Override
    protected void clearStreak(){
        // Don't clear the streak...
    }
}
