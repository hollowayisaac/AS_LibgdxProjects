package com.isaac.gameobjects.fruits;

import com.isaac.gameworld.GameValues;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 12/20/2014.
 */
public class Basket extends Fruit {

    public Basket(GameWorld world){
        super(
                world,
                GameValues.BASKET_WIDTH,
                GameValues.BASKET_WIDTH,
                GameValues.BASKET_ADDITIONAL_WEIGHT,
                AssetLoader.trBasket,
                GameValues.LARGE_PEAK,
                GameValues.BASKET_SCORE_VALUE);
    }

    @Override
    protected void collisionBounce(boolean didFruitBounce) {
        if (didFruitBounce) {
            world.createFruitsFromBasket(getX(), getY());

            // TODO: Here is where we should not only remove the rotten fruit, but SPLAT it on the trampoline.
            alive = false;
        }
    }
}