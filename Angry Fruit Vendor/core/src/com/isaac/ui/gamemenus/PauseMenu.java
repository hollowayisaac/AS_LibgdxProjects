package com.isaac.ui.gamemenus;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.isaac.helpers.AssetLoader;
import com.isaac.screens.GameScreen;
import com.isaac.screens._Screen;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 6/11/2015.
 */
public class PauseMenu extends _Menu implements com.isaac.interfaces.GameScreenable {

    /***/
    public PauseMenu(_Screen screen) {
        super(screen);
    }

    /***/
    @Override
    protected void createStage() {
        // Root Table
        Table rootTable = new Table();
        rootTable.setFillParent(true);
        stage.addActor(rootTable);

        // Table
        Table table = new Table();
        rootTable.add(table);

        // Set table background
        table.setSize(250, 250);
        TextureRegionDrawable trd = new TextureRegionDrawable(AssetLoader.trApple);
        table.setBackground(trd);

        // Resume
        final TextButton bResume = new TextButton("Resume", AssetLoader.defaultSkin);
        bResume.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                getGameScreen().resumeGame();
            }
        });
        table.add(bResume);
        table.row();

        // Exit to Menu
        final TextButton bSettings = new TextButton("Exit to Menu", AssetLoader.defaultSkin);
        bSettings.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                screen.game.setScreenWithMenu(screen.game.mainMenuScreen, screen.game.mainMenuScreen.gameModeMenu);
            }
        });
        table.add(bSettings);
    }

    /***/
    @Override
    public GameScreen getGameScreen() {
        return (GameScreen) screen;
    }
}
