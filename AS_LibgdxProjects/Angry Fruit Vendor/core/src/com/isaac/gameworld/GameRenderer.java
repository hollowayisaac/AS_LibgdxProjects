package com.isaac.gameworld;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.environment.EnvironmentHandler;
import com.isaac.environment.EnvironmentValues;
import com.isaac.environment.Grass;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.InputHandler;
import com.isaac.tweenaccessors.Value;
import com.isaac.tweenaccessors.ValueAccessor;
import com.isaac.ui.SimpleButton;

import java.util.List;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

public class GameRenderer {

    private GameWorld world;
    /*private OrthographicCamera cam;*/
    private ShapeRenderer shapeRenderer;

    private GameCamera gameCamera;
    private Matrix4 matrix = new Matrix4();

    private SpriteBatch batch;

    /*private int midPointY;*/

    // Game Objects
    /*private Bird bird;
    private ScrollHandler scroller;
    private Pipe pipe1, pipe2, pipe3;*/

    private EnvironmentHandler environmentHandler;
    private Grass grass;

    // Game Assets
    private TextureRegion trBg, trGrass, birdMid, skullUp, skullDown, bar;
    private Animation birdAnimation;

    // Tween stuff
    private TweenManager manager;
    private Value alpha = new Value();

    // Buttons
    private List<SimpleButton> menuButtons;

    public GameRenderer(GameWorld world) {
        this.world = world;

        this.menuButtons = ((InputHandler) Gdx.input.getInputProcessor())
                .getMenuButtons();

        Matrix4 projection = new Matrix4();
        projection.setToOrtho(0, EnvironmentValues.GAME_WIDTH, 0, EnvironmentValues.GAME_HEIGHT, -1, 1);
        batch = new SpriteBatch(100);
        batch.setProjectionMatrix(projection);

        this.gameCamera = new GameCamera(EnvironmentValues.GAME_WIDTH, EnvironmentValues.GAME_HEIGHT);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(projection);

/*
        cam = new OrthographicCamera();
        cam.setToOrtho(true, EnvironmentValues.GAME_WIDTH, EnvironmentValues.GAME_HEIGHT);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
*/
/*        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(matrix);*/

        initGameObjects();
        initAssets();
        setupTweens();
    }

    private void setupTweens() {
        Tween.registerAccessor(Value.class, new ValueAccessor());
        manager = new TweenManager();
        Tween.to(alpha, -1, .5f).target(0).ease(TweenEquations.easeOutQuad)
                .start(manager);
    }

    private void initGameObjects() {
        environmentHandler = world.getEnvironmentHandler();
        grass = environmentHandler.getGrass();

/*        bird = myWorld.getBird();
        scroller = myWorld.getScroller();
        frontGrass = scroller.getFrontGrass();
        backGrass = scroller.getBackGrass();
        pipe1 = scroller.getPipe1();
        pipe2 = scroller.getPipe2();
        pipe3 = scroller.getPipe3();*/
    }

    private void initAssets() {
/*        trBg = AssetLoader.bg;
        trGrass = AssetLoader.grass;
        birdAnimation = AssetLoader.birdAnimation;
        birdMid = AssetLoader.bird;
        skullUp = AssetLoader.skullUp;
        skullDown = AssetLoader.skullDown;
        bar = AssetLoader.bar;*/
    }

    /**
     * render
     *
     * @param delta
     * @param runTime
     */
    public void render(float delta, float runTime) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeType.Filled);

        // Draw Background color
        //shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        //shapeRenderer.rect(EnvironmentValues.ARENA_X, EnvironmentValues.ARENA_Y, EnvironmentValues.ARENA_WIDTH, EnvironmentValues.ARENA_HEIGHT);

        // Draw BG Grass
        //shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        //shapeRenderer.rect(EnvironmentValues.GRASS_X, EnvironmentValues.GRASS_Y, EnvironmentValues.GRASS_WIDTH, EnvironmentValues.GRASS_HEIGHT);

        // ***DEV_MODE***
        drawDEV_LOCS();

        shapeRenderer.end();

        //////////////////
        matrix.idt();
        matrix.setToTranslation(gameCamera.x, gameCamera.y, 0);
        batch.setTransformMatrix(matrix);
        /////////////

        batch.begin();
        batch.disableBlending();
        batch.enableBlending();

        // Level Background
        world.getGameMode().renderGameModeBG(delta, batch);

        // Level
        world.getGameMode().renderGameMode(delta, batch);

        // Trampoline
        world.getTrampoline().draw(runTime, batch);

