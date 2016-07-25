package com.isaac.ui.mainmenus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.SoundHelper;
import com.isaac.helpers.UserData;
import com.isaac.screens.MainMenuScreen;
import com.isaac.screens._Screen;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 6/20/2015.
 */
public class GameModeMenu extends _Menu implements com.isaac.interfaces.MainScreenable {

    private Label lHSEndless;
    private Label lHSEndlessBaskets;
    private ImageButton bSoundToggle;

    /***/
    public GameModeMenu(_Screen screen){
        super(screen);
    }

    /* **/
    @Override
    public void init(){
        super.init();

        lHSEndless.setText(UserData.getEndlessScoreString());
        lHSEndlessBaskets.setText(UserData.getEndlessBasketsScoreString());
        bSoundToggle.setChecked(UserData.getSound());
        lHSEndlessBaskets.setText(Boolean.toString(UserData.getSound()));

    }

    /***/
    @Override
    protected void createStage(){
        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // Column Buffer
        table.add(new TextButton("",  AssetLoader.defaultSkin));

        // High Score Header
        Label lHighScoreHeader = new Label("High Scores", AssetLoader.defaultSkin);
        table.add(lHighScoreHeader);
        table.row();

        // Endless
        final TextButton bEndless = new TextButton("Endless", AssetLoader.defaultSkin);
        bEndless.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                screen.game.setGameScreen(screen.game.gameScreen, screen.game.gameScreen.endlessMode);
            }
        });
        table.add(bEndless);

        // Endless High Score
        lHSEndless = new Label("", AssetLoader.defaultSkin);
        table.add(lHSEndless);
        table.row();

        // Endless Baskets
        final TextButton bEndlessBaskets = new TextButton("Endless Baskets", AssetLoader.defaultSkin);
        bEndlessBaskets.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                screen.game.setGameScreen(screen.game.gameScreen, screen.game.gameScreen.endlessBasketsMode);
            }
        });
        table.add(bEndlessBaskets);

        // Endless Baskets High Score
        lHSEndlessBaskets = new Label("", AssetLoader.defaultSkin);
        table.add(lHSEndlessBaskets);

        // Sound Toggle
        Drawable dSoundON = new TextureRegionDrawable(AssetLoader.trSoundON);
        Drawable dSoundOFF = new TextureRegionDrawable(AssetLoader.trSoundOFF);
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.up           = dSoundOFF;
        //style.down         = background;
        style.checked      = dSoundON;
        style.imageUp      = dSoundOFF;
        //style.imageDown    = icon_down;
        style.imageChecked = dSoundON;
        //style.unpressedOffsetY = -20; // to "not" center the icon
        //style.unpressedOffsetX = -30; // to "not" center the icon

        bSoundToggle = new ImageButton(style);
        bSoundToggle.setPosition(stage.getWidth() - 70, stage.getHeight() - 70);
        bSoundToggle.setSize(60, 60);
        bSoundToggle.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                // Toggle Sound
                boolean soundToggle = !UserData.getSound();
                UserData.setSound(soundToggle);
                // After the sound is toggled (Play sound to indicate that it the sound has turned back on)
                SoundHelper.playSound(AssetLoader.coin);
            }
        });
                /*new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                // Toggle Sound
                boolean soundToggle = !UserData.getSound();
                UserData.setSound(soundToggle);
                // After the sound is toggled (Play sound to indicate that it the sound has turned back on)
                SoundHelper.playSound(AssetLoader.coin);
            }
    });*/
        table.addActor(bSoundToggle);

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
