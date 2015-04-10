package com.isaac.angryfruitvendor;

import com.badlogic.gdx.Game;
import com.isaac.helpers.AssetLoader;
import com.isaac.screens.GameScreen;
import com.isaac.screens.SplashScreen;

public class AngryFVGame extends Game {

    public static boolean DEV_MODE = true;

    @Override
    public void create() {
        AssetLoader.load();
        if(DEV_MODE){
            setScreen(new GameScreen());
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
