package com.isaac.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.isaac.gamemodes.EndlessMode;
import com.isaac.gameworld.GameRenderer;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.InputHandler;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    // This is the constructor, not the class declaration
    public GameScreen() {

/*        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);*/

        world = new GameWorld();
//        world.init(new StageMode(world));
        world.init(new EndlessMode(world));

        Gdx.input.setInputProcessor(new InputHandler(world));
        renderer = new GameRenderer(world);
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
