package com.isaac.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.isaac.gamemodes._GameMode;
import com.isaac.helpers.AssetLoader;
import com.isaac.helpers.GameValues;
import com.isaac.renderers.GameRenderer;

/**
 * Created by Isaac Holloway on 7/19/2015.
 */
public class FallingObject extends GameObject {
    protected Vector2 velocity;
    public boolean isAlive;
    protected _GameMode gameMode;

    protected boolean isObjectDropped;

    // The position the fruit is in (1, 2, 3, or saved)
    protected Trampoline.TrampolinePosition fruitTrampolinePosition;

    /***/
    public FallingObject(){
        this.position = new Vector2();
    }

    /***
     * init
     */
    @Override
    public void init() {
        this.isAlive = true;
    }

    /***/
    public void spawn(Trampoline.TrampolinePosition fruitTrampolinePosition) {
        this.fruitTrampolinePosition = fruitTrampolinePosition;
        init();
        this.position.set(Trampoline.getTrampolineXLocGivenPosition(fruitTrampolinePosition), GameValues.GAME_HEIGHT);
    }

    /***/
    @Override
    public void draw(float runTime, GameRenderer renderer) {
        renderer.getSpriteBatch().draw(AssetLoader.trPlusOne, getX(), getY(), width / 2, height / 2,
                getWidth(), getHeight(),1,1,0);
    }

    /***/
    @Override
    public void update(float delta) {
        collision();
        movement(delta);
    }

    /***/
    protected void movement(float delta) {
        velocity.scl(delta);
        position.x += velocity.x;
        position.y += velocity.y;
        velocity.scl(1 / delta);
    }

    /***/
    protected void collision() {
        collisionHitTrampoline(didObjectCollideWithTrampoline());
        collisionMissedTrampoline();
        collisionHitGround();
    }


    /***/
    protected void collisionHitTrampoline(boolean didFruitBounce) {
        //      *** BOUNCE ***      //
        if (didFruitBounce) {
            // Add the score
            gameMode.setLivesLeft(gameMode.getLivesLeft() + 1);
            this.isAlive = false;
        }
    }

    /***/
    protected boolean didObjectCollideWithTrampoline() {
        if (getY() <= GameValues.TRAMPOLINE_TOP_COLLISION_Y &&
                getY() >= GameValues.TRAMPOLINE_BOTTOM_COLLISION_Y &&
                fruitTrampolinePosition == gameMode.getTrampoline().getTrampolinePosition()) {

            return true;
        }
        return false;
    }

    /***/
    protected void collisionMissedTrampoline() {
        //      *** MISSED TRAMPOLINE ***      //
        if (getY() <= GameValues.TRAMPOLINE_BOTTOM_COLLISION_Y) {

            // Set state to Dropped
            isObjectDropped = true;
        }
    }

    /**
     * collisionHitGround
     */
    protected void collisionHitGround() {
        //      *** HIT GROUND ***      //
        if (getY() <= GameValues.DROPPED_Y_LOC &&
                isObjectDropped) {

            // Destroy/Remove Fruit, by setting the alive = false.
            isAlive = false;
        }
    }
}
