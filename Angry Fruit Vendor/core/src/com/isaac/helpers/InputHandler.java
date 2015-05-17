package com.isaac.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.isaac.gamemodes.StageMode;
import com.isaac.gameworld.GameWorld;
import com.isaac.ui.SimpleButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
public class InputHandler implements InputProcessor {
    private GameWorld world;

    private float scaleFactorX;
    private float scaleFactorY;

    public List<SimpleButton> menuButtons;
    private SimpleButton playButton;

    public InputHandler(GameWorld myWorld, float scaleFactorX, float scaleFactorY) {


        this.world = myWorld;
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;

        menuButtons = new ArrayList<SimpleButton>();
        playButton = new SimpleButton(100,100,100,35, AssetLoader.trBanana, AssetLoader.trWatermelon);
        //playButton = new SimpleButton(
//                136 / 2 - (AssetLoader.playButtonUp.getRegionWidth() / 2),
//                GameValues.GAME_MIDPOINT_Y + 50, 29, 16, AssetLoader.trBanana,
//                AssetLoader.grass);
        menuButtons.add(playButton);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
/*        screenX = scaleX(screenX);
        screenY = scaleY(screenY);*/


        Vector3 unprojectedScreen = new Vector3(Gdx.input.getX(), Gdx.input.getY(),0);
        world.gameRenderer.gameCamera.unproject(unprojectedScreen);
        /*renderer.matrix.idt();
        renderer.matrix.setToTranslation(renderer.gameCamera.x, renderer.gameCamera.y, 0);*/

        if (world.getGameState() == GameWorld.GameState.MENU) {

//            if (playButton.isTouchDown(screenX, screenY)) {
            if (playButton.isTouchDown((int)unprojectedScreen.x,(int) unprojectedScreen.y)) {
                playButton.isPressed = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        if (world.getGameState() == GameWorld.GameState.RUNNING) {
            world.setGameState(GameWorld.GameState.PAUSED);
        } else if (world.getGameState() == GameWorld.GameState.PAUSED) {
            world.setGameState(GameWorld.GameState.RUNNING);
        }

        if (world.getGameState() == GameWorld.GameState.MENU) {
            //boolean isTouchUp =
            if (playButton.isTouchUp(screenX, screenY)) {
                world.setGameState(GameWorld.GameState.RUNNING);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (world.getGameState() == GameWorld.GameState.RUNNING) {

            switch (keycode) {
                // Move Left
                case Input.Keys.LEFT:
                    world.getTrampoline().onInput_Left();
                    break;

                // Move Right
                case Input.Keys.RIGHT:
                    world.getTrampoline().onInput_Right();
                    break;

                // Prev Level
                case Input.Keys.FORWARD_DEL:
                    StageMode sm = (StageMode) world.getGameMode();
                    if (sm.getCurrentLevelIndex() != 0) {
                        sm.setCurrentLevel(sm.getCurrentLevelIndex() - 1);
                    }
                    break;

                // Next Level
                case Input.Keys.END:
                    StageMode sm1 = (StageMode) world.getGameMode();
                    sm1.advanceCurrentLevel();
                    break;
            }

//            // Start Game
//            case Input.Keys.SPACE:
//                if (world.isReady()) {
//                    world.start();
//                }
//                break;


          /*  // Restart Game
            case Input.Keys.UP:
                if (world.isReady() || world.isRunning()) {
                    world.restart();
                }
                break;*/
        }

/*        // Can now use Space Bar to play the game
        if (keycode == Input.Keys.SPACE) {

            if (myWorld.isMenu()) {
                myWorld.ready();
            } else if (myWorld.isReady()) {
                myWorld.start();
            }

*//*            myBird.onClick();*//*

            if (myWorld.isGameOver() || myWorld.isHighScore()) {
                myWorld.restart();
            }
        }*/

        return false;
    }


    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private int scaleX(int screenX) {

        return (int)(screenX / scaleFactorX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleFactorY);
    }

//    private int scaleX(int screenX) {
//        return (int) (screenX / scaleFactorX);
//    }
//
//    private int scaleY(int screenY) {
//        return (int) (screenY / scaleFactorY);
//    }

    public List<SimpleButton> getMenuButtons() {
        return menuButtons;
    }
}