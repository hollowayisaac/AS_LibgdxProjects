package com.isaac.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.isaac.screens._Screen;

/**
 * Created by Isaac Holloway on 6/11/2015.
 */
public abstract class _Menu {

    protected abstract void createStage();/***/

    protected Stage stage;
    protected _Screen screen;
    protected _DisplayObject dspMenuPanel;

    /***/
    public _Menu(_Screen screen){
        this.screen = screen;
        this.stage = new Stage();

        createStage();
    }

    /***/
    public void init(){
        Gdx.input.setInputProcessor(stage);
    }

    /***/
    public void update(float delta){
        stage.act();
    }

    /***/
    public void draw(float delta, SpriteBatch batch){
        stage.draw();
    }

    /*
    public void drawButtons(float delta, SpriteBatch batch){
        // Draw Buttons
        for (int i = 0; i < this.buttons.size(); i++) {
            buttons.get(i).draw(delta, batch);
        }
    }*/
}
