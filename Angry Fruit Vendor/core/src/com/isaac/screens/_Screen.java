package com.isaac.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.input._Input;
import com.isaac.renderers._Renderer;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 6/7/2015.
 */
public abstract class _Screen extends ScreenAdapter {

    public abstract _Menu getCurrentMenu();/***/

    public AngryFVGame game;
    public float runTime;
    public _Renderer renderer;
    public _Input input;

    /**
     * [CONSTRUCTOR]
     */
    public _Screen(AngryFVGame game) {
        this.game = game;
    }

    /***/
    public void init(){
        input.init();
    }

    /***/
    @Override
    public void render(float delta) {
        runTime += delta;
        renderer.render(delta);
    }

    /***/
    public SpriteBatch getBatch() {
        return game.batch;
    }
}
