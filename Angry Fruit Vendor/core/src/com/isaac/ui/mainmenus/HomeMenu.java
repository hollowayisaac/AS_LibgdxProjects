package com.isaac.ui.mainmenus;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
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
                screen.setCurrentMenu(getMainMenuScreen().gameModeMenu);
            }
        });
        table.add(bPlay);
        table.row();

        // Settings
        final TextButton bSettings = new TextButton("Settings", AssetLoader.defaultSkin);
        bSettings.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                // TODO: Settings
            }
        });
        table.add(bSettings);
        table.row();

        // Sound (toggle)
        final TextButton bSound = new TextButton("Sound (ON)", AssetLoader.defaultSkin);
        bSound.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                // TODO: Sound
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



/*    *//***//*
    public void draw(float delta, SpriteBatch batch){
        // Draw Menu Panel
        dspMenuPanel.draw(delta, batch);

        // Draw Title text
        drawGameTitle(delta);

        drawButtons(delta, batch);
    }*/

    /***//*
    @Override
    protected void setMenuPanel() {
        //dspMenuPanel = new _DisplayObject(screen, 0, 0, GameValues.GAMEUNIT_WIDTH,GameValues.GAMEUNIT_HEIGHT, AssetLoader.trBGField);
    }

    *//***//*
    @Override
    public void setButtons() {
*//*
        // Play!
        buttons.add(new _Button(screen, 200, 200, 75, 75, AssetLoader.tPlay_Up, AssetLoader.tPlay_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                screen.setCurrentMenu(getMainMenuScreen().gameModeMenu);
            }
        }));

        // Options
        buttons.add(new _Button(screen, 25, 25, 75, 75, AssetLoader.tOptions_Up, AssetLoader.tOptions_Down, new _ButtonListener() {
            @Override
            public void onClick() {

            }
        }));

        // Sound Toggle
        buttons.add(new _Button(screen, 450, 300, 75, 75, AssetLoader.tSoundON_Up, AssetLoader.tSoundON_Down, new _ButtonListener() {
            @Override
            public void onClick() {

            }
        }));*//*
    }*/
}
