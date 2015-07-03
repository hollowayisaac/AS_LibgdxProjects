package com.isaac.gamemodes.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes._GameMode;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;

/**
 * Created by Isaac Holloway on 1/1/2015.
 */
public class StageMode_Level_5 extends _Level {

    // Level 1
    // Save 15 fruits
    protected  int fruitsSaved;
    protected final int FRUIT_GOAL = 30;
    protected final int STARTING_LIVES = 3;

    public StageMode_Level_5(_GameMode gameMode){
        super(gameMode);
        fruitsSaved = 0;
    }

    /**
     * setAllowedFruitsForLevel
     */
    @Override
    protected void setAllowedFruitsForLevel() {
        // *ALL* //
        allowedFruits.put(Fruit.FruitType.Apple, 15);
        allowedFruits.put(Fruit.FruitType.Orange, 20);
        allowedFruits.put(Fruit.FruitType.Watermelon, 15);
        allowedFruits.put(Fruit.FruitType.RottenFruit, 10);
        allowedFruits.put(Fruit.FruitType.Banana, 20);
        allowedFruits.put(Fruit.FruitType.Basket, 20);
    }

    /***/
    @Override
    protected void setLevelBackground() {
        this.levelBackground = AssetLoader.trBasket;
    }

    /***/
    @Override
    public void init(){

        gameMode.setLivesLeft(STARTING_LIVES);
        if (AngryFVGame.DEV_MODE){
            gameMode.addFruitScore(25);
        }
    }

    /***/
    public void update(float delta){
        super.update(delta);

        // TODO: Update the current goal status, if the score is the goal, update fruitSaved,
        // because this may (in other levels) apply to only certain types of fruit)
    }

    /***/
    @Override
    protected boolean isGoalMet() {
        if(gameMode.getScore() >= FRUIT_GOAL){
            return true;
        }
        return false;
    }

    /***/
    @Override
    protected boolean isLevelFail(){
        if (gameMode.getLivesLeft() <= 0){
            return true;
        }
        return false;
    }

    /***/
    @Override
    public void drawLevel(float delta, SpriteBatch batch){
        drawGoal(delta, batch);
    }

    /***/
    public void drawGoal(float delta, SpriteBatch batch){
        // Draw the Goal Text
        drawText_Wag(450, GameValues.ARENA_HEIGHT, "" + getGoalText(), batch);
    }

    /***/
    protected String getGoalText(){
        return "Goal: " + gameMode.getScore() + "/" +FRUIT_GOAL;
    }
}
