package com.isaac.gamemodes.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.isaac.environment.EnvironmentValues;
import com.isaac.gamemodes.GameMode;
import com.isaac.gameobjects.fruits.Fruit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Isaac Holloway on 12/28/2014.
 */
public abstract class Level {
    protected GameMode gameMode;
    protected int startingLives;
    protected abstract boolean isGoalMet();
    protected abstract boolean isLevelFail();
    protected abstract void setAllowedFruitsForLevel();
    protected abstract void setLevelBackground();

    protected TextureRegion levelBackground;

    protected Map<Fruit.FruitType, Integer> allowedFruits;
    public abstract void init();

    /**
     *          [CONSTRUCTOR]
     * @param gameMode
     */
    public Level(GameMode gameMode){
        this.gameMode = gameMode;
        allowedFruits = new HashMap<Fruit.FruitType, Integer>();
        setLevelBackground();
        setAllowedFruitsForLevel();
    }

    /**
     * update
     * @param delta
     */
    public void update(float delta){
        if(isGoalMet()){
            gameMode.levelComplete();
        }
        if(isLevelFail()){
            gameMode.restartGame();
        }
    }

    /**
     * drawLevelBG
     * @param batch
     */
    public void drawLevelBG(float delta, SpriteBatch batch) {
        batch.draw(levelBackground, EnvironmentValues.ARENA_X, EnvironmentValues.ARENA_Y,EnvironmentValues.ARENA_WIDTH/2, EnvironmentValues.ARENA_HEIGHT/2,
                EnvironmentValues.ARENA_WIDTH, EnvironmentValues.ARENA_HEIGHT,1, 1, 0, true);
    }

    /**
     * drawLevel
     * @param batch
     */
    public void drawLevel(float delta, SpriteBatch batch) {

    }

    /**
     * getAllowedFruits
     * @return
     */
    public Map<Fruit.FruitType, Integer> getAllowedFruits(){
        return allowedFruits;
    }

}
