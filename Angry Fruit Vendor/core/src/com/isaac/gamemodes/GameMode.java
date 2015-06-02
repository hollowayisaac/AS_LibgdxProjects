package com.isaac.gamemodes;

import com.badlogic.gdx.math.MathUtils;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes.levels.Level;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.gameworld.GameRenderer;
import com.isaac.gameworld.GameWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Isaac Holloway on 12/9/2014.
 */
public abstract class GameMode {
    protected abstract void createLevelPool();

    public GameWorld world;
    protected float startFruitTossInterval_Low = 1000;
    protected float startFruitTossInterval_High = 2000;

    /**
     *      [CONSTRUCTOR]
     */
    public GameMode(){
        setLevels(new ArrayList<Level>());
        createLevelPool();
    }
    protected List<Level> levels;
    protected int currentLevelIndex;

    public void init(GameWorld world){
        this.world = world;
    }

    /***/
    public void renderGameMode(float delta, GameRenderer renderer) {
        getCurrentLevel().drawLevel(delta, renderer);
    }

    /***/
    public void renderGameModeBG(float delta,  GameRenderer renderer) {
        getCurrentLevel().drawLevelBG(delta, renderer);
    }
    /***/
    public void setCurrentLevel(int index) {
        world.resetWorld();
        this.setCurrentLevelIndex(index);
        this.getCurrentLevel().init();
    }

    /***/
    public Fruit getRandomFruit() {
        Fruit.FruitType selectedFruitType = null;
        Integer randFruitIndex = MathUtils.random(0, 100);
        int percentageSum = 0;
        for (Map.Entry<Fruit.FruitType, Integer> entry : getCurrentLevel().getAllowedFruits().entrySet()) {
            Integer percentage = entry.getValue();
            if (randFruitIndex >= percentageSum
                    && randFruitIndex <= (percentage + percentageSum)) {
                selectedFruitType = entry.getKey();
                break;
            }
            percentageSum += percentage;
        }
        return world.getFruitGivenType(selectedFruitType);
    }

    /***/
    public void advanceCurrentLevel() {
        if(getCurrentLevelIndex() >= levels.size()-1 ){
            setCurrentLevel(0);
        }else{
            setCurrentLevel(getCurrentLevelIndex() + 1);
        }
    }

    /***/
    public void levelComplete() {
        if (getCurrentLevelIndex() == getLevels().size() - 1) {
            allStagesCompleted();
        } else {
            advanceCurrentLevel();
        }
    }



    /***/
    public void restartGame() {
        world.resetWorld();
        world.clearStreak();
        // TODO: Display a message that indicates the I Lost and the level is restarting.

        setCurrentLevel(this.getCurrentLevelIndex());
    }

    /***/
    public void update(float delta) {
        getCurrentLevel().update(delta);
    }

    /** **/
    public void allStagesCompleted() {
        // TODO: Stages complete! animation
        // TODO: Go to menu screen (GameMode selection OR stage selection)


        setCurrentLevel(0);
    }

    /***/
    protected Level getCurrentLevel() {
        return getLevels().get(getCurrentLevelIndex());
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public void setCurrentLevelIndex(int currentLevelIndex) {
        this.currentLevelIndex = currentLevelIndex;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
    public float getCurrentFruitTossInterval_Low() {
        if(AngryFVGame.DEV_MODE){
            //return 10000;
        }
        return startFruitTossInterval_Low;
    }

    public float getCurrentFruitTossInterval_High() {
        if(AngryFVGame.DEV_MODE){
            //return 10000;
        }
        return startFruitTossInterval_High;
    }
}
