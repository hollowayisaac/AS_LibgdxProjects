package com.isaac.gamemodes.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes._GameMode;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.renderers.GameRenderer;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 1/1/2015.
 */
public class EndlessBaskets_Level extends _Level {

    protected final int STARTING_LIVES = 3;

    public EndlessBaskets_Level(_GameMode gameMode){
        super(gameMode);
    }

    /**
     * setAllowedFruitsForLevel
     */
    @Override
    protected void setAllowedFruitsForLevel() {
        // *Baskets Only!!!* //
        allowedFruits.put(Fruit.FruitType.Basket, 100);
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
        gameMode.setLivesLeft(STARTING_LIVES);
        if (AngryFVGame.DEV_MODE){

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
        return false;
    }

    @Override
    protected boolean isLevelFail(){
        if (gameMode.getLivesLeft() <= 0){
           return true;
        }
        return false;
    }

/*    *//**
     * drawLevelBG
     * @param delta
     * @param renderer
     *//*
    @Override
    public void drawLevelBG(float delta, SpriteBatch batch){

    }*/

    @Override
    public void drawLevel(float delta, SpriteBatch batch){
        drawGoal(delta, batch);
    }

    /***/
    public void drawGoal(float delta, SpriteBatch batch){
        // Draw the Goal Text
        AssetLoader.ftWag.draw(batch, "" + getGoalText(),
                450, GameValues.ARENA_HEIGHT);
    }

    /**
     * getGoalText
     * @return
     */
    protected String getGoalText(){
       // return "Goal: " + gameMode.world.getScore() + "/" +FRUIT_GOAL;
        return "no";
    }
}
