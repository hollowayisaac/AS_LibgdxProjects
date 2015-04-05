package com.isaac.angryfruitvendor.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.isaac.angryfruitvendor.AngryFVGame;

public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Angry Fruit Vendor";
        config.width = 800;
        config.height = 450;
        new LwjglApplication(new AngryFVGame(), config);
    }
}
