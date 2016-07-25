package com.isaac.angryfruitvendor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.gamemodes._GameMode;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.UserData;
import com.isaac.screens.GameScreen;
import com.isaac.screens.MainMenuScreen;
import com.isaac.screens._Screen;
import com.isaac.ui._Menu;

public class AngryFVGame extends Game {

    public static boolean DEV_MODE = true;
    public SpriteBatch batch;
    public OrthographicCamera camera;

    // Screens
    public MainMenuScreen mainMenuScreen;
    public GameScreen gameScreen;

    /**
     * [CONSTRUCTOR]
     */
    @Override
    public void create() {
        this.batch = new SpriteBatch();
        camera = new OrthographicCamera(GameValues.GAME_WIDTH, GameValues.GAME_HEIGHT);
        camera.position.set(GameValues.GAME_WIDTH / 2, GameValues.GAME_HEIGHT / 2, 0);

        ////  LOADING  ////
        // [User Data]
        UserData.loadPreferences();

        // [Assets]
        AssetLoader.load();

        // [Screens]
        loadScreens();

        // Set the initial Screen
        if (DEV_MODE) {
            setScreen(mainMenuScreen);
            //setScreen(mainMenuScreen);
        } else {
            setScreen(mainMenuScreen);
        }
    }

    /***/
    private void loadScreens() {
        this.mainMenuScreen = new MainMenuScreen(this);
        this.gameScreen = new GameScreen(this);
    }

    /***/
    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);
        _Screen _screen = (_Screen) screen;
        _screen.init();
    }

    /***/
    public void setScreenWithMenu(Screen screen, _Menu menu) {
        super.setScreen(screen);
        _Screen _screen = (_Screen) screen;
        _screen.init();
        _screen.setCurrentMenu(menu);
    }

    /***/
    public void setGameScreen(Screen screen, _GameMode gameMode) {
        setScreen(screen);
        gameScreen.setGameMode(gameMode);
    }

    /***/
    public void setStageMode(Screen screen, _GameMode gameMode, int startingLevel) {
        setScreen(screen);
        gameScreen.setStageMode(gameMode, startingLevel);
    }

    /***/
    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        AssetLoader.dispose();
    }
}
