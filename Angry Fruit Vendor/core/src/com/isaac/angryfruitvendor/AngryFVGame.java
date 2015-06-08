package com.isaac.angryfruitvendor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.gamemodes.EndlessBasketsMode;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.screens.GameScreen;
import com.isaac.screens.SplashScreen;

public class AngryFVGame extends Game {

    public static boolean DEV_MODE = true;
    public SpriteBatch batch;
    public OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(GameValues.GAMEUNIT_WIDTH, GameValues.GAMEUNIT_HEIGHT);
        camera.position.set(GameValues.GAMEUNIT_WIDTH / 2, GameValues.GAMEUNIT_HEIGHT / 2, 0);
        AssetLoader.load();
        if(DEV_MODE){
            setScreen(new GameScreen(this, new EndlessBasketsMode()));
            //setScreen(new MainMenuScreen(this));
        }else       {
            setScreen(new SplashScreen(this));
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
