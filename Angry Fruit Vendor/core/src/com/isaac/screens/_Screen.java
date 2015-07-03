package com.isaac.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.renderers._Renderer;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 6/7/2015.
 */
public abstract class _Screen extends ScreenAdapter {
    public abstract void init();/***/
    protected abstract void createMenus();/***/

    public AngryFVGame game;
    public float runTime;
    public _Renderer renderer;
    protected _Menu currentMenu;

    /**
     * [CONSTRUCTOR]
     */
    public _Screen(AngryFVGame game) {
        this.game = game;
        createMenus();
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
        if (currentMenu != null){
            currentMenu.update(delta);
        }
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
        if(this.currentMenu != null ){
            this.currentMenu.init();
        }
    }
}
