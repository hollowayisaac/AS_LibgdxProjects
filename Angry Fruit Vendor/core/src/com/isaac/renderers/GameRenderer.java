package com.isaac.renderers;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */

import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.gamemodes._GameMode;
import com.isaac.gameobjects.FallingObject;
import com.isaac.gameobjects.FloatingText;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.screens.GameScreen;
import com.isaac.ui._Button;

import java.util.List;

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
        return getGameScreen().currentGameMode;
    }

    /***/
    @Override
    protected void drawBackground(float delta) {
        getGameScreen().currentGameMode.renderGameModeBG(delta, this);
    }

    /***/
    @Override
    protected void drawEverythingElse(float delta) {
        switch (getGameScreen().getGameState()) {
            case MENU:

            //////////////////////////////////   ~ [Game Running] ~   ////
            case RUNNING:
                // Enter Hole
                float enterHoleX = GameValues.FRUIT_STARTING_X;
                float enterHoleY = GameValues.GAME_Y + 125;
                float enterHoleHeight = 170;
                float enterHoleWidth = (enterHoleHeight * (.364f));

                // Exit Hole
                float exitHoleWidth =  80;
                float exitHoleHeight = (exitHoleWidth * (.577f));
                float exitHoleX = GameValues.GAME_WIDTH - (exitHoleWidth + 25);
                float exitHoleY = 0;

                // Level
                getGameMode().renderGameMode(delta, this);

                // White Border
                getSpriteBatch().draw(
                        AssetLoader.trWhiteBorder,
                        0,
                        0,
                        GameValues.GAME_WIDTH,
                        GameValues.GAME_HEIGHT);

                // Trampoline
                getGameMode().getTrampoline().draw(delta, this);

                // Fruit vendor
                getGameMode().getFruitVendor().draw(delta, this);

                // Enter Hole Back
                getSpriteBatch().draw(
                        AssetLoader.trEnterHoleBack,
                        enterHoleX,
                        enterHoleY,
                        enterHoleWidth,
                        enterHoleHeight);

                // Exit Hole Back
                getSpriteBatch().draw(
                        AssetLoader.trExitHoleBack,
                        exitHoleX,
                        exitHoleY,
                        exitHoleWidth,
                        exitHoleHeight);

                // Fruits
                for (int i = 0; i < getGameMode().getActiveFruits().size; i++) {
                    Fruit fruit = getGameScreen().currentGameMode.getActiveFruits().get(i);
                    fruit.draw(delta, this);
                }

                // Enter Hole Front
                getSpriteBatch().draw(
                        AssetLoader.trEnterHoleFront,
                        enterHoleX,
                        enterHoleY,
                        enterHoleWidth,
                        enterHoleHeight);

                // Exit Hole Front
                getSpriteBatch().draw(
                        AssetLoader.trExitHoleFront,
                        exitHoleX,
                        exitHoleY,
                        exitHoleWidth,
                        exitHoleHeight);


                // Falling Objects
                for (int i = 0; i < getGameMode().getFallingObjects().size; i++) {
                    FallingObject fallingObject = getGameScreen().currentGameMode.getFallingObjects().get(i);
                    fallingObject.draw(delta, this);
                }

                // Floating Texts
                for (int i = 0; i < getGameMode().getFloatingTexts().size; i++) {
                    FloatingText floatingText = getGameScreen().currentGameMode.getFloatingTexts().get(i);
                    floatingText.draw(delta, this);
                }

                // GameMode/Level
                //getGameMode().renderGameMode(delta, this);

                // [TEXT] Score
                drawScore();

                // [TEXT] Streak
                //drawStreak();

                // [TEXT] Lives
                drawLives();

                // [TEXT] DEV STUFF
                //draw__DEVMODE__TEXT();

                // Draw the Top Menu
                drawButtons(delta);

                break;
        }
    }

    /***/
    private void drawButtons(float delta) {
        List<_Button> buttons = getGameScreen().buttons;
        for (int i = 0; i < buttons.size(); i++){
            buttons.get(i).draw(delta, getSpriteBatch());
            if (getGameScreen().getGameState() == GameScreen.GameState.MENU && i == 2){
                int f = 3;
            }
        }
    }

    /***/
    public void drawText_Wag(float xLoc, float yLoc, String text) {
        AssetLoader.ftWag.draw(getSpriteBatch(), text, xLoc, yLoc);
    }

    /***/
    private void drawScore() {
        // Border Size
        float scoreBGWidth = 90;
        float scoreBGHeight = scoreBGWidth * .55f;

        //// Score ////
        // Header
        float scoreTextX =  GameValues.GAME_WIDTH - (scoreBGWidth + 25);
        float scoreTextY = GameValues.GAME_HEIGHT - (5);
        // Border
        float scoreBGX =  scoreTextX;
        float scoreBGY =  scoreTextY - 75;
        // Val
        float scoreValueX =  scoreBGX + 10;
        float scoreValueY =  (scoreBGY) + 35;

        //// Lives ////
        // Header
        float livesTextX =  GameValues.GAME_X + (100);
        float livesTextY = scoreTextY;
        // Border
        float livesBGX =  livesTextX;
        float livesBGY =  livesTextY -  75;
        // Val
        float livesValueX =  livesBGX + 10;
        float livesValueY =  (livesBGY) + 35;

        getSpriteBatch().draw(
                AssetLoader.trScoreBG,
                scoreBGX,
                scoreBGY,
                scoreBGWidth,
                scoreBGHeight);

        //AssetLoader.ftWagScore.draw(getSpriteBatch(), "" + getGameMode().getDisplayedScoreText(),
        // Score Header Text
        AssetLoader.ftWagScore.draw(getSpriteBatch(), "Score",
                scoreTextX,
                scoreTextY);

        // Score Value
        AssetLoader.ftWagScore.draw(getSpriteBatch(), "" + getGameMode().getScoreText(),
                scoreValueX,
                scoreValueY);

        getSpriteBatch().draw(
                AssetLoader.trScoreBG,
                livesBGX,
                livesBGY,
                scoreBGWidth,
                scoreBGHeight);

        // Lives Header Text
        AssetLoader.ftWagScore.draw(getSpriteBatch(), "Lives",
                livesTextX,
                livesTextY);

        // Lives Value
        AssetLoader.ftWagScore.draw(getSpriteBatch(), "" + getGameMode().getLivesLeft(),
                livesValueX,
                livesValueY);
    }

    /***/
    private void drawLives() {
/*        AssetLoader.ftWag.draw(getSpriteBatch(), "" + getGameMode().getDisplayedLivesText(),
                300, GameValues.GAME_HEIGHT);*/
    }

    /***/
    private void drawStreak() {
        // Draw the Streak Text
        AssetLoader.ftWag.draw(getSpriteBatch(), "" + getGameMode().getDisplayedStreakText(),
                150, GameValues.GAME_HEIGHT);
    }

    /***/
    private void draw__DEVMODE__TEXT() {
        if (AngryFVGame.DEV_MODE) {
            // Current Fruit Toss interval
            AssetLoader.ftWag.draw(getSpriteBatch(), "" + getGameMode().currentFruitTossInterval,
                    0, GameValues.GAME_HEIGHT / 2);

            // Time until next fruit toss
            AssetLoader.ftWag.draw(getSpriteBatch(), "" + getGameMode().timeUntilNextFruitToss,
                    0, GameValues.GAME_HEIGHT - 100);
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
