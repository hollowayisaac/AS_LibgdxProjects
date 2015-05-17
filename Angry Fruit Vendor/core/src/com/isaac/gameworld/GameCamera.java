package com.isaac.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by Isaac Holloway on 11/18/2014.
 */
public class GameCamera extends OrthographicCamera{
    public int x, y, width, height;
    public GameCamera(int width, int height) {
        this.width = width;
        this.height = height;
    }
}