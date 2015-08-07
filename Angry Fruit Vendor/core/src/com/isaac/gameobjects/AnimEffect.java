package com.isaac.gameobjects;

/**
 * Created by Isaac Lappy on 8/6/2015.
 */
public abstract class AnimEffect {
    public abstract void update(FloatingText floatingText, float delta);
    public abstract boolean isAlive();
    protected boolean alive;
    protected double runTime;
    protected double animationDurationSeconds;

    /** [CONSTRUCTOR] */
    public AnimEffect(double animationDurationSeconds){
        this.animationDurationSeconds = animationDurationSeconds;
        alive = true;
    }
}
