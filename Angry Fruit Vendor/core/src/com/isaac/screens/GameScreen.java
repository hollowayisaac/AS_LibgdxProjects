package com.isaac.screens;

import com.badlogic.gdx.Gdx;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes._GameMode;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.InputHandler;
import com.isaac.renderers.GameRenderer;
import com.isaac.ui.SimpleButton;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
public class GameScreen extends _Screen {
    public enum GameState {
        MENU, PAUSED, RUNNING, GAMEOVER, HIGHSCORE
    }

    private GameState currentState;
    public _GameMode gameMode;
    public SimpleButton bMenu;

    /**     [CONSTRUCTOR] */
    public GameScreen(AngryFVGame game, _GameMode gameMode) {
        super(game);
        this.gameMode = gameMode;
        gameMode.init();

        float scaleFactorX = ((float)Gdx.graphics.getWidth() / GameValues.GAMEUNIT_WIDTH);
        float scaleFactorY = ((float)Gdx.graphics.getHeight() / GameValues.GAMEUNIT_HEIGHT);

        Gdx.input.setInputProcessor(new InputHandler(this, scaleFactorX, scaleFactorY));

        this.renderer = new GameRenderer(this);

        bMenu = new SimpleButton(25,25, 100, 50, AssetLoader.trBasket, AssetLoader.trRottenFruit);

        currentState = GameState.RUNNING;
    }

    /***/
    protected GameRenderer getGameRenderer() {
        return (GameRenderer)renderer;
    }

    /***/
    @Override
    public void render(float delta) {
        runTime += delta;

        gameMode.update(delta);

        getGameRenderer().render(delta);

        updateInputEvents(delta);
    }

    /** */
    public void updateInputEvents(float delta){
        if (Gdx.input.justTouched()) {
            float inputGetX = Gdx.input.getX();
            float inputGetY = Gdx.input.getY();
            game.camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

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
