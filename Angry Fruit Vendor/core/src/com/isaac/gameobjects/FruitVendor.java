package com.isaac.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.isaac.helpers.AssetLoader;
import com.isaac.renderers.GameRenderer;

/**
 * Created by Isaac Holloway on 8/2/2015.
 */
public class FruitVendor extends GameObject {


    /** [CONSTRUCTOR] */
    public FruitVendor(){
        this.position = new Vector2(20, 200);
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
     *
     * @param runTime
     * @param renderer
     */
    @Override
    public void draw(float runTime, GameRenderer renderer) {
        renderer.getSpriteBatch().draw(AssetLoader.blueJayAnimation.getKeyFrame(runTime,true),getX(),getY());
    }
}
