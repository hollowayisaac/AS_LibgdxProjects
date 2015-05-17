package com.isaac.gamemodes.levels;

import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes.GameMode;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.gameworld.GameRenderer;
import com.isaac.gameworld.GameValues;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 1/1/2015.
 */
public class StageMode_Level_1 extends Level{

    // Level 1
    protected final int FRUIT_GOAL = 10;
    protected final int STARTING_LIVES = 3;

    public StageMode_Level_1(GameMode gameMode){
        super(gameMode);
    }

    /**
     * setAllowedFruitsForLevel
     */
    @Override
    protected void setAllowedFruitsForLevel() {
        allowedFruits.put(Fruit.FruitType.Apple, 60);
        allowedFruits.put(Fruit.FruitType.Orange, 40);
    }

    /**
     * setLevelBackground
     */
    @Override
    protected void setLevelBackground() {
        this.levelBackground = AssetLoader.trApple;
    }

    /**
     * init
     */
    @Override
    public void init(){
        gameMode.world.setLivesLeft(STARTING_LIVES);
        if (AngryFVGame.DEV_MODE){
            gameMode.world.addFruitScore(7);
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
        if(gameMode.world.getScore() >= FRUIT_GOAL){
            return true;
        }
        return false;
    }

    @Override
    protected boolean isLevelFail(){
        if (gameMode.world.getLivesLeft() <= 0){
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
        return "Goal: " + gameMode.world.getScore() + "/" +FRUIT_GOAL;
    }
}
