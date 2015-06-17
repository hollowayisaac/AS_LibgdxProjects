package com.isaac.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.isaac.screens._Screen;

/**
 * Created by Isaac Holloway on 6/15/2015.
 */
public class _DisplayObject {
    protected float x, y, width, height;
    public Rectangle bounds;
    protected Texture tBG;

    /** [CONSTRUCTOR] */
    protected _DisplayObject(_Screen screen, float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle(x, y, width, height);
    }

    /** [CONSTRUCTOR] */
    public _DisplayObject(_Screen screen, float x, float y, float width, float height, Texture tBG){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tBG = tBG;
        bounds = new Rectangle(x, y, width, height);
    }

    /***/
    public void draw(float delta, SpriteBatch batch) {
        batch.draw(tBG, x, y, width, height);
    }
}
