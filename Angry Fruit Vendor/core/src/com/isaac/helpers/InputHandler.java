package com.isaac.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
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

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

/*        if (world.getGameState() == GameScreen.GameState.RUNNING) {
            world.setGameState(GameScreen.GameState.PAUSED);
        } else if (world.getGameState() == GameScreen.GameState.PAUSED) {
            world.setGameState(GameScreen.GameState.RUNNING);
        }

        if (world.getGameState() == GameScreen.GameState.MENU) {
            //boolean isTouchUp =
            if (playButton.isTouchUp(screenX, screenY)) {
                world.setGameState(GameScreen.GameState.RUNNING);
                return true;
            }
        }*/

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
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
        return  false;
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