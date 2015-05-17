package com.isaac.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.isaac.gameworld.GameRenderer;

/**
 * Created by Isaac Holloway on 11/16/2014.
 */
public abstract class GameObject {

    protected Vector2 position;
    protected float width;
    protected float height;

    /*** init */
    abstract public void init();

    /*** update */
    abstract public void update(float delta);

    /*** draw */
    abstract public void draw(float runTime, GameRenderer renderer) ;

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getCenterX() {
        return position.x + (width / 2);
    }

    public float getCenterY() {
        return position.y + (height / 2);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getHalfWidth() {
        return width / 2;
    }

    public float getHalfHeight() {
        return height / 2;
    }
}
