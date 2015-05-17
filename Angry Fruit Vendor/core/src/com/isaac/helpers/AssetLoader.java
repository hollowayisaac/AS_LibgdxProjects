package com.isaac.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

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

    // Textures
    public static Texture texture, logoTexture;

    // Animations
    public static Animation birdAnimation;

    // Sound
    public static Sound dead, flap, coin;

    // Font
    public static BitmapFont ftWag; //(Wag) White and Gray

    // Preferences
    private static Preferences prefs;

    /***/
    public static void load() {
        load_Preferences();
        load_Fonts();
        load_Skins();
        load_Sound();
        load_Images();
    }

    /***/
    private static void load_Preferences() {
        // Create (or retrieve existing) preferences file
        prefs = Gdx.app.getPreferences("ZombieBird");

        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }
    }


    /***/
    private static void load_Fonts() {
        ftWag = new BitmapFont(Gdx.files.internal("fonts/simple1.fnt"));
        ftWag.setScale(.5f, .5f);
    }


    /***/
    private static void load_Skins() {

    }


    /***/
    private static void load_Sound() {
        dead = Gdx.audio.newSound(Gdx.files.internal("sound/dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("sound/flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("sound/coin.wav"));
    }


    /***/
    private static void load_Images() {
        texture = new Texture(Gdx.files.internal("images/flappy-bird-texture.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

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
    }


    public static void setHighScore(int val) {
        prefs.putInteger("highScore", val);
        prefs.flush();
    }


    public static int getHighScore() {
        return prefs.getInteger("highScore");
    }


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