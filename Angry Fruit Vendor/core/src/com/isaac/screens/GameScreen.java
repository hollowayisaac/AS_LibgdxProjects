package com.isaac.screens;

import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes.EndlessBasketsMode;
import com.isaac.gamemodes.EndlessMode;
import com.isaac.gamemodes.StageMode;
import com.isaac.gamemodes._GameMode;
import com.isaac.helpers.AssetLoader;
import com.isaac.input.GameInput;
import com.isaac.interfaces._ButtonListener;
import com.isaac.renderers.GameRenderer;
import com.isaac.ui._Button;
import com.isaac.ui._Menu;
import com.isaac.ui.gamemenus.AllLevelCompleteMenu;
import com.isaac.ui.gamemenus.LevelCompleteMenu;
import com.isaac.ui.gamemenus.LevelFailedMenu;
import com.isaac.ui.gamemenus.NewHighScoreMenu;
import com.isaac.ui.gamemenus.PauseMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
public class GameScreen extends _Screen {
    /**
     * ~~~ *
     */
    public enum GameState {
        RUNNING, MENU,
    }
    private GameState currentState;

    public GameInput gameInput;

    public _GameMode currentGameMode;
    public _GameMode stageMode;
    public _GameMode endlessMode;
    public _GameMode endlessBasketsMode;

    public _Menu pauseMenu;
    public _Menu levelCompleteMenu;
    public _Menu levelFailedMenu;
    public _Menu allLevelCompleteMenu;
    public _Menu newHighScoreMenu;

    public List<_Button> buttons;

    /**
     * [CONSTRUCTOR]
     */
    public GameScreen(AngryFVGame game) {
        super(game);
        this.renderer = new GameRenderer(this);
        this.gameInput = new GameInput(this);

        createMenus();
        createGameModes();
        createButtons();
    }

    /***/
    @Override
    public void init() {
        resumeGame();
    }

    /***/
    private void createGameModes() {
        stageMode = new StageMode(this);
        endlessMode = new EndlessMode(this);
        endlessBasketsMode = new EndlessBasketsMode(this);
    }

    /***/
    public void setGameMode(_GameMode currentGameMode) {
        currentState = GameState.RUNNING;

        this.currentGameMode = currentGameMode;
        currentGameMode.init();
    }

    /***/
    public void setStageMode(_GameMode gameMode, int startingLevel) {
        currentState = GameState.RUNNING;
        this.currentGameMode = gameMode;

        StageMode sm = (StageMode) this.currentGameMode;
        sm.init(startingLevel);
    }

    /***/
    @Override
    protected void createMenus() {
        pauseMenu = new PauseMenu(this);
        levelCompleteMenu = new LevelCompleteMenu(this);
        levelFailedMenu = new LevelFailedMenu(this);
        allLevelCompleteMenu = new AllLevelCompleteMenu(this);
        newHighScoreMenu = new NewHighScoreMenu(this);

        // TODO: Draw the AdMob stuff here...
        //
    }

    /***/
    protected void createButtons() {
        this.buttons = new ArrayList<_Button>();

        // Pause
        _Button bnPause = new _Button(this, 25, 350, 100, 40, AssetLoader.tCancel_Up, AssetLoader.tCancel_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                pauseGame();
            }
        });
        buttons.add(bnPause);

        // Trampoline LEFT
        _Button bnMoveTrampolineLeft = new _Button(this, 100, 100, 75, 75, AssetLoader.tArrowLeftUp, AssetLoader.tArrowRightUp, new _ButtonListener() {
            @Override
            public void onClick() {
                currentGameMode.getTrampoline().onInput_Left();
            }
        });
        buttons.add(bnMoveTrampolineLeft);

        // Trampoline RIGHT
        _Button bnMoveTrampolineRight = new _Button(this, 350, 100, 75, 75, AssetLoader.tArrowRightUp, AssetLoader.tArrowLeftUp, new _ButtonListener() {
            @Override
            public void onClick() {
                currentGameMode.getTrampoline().onInput_Right();
            }
        });
        buttons.add(bnMoveTrampolineRight);
    }

    /***/
    @Override
    public void render(float delta) {
        // Update
        switch (currentState) {
            case RUNNING:
                currentGameMode.update(delta);
                break;
            case MENU:
                break;
        }

        // Draw
        super.render(delta);
    }

    /***/
    public void closeMenu(){
        resumeGame();
    }

    /***/
    public void pauseGame() {
        currentState = GameState.MENU;
        setCurrentMenu(pauseMenu);
    }

    /***/
    public void resumeGame() {
        this.setGameState(GameState.RUNNING);
        setCurrentMenu(null);
        this.gameInput.init();
    }

    /***/
    public void setGameScreenMenu(_Menu menu){
        setGameState(GameScreen.GameState.MENU);
        setCurrentMenu(menu);
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
