package com.isaac.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.renderers.GameRenderer;

/**
 * Created by Isaac Lappy on 8/4/2015.
 */
public class FloatingText extends GameObject {

    private float animationDuration;
    private float currentAnimationTime;
    private float startingX;
    private float startingY;
    private float destinX;
    private float destinY;

    /** [CONSTRUCTOR] */
    public FloatingText(){
        this.position = new Vector2(200,100);
        this.animationDuration = 1500;
        this.startingX = position.x;
        this.startingY = position.y;
    }

    /***/
    @Override
    public void init() {
        this.currentAnimationTime = 0;
    }

    /***/
    @Override
    public void update(float delta) {

    }

    /***/
    @Override
    public void draw(float delta, GameRenderer renderer) {

        AssetLoader.ftWag.draw(renderer.getSpriteBatch(), "+1",
                getX(), getY());
    }
}
