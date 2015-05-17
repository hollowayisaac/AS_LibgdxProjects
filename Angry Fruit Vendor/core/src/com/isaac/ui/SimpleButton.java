package com.isaac.ui;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class SimpleButton {

    private float x, y, width, height;

    private TextureRegion buttonUp;
    private TextureRegion buttonDown;

    public Rectangle bounds;

    public boolean isPressed = false;

    /**
     *          [CONSTRUCTOR]
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param buttonUp
     * @param buttonDown
     */
    public SimpleButton(float x, float y, float width, float height,
                        TextureRegion buttonUp, TextureRegion buttonDown) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonUp = buttonUp;
        this.buttonDown = buttonDown;

        bounds = new Rectangle(x, y, width, height);

    }

    /**
     * isClicked
     *
     * @param screenX
     * @param screenY
     * @return
     */
    public boolean isClicked(int screenX, int screenY) {
        return bounds.contains(screenX, screenY);
    }

    /**
     * draw
     *
     * @param batcher
     */
    public void draw(SpriteBatch batcher) {
        if (isPressed) {
            batcher.draw(buttonDown, x, y, width, height);
        } else {
            batcher.draw(buttonUp, x, y, width, height);
        }
    }

    /**
     * isTouchDown
     *
     * @param screenX
     * @param screenY
     * @return
     */
    public boolean isTouchDown(int screenX, int screenY) {

        if (bounds.contains(screenX, screenY)) {
            isPressed = true;
            return true;
        }

        return false;
    }

    /**
     * isTouchUp
     *
     * @param screenX
     * @param screenY
     * @return
     */
    public boolean isTouchUp(int screenX, int screenY) {

        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds.contains(screenX, screenY) && isPressed) {
            isPressed = false;
            return true;
        }

        // Whenever a finger is released, we will cancel any presses.
        isPressed = false;
        return false;
    }

}

