package com.isaac.renderers;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */

import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes._GameMode;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.screens.GameScreen;

public class GameRenderer extends _Renderer {

    /**
     * [CONSTRUCTOR]
     */
    public GameRenderer(GameScreen gameScreen) {
        super(gameScreen);
    }

    /***/
    private GameScreen getGameScreen() {
        return (GameScreen) screen;
    }

    /***/
    private _GameMode getGameMode(){
        return getGameScreen().gameMode;
    }

    /***/
    @Override
    protected void drawBackground(float delta) {
        getGameScreen().gameMode.renderGameModeBG(delta, this);
    }

    /***/
    @Override
    protected void drawEverythingElse(float delta) {
        switch (getGameScreen().getGameState()) {
            //////////////////////////////////   ~ [Game Running] ~   ////
            case RUNNING:

                // Level Background


                // Level
                getGameMode().renderGameMode(delta, this);

                // Trampoline
                getGameMode().getTrampoline().draw(screen.runTime, this);

                // Fruits
                for (int i = 0; i < getGameMode().getActiveFruits().size; i++) {
                    Fruit fruit = getGameScreen().gameMode.getActiveFruits().get(i);
                    fruit.draw(screen.runTime, this);
                }

                // GameMode/Level
                getGameMode().renderGameMode(delta, this);

                // [TEXT] Score
                drawScore();

                // [TEXT] Streak
                drawStreak();

                // [TEXT] Lives
                drawLives();

                // [TEXT] DEV STUFF
                draw__DEVMODE__TEXT();
                break;

            case PAUSED:
                break;
        }
    }


    /**
     * @param xLoc
     * @param yLoc
     * @param text
     */
    public void drawText_Wag(float xLoc, float yLoc, String text) {
        AssetLoader.ftWag.draw(getSpriteBatch(), text, xLoc, yLoc);
    }


    /***/
    private void drawScore() {
        AssetLoader.ftWag.draw(getSpriteBatch(), "" + getGameMode().getDisplayedScoreText(),
                0, GameValues.ARENA_HEIGHT);
    }


    /***/
    private void drawLives() {
        AssetLoader.ftWag.draw(getSpriteBatch(), "" + getGameMode().getDisplayedLivesText(),
                300, GameValues.ARENA_HEIGHT);
    }


    /***/
    private void drawStreak() {
        // Draw the Streak Text
        AssetLoader.ftWag.draw(getSpriteBatch(), "" + getGameMode().getDisplayedStreakText(),
                150, GameValues.ARENA_HEIGHT);
    }


    /***/
    private void draw__DEVMODE__TEXT() {
        if (AngryFVGame.DEV_MODE) {
            // Current Fruit Toss interval
            AssetLoader.ftWag.draw(getSpriteBatch(), "" + getGameMode().currentFruitTossInterval,
                    0, GameValues.ARENA_HEIGHT / 2);

            // Time until next fruit toss
            AssetLoader.ftWag.draw(getSpriteBatch(), "" + getGameMode().timeUntilNextFruitToss,
                    0, GameValues.ARENA_HEIGHT - 100);
        }
    }

/*    *//***//*
    private void drawDEV_LOCS() {
        if (AngryFVGame.DEV_MODE) {
            // Fruit ALLOWED Bounce Lines
            if (gameScreen.gameMode.getTrampoline().isStunned()) {
                shapeRenderer.setColor(Color.GREEN);
            } else {
                shapeRenderer.setColor(Color.RED);
            }
            shapeRenderer.line(gameScreen.gameMode.getTrampoline().getX(), GameValues.TRAMPOLINE_TOP_COLLISION_Y, gameScreen.gameMode.getTrampoline().getX() + GameValues.TRAMPOLINE_WIDTH, GameValues.TRAMPOLINE_TOP_COLLISION_Y);
            shapeRenderer.line(gameScreen.gameMode.getTrampoline().getX(), GameValues.TRAMPOLINE_BOTTOM_COLLISION_Y, gameScreen.gameMode.getTrampoline().getX() + GameValues.TRAMPOLINE_WIDTH, GameValues.TRAMPOLINE_BOTTOM_COLLISION_Y);

            // Fruit PEAK Lines
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.line(0, GameValues.SMALL_PEAK, GameValues.ARENA_WIDTH, GameValues.SMALL_PEAK);
        }
    }*/

}
