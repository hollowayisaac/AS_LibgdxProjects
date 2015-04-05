package com.isaac.environment;

import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.gameworld.GameWorld;

/**
 * Created by Isaac Holloway on 11/13/2014.
 */
public class EnvironmentHandler {

    private Grass grass;
    private GameWorld world;

    public EnvironmentHandler(GameWorld world) {
        this.world = world;
        grass = new Grass(0,400,800,20);
    }

    public void updateReady(float delta) {
        grass.update(delta);
    }

    public void update(float delta) {
        // Update our objects
        grass.update(delta);
    }

    public void stop() {
        grass.stop();
    }

    public boolean collides(Fruit fruit) {
        return  false   ;
    }
    public Grass getGrass() {
        return grass;
    }
}

