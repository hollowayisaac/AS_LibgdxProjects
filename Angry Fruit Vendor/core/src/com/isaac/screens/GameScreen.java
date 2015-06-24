package com.isaac.screens;

import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes.EndlessBasketsMode;
import com.isaac.gamemodes.EndlessMode;
import com.isaac.gamemodes.StageMode;
import com.isaac.gamemodes._GameMode;
import com.isaac.helpers.AssetLoader;
import com.isaac.input.GameInput;
import com.isaac.renderers.GameRenderer;
import com.isaac.ui._Button;
import com.isaac.ui._ButtonListener;
import com.isaac.ui._Menu;
import com.isaac.ui.gamemenus.PauseMenu;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
public class GameScreen extends _Screen {
    /**
     * ~~~ *
     */
    public enum GameState {
        RUNNING, PAUSE_MENU, LEVEL_COMPLETE, LEVEL_FAIL,
    }

    public _GameMode stageMode;
    public _GameMode endlessMode;
    public _GameMode endlessBasketsMode;

    private GameState currentState;
    public _GameMode gameMode;
    private _Menu pauseMenu;
    public _Button bnPause;

    /**
     * [CONSTRUCTOR]
     */
    public GameScreen(AngryFVGame game) {
        super(game);

        this.renderer = new GameRenderer(this);
        this.input = new GameInput(this);

        createMenus();
        createGameModes();
    }

    /***/
    private void createGameModes() {
        stageMode = new StageMode();
        endlessMode = new EndlessMode();
        endlessBasketsMode = new EndlessBasketsMode();
    }

    /***/
    public void setGameMode(_GameMode gameMode){
        currentState = GameState.RUNNING;

        this.gameMode = gameMode;
        gameMode.init();
    }

    /***/
    @Override
    protected void createMenus() {
        pauseMenu = new PauseMenu(this);

        bnPause = new _Button(this, 25, 25, 120, 40, AssetLoader.tCancel_Up, AssetLoader.tCancel_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                setGameState(GameState.PAUSE_MENU);
            }
        });

        // TODO: Draw the AdMob stuff here...
        //
    }

    /***/
    @Override
    public _Menu getCurrentMenu() {
        switch (currentState) {
            case PAUSE_MENU:
                return pauseMenu;
            default:
                return null;
        }
    }

    /***/
    @Override
    public void render(float delta) {
        switch (currentState) {
            case RUNNING:
                gameMode.update(delta);
                break;
            case PAUSE_MENU:
                break;
        }
        super.render(delta);
    }

    /***/
    public void pauseGame() {
        currentState = GameState.PAUSE_MENU;
    }

    /***/
    public void resumeGame() {
        currentState = GameState.RUNNING;
    }

    /***/
    public void returnToMainMenu() {
        game.setScreen(game.mainMenuScreen);
    }

    /***/
    @Override
    public void show() {
    }

    /***/
    @Override
    public void hide() {
    }

    /***/
    @Override
    public void pause() {
        pauseGame();
    }

    /***/
    @Override
    public void resume() {
        pauseGame();
    }

    /***/
    public void setGameState(GameScreen.GameState newGameState) {
        this.currentState = newGameState;
    }

    /***/
    public GameScreen.GameState getGameState() {
        return currentState;
    }

}
