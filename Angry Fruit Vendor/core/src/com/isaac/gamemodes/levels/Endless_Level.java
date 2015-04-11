package com.isaac.gamemodes.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.environment.EnvironmentValues;
import com.isaac.gamemodes.GameMode;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 1/1/2015.
 */
public class Endless_Level extends Level{

    protected final int STARTING_LIVES = 3;

    public Endless_Level(GameMode gameMode){
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
     * @param batch
     *//*
    @Override
    public void drawLevelBG(float delta, SpriteBatch batch){

    }*/

    @Override
    public void drawLevel(float delta, SpriteBatch batch){
        drawGoal(delta, batch);
    }

    /**
     * drawGoal
     * @param delta
     * @param batch
     */
    public void drawGoal(float delta, SpriteBatch batch){
        // Draw the Goal Text
        AssetLoader.shadow.draw(batch, "" + getGoalText(),
                450, EnvironmentValues.ARENA_HEIGHT);
        AssetLoader.font.draw(batch, "" + getGoalText(),
                450, EnvironmentValues.ARENA_HEIGHT);
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
