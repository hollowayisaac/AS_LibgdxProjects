package com.isaac.ui.gamemenus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.helpers.AssetLoader;
import com.isaac.screens.GameScreen;
import com.isaac.screens._Screen;
import com.isaac.ui._Button;
import com.isaac.ui._ButtonListener;
import com.isaac.ui._DisplayObject;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 6/11/2015.
 */
public class PauseMenu extends _Menu {

    /***/
    public PauseMenu(_Screen screen){
        super(screen);
    }

    /***/
    public void draw(float delta, SpriteBatch batch){
        // Draw Menu Panel
        dspMenuPanel.draw(delta, batch);

        // Draw Buttons
        for(int i = 0;i < this.buttons.size();i++){
            buttons.get(i).draw(delta, batch);
        }
    }

    /***/
    @Override
    protected void setMenuPanel() {
        dspMenuPanel = new _DisplayObject(screen, 100,100,225,225, AssetLoader.tSoundON_Up);
    }

    /***/
    @Override
    public void setButtons() {

        // Resume
        buttons.add(new _Button(screen, 150, 150, 120, 40, AssetLoader.tResume_Up, AssetLoader.tResume_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                GameScreen gameScreen = (GameScreen)screen;
                gameScreen.resumeGame();
            }
        }));

        // Quit to menu
        buttons.add(new _Button(screen, 150, 200, 120, 40, AssetLoader.tQuit_Up, AssetLoader.tQuit_Down, new _ButtonListener() {
            @Override
            public void onClick() {
                Gdx.app.exit();
            }
        }));
    }

}
