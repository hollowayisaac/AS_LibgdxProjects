package com.isaac.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
public class AssetLoader {
    // TextureRegions
    public static TextureRegion trApple;
    public static TextureRegion trWatermelon;
    public static TextureRegion trOrange;
    public static TextureRegion trBanana;
    public static TextureRegion trRottenFruit;
    public static TextureRegion trBasket;
    public static TextureRegion trTrampoline;
    public static TextureRegion logo, zbLogo, bg, grass, bird, birdDown,
            birdUp, skullUp, skullDown, bar, playButtonUp, playButtonDown;

    public static Texture tCancel_Up, tCancel_Down;
    public static Texture tClickToStart_Up, tClickToStart_Down;
    public static Texture tEndless_Up, tEndless_Down;
    public static Texture tEndlessBaskets_Up, tEndlessBaskets_Down;
    public static Texture tHighScore_Up, tHighScore_Down;
    public static Texture tOk_Up, tOk_Down;
    public static Texture tOptions_Up, tOptions_Down;
    public static Texture tPlay_Up, tPlay_Down;
    public static Texture tQuit_Up, tQuit_Down;
    public static Texture tResume_Up, tResume_Down;
    public static Texture tStage_Up, tStage_Down;
    public static Texture tStageSelect_Up, tStageSelect_Down;
    public static Texture tSoundON_Up, tSoundON_Down;
    public static Texture tSoundOFF_Up, tSoundOFF_Down;

    public static TextureRegion trPlusOne;

    public static Texture tArrowLeftUp;
    public static Texture tArrowRightUp;

    public static TextureRegion trQuitGame;
    public static Texture trBGField;

    // Skin
    public static Skin defaultSkin;

    // Textures
    public static Texture texture, logoTexture;

    // Animations
    public static Animation birdAnimation;

    // Sound
    public static Sound dead, flap, coin;

    // Font
    public static BitmapFont ftWag; //(Wag) White and Gray

    /***/
    public static void load() {
        load_Fonts();
        load_Skins();
        load_Sound();
        load_Images();
    }

    /***/
    private static void load_Fonts() {
        ftWag = new BitmapFont(Gdx.files.internal("fonts/simple1.fnt"));
        ftWag.setScale(.5f, .5f);
    }

    /***/
    private static void load_Skins() {
        // A skin can be loaded via JSON or defined programmatically, either is fine. Using a skin is optional but strongly
        // recommended solely for the convenience of getting a texture, region, etc as a drawable, tinted drawable, etc.
        defaultSkin = new Skin();

        // Generate a 1x1 white texture and store it in the skin named "white".
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        defaultSkin .add("white", new Texture(pixmap));
        pixmap.dispose();

        // Store the default libgdx font under the name "default".
        defaultSkin .add("default", new BitmapFont());

        // Label Style
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = defaultSkin .getFont("default");
        labelStyle.fontColor = Color.WHITE;
        defaultSkin.add("default", labelStyle);

        // Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.disabled = defaultSkin. newDrawable("white", Color.YELLOW);
        textButtonStyle.up = defaultSkin .newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = defaultSkin .newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.checked = defaultSkin .newDrawable("white", Color.BLUE);
        textButtonStyle.over = defaultSkin .newDrawable("white", Color.LIGHT_GRAY);
        textButtonStyle.font = defaultSkin .getFont("default");
        defaultSkin.add("default", textButtonStyle);
    }

