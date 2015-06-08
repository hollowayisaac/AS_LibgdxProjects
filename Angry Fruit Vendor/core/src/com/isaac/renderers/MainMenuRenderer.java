package com.isaac.renderers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.isaac.helpers.AssetLoader;
import com.isaac.screens._Screen;
import com.isaac.ui.SimpleButton;

import java.util.List;

/**
 * Created by Isaac Holloway on 6/7/2015.
 */
public class MainMenuRenderer extends _Renderer{

    private _Screen screen;

    public SpriteBatch batch;
    public Matrix4 matrix = new Matrix4();

    // Buttons
    private List<SimpleButton> menuButtons;

    @Override
    protected void drawBackground(float delta) {

    }

    @Override
    protected void drawEverythingElse(float delta) {

    }

    /**
     * [CONSTRUCTOR]
     *
     * @param screen
     */
    public MainMenuRenderer(_Screen screen) {
        super(screen);
    }

    /**
     * @param xLoc
     * @param yLoc
     * @param text
     */
    public void drawText_Wag(float xLoc, float yLoc, String text) {
        AssetLoader.ftWag.draw(batch, text, xLoc, yLoc);
    }
}
