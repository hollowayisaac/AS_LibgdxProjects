package com.isaac.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.isaac.screens._Screen;

/**
 * Created by Isaac Holloway on 6/7/2015.
 */
public abstract class _Input implements InputProcessor{

    protected _Screen screen;
    protected Vector3 touchPoint;

    /** [CONSTRUCTOR] **/
    public _Input(_Screen screen){
        this.screen = screen;
        this.touchPoint = new Vector3();
    }

    /***/
    public void init(){
        Gdx.input.setInputProcessor(this);
    }

    /***/
    @Override
    public abstract boolean touchDown(int screenX, int screenY, int pointer, int button);

    /***/
    @Override
    public abstract boolean touchUp(int screenX, int screenY, int pointer, int button);

    /***/
    public void unprojectTouchPoint(){
        screen.game.camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
    }
}
