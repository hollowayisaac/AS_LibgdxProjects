package com.isaac.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
public class AssetLoader {
    public static TextureRegion trApple;
    public static TextureRegion trWatermelon;
    public static TextureRegion trOrange;
    public static TextureRegion trBanana;
    public static TextureRegion trRottenFruit;
    public static TextureRegion trBasket;

    public static TextureRegion trSoundON, trSoundOFF;
    public static TextureRegion trPlusOne;
    public static TextureRegion trEnterHoleFront;
    public static TextureRegion trEnterHoleBack;
    public static TextureRegion trExitHoleFront;
    public static TextureRegion trExitHoleBack;
    public static TextureRegion trWhiteBorder;
    public static TextureRegion trScoreBG;

    public static Texture tArrowLeftUp;
    public static Texture tArrowRightUp;
    public static Texture tCancel_Up;
    public static Texture tCancel_Down;

    // Skin
    public static Skin defaultSkin;

    // Animations
    public static Animation trampolineBounceAnimation;
    public static TextureAtlas trampolineBounceAtlas;
    public static Animation cannonAnimation;
    public static TextureAtlas cannonAtlas;

    // Sound
    public static Sound dead, flap, coin;

    // Font
    public static BitmapFont ftWag; //(Wag) White and Gray
    public static BitmapFont ftWagScore;
    public static BitmapFont ftWagPlusOne;
    public static BitmapFont ftPlainBlack;

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

        ftWagPlusOne = new BitmapFont(Gdx.files.internal("fonts/simple1.fnt"));
        ftWagPlusOne.setScale(1.75f, 1.75f);

        ftWagScore = new BitmapFont(Gdx.files.internal("fonts/simple1.fnt"));
        ftWagScore.setScale(1f, 1f);

        ftPlainBlack = new BitmapFont(Gdx.files.internal("fonts/plain-black.fnt"));
        ftPlainBlack.setScale(1, 1);
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
        textButtonStyle.up = defaultSkin .newDrawable("white", Color.BLACK);
        textButtonStyle.down = defaultSkin .newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.checked = defaultSkin .newDrawable("white", Color.BLUE);
        textButtonStyle.over = defaultSkin .newDrawable("white", Color.LIGHT_GRAY);
        textButtonStyle.font = defaultSkin .getFont("default");
        textButtonStyle.font.setScale(2);
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

        //// Buttons ////
        tCancel_Up = new Texture(Gdx.files.internal("buttons/cancel-up.png"));
        tCancel_Down = new Texture(Gdx.files.internal("buttons/cancel-down.png"));

        tArrowLeftUp = new Texture(Gdx.files.internal("buttons/left-arrow-up.png"));
        tArrowRightUp = new Texture(Gdx.files.internal("buttons/right-arrow-up.png"));

        Texture tPlusOne = new Texture(Gdx.files.internal("images/plus-one.png"));
        tPlusOne.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trPlusOne = new TextureRegion(tPlusOne, 0, 0, tPlusOne.getWidth(), tPlusOne.getHeight());

        Texture tSoundON = new Texture(Gdx.files.internal("images/SoundON.png"));
        tSoundON.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trSoundON = new TextureRegion(tSoundON, 0, 0, tSoundON.getWidth(), tSoundON.getHeight());

        Texture tSoundOFF = new Texture(Gdx.files.internal("images/SoundOFF.png"));
        tSoundOFF.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trSoundOFF= new TextureRegion(tSoundOFF, 0, 0, tSoundON.getWidth(), tSoundON.getHeight());

        // Fruits //
        Texture tApple = new Texture(Gdx.files.internal("images/apple.png"));
        tApple.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trApple = new TextureRegion(tApple, 0, 0, tApple.getWidth(), tApple.getHeight());

        Texture tOrange = new Texture(Gdx.files.internal("images/orange.png"));
        tOrange.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trOrange = new TextureRegion(tOrange, 0, 0, tOrange.getWidth(), tOrange.getHeight());

        Texture tWatermelon = new Texture(Gdx.files.internal("images/watermelon.png"));
        tWatermelon.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trWatermelon = new TextureRegion(tWatermelon, 0, 0, tWatermelon.getWidth(), tWatermelon.getHeight());

        Texture tBanana = new Texture(Gdx.files.internal("images/banana.png"));
        tBanana.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trBanana = new TextureRegion(tBanana, 0, 0, tBanana.getWidth(), tBanana.getHeight());

        Texture tRottenFruit = new Texture(Gdx.files.internal("images/rotten-fruit.png"));
        tRottenFruit.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trRottenFruit = new TextureRegion(tRottenFruit, 0, 0, tRottenFruit.getWidth(), tRottenFruit.getHeight());

        Texture tBasket = new Texture(Gdx.files.internal("images/fruit-basket.png"));
        tBasket.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trBasket = new TextureRegion(tBasket, 0, 0, tBasket.getWidth(), tBasket.getHeight());

        Texture tEnterHoleFront = new Texture(Gdx.files.internal("images/hole-front.png"));
        tEnterHoleFront.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trEnterHoleFront = new TextureRegion(tEnterHoleFront, 0, 0, tEnterHoleFront.getWidth(), tEnterHoleFront.getHeight());

        Texture tEnterHoleBack = new Texture(Gdx.files.internal("images/hole-back.png"));
        tEnterHoleBack.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trEnterHoleBack = new TextureRegion(tEnterHoleBack, 0, 0, tEnterHoleBack.getWidth(), tEnterHoleBack.getHeight());

        Texture tExitHoleFront = new Texture(Gdx.files.internal("images/exit-hole-front.png"));
        tExitHoleFront.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trExitHoleFront = new TextureRegion(tExitHoleFront, 0, 0, tExitHoleFront.getWidth(), tExitHoleFront.getHeight());

        Texture tExitHoleBack = new Texture(Gdx.files.internal("images/exit-hole-back.png"));
        tExitHoleBack.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trExitHoleBack = new TextureRegion(tExitHoleBack, 0, 0, tExitHoleBack.getWidth(), tExitHoleBack.getHeight());

        Texture tWhiteBorder = new Texture(Gdx.files.internal("images/whiteborder.png"));
        tWhiteBorder.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trWhiteBorder = new TextureRegion(tWhiteBorder, 0, 0, tWhiteBorder.getWidth(), tWhiteBorder.getHeight());

        Texture tScoreBG = new Texture(Gdx.files.internal("images/Score-BG.png"));
        tScoreBG.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        trScoreBG = new TextureRegion(tScoreBG, 0, 0, tScoreBG.getWidth(), tScoreBG.getHeight());

        //// Animations ////
        trampolineBounceAtlas = new TextureAtlas(Gdx.files.internal("animation/trampolinebounce.atlas"));
        trampolineBounceAnimation = new Animation(0.06f, trampolineBounceAtlas.getRegions());
        trampolineBounceAnimation.setPlayMode(Animation.PlayMode.NORMAL);

/*        cannonAtlas = new TextureAtlas(Gdx.files.internal("animation/cannon.atlas"));
        cannonAnimation = new Animation(0.06f, cannonAtlas.getRegions());
        cannonAnimation.setPlayMode(Animation.PlayMode.NORMAL);*/
    }

    /***/
    public static void dispose() {
        // We must dispose of the texture when we are finished.
        // Insert Textures Here...

        // Animations Atlas's
        trampolineBounceAtlas.dispose();
        cannonAtlas.dispose();

        // Font's
        ftWag.dispose();

        // Dispose sounds
        dead.dispose();
        flap.dispose();
        coin.dispose();
    }
}