package com.isaac.gamemodes.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes._GameMode;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.renderers.GameRenderer;

/**
 * Created by Isaac Holloway on 1/1/2015.
 */
public class StageMode_Level_1 extends _Level {

    // Level 1
    protected final int FRUIT_GOAL = 10;
    protected final int STARTING_LIVES = 3;

    public StageMode_Level_1(_GameMode gameMode){
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
        super.init();
        gameMode.setLivesLeft(STARTING_LIVES);
        if (AngryFVGame.DEV_MODE){
            gameMode.addFruitScore(7);
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
    public void drawLevel(float delta, GameRenderer renderer){
        super.drawLevel(delta, renderer);
        drawGoal(delta, renderer);
    }

    /***/
    public void drawGoal(float delta, GameRenderer renderer){
        drawText_Wag(450, GameValues.GAME_HEIGHT, "" + getGoalText(), renderer);
    }

    /***/
    protected String getGoalText(){
        return "Goal: " + gameMode.getScore() + "/" +FRUIT_GOAL;
    }
}