/*        // Draw Game Objects
        for (int i = 0; i < world.getGameObjects().size(); i++) {
*//*            GameObject gameObject = world.getGameObjects().get(i);
            gameObject.draw(runTime, batch);*//*
        }*/

        // Fruits
        for (int i = 0; i < world.getActiveFruits().size; i++) {
            Fruit fruit = world.getActiveFruits().get(i);
            fruit.draw(runTime, batch);
        }

        // Draw Level
        world.getGameMode().renderGameMode(delta, batch);

        // Draw Score
        drawScore();

        // Draw Streak
        drawStreak();

        // Draw Lives
        drawLives();

        // ***DEV_MODE***
        drawDEV_TEXT();

        batch.end();
        drawTransition(delta);
    }

    /**
     * drawScore
     */
    private void drawScore() {
        AssetLoader.shadow.draw(batch, "" + world.getDisplayedScoreText(),
                0, EnvironmentValues.ARENA_HEIGHT);
        AssetLoader.font.draw(batch, "" + world.getDisplayedScoreText(),
                0, EnvironmentValues.ARENA_HEIGHT);
    }

    /**
     * drawLives
     */
    private void drawLives(){
        AssetLoader.shadow.draw(batch, "" + world.getDisplayedLivesText(),
                300, EnvironmentValues.ARENA_HEIGHT);
        AssetLoader.font.draw(batch, "" + world.getDisplayedLivesText(),
                300, EnvironmentValues.ARENA_HEIGHT);
    }

    /**
     * drawStreak
     */
    private void drawStreak(){
        // Draw the Streak Text
        AssetLoader.shadow.draw(batch, "" + world.getDisplayedStreakText(),
                150, EnvironmentValues.ARENA_HEIGHT);
        AssetLoader.font.draw(batch, "" + world.getDisplayedStreakText(),
                150, EnvironmentValues.ARENA_HEIGHT);
    }

    /**
     * drawDEV_TEXT
     */
    private void drawDEV_TEXT() {
        if(AngryFVGame.DEV_MODE) {
            // Current Fruit Toss interval
            AssetLoader.shadow.draw(batch, "" + world.currentFruitTossInterval,
                    0, EnvironmentValues.ARENA_HEIGHT/2);
            AssetLoader.font.draw(batch, "" + world.currentFruitTossInterval,
                    0, EnvironmentValues.ARENA_HEIGHT/2);

            // Time until next fruit toss
            AssetLoader.shadow.draw(batch, "" + world.timeUntilNextFruitToss,
                    0, EnvironmentValues.ARENA_HEIGHT-100);
            AssetLoader.font.draw(batch, "" + world.timeUntilNextFruitToss,
                    0, EnvironmentValues.ARENA_HEIGHT-100);
        }
    }

    /**
     * drawDEV_LOCS
     */
    private void drawDEV_LOCS() {
        if(AngryFVGame.DEV_MODE) {
            // Fruit ALLOWED Bounce Lines
            if (world.getTrampoline().isStunned()){
                shapeRenderer.setColor(Color.GREEN);
            }else {
                shapeRenderer.setColor(Color.RED);
            }
            shapeRenderer.line(world.getTrampoline().getX(), EnvironmentValues.TRAMPOLINE_TOP_COLLISION_Y, world.getTrampoline().getX() + EnvironmentValues.TRAMPOLINE_WIDTH, EnvironmentValues.TRAMPOLINE_TOP_COLLISION_Y);
            shapeRenderer.line(world.getTrampoline().getX(), EnvironmentValues.TRAMPOLINE_BOTTOM_COLLISION_Y, world.getTrampoline().getX() + EnvironmentValues.TRAMPOLINE_WIDTH, EnvironmentValues.TRAMPOLINE_BOTTOM_COLLISION_Y);
            //shapeRenderer.rect(world.getTrampoline().getX(), EnvironmentValues.GRASS_Y, EnvironmentValues.GRASS_WIDTH, EnvironmentValues.GRASS_HEIGHT);

            // Fruit PEAK Lines
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.line(0, EnvironmentValues.SMALL_PEAK, EnvironmentValues.ARENA_WIDTH,  EnvironmentValues.SMALL_PEAK);
            //shapeRenderer.line(0, EnvironmentValues.TRAMPOLINE_BOTTOM_COLLISION_Y, world.getTrampoline().getX() + EnvironmentValues.TRAMPOLINE_WIDTH, EnvironmentValues.TRAMPOLINE_BOTTOM_COLLISION_Y);
        }
    }

    private void drawTransition(float delta) {
        if (alpha.getValue() > 0) {
            manager.update(delta);
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.setColor(1, 1, 1, alpha.getValue());
            shapeRenderer.rect(0, 0, 136, 300);
            shapeRenderer.end();
            Gdx.gl.glDisable(GL20.GL_BLEND);

        }
    }

}
