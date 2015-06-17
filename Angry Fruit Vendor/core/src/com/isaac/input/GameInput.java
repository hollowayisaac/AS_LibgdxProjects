package com.isaac.input;

import com.badlogic.gdx.Input;
import com.isaac.helpers.GameValues;
import com.isaac.screens.GameScreen;
import com.isaac.screens._Screen;
import com.isaac.ui._Button;

import java.util.List;

/**
 * Created by Isaac Holloway on 6/7/2015.
 */
public class GameInput extends _Input{

    /** [CONSTRUCTOR] **/
    public GameInput(_Screen screen){
        super(screen);
    }

    /***/
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        unprojectTouchPoint();

        if(button == Input.Buttons.LEFT) {
            if (getGameScreen().getCurrentMenu() != null) {
                List<_Button> buttons = getGameScreen().getCurrentMenu().buttons;
                for (int i = 0; i < buttons.size(); i++){
                    buttons.get(i).isTouchDown(touchPoint.x, touchPoint.y);
                }
            }  else if(getGameScreen().bnPause.isTouchDown(touchPoint.x, touchPoint.y)) {
            }
            else if (touchPoint.x < GameValues.GAMEUNIT_WIDTH / 2) {
                // Trampoline Left
                getGameScreen().gameMode.getTrampoline().onInput_Left();
            } else {
                // Trampoline Right
                getGameScreen().gameMode.getTrampoline().onInput_Right();
            }
        }
        return false;
    }

    /***/
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        unprojectTouchPoint();

        if (getGameScreen().getCurrentMenu() != null) {
            List<_Button> buttons = getGameScreen().getCurrentMenu().buttons;
            for (int i = 0; i < buttons.size(); i++){
                if(buttons.get(i).isTouchUp(touchPoint.x, touchPoint.y)){
                    // TODO: Create button actions (aka button event handlers)
                    //

                }
            }
        }else if(getGameScreen().bnPause.isTouchUp(touchPoint.x, touchPoint.y)){
        }

        return false;
    }

    /***/
    public GameScreen getGameScreen(){
        return (GameScreen)screen;
    }

    @Override
    public boolean keyDown(int keycode) {
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
