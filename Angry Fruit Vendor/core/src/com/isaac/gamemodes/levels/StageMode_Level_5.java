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
        allowedFruits.put(Fruit.FruitType.Banana, 10);
        allowedFruits.put(Fruit.FruitType.Basket, 20);
    }

    /**
     * setLevelBackground
     */
    @Override
    protected void setLevelBackground() {
        this.levelBackground = AssetLoader.trBasket;
    }

    /**
     * init
     */
    @Override
    public void init(){

        gameMode.setLivesLeft(STARTING_LIVES);
        if (AngryFVGame.DEV_MODE){
            gameMode.addFruitScore(25);
        }
    }

    /**
     * update
     * @param delta
     */
    public void update(float delta){
        super.update(delta);

        // TODO: Update the current goal status, if the score is the goal, update fruitSaved,
        // because this may (in other levels) apply to only certain types of fruit)
    }

    @Override
    protected boolean isGoalMet() {
        if(gameMode.getScore() >= FRUIT_GOAL){
            return true;
        }
        return false;
    }

    @Override
    protected boolean isLevelFail(){
        if (gameMode.getLivesLeft() <= 0){
            return true;
        }
        return false;
    }


    @Override
    public void drawLevel(float delta, GameRenderer renderer){
        drawGoal(delta, renderer);
    }

    /**
     * drawGoal
     * @param delta
     * @param renderer
     */
    public void drawGoal(float delta, GameRenderer renderer){
        // Draw the Goal Text
        renderer.drawText_Wag(450, GameValues.ARENA_HEIGHT, "" + getGoalText());
    }

    /**
     * getGoalText
     * @return
     */
    protected String getGoalText(){
        return "Goal: " + gameMode.getScore() + "/" +FRUIT_GOAL;
    }
}
