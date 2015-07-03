package com.isaac.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.isaac.screens.GameScreen;
import com.isaac.ui._Button;

import java.util.List;

/**
 * Created by Isaac Holloway on 6/7/2015.
 */
public class GameInput implements InputProcessor {

    protected GameScreen gameScreen;
    protected Vector3 touchPoint;

    /** [CONSTRUCTOR] **/
    public GameInput(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        touchPoint = new Vector3();
    }

    /***/
    public void init(){
        Gdx.input.setInputProcessor(this);
    }

    /***/
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        unProjectTouchPoint();

        if(button == Input.Buttons.LEFT) {
            if (gameScreen.getCurrentMenu() == null) {
                List<_Button> buttons = gameScreen.buttons;
                for (int i = 0; i < buttons.size(); i++){
                    buttons.get(i).isTouchDown(touchPoint.x, touchPoint.y);
                }
            }

            /*else if (touchPoint.x < GameValues.GAMEUNIT_WIDTH / 2) {
                // Trampoline Left
                gameScreen.gameMode.getTrampoline().onInput_Left();
            } else {
                // Trampoline Right
                gameScreen.gameMode.getTrampoline().onInput_Right();
            }*/
        }
        return false;
    }

    /***/
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        unProjectTouchPoint();

        if (gameScreen.getCurrentMenu() == null) {
            List<_Button> buttons = gameScreen.buttons;
            for (int i = 0; i < buttons.size(); i++){
                buttons.get(i).isTouchUp(touchPoint.x, touchPoint.y);
            }
        }

        return false;
    }

    /***/
    protected void unProjectTouchPoint(){
        gameScreen.game.camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
    }

    /***/
    @Override
    public boolean keyDown(int keycode) {
        if (Input.Keys.LEFT == keycode){
            gameScreen.currentGameMode.getTrampoline().onInput_Left();
        }else if(Input.Keys.RIGHT == keycode){
            gameScreen.currentGameMode.getTrampoline().onInput_Right();
        }
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
}
