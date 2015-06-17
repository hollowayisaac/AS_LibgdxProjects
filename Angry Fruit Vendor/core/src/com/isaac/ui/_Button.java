package com.isaac.ui;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.isaac.screens._Screen;

public class _Button extends _DisplayObject{

    private _ButtonListener buttonListener;
    private TextureRegion trUp, trDown;

    public boolean isDown;

    public _Screen screen;

    /**
     * [CONSTRUCTOR]
     */
    public _Button(_Screen screen, float x, float y, float width, float height,
                   TextureRegion trUp, TextureRegion trDown, _ButtonListener buttonListener) {
        super(screen, x, y, width, height);

        this.trUp = trUp;
        this.trDown = trDown;
        this.buttonListener = buttonListener;

        isDown = false;
    }

    /**
     * [CONSTRUCTOR] #2
     */
    public _Button(_Screen screen, float x, float y, float width, float height,
                   Texture tUp, Texture tDown, _ButtonListener buttonListener) {
        super(screen, x, y, width, height);

        // Make the Textures into TextureRegions
        tUp.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        this.trUp = new TextureRegion(tUp, 0, 0, tUp.getWidth(), tUp.getHeight());
        tDown.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        this.trDown = new TextureRegion(tDown, 0, 0, tDown.getWidth(), tDown.getHeight());

        this.buttonListener = buttonListener;
        this.buttonListener = buttonListener;
        isDown = false;
    }

    /***/
    @Override
    public void draw(float delta, SpriteBatch batch) {
        if (isDown) {
            batch.draw(trDown, x, y, width, height);
        } else {
            batch.draw(trUp, x, y, width, height);
        }
    }

    /***/
    public boolean isTouchDown(float screenX, float screenY) {
        if (bounds.contains(screenX, screenY)) {
            isDown = true;
            return true;
        }

        return false;
    }

    /***/
    public boolean isTouchUp(float screenX, float screenY) {
        boolean returnValue = false;
        if (bounds.contains(screenX, screenY) && isDown) {
            buttonListener.onClick();
            returnValue = true;
        }
        isDown = false;
        return returnValue;
    }
}

