package com.isaac.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.isaac.gamemodes._GameMode;

/**
 * Created by Isaac Holloway on 7/19/2015.
 */
public class AddALife extends FallingObject {

    protected final float fallSpeed = -100;

    /**
     * [CONSTRUCTOR]
     */
    public AddALife(_GameMode gameMode){
        super();
        this.gameMode = gameMode;
        this.width = 40;
        this.height = 40;
        this.velocity = new Vector2(0,fallSpeed);
    }

}
