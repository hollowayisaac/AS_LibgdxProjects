package com.isaac.ui.mainmenus;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.SoundHelper;
import com.isaac.helpers.UserData;
import com.isaac.screens.MainMenuScreen;
import com.isaac.screens._Screen;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 6/11/2015.
 */
public class HomeMenu extends _Menu implements com.isaac.interfaces.MainScreenable {

    /***/
    public HomeMenu(_Screen screen){
        super(screen);
    }

    /***/
    @Override
    protected void createStage(){
        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // Play
        final TextButton bPlay = new TextButton("Play", AssetLoader.defaultSkin);
        bPlay.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                SoundHelper.playSound(AssetLoader.coin);
                screen.setCurrentMenu(getMainMenuScreen().gameModeMenu);
            }
        });
        table.add(bPlay);
        table.row();

        // Settings
        final TextButton bSettings = new TextButton("Settings", AssetLoader.defaultSkin);
        bSettings.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                // TODO: Settings
                SoundHelper.playSound(AssetLoader.coin);
            }
        });
        table.add(bSettings);
        table.row();

        if(AngryFVGame.DEV_MODE) {
            // Clear Preferences
            final TextButton bClearPrefs = new TextButton("Clear Prefs", AssetLoader.defaultSkin);
            bClearPrefs.addListener(new ChangeListener() {
                public void changed(ChangeEvent event, Actor actor) {
                    SoundHelper.playSound(AssetLoader.coin);
                    UserData.clearPrefs();
                }
            });
            table.add(bClearPrefs);
            table.row();
        }

        // Sound (toggle)
        final TextButton bSound = new TextButton("Sound (ON)", AssetLoader.defaultSkin);
        bSound.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                // Toggle Sound
                UserData.setSound(!UserData.getSound());
                // After the sound is toggled (Play sound to indicate that it the sound has turned back on)
                SoundHelper.playSound(AssetLoader.coin);
            }
        });
        table.add(bSound);
    }

    /***/
    public MainMenuScreen getMainMenuScreen(){
        return (MainMenuScreen)screen;
    }

    /***/
    private void drawGameTitle(float delta) {
        AssetLoader.ftWag.draw(screen.getBatch(), "" + "ANGRY FRUIT VENDOR",
                0, GameValues.GAMEUNIT_HEIGHT);
    }
}
