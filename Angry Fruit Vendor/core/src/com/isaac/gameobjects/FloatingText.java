package com.isaac.gameobjects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.isaac.renderers.GameRenderer;

import java.util.ArrayList;

/**
 * Created by Isaac Lappy on 8/4/2015.
 */
public class FloatingText extends GameObject {

    public ArrayList<ArrayList<AnimEffect>> chainedAnimEffects;
    public ArrayList<AnimEffect> animEffects;

    public float startingX;
    public float startingY;

    protected BitmapFont font;
    protected String message;

    /** [CONSTRUCTOR] */
    public FloatingText(BitmapFont font, String message, Vector2 position){
        this.font = font;
        this.message = message;
        this.animEffects = new ArrayList<AnimEffect>();
        chainedAnimEffects = new ArrayList<ArrayList<AnimEffect>>();
        this.position = position;
        this.startingX = position.x;
        this.startingY = position.y;
    }

    /***/
    @Override
    public void init() {
    }

    /***/
    @Override
    public void update(float delta) {
        // Update the Anim Effects on the first chain
        for (int i = 0;i < chainedAnimEffects.get(0).size();i++){
            chainedAnimEffects.get(0).get(i).update(this, delta);
        }

        // Remove any dead animations
        for (int i = chainedAnimEffects.get(0).size()-1;i >= 0;i--){
            if(!chainedAnimEffects.get(0).get(i).isAlive()){
                chainedAnimEffects.get(0).remove(i);
            }
        }

        // If the first anim Effects array has no items, remove it.
        if (chainedAnimEffects.get(0).size() == 0){
            chainedAnimEffects.remove(0);

            // When we remove an animEffect list from the chain we need to set our StartingX & Y to the current location
            this.startingX = getX();
            this.startingY = getY();
        }
    }

    /***/
    @Override
    public void draw(float delta, GameRenderer renderer) {
        font.draw(renderer.getSpriteBatch(), message,
                getX(), getY());
    }

    /***/
    public void addAnimEffectListToChain(ArrayList<AnimEffect> incomingAnimEffects){
        chainedAnimEffects.add(incomingAnimEffects);
    }

    /***/
    public boolean isAlive(){
        if(chainedAnimEffects.size() == 0){
            return false;
        }else{
            return true;
        }
    }

    /***/
    public static MoveAnimEffect addMoveAnimation(double animationDurationSeconds, float destX, float destY){
        MoveAnimEffect moveEffect = new MoveAnimEffect(animationDurationSeconds, destX, destY);
        return moveEffect;
    }
}
