package com.isaac.gamemodes.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.isaac.gamemodes._GameMode;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.helpers.AssetLoader;
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

    /***/
    public _Level(_GameMode gameMode){
        this.gameMode = gameMode;
        allowedFruits = new HashMap<Fruit.FruitType, Integer>();
        setLevelBackground();
        setAllowedFruitsForLevel();
    }

    /***/
    public void update(float delta){
        if(isGoalMet()){
            levelComplete();
        }
        if(isLevelFail()){
            gameMode.levelFail();
            //gameMode.restartLevel();
        }
    }

    /***/
    public void levelComplete(){
        gameMode.levelComplete();
    }

    /***/
    public void drawLevelBG(float delta, SpriteBatch batch) {
        /*renderer.getSpriteBatch().draw(levelBackground, GameValues.ARENA_X, GameValues.ARENA_Y, GameValues.ARENA_WIDTH/2, GameValues.ARENA_HEIGHT/2,
                GameValues.ARENA_WIDTH, GameValues.ARENA_HEIGHT,1, 1, 0, true);*/
        batch.draw(AssetLoader.trBGField, GameValues.ARENA_X, GameValues.ARENA_Y, GameValues.ARENA_WIDTH, GameValues.ARENA_HEIGHT);
    }

    /***/
    public void drawLevel(float delta, SpriteBatch batch) {

    }

    /***/
    public void drawText_Wag(float xLoc, float yLoc, String text, SpriteBatch batch) {
        AssetLoader.ftWag.draw(batch, text, xLoc, yLoc);
    }

    /**
     * getAllowedFruits
     * @return
     */
    public Map<Fruit.FruitType, Integer> getAllowedFruits(){
        return allowedFruits;
    }

}
