package com.isaac.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes.GameMode;
import com.isaac.gameworld.GameRenderer;
import com.isaac.gameworld.GameValues;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.InputHandler;
import com.isaac.ui.SimpleButton;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
public class GameScreen extends ScreenAdapter {
    public enum GameState {
        MENU, PAUSED, RUNNING, GAMEOVER, HIGHSCORE
    }
    private GameScreen.GameState currentState;
    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;
    private AngryFVGame game;
    private OrthographicCamera guiCam;
    Vector3 touchPoint;

    public SimpleButton bMenu;

    /**     [CONSTRUCTOR] */
    public GameScreen(AngryFVGame game, GameMode gameMode) {
        this.game = game;
        float scaleFactorX = ((float)Gdx.graphics.getWidth() / GameValues.GAMEUNIT_WIDTH);
        float scaleFactorY = ((float)Gdx.graphics.getHeight() / GameValues.GAMEUNIT_HEIGHT);
        world = new GameWorld();
        world.init(gameMode);
        //world.init(new EndlessBasketsMode(world));
        //world.init(new StageMode(world));
        //world.init(new EndlessMode(world));

        Gdx.input.setInputProcessor(new InputHandler(world, scaleFactorX, scaleFactorY));
        this.renderer = new GameRenderer(world);

        guiCam = new OrthographicCamera(GameValues.GAMEUNIT_WIDTH, GameValues.GAMEUNIT_HEIGHT);
        guiCam.position.set(GameValues.GAMEUNIT_WIDTH / 2, GameValues.GAMEUNIT_HEIGHT / 2, 0);
        touchPoint = new Vector3();
        bMenu = new SimpleButton(25,25, 100, 50, AssetLoader.trBasket, AssetLoader.trRottenFruit);

        currentState = GameState.RUNNING;
    }

    /** */
    @Override
    public void render(float delta) {
        runTime += delta;

        //runTime += delta;

        switch (currentState) {
            case PAUSED:
                break;

            case MENU:
                updateInputEvents(delta);
                break;

            case RUNNING:
                world.updateRunning(delta);
                break;
        }


        renderer.render(delta, runTime, currentState);

        updateInputEvents(delta);
    }

    /** */
    public void updateInputEvents(float delta){
        if (Gdx.input.justTouched()) {
            float inputGetX = Gdx.input.getX();
            float inputGetY = Gdx.input.getY();
            guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (bMenu.bounds.contains(inputGetX, inputGetY )) {
                setGameState(GameState.MENU);
                return;
            }
        }
    }

    /** */
    @Override
    public void resize(int width, int height) {

    }

    /** */
    @Override
    public void show() {
    }

    /** */
    @Override
    public void hide() {
    }

    /** */
    @Override
    public void pause() {
    }

    /** */
    @Override
    public void resume() {
    }

    /** */
    @Override
    public void dispose() {
    }

    public void setGameState(GameScreen.GameState newGameState){
        this.currentState = newGameState;
    }
    public GameScreen.GameState getGameState() {
        return currentState;
    }

}
