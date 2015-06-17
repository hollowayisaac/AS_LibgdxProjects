package com.isaac.angryfruitvendor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.screens.GameScreen;
import com.isaac.screens.MainMenuScreen;
import com.isaac.screens.SplashScreen;
import com.isaac.screens._Screen;

public class AngryFVGame extends Game {

    public static boolean DEV_MODE = true;
    public SpriteBatch batch;
    public OrthographicCamera camera;

    // Screens
    public SplashScreen splashScreen;
    public MainMenuScreen mainMenuScreen;
    public GameScreen gameScreen;


    /** [CONSTRUCTOR] */
    @Override
    public void create() {
        this.batch = new SpriteBatch();
        camera = new OrthographicCamera(GameValues.GAMEUNIT_WIDTH, GameValues.GAMEUNIT_HEIGHT);
        camera.position.set(GameValues.GAMEUNIT_WIDTH / 2, GameValues.GAMEUNIT_HEIGHT / 2, 0);
        AssetLoader.load();
        
        loadScreens();

        if(DEV_MODE){
            setScreen(mainMenuScreen);
            //setScreen(gameScreen);
            //gameScreen.setGameMode(gameScreen.endlessBasketsMode);
        }else       {
            setScreen(splashScreen);
        }
    }

    /***/
    private void loadScreens() {
        this.splashScreen = new SplashScreen(this);
        this.mainMenuScreen = new MainMenuScreen(this);
        this.gameScreen = new GameScreen(this);
    }

    /***/
    @Override
    public void setScreen(Screen screen){
        super.setScreen(screen);
        _Screen _screen = (_Screen)screen;
        _screen.init();
    }

    /***/
    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
