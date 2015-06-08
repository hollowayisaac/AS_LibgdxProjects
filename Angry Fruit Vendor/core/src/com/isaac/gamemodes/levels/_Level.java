package com.isaac.gamemodes.levels;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.isaac.gamemodes._GameMode;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.renderers.GameRenderer;
import com.isaac.helpers.GameValues;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Isaac Holloway on 12/28/2014.
 */
public abstract class _Level {
    protected _GameMode gameMode;
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
    public _Level(_GameMode gameMode){
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
            gameMode.restartLevel();
        }
    }

    /**
     * drawLevelBG
     * @param renderer
     */
    public void drawLevelBG(float delta, GameRenderer renderer) {
        renderer.getSpriteBatch().draw(levelBackground, GameValues.ARENA_X, GameValues.ARENA_Y, GameValues.ARENA_WIDTH/2, GameValues.ARENA_HEIGHT/2,
                GameValues.ARENA_WIDTH, GameValues.ARENA_HEIGHT,1, 1, 0, true);
    }

    /**
     * drawLevel
     * @param renderer
     */
    public void drawLevel(float delta, GameRenderer renderer) {

    }

    /**
     * getAllowedFruits
     * @return
     */
    public Map<Fruit.FruitType, Integer> getAllowedFruits(){
        return allowedFruits;
    }

}
