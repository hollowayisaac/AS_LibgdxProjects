package com.isaac.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.renderers.GameRenderer;

/**
 * Created by Isaac Holloway on 5/16/2015.
 */
public class MainMenuScreen extends ScreenAdapter {


    private GameRenderer renderer;
    private float runTime;

    /**
     *      [CONSTRUCTOR]
     */
    public MainMenuScreen(AngryFVGame game) {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
/*        world.update(delta);
        renderer.render(delta, runTime);*/
    }

    /***/
    public void update(float delta){

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}
