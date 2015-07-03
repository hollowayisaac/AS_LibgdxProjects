package com.isaac.input;

import com.isaac.screens.MainMenuScreen;
import com.isaac.screens._Screen;

/**
 * Created by Isaac Holloway on 6/16/2015.
 */
public class MainMenuInput extends _Input {
    /** [CONSTRUCTOR] **/
    public MainMenuInput(_Screen screen) {
        super(screen);
    }

    /***/
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        unprojectTouchPoint();
/*
        if(button == Input.Buttons.LEFT) {
            if (getMainMenuScreen().getCurrentMenu() != null) {
                List<_Button> buttons = getMainMenuScreen().getCurrentMenu().buttons;
                for (int i = 0; i < buttons.size(); i++){
                    buttons.get(i).isTouchDown(touchPoint.x, touchPoint.y);
                }
            }
        }*/
        return false;
    }

    /***/
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        unprojectTouchPoint();

/*        if (getMainMenuScreen().getCurrentMenu() != null) {
            List<_Button> buttons = getMainMenuScreen().getCurrentMenu().buttons;
            for (int i = 0; i < buttons.size(); i++){
                if(buttons.get(i).isTouchUp(touchPoint.x, touchPoint.y)){
                    //
                }
            }
        }*/

        return false;
    }

    /***/
    public MainMenuScreen getMainMenuScreen(){
        return (MainMenuScreen)screen;
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
