package com.isaac.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.isaac.gameworld.GameRenderer;
import com.isaac.gameworld.GameWorld;

/**
 * Created by Isaac Holloway on 5/16/2015.
 */
public class MainMenuScreen extends ScreenAdapter {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    /**
     *      [CONSTRUCTOR]
     */
    public MainMenuScreen() {
        this.renderer = new GameRenderer(world);
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
