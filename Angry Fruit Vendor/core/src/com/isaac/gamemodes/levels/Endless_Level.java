package com.isaac.gamemodes.levels;

import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes._GameMode;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.renderers.GameRenderer;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 1/1/2015.
 */
public class Endless_Level extends _Level {

    protected final int STARTING_LIVES = 3;

    public Endless_Level(_GameMode gameMode) {
        super(gameMode);
    }

    /**
     * setAllowedFruitsForLevel
     */
    @Override
    protected void setAllowedFruitsForLevel() {
        // *ALL* //
        allowedFruits.put(Fruit.FruitType.Apple, 25);
        allowedFruits.put(Fruit.FruitType.Orange, 20);
        allowedFruits.put(Fruit.FruitType.Watermelon, 20);
        allowedFruits.put(Fruit.FruitType.RottenFruit, 5);
        allowedFruits.put(Fruit.FruitType.Banana, 20);
        allowedFruits.put(Fruit.FruitType.Basket, 10);
    }

    /**
     * setLevelBackground
     */
    @Override
    protected void setLevelBackground() {
        this.levelBackground = AssetLoader.trTrampoline;
    }

    /**
     * init
     */
    @Override
    public void init() {
        gameMode.setLivesLeft(STARTING_LIVES);
        if (AngryFVGame.DEV_MODE) {

        }
    }

    /**
     * update
     *
     * @param delta
     */
    public void update(float delta) {
        super.update(delta);


        // TODO: Update the current goal status, if the score is the goal, update fruitSaved,
        // because this may (in other levels) apply to only certain types of fruit)
    }

    @Override
    protected boolean isGoalMet() {
        return false;
    }

    @Override
    protected boolean isLevelFail() {
        if (gameMode.getLivesLeft() <= 0) {
            return true;
        }
        return false;
    }

/*    */

    /**
     * drawLevelBG
     *
     * @param delta
     * @param renderer
     *//*
    @Override
    public void drawLevelBG(float delta, SpriteBatch batch){

    }*/
    @Override
    public void drawLevel(float delta, GameRenderer renderer) {
        drawGoal(delta, renderer);
    }

    /**
     * drawGoal
     *
     * @param delta
     * @param renderer
     */
    public void drawGoal(float delta, GameRenderer renderer) {
        // Draw the Goal Text

        renderer.drawText_Wag(450, GameValues.ARENA_HEIGHT, "Goal: " + getGoalText());
    }

    /**
     * getGoalText
     *
     * @return
     */
    protected String getGoalText() {
        // return "Goal: " + gameMode.world.getScore() + "/" +FRUIT_GOAL;
        return "no";
    }
}
