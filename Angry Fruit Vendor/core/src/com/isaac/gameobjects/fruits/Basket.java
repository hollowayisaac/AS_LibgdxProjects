package com.isaac.gameobjects.fruits;

import com.isaac.gamemodes._GameMode;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 12/20/2014.
 */
public class Basket extends Fruit {

    public Basket(_GameMode gameMode){
        super(
                gameMode,
                GameValues.BASKET_WIDTH,
                GameValues.BASKET_WIDTH,
                GameValues.BASKET_ADDITIONAL_WEIGHT,
                AssetLoader.trBasket,
                GameValues.LARGE_PEAK,
                GameValues.BASKET_SCORE_VALUE);
    }

    @Override
    protected void collisionHitTrampoline(boolean didFruitBounce) {
        if (didFruitBounce) {
            gameMode.createFruitsFromBasket(getX(), getY());

            // TODO: Here is where we should not only remove the rotten fruit, but SPLAT it on the trampoline.
            isAlive = false;
        }
    }
}