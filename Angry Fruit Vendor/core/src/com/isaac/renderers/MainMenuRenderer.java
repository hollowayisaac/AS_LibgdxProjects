package com.isaac.renderers;

import com.isaac.screens._Screen;

/**
 * Created by Isaac Holloway on 6/7/2015.
 */
public class MainMenuRenderer extends _Renderer{

    /** [CONSTRUCTOR] */
    public MainMenuRenderer(_Screen screen) {
        super(screen);
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
