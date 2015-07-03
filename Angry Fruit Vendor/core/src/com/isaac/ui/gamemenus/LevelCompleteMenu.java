package com.isaac.ui.gamemenus;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
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
public class LevelCompleteMenu extends _Menu implements com.isaac.interfaces.GameScreenable {

    protected Label labScore;

    /***/
    public LevelCompleteMenu(_Screen screen) {
        super(screen);
    }

    /***/
    @Override
    public void init() {
        super.init();
        labScore.setText(Integer.toString(getGameScreen().currentGameMode.getScore()));
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
        TextureRegionDrawable trd = new TextureRegionDrawable(AssetLoader.trTrampoline);
        table.setBackground(trd);

        // Display your Score
        labScore = new Label("", AssetLoader.defaultSkin);
        table.add(labScore);
        table.row();

        // Play Next Level
        final TextButton bPlayNextLevel = new TextButton("Play Next Level", AssetLoader.defaultSkin);
        bPlayNextLevel.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                getGameScreen().closeMenu();
                getGameScreen().currentGameMode.advanceCurrentLevel();
            }
        });
        table.add(bPlayNextLevel);
        table.row();

        // Exit to Menu
        final TextButton bExitToMenu = new TextButton("Exit to Menu", AssetLoader.defaultSkin);
        bExitToMenu.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                screen.game.setScreenWithMenu(screen.game.mainMenuScreen, screen.game.mainMenuScreen.gameModeMenu);
            }
        });
        table.add(bExitToMenu);
    }

    /***/
    @Override
    public GameScreen getGameScreen() {
        return (GameScreen) screen;
    }
}
