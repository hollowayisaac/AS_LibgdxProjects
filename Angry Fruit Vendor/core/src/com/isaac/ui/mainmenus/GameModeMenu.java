package com.isaac.ui.mainmenus;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.isaac.helpers.AssetLoader;
import com.isaac.screens.MainMenuScreen;
import com.isaac.screens._Screen;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 6/20/2015.
 */
public class GameModeMenu extends _Menu implements com.isaac.interfaces.MainScreenable {

    /***/
    public GameModeMenu(_Screen screen){
        super(screen);
    }

    /***/
    @Override
    protected void createStage(){
        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // Stage Mode
        final TextButton bStageMode = new TextButton("Stage Mode", AssetLoader.defaultSkin);
        bStageMode.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.setCurrentMenu(getMainMenuScreen().levelSelectionMenu);
            }
        });
        table.add(bStageMode);
        table.row();

        // Endless
        final TextButton bEndless = new TextButton("Endless", AssetLoader.defaultSkin);
        bEndless.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.game.setGameScreen(screen.game.gameScreen, screen.game.gameScreen.endlessMode);
            }
        });
        table.add(bEndless);
        table.row();

        // Endless Baskets
        final TextButton bEndlessBaskets = new TextButton("Endless Baskets", AssetLoader.defaultSkin);
        bEndlessBaskets.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.game.setGameScreen(screen.game.gameScreen, screen.game.gameScreen.endlessBasketsMode);
            }
        });
        table.add(bEndlessBaskets);

        // Back
        final TextButton bBack = new TextButton("Back", AssetLoader.defaultSkin);
        bBack.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.setCurrentMenu(getMainMenuScreen().homeMenu);
            }
        });
        stage.addActor(bBack);

    }

    /***/
    @Override
    public MainMenuScreen getMainMenuScreen(){
        return (MainMenuScreen)screen;
    }

/*
    *//***//*
    public void draw(float delta, SpriteBatch batch) {
        // Draw Menu Panel
        dspMenuPanel.draw(delta, batch);

        // Draw Title text
        drawGameTitle(delta);

        drawButtons(delta, batch);
    }

    *//***//*
    private void drawGameTitle(float delta) {
        AssetLoader.ftWag.draw(screen.getBatch(), "" + "Choose a game Mode",
                0, GameValues.GAMEUNIT_HEIGHT);
    }

    *//***//*
    @Override
    protected void setMenuPanel() {
        dspMenuPanel = new _DisplayObject(screen, 0, 0, GameValues.GAMEUNIT_WIDTH, GameValues.GAMEUNIT_HEIGHT, AssetLoader.trBGField);
    }

    *//***//*
    @Override
    public void setButtons() {
        // StageMode
        buttons.add(new _Button(screen, 100, 100, 100, 25, AssetLoader.tStageSelect_Up, AssetLoader.tStageSelect_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                screen.setCurrentMenu(getMainMenuScreen().stageSelectionMenu);
            }
        }));

        // Endless
        buttons.add(new _Button(screen, 100, 150, 100, 25, AssetLoader.tEndless_Up, AssetLoader.tEndless_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                screen.game.setGameScreen(screen.game.gameScreen, screen.game.gameScreen.endlessMode);
            }
        }));

        // Endless Baskets
        buttons.add(new _Button(screen, 100, 200, 100, 25, AssetLoader.tEndlessBaskets_Up, AssetLoader.tEndlessBaskets_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                screen.game.setGameScreen(screen.game.gameScreen, screen.game.gameScreen.endlessBasketsMode);
            }
        }));
    }*/

}
