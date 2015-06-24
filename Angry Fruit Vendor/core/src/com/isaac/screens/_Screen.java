package com.isaac.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.input._Input;
import com.isaac.renderers._Renderer;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 6/7/2015.
 */
public abstract class _Screen extends ScreenAdapter {

    protected abstract void createMenus();/***/

    public AngryFVGame game;
    public float runTime;
    public _Renderer renderer;
    public _Input input;
    private _Menu currentMenu;

    /**
     * [CONSTRUCTOR]
     */
    public _Screen(AngryFVGame game) {
        this.game = game;
        createMenus();
    }

    /***/
    public void init(){
        input.init();
    }

    /***/
    @Override
    public void render(float delta) {
        runTime += delta;
        update(delta);
        renderer.render(delta);
    }

    /***/
    public void update(float delta){

    }

    /***/
    public SpriteBatch getBatch() {
        return game.batch;
    }

    /***/
    public _Menu getCurrentMenu() {
        return currentMenu;
    }

    /***/
    public void setCurrentMenu(_Menu menu){
        this.currentMenu = menu;
    }
}
