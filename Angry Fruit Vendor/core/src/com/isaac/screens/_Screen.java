package com.isaac.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector3;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.renderers._Renderer;

/**
 * Created by Isaac Holloway on 6/7/2015.
 */
public abstract class _Screen extends ScreenAdapter {

    public AngryFVGame game;
    public float runTime;
    protected _Renderer renderer;
    protected Vector3 touchPoint;

    /**     [CONSTRUCTOR] */
    public _Screen(AngryFVGame game) {
        this.game = game;
        touchPoint = new Vector3();
    }

    /***/
    @Override
    public void render(float delta) {
        runTime += delta;
        renderer.render(delta);
        updateInputEvents(delta);
    }

    /***/
    public void updateInputEvents(float delta){
        if (Gdx.input.justTouched()) {
            game.camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        }
    }
}
