package com.isaac.ui.mainmenus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.screens._Screen;
import com.isaac.ui._Button;
import com.isaac.ui._ButtonListener;
import com.isaac.ui._DisplayObject;

/**
 * Created by Isaac Holloway on 6/20/2015.
 */
public class GameModeMenu extends _MainMenu {
    public GameModeMenu(_Screen screen) {
        super(screen);
    }

    /***/
    public void draw(float delta, SpriteBatch batch) {
        // Draw Menu Panel
        dspMenuPanel.draw(delta, batch);

        // Draw Title text
        drawGameTitle(delta);

        drawButtons(delta, batch);
    }

    /***/
    private void drawGameTitle(float delta) {
        AssetLoader.ftWag.draw(screen.getBatch(), "" + "Choose a game Mode",
                0, GameValues.GAMEUNIT_HEIGHT);
    }

    /***/
    @Override
    protected void setMenuPanel() {
        dspMenuPanel = new _DisplayObject(screen, 0, 0, GameValues.GAMEUNIT_WIDTH, GameValues.GAMEUNIT_HEIGHT, AssetLoader.trBGField);
    }

    /***/
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
    }

}
