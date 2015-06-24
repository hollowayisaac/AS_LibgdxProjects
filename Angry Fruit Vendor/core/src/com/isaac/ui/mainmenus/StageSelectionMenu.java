package com.isaac.ui.mainmenus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.screens._Screen;
import com.isaac.ui._Button;
import com.isaac.ui._ButtonListener;
import com.isaac.ui._DisplayObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isaac Holloway on 6/20/2015.
 */
public class StageSelectionMenu extends _MainMenu {

    public List<_Button> stageButtons;

    /***/
    public StageSelectionMenu(_Screen screen) {
        super(screen);

        setStageButtons();
    }

    /***/
    public void draw(float delta, SpriteBatch batch) {
        // Draw Menu Panel
        dspMenuPanel.draw(delta, batch);

        // Draw Title text
        drawGameTitle(delta);

        drawButtons(delta, batch);

        drawStageButtons(delta, batch);
    }

    /***/
    protected void drawStageButtons(float delta, SpriteBatch batch) {
        // Draw stage buttons
        for (int i = 0; i < this.buttons.size(); i++) {
            stageButtons.get(i).draw(delta, batch);
        }
    }

    /***/
    private void drawGameTitle(float delta) {
        AssetLoader.ftWag.draw(screen.getBatch(), "" + "Choose a Stage",
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
        // Left Arrow
        buttons.add(new _Button(screen, 100, 100, 50, 100, AssetLoader.tArrowLeftUp, AssetLoader.tOk_Down, new _ButtonListener() {
            @Override
            public void onClick() {

            }
        }));

        // Right Arrow
        buttons.add(new _Button(screen, 450, 100, 50, 100, AssetLoader.tArrowRightUp, AssetLoader.tOk_Down, new _ButtonListener() {
            @Override
            public void onClick() {

            }
        }));


    }

    /***/
    protected void setStageButtons() {
        this.stageButtons = new ArrayList<_Button>();

        // Stage Buttons
        stageButtons.add(new _Button(screen, 250, 100, 75, 75, AssetLoader.trApple, AssetLoader.trBanana, new _ButtonListener() {
            @Override
            public void onClick() {

            }
        }));
    }

}
