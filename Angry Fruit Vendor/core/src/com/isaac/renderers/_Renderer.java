package com.isaac.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.screens._Screen;

/**
 * Created by Isaac Holloway on 6/7/2015.
 */
public abstract class _Renderer {
    protected abstract void drawBackground(float delta);        /***/
    protected abstract void drawEverythingElse(float delta);    /***/

    protected _Screen screen;

    /**
     * [CONSTRUCTOR]
     */
    public _Renderer(_Screen screen) {
        this.screen = screen;
    }

    /**
     * @param delta
     */
    public void render(float delta) {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        screen.game.camera.update();
        screen.game.batch.setProjectionMatrix(screen.game.camera.combined);

        screen.game.batch.disableBlending();
        screen.game.batch.begin();
        drawBackground(delta);               // Draw Background
        screen.game.batch.end();

        screen.game.batch.enableBlending();
        screen.game.batch.begin();
        drawEverythingElse(delta);           // Draw everything else
        drawMenus(delta);                    // Draw menu's on top of "EverythingElse"
        screen.game.batch.end();
    }

    /***/
    protected void drawMenus(float delta) {
        if (screen.getCurrentMenu() != null) {
            screen.getCurrentMenu().draw(delta, getSpriteBatch());
        }
    }

    /***/
    public SpriteBatch getSpriteBatch(){
        return screen.getBatch();
    }
}
