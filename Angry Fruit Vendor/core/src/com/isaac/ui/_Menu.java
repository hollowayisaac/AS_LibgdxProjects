package com.isaac.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.screens._Screen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isaac Holloway on 6/11/2015.
 */
public abstract class _Menu {
    protected abstract void setMenuPanel();         /***/
    protected abstract void setButtons();           /***/

    public List<_Button> buttons;
    protected _Screen screen;
    protected _DisplayObject dspMenuPanel;

    /***/
    public _Menu(_Screen screen){
        this.screen = screen;
        this.buttons = new ArrayList<_Button>();
        setMenuPanel();
        setButtons();
    }

    /***/
    public void draw(float delta, SpriteBatch batch){
        for(int i = 0;i < this.buttons.size();i++){
            buttons.get(i).draw(delta, batch);
        }
    }

    /***/
    public void drawButtons(float delta, SpriteBatch batch){
        // Draw Buttons
        for (int i = 0; i < this.buttons.size(); i++) {
            buttons.get(i).draw(delta, batch);
        }
    }
}
