package com.isaac.environment;

public class Grass extends EnvironmentObject{
    public Grass(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public void onRestart(float x) {
        position.x = x;
    }
}