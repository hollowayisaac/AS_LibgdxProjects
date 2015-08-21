package com.isaac.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.renderers.GameRenderer;

import java.util.ArrayList;

/**
 * Created by Isaac Lappy on 8/18/2015.
 */
public class Transition {

    private boolean alive;
    private ArrayList<FloatingText> floatingTexts;

    /** */
    public Transition(){
        floatingTexts = new ArrayList<FloatingText>();
    }

    /** */
    public void update(float delta){
        if (isAlive()) {
            this.alive = false;
            for (int i = floatingTexts.size() - 1; i >= 0; i--) {
                if (floatingTexts.get(i).isAlive()) {
                    floatingTexts.get(i).update(delta);
                    this.alive = true;
                }
            }

            if(!isAlive()){
                int s = 4;
            }
        }

    }
    /***/
    public void draw(float delta, GameRenderer renderer){
        for (int i = floatingTexts.size() - 1; i >= 0; i--) {
            floatingTexts.get(i).draw(delta, renderer);
        }
    }

    /** */
    public void addFloatingText(FloatingText floatingText){
        this.floatingTexts.add(floatingText);
    }

    /** */
    public void start(){
        alive = true;
        for (int i = floatingTexts.size() - 1; i >= 0; i--) {
            floatingTexts.get(i).animate();
        }
    }

    /** */
    public boolean isAlive(){
        return alive;
    }
}
