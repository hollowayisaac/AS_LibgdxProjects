package com.isaac.gamemodes.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.isaac.gamemodes._GameMode;
import com.isaac.gameobjects.AnimEffect;
import com.isaac.gameobjects.FloatingText;
import com.isaac.gameobjects.Transition;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.renderers.GameRenderer;

import java.util.ArrayList;
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

    protected Transition beginningTransition;
    protected Transition gameOverTransition;

    protected boolean isAnimating;

    protected Map<Fruit.FruitType, Integer> allowedFruits;

    /***/
    public _Level(_GameMode gameMode){
        this.gameMode = gameMode;
        allowedFruits = new HashMap<Fruit.FruitType, Integer>();

        setTransitions();
        setLevelBackground();
        setAllowedFruitsForLevel();
    }

    /***/
    public void init(){
        startBeginningTransition();
    }

    /***/
    private void setTransitions() {
        this.beginningTransition = new Transition();
        FloatingText floatingText = new FloatingText(AssetLoader.ftPlainBlack, "Ready?", new Vector2(250, 100));
        floatingText.animate();

        ArrayList<AnimEffect> animEffects = new ArrayList<AnimEffect>();
        animEffects.add(FloatingText.addMoveAnimation(2,450,100));

        animEffects.add(FloatingText.addFadeAnimation(2, 0, 1));
        floatingText.addAnimEffectListToChain(animEffects);

        floatingText.init();
        this.beginningTransition.addFloatingText(floatingText);

        this.gameOverTransition = new Transition();
    }

    /***/
    public void startBeginningTransition(){
        this.beginningTransition.start();
    }

    /***/
    public void startGameOverTransition(){
        this.gameOverTransition.start();
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
    public boolean animate(float delta){
        if(beginningTransition.isAlive()){
            beginningTransition.update(delta);
            return true;
        }else if(gameOverTransition.isAlive()){
            gameOverTransition.update(delta);
            return true;
        }else{
            return false;
        }
    }

    /***/
    public void levelComplete(){
        gameMode.levelComplete();
    }

    /***/
    public void drawLevelBG(float delta, GameRenderer renderer) {
        /*renderer.getSpriteBatch().draw(levelBackground, GameValues.ARENA_X, GameValues.ARENA_Y, GameValues.ARENA_WIDTH/2, GameValues.ARENA_HEIGHT/2,
                GameValues.ARENA_WIDTH, GameValues.ARENA_HEIGHT,1, 1, 0, true);*/
        renderer.getSpriteBatch().draw(AssetLoader.trBGField, GameValues.ARENA_X, GameValues.ARENA_Y, GameValues.ARENA_WIDTH, GameValues.ARENA_HEIGHT);
    }

    /***/
    public void drawLevel(float delta, GameRenderer gameRenderer) {
        beginningTransition.draw(delta, gameRenderer);
        gameOverTransition.draw(delta, gameRenderer);
    }

    /***/
    public void drawText_Wag(float xLoc, float yLoc, String text, GameRenderer renderer) {
        AssetLoader.ftWag.draw(renderer.getSpriteBatch(), text, xLoc, yLoc);
    }

    /**
     * getAllowedFruits
     * @return
     */
    public Map<Fruit.FruitType, Integer> getAllowedFruits(){
        return allowedFruits;
    }

}
