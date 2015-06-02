package com.isaac.angryfruitvendor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.gamemodes.EndlessBasketsMode;
import com.isaac.helpers.AssetLoader;
import com.isaac.screens.GameScreen;
import com.isaac.screens.SplashScreen;

public class AngryFVGame extends Game {

    public static boolean DEV_MODE = true;
    public SpriteBatch batcher;

    @Override
    public void create() {
        this.batcher = new SpriteBatch();
        AssetLoader.load();
        if(DEV_MODE){
            setScreen(new GameScreen(this, new EndlessBasketsMode()));
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
