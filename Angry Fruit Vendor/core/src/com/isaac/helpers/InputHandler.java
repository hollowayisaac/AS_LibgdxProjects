package com.isaac.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.isaac.environment.EnvironmentValues;
import com.isaac.gamemodes.StageMode;
import com.isaac.gameworld.GameWorld;
import com.isaac.ui.SimpleButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isaac Holloway on 11/12/2014.
 */
public class InputHandler implements InputProcessor {
    /*    private Bird myBird;*/
    private GameWorld world;

    private List<SimpleButton> menuButtons;

    private SimpleButton playButton;

/*    private float scaleFactorX = EnvironmentValues.GRASS_WIDTH / Gdx.graphics.getWidth();
    private float scaleFactorY;*/

    public InputHandler(GameWorld myWorld) {
        this.world = myWorld;
/*        myBird = myWorld.getBird();*/

        /*int midPointY = myWorld.getMidPointY();*/

/*        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;*/

        menuButtons = new ArrayList<SimpleButton>();
        playButton = new SimpleButton(
                136 / 2 - (AssetLoader.playButtonUp.getRegionWidth() / 2),
                EnvironmentValues.GAME_MIDPOINT_Y + 50, 29, 16, AssetLoader.playButtonUp,
                AssetLoader.playButtonDown);
        menuButtons.add(playButton);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
/*        screenX = scaleX(screenX);
        screenY = scaleY(screenY);
        System.out.println(screenX + " " + screenY);
        if (myWorld.isMenu()) {
            playButton.isTouchDown(screenX, screenY);
        } else if (myWorld.isReady()) {
            myWorld.start();
        }

        *//*myBird.onClick();*//*

        if (myWorld.isGameOver() || myWorld.isHighScore()) {
            myWorld.restart();
        }*/

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
       /* screenX = scaleX(screenX);
        screenY = scaleY(screenY);*/

        if (world.isRunning()) {
            world.ready();
        } else if (world.isReady()) {
            world.start();
        }

/*        if (myWorld.isMenu()) {
            if (playButton.isTouchUp(screenX, screenY)) {
                myWorld.ready();
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
                if (world.isRunning()) {
                    world.getTrampoline().onInput_Left();
                }
                break;

            // Move Right
            case Input.Keys.RIGHT:
                if (world.isRunning()) {
                    world.getTrampoline().onInput_Right();
                }
                break;

            // Prev Level
            case Input.Keys.FORWARD_DEL:
                if (world.isRunning() || world.isReady()) {
                    StageMode sm = (StageMode) world.getGameMode();
                    if (sm.getCurrentLevelIndex() != 0) {
                        sm.setCurrentLevel(sm.getCurrentLevelIndex() - 1);
                    }
                }
                break;

            // Next Level
            case Input.Keys.END:
                if (world.isRunning() || world.isReady()) {
                    StageMode sm = (StageMode) world.getGameMode();
                    sm.advanceCurrentLevel();
                }
                break;

            // Start Game
            case Input.Keys.SPACE:
                if (world.isReady()) {
                    world.start();
                }
                break;


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
        return (int) (screenX / EnvironmentValues.GAME_SCALE_FACTOR_X);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / EnvironmentValues.GAME_SCALE_FACTOR_Y);
    }

    public List<SimpleButton> getMenuButtons() {
        return menuButtons;
    }
}