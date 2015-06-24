package com.isaac.renderers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.isaac.screens._Screen;

/**
 * Created by Isaac Holloway on 6/21/2015.
 */
public class Scene2dRenderer extends _Renderer{

    private Stage stage;

    /** [CONSTRUCTOR] */
    public Scene2dRenderer(_Screen screen, Stage stage) {
        super(screen);
        this.stage = stage;
    }

    /***/
    @Override
    public void render(float delta){
        super.render(delta);
        /*Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);*/
        stage.draw();
    }

    /***/
    @Override
    protected void drawBackground(float delta) {

    }

    /***/
    @Override
    protected void drawEverythingElse(float delta) {
        drawMenus(delta);
    }
}