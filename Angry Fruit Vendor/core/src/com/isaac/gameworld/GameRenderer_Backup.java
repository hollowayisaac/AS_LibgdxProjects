package com.isaac.gameworld;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.InputHandler;
import com.isaac.ui.SimpleButton;

import java.util.List;

public class GameRenderer_Backup {

    private GameWorld world;

    public SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    public GameCamera gameCamera;
    public Matrix4 matrix = new Matrix4();

    // Buttons
    private List<SimpleButton> menuButtons;

    /**
     * [CONSTRUCTOR]
     */
    public GameRenderer_Backup(GameWorld world) {
        this.world = world;

        this.menuButtons = ((InputHandler) Gdx.input.getInputProcessor())
                .getMenuButtons();

        Matrix4 projection = new Matrix4();
        projection.setToOrtho(0, GameValues.GAMEUNIT_WIDTH, 0, GameValues.GAMEUNIT_HEIGHT, -1, 1);
        batch = new SpriteBatch(100);
        batch.setProjectionMatrix(projection);

        this.gameCamera = new GameCamera(GameValues.GAMEUNIT_WIDTH, GameValues.GAMEUNIT_HEIGHT);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(projection);
    }

    /**
     * @param xLoc
     * @param yLoc
     * @param text
     */
    public void drawText_Wag(float xLoc, float yLoc, String text){
        AssetLoader.ftWag.draw(batch, text, xLoc, yLoc);
    }


    /**
     * @param delta
     * @param runTime
     */
    public void render(float delta, float runTime) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Renders shapes
        shapeRenderer.begin(ShapeType.Filled);

        // ***DEV_MODE***
        drawDEV_LOCS();
        shapeRenderer.end();

        // Init
        matrix.idt();
        matrix.setToTranslation(gameCamera.x, gameCamera.y, 0);
        batch.setTransformMatrix(matrix);
        batch.begin();
        batch.disableBlending();
        batch.enableBlending();
/*
        switch (world.getGameState()){
            //////////////////////////////////   ~ [Main Menu] ~   ////
            case MENU:
                batch.draw(AssetLoader.trApple, GameValues.ARENA_X, GameValues.ARENA_Y, GameValues.ARENA_WIDTH/2, GameValues.ARENA_HEIGHT/2,
                        GameValues.ARENA_WIDTH, GameValues.ARENA_HEIGHT,1, 1, 0, true);
                for (int i = 0; i < menuButtons.size(); i++) {
                    SimpleButton button = menuButtons.get(i);
                    button.draw(batch);
                }
                break;

            case PAUSED:
                world.setGameState(GameScreen.GameState.RUNNING);
            //////////////////////////////////   ~ [Game Running] ~   ////
            case RUNNING:

                // Level Background
*//*                world.getGameMode().renderGameModeBG(delta, this);

                // Level
                world.getGameMode().renderGameMode(delta, this);

                // Trampoline
                world.getTrampoline().draw(runTime, this);

                // Fruits
                for (int i = 0; i < world.getActiveFruits().size; i++) {
                    Fruit fruit = world.getActiveFruits().get(i);
                    fruit.draw(runTime, this);
                }

                // GameMode/Level
                world.getGameMode().renderGameMode(delta, this);*//*

                // [TEXT] Score
                drawScore();

                // [TEXT] Streak
                drawStreak();

                // [TEXT] Lives
                drawLives();

                // [TEXT] DEV STUFF
                draw__DEVMODE__TEXT();

                break;

            case HIGHSCORE:
                break;

            case GAMEOVER:
                break;
        }
        batch.end();*/
    }


    /***/
    private void drawScore() {
        AssetLoader.ftWag.draw(batch, "" + world.getDisplayedScoreText(),
                0, GameValues.ARENA_HEIGHT);
    }


    /***/
    private void drawLives(){
        AssetLoader.ftWag.draw(batch, "" + world.getDisplayedLivesText(),
                300, GameValues.ARENA_HEIGHT);
    }


    /***/
    private void drawStreak(){
        // Draw the Streak Text
        AssetLoader.ftWag.draw(batch, "" + world.getDisplayedStreakText(),
                150, GameValues.ARENA_HEIGHT);
    }


    /***/
    private void draw__DEVMODE__TEXT() {
        if(AngryFVGame.DEV_MODE) {
            // Current Fruit Toss interval
            AssetLoader.ftWag.draw(batch, "" + world.currentFruitTossInterval,
                    0, GameValues.ARENA_HEIGHT/2);

            // Time until next fruit toss
            AssetLoader.ftWag.draw(batch, "" + world.timeUntilNextFruitToss,
                    0, GameValues.ARENA_HEIGHT - 100);
        }
    }


    /***/
    private void drawDEV_LOCS() {
        if(AngryFVGame.DEV_MODE) {
            // Fruit ALLOWED Bounce Lines
            if (world.getTrampoline().isStunned()){
                shapeRenderer.setColor(Color.GREEN);
            }else {
                shapeRenderer.setColor(Color.RED);
            }
            shapeRenderer.line(world.getTrampoline().getX(), GameValues.TRAMPOLINE_TOP_COLLISION_Y, world.getTrampoline().getX() + GameValues.TRAMPOLINE_WIDTH, GameValues.TRAMPOLINE_TOP_COLLISION_Y);
            shapeRenderer.line(world.getTrampoline().getX(), GameValues.TRAMPOLINE_BOTTOM_COLLISION_Y, world.getTrampoline().getX() + GameValues.TRAMPOLINE_WIDTH, GameValues.TRAMPOLINE_BOTTOM_COLLISION_Y);

            // Fruit PEAK Lines
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.line(0, GameValues.SMALL_PEAK, GameValues.ARENA_WIDTH,  GameValues.SMALL_PEAK);
        }
    }
}
