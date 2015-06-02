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
public class EndlessBaskets_Level extends Level{

    protected final int STARTING_LIVES = 3;

    public EndlessBaskets_Level(GameMode gameMode){
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
        this.levelBackground = AssetLoader.trTrampoline;
    }

    /**
     * init
     */
    @Override
    public void init(){
        gameMode.world.setLivesLeft(STARTING_LIVES);
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
        if (gameMode.world.getLivesLeft() <= 0){
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
        AssetLoader.ftWag.draw(renderer.batch, "" + getGoalText(),
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