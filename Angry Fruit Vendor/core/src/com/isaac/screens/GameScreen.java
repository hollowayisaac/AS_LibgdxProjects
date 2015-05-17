package com.isaac.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.isaac.gamemodes.EndlessBasketsMode;
import com.isaac.gameworld.GameRenderer;
import com.isaac.gameworld.GameValues;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.InputHandler;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    /**
     *      [CONSTRUCTOR]
     */
    public GameScreen() {
        float scaleFactorX = ((float)Gdx.graphics.getWidth() / GameValues.GAMEUNIT_WIDTH);
        float scaleFactorY = ((float)Gdx.graphics.getHeight() / GameValues.GAMEUNIT_HEIGHT);
        world = new GameWorld();
        world.init(new EndlessBasketsMode(world));
        //world.init(new StageMode(world));
        //world.init(new EndlessMode(world));

        Gdx.input.setInputProcessor(new InputHandler(world, scaleFactorX, scaleFactorY));
        this.renderer = new GameRenderer(world);
        world.gameRenderer = this.renderer;
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(delta, runTime);
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
