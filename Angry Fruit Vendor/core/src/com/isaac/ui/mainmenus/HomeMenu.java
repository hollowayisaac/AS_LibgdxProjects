package com.isaac.ui.mainmenus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.screens._Screen;
import com.isaac.ui._Button;
import com.isaac.ui._ButtonListener;
import com.isaac.ui._DisplayObject;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 6/11/2015.
 */
public class HomeMenu extends _Menu {

    /***/
    public HomeMenu(_Screen screen){
        super(screen);
    }

    /***/
    public void draw(float delta, SpriteBatch batch){
        // Draw Menu Panel
        dspMenuPanel.draw(delta, batch);

        // Draw Title text
        drawGameTitle(delta);

        // Draw Buttons
        for(int i = 0;i < this.buttons.size();i++){
            buttons.get(i).draw(delta, batch);
        }
    }

    /***/
    private void drawGameTitle(float delta) {
        AssetLoader.ftWag.draw(screen.getBatch(), "" + "ANGRY FRUIT VENDOR",
                0, GameValues.GAMEUNIT_HEIGHT);
    }

    /***/
    @Override
    protected void setMenuPanel() {
        dspMenuPanel = new _DisplayObject(screen, 0, 0, GameValues.GAMEUNIT_WIDTH,GameValues.GAMEUNIT_HEIGHT, AssetLoader.trBGField);
    }

    /***/
    @Override
    public void setButtons() {

        // Play!
        buttons.add(new _Button(screen, 200, 200, 75, 75, AssetLoader.tPlay_Up, AssetLoader.tPlay_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                screen.game.setScreen(screen.game.gameScreen);
                screen.game.gameScreen.setGameMode(screen.game.gameScreen.endlessBasketsMode);
            }
        }));

        // Options
        buttons.add(new _Button(screen, 25, 25, 75, 75, AssetLoader.tOptions_Up, AssetLoader.tOptions_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                // TODO: Options
            }
        }));

        // Sound Toggle
        buttons.add(new _Button(screen, 450, 300, 75, 75, AssetLoader.tSoundON_Up, AssetLoader.tSoundON_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                // TODO: Sound!
            }
        }));
    }

}
