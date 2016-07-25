package com.isaac.ui.mainmenus;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.UserData;
import com.isaac.screens.MainMenuScreen;
import com.isaac.screens._Screen;
import com.isaac.ui._Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isaac Holloway on 6/20/2015.
 */
public class LevelSelectionMenu extends _Menu implements com.isaac.interfaces.MainScreenable {

    private List<TextButton> levelButtons;

    private TextButton bStage1;
    private TextButton bStage2;
    private TextButton bStage3;
    private TextButton bStage4;
    private TextButton bStage5;
    private TextButton bStage6;

    /***/
    public LevelSelectionMenu(_Screen screen){
        super(screen);
    }

    /***/
    @Override
    public void init() {
        super.init();

        for (int i = 0; i < levelButtons.size();i++){
            if ((UserData.getHighestLevelCompleted()) < i ){
                levelButtons.get(i).setDisabled(true);
            }
            else{
                levelButtons.get(i).setDisabled(false);
            }
        }
    }

    /***/
    @Override
    protected void createStage(){
        // *** Testing *** Drawables
        /*Drawable d = new TextureRegionDrawable(AssetLoader.trApple);
        Drawable d2 = new TextureRegionDrawable(AssetLoader.trBanana);
        final Button bLeftArrow = new Button(d, d2);
        bLeftArrow.setPosition(35, 35);
        bLeftArrow.setSize(40, 40);
        stage.addActor(bLeftArrow);*/

        // Table
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        levelButtons = new ArrayList<TextButton>();

        // Stage 1
        bStage1 = new TextButton("Stage 1", AssetLoader.defaultSkin);
        bStage1.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.game.setStageMode(screen.game.gameScreen, screen.game.gameScreen.stageMode, 0);
            }
        });
        levelButtons.add(bStage1);
        table.add(bStage1);
        table.row();

        // Stage 2
        bStage2 = new TextButton("Stage 2", AssetLoader.defaultSkin);
        bStage2.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.game.setStageMode(screen.game.gameScreen, screen.game.gameScreen.stageMode, 1);
            }
        });
        levelButtons.add(bStage2);
        table.add(bStage2);
        table.row();

        // Stage 3
        bStage3 = new TextButton("Stage 3", AssetLoader.defaultSkin);
        bStage3.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.game.setStageMode(screen.game.gameScreen, screen.game.gameScreen.stageMode, 2);
            }
        });
        levelButtons.add(bStage3);
        table.add(bStage3);
        table.row();

        // Stage 4
        bStage4 = new TextButton("Stage 4", AssetLoader.defaultSkin);
        bStage4.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.game.setStageMode(screen.game.gameScreen, screen.game.gameScreen.stageMode, 3);
            }
        });
        levelButtons.add(bStage4);
        table.add(bStage4);
        table.row();

        // Stage 5
        bStage5 = new TextButton("Stage 5", AssetLoader.defaultSkin);
        bStage5.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.game.setStageMode(screen.game.gameScreen, screen.game.gameScreen.stageMode, 4);
            }
        });
        levelButtons.add(bStage5);
        table.add(bStage5);
        table.row();

        // Stage 6
        bStage6 = new TextButton("Stage 6", AssetLoader.defaultSkin);
        bStage6.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.game.setStageMode(screen.game.gameScreen, screen.game.gameScreen.stageMode, 5);
            }
        });
        levelButtons.add(bStage6);
        table.add(bStage6);

        // Back
        final TextButton bBack = new TextButton("Back", AssetLoader.defaultSkin);
        bBack.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                screen.setCurrentMenu(getMainMenuScreen().gameModeMenu);
            }
        });
        stage.addActor(bBack);
    }

    /***/
    @Override
    public MainMenuScreen getMainMenuScreen(){
        return (MainMenuScreen)screen;
    }

}
