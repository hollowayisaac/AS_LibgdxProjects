package com.isaac.environment;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.isaac.gameobjects.GameObject;

/**
 * Created by Isaac Holloway on 11/13/2014.
 */
public class EnvironmentObject extends GameObject {

    // Protected is similar to private, but allows inheritance by subclasses.
    protected Vector2 position;
    protected int width;
    protected int height;

    public EnvironmentObject(float x, float y, int width, int height) {
        position = new Vector2(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void init() {

    }

    @Override
    public void update(float delta) {
/*        position.add(velocity.cpy().scl(delta));

        // If the Scrollable object is no longer visible:
        if (position.x + width < 0) {
            isScrolledLeft = true;
        }*/
    }

    /**
     * draw
     * @param runTime
     * @param batch
     */
    public void draw(float runTime, SpriteBatch batch){

    }

    // Reset: Should Override in subclass for more specific behavior.
    public void reset(float newX) {
        position.x = newX;
    }

    public void stop() {
/*        velocity.x = 0;*/
    }

    public float getTailX() {
        return position.x + width;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

}