    /***/
    private static void load_Sound() {
        dead = Gdx.audio.newSound(Gdx.files.internal("sound/dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("sound/flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("sound/coin.wav"));
    }

    /***/
    private static void load_Images() {

        //      ~Buttons~      //
        tCancel_Up = new Texture(Gdx.files.internal("buttons/cancel-up.png"));
        tCancel_Down = new Texture(Gdx.files.internal("buttons/cancel-down.png"));

        tClickToStart_Up = new Texture(Gdx.files.internal("buttons/clicktostart-up.png"));
        tClickToStart_Down = new Texture(Gdx.files.internal("buttons/clicktostart-down.png"));

        tEndless_Up = new Texture(Gdx.files.internal("buttons/endless-up.png"));
        tEndless_Down = new Texture(Gdx.files.internal("buttons/endless-down.png"));

        tEndlessBaskets_Up = new Texture(Gdx.files.internal("buttons/endlessbaskets-up.png"));
        tEndlessBaskets_Down = new Texture(Gdx.files.internal("buttons/endlessbaskets-down.png"));

        tHighScore_Up = new Texture(Gdx.files.internal("buttons/highscore-up.png"));
        tHighScore_Down = new Texture(Gdx.files.internal("buttons/highscore-down.png"));

        tOk_Up = new Texture(Gdx.files.internal("buttons/ok-up.png"));
        tOk_Down = new Texture(Gdx.files.internal("buttons/ok-down.png"));

        tOptions_Up = new Texture(Gdx.files.internal("buttons/options-up.png"));
        tOptions_Down = new Texture(Gdx.files.internal("buttons/options-down.png"));

        tPlay_Up = new Texture(Gdx.files.internal("buttons/play-up.png"));
        tPlay_Down = new Texture(Gdx.files.internal("buttons/play-down.png"));

        tQuit_Up = new Texture(Gdx.files.internal("buttons/quit-up.png"));
        tQuit_Down= new Texture(Gdx.files.internal("buttons/quit-down.png"));

        tResume_Up = new Texture(Gdx.files.internal("buttons/resume-up.png"));
        tResume_Down= new Texture(Gdx.files.internal("buttons/resume-down.png"));

        tStage_Up = new Texture(Gdx.files.internal("buttons/stage-up.png"));
        tStage_Down= new Texture(Gdx.files.internal("buttons/stage-down.png"));

        tStageSelect_Up = new Texture(Gdx.files.internal("buttons/stageselect-up.png"));
        tStageSelect_Down = new Texture(Gdx.files.internal("buttons/stageselect-down.png"));

        tSoundOFF_Up= new Texture(Gdx.files.internal("buttons/turnsoundOFF-up.png"));
        tSoundOFF_Down = new Texture(Gdx.files.internal("buttons/turnsoundOFF-down.png"));

        tSoundON_Up= new Texture(Gdx.files.internal("buttons/turnsoundON-up.png"));
        tSoundON_Down = new Texture(Gdx.files.internal("buttons/turnsoundON-down.png"));

        // Arrows
        tArrowLeftUp = new Texture(Gdx.files.internal("buttons/left-arrow-up.png"));
        tArrowRightUp = new Texture(Gdx.files.internal("buttons/right-arrow-up.png"));

        //      ~Fruits~      //
        // Apple
        Texture tApple = new Texture(Gdx.files.internal("images/apple.png"));
        tApple.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trApple = new TextureRegion(tApple, 0, 0, tApple.getWidth(), tApple.getHeight());

        // Orange
        Texture tOrange = new Texture(Gdx.files.internal("images/orange.png"));
        tOrange.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trOrange = new TextureRegion(tOrange, 0, 0, tOrange.getWidth(), tOrange.getHeight());

        // Watermelon
        Texture tWatermelon = new Texture(Gdx.files.internal("images/watermelon.png"));
        tWatermelon.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trWatermelon = new TextureRegion(tWatermelon, 0, 0, tWatermelon.getWidth(), tWatermelon.getHeight());

        // Banana
        Texture tBanana = new Texture(Gdx.files.internal("images/banana.png"));
        tBanana.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trBanana = new TextureRegion(tBanana, 0, 0, tBanana.getWidth(), tBanana.getHeight());

        // Rotten Fruit
        Texture tRottenFruit = new Texture(Gdx.files.internal("images/rotten-fruit.png"));
        tRottenFruit.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trRottenFruit = new TextureRegion(tRottenFruit, 0, 0, tRottenFruit.getWidth(), tRottenFruit.getHeight());

        // Basket
        Texture tBasket = new Texture(Gdx.files.internal("images/fruit-basket.png"));
        tBasket.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trBasket = new TextureRegion(tBasket, 0, 0, tBasket.getWidth(), tBasket.getHeight());

        //// Buttons
        // Quit Game Button
        Texture tQuitGame = new Texture(Gdx.files.internal("images/giant-close-button.png"));
        tQuitGame.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trQuitGame = new TextureRegion(tQuitGame, 0, 0, tQuitGame.getWidth(), tQuitGame.getHeight());

        //// Backgrounds
        // BG Field
        trBGField = new Texture(Gdx.files.internal("images/afv-bg.png"));

        // Flappy bird Texture (old)
        texture = new Texture(Gdx.files.internal("images/flappy-bird-texture.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        // Trampoline
        trTrampoline = new TextureRegion(texture, 0, 43, 143, 11);
        trTrampoline.flip(false, true);

        playButtonUp = new TextureRegion(texture, 0, 83, 29, 16);
        playButtonDown = new TextureRegion(texture, 29, 83, 29, 16);
        playButtonUp.flip(false, true);
        playButtonDown.flip(false, true);

        zbLogo = new TextureRegion(texture, 0, 55, 135, 24);
        zbLogo.flip(false, true);

        bg = new TextureRegion(texture, 0, 0, 136, 43);
        bg.flip(false, true);

        grass = new TextureRegion(texture, 0, 43, 143, 11);
        grass.flip(false, true);

        birdDown = new TextureRegion(texture, 136, 0, 17, 12);
        birdDown.flip(false, true);

        bird = new TextureRegion(texture, 153, 0, 17, 12);
        bird.flip(false, true);

        birdUp = new TextureRegion(texture, 170, 0, 17, 12);
        birdUp.flip(false, true);

        TextureRegion[] birds = {birdDown, bird, birdUp};
        birdAnimation = new Animation(0.06f, birds);
        birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        skullUp = new TextureRegion(texture, 192, 0, 24, 14);
        // Create by flipping existing skullUp
        skullDown = new TextureRegion(skullUp);
        skullDown.flip(false, true);

        bar = new TextureRegion(texture, 136, 16, 22, 3);
        bar.flip(false, true);

        // Plus One Power up
        Texture tPlusOne = new Texture(Gdx.files.internal("images/plus-one.png"));
        tPlusOne.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trPlusOne = new TextureRegion(tPlusOne, 0, 0, tPlusOne.getWidth(), tPlusOne.getHeight());
    }

    /***/
    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();

        // Dispose sounds
        dead.dispose();
        flap.dispose();
        coin.dispose();
        ftWag.dispose();
    }
}