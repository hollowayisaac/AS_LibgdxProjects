package com.isaac.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.isaac.helpers.AssetLoader;
import com.isaac.renderers.GameRenderer;

/**
 * Created by Isaac Holloway on 8/2/2015.
 */
public class FruitVendor extends GameObject {

    protected float runTime;
    protected boolean isAnimationRunning;

    /** [CONSTRUCTOR] */
    public FruitVendor(){
        this.position = new Vector2(20, 200);
        isAnimationRunning = false;
        runTime = 0;
    }

    /***
     * init
     */
    @Override
    public void init() {

    }

    /***
     * update
     *
     * @param delta
     */
    @Override
    public void update(float delta) {

    }

    /***
     * draw
     **/
    @Override
    public void draw(float delta, GameRenderer renderer) {

        if (isAnimationRunning){
            runTime+=delta;
        }
        if(AssetLoader.blueJayAnimation.isAnimationFinished(runTime)){
            runTime = 0;
            isAnimationRunning = false;
    }

        renderer.getSpriteBatch().draw(AssetLoader.blueJayAnimation.getKeyFrame(runTime),getX(),getY());
    }

    /***/
    public void turnAnimationOn(){
        this.isAnimationRunning = true;
    }
}
