package com.isaac.gamemodes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.gameworld.GameWorld;

/**
 * Created by Isaac Holloway on 12/9/2014.
 */
public abstract class GameMode {
    public GameWorld world;

/*    protected float currentFruitTossInterval_Low;
    protected float currentFruitTossInterval_High;*/

    protected float startFruitTossInterval_Low = 1000;
    protected float startFruitTossInterval_High = 2000;
    protected float endFruitTossInterval_Low;
    protected float endFruitTossInterval_High;

    //protected GameWorld gameWorld;

    /**
     *      [CONSTRUCTOR]
     * @param world
     */
    public GameMode(GameWorld world){
        this.world = world;
    }

/*    *//**
     * init
     *//*
    public void init(float startFruitTossInterval_Low, float startFruitTossInterval_High, float endFruitTossInterval_Low, float endFruitTossInterval_High){
        this.startFruitTossInterval_Low = startFruitTossInterval_Low;
        this.startFruitTossInterval_High = startFruitTossInterval_High;
        this.endFruitTossInterval_Low = endFruitTossInterval_Low;
        this.endFruitTossInterval_High = endFruitTossInterval_High;
    }*/
    public abstract void init();
    public abstract void renderGameMode(float delta, SpriteBatch batch);
    public abstract void renderGameModeBG(float delta, SpriteBatch batch);
    public abstract void update(float delta);
    public abstract void levelComplete();
    public abstract void restartGame();
    public abstract Fruit getRandomFruit();

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
