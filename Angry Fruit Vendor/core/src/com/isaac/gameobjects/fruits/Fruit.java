package com.isaac.gameobjects.fruits;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import com.isaac.gamemodes._GameMode;
import com.isaac.gameobjects.FallingObject;
import com.isaac.gameobjects.Trampoline;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.Util;
import com.isaac.renderers.GameRenderer;

/**
 * Created by Isaac Holloway on 11/13/2014.
 */
public class Fruit extends FallingObject implements Pool.Poolable {

    /*
     * What type of fruit is this?
     */
    public enum FruitType{
        Apple, Banana, Basket, Orange, RottenFruit, Watermelon, All
    }
    protected FruitType fruitType;

    /**
     * The state that the fruit is
     * currently in.
     */
    protected enum FruitState {
        Tossed, Rising, Falling, Dropped, Completed
    }

    protected FruitState fruitState;

    // The position the fruit is in (1, 2, 3, or saved)
    protected Trampoline.TrampolinePosition fruitTrampolinePosition;

    // ***NOTE***
    // Increasing the Gravity (As in changing the gravity from -150 to -100) will make
    // it so the fruits will go too high!
    protected final static int GRAVITY = -150;

    // Each time the fruit bounces, the gravity_decay determines how much much lower the next bounc will be
    protected final float GRAVITY_DECAY = .90f;

    // This is the only value that can be changed without really breaking anything (nothing will go off the screen).
    protected final static int TERMINAL_VELOCITY = -70;
    protected final float INITIAL_GRAVITY = 100f;

    /*
     * When adjusting the gravity for gameplay purposes, launchOffset
	 * allows me to only have to change 1 value to compensate for the
	 * launch heights.
	 */
    private final static float LAUNCH_OFFSET = 1.15f;

    protected float fruitWeight;
    protected float peakHeight;

        protected Vector2 acceleration;

    protected float rotation;
    //protected float rotationSpeed;
    // 1  = clockwise
    // -1 = counterclockwise
    protected int rotationDirection;

    // Score
    protected int scoreValue;

    // TextureRegion
    protected TextureRegion fruitImage;

    /**
     * [CONSTRUCTOR]
     */
    public Fruit(_GameMode gameMode, float width, float height, float fruitWeight, TextureRegion fruitImage, float peakHeight, int scoreValue) {
        position = new Vector2();
        velocity = new Vector2();
        acceleration = new Vector2();
        this.width = width;
        this.height = height;

        this.gameMode = gameMode;

        this.rotationDirection = 1;

        this.fruitWeight = fruitWeight;
        this.fruitImage = fruitImage;
        this.peakHeight = peakHeight;
        this.scoreValue = scoreValue;
    }

    /***/
    @Override
    public void init() {
        this.fruitTrampolinePosition = Trampoline.TrampolinePosition.Position1;
        isAlive = true;
    }

    /**
     * spawn
     * @param x
     * @param y
     */
    public void spawn(float x, float y) {
        init();

        position.x = x;
        position.y = y;

        this.fruitState = FruitState.Tossed;

        float distanceTossed = GameValues.TRAMPOLINE_CENTER_POSITION_X_1 - getCenterX();
        float initialVelX = getXVelocity(y - GameValues.TRAMPOLINE_TOP_COLLISION_Y, distanceTossed, INITIAL_GRAVITY);

        velocity.x = initialVelX;
        velocity.y = INITIAL_GRAVITY;
    }

    /**
     * spawnFromBasket
     * (From Basket)
     */
    public void spawnFromBasket(float x, float y){
        init();

        position.x = x;
        position.y = y;

        collisionHitTrampoline(true);
    }

    /**
     * rotateFruit
     * @param delta
     */
    protected void rotateFruit(float delta){
        this.rotation += ((getRotationSpeed() * delta) * rotationDirection);
    }

    /**
     * getRotationSpeed
     */
    protected float getRotationSpeed(){
        return (1/fruitWeight) * GameValues.FRUIT_ROTATION_OFFSET;
    }

    /**
     * reset
     * <p/>
     * Callback method when the object is freed. It is automatically called by Pool.free()
     * Must reset every meaningful field of this bullet.
     */
    @Override
    public void reset() {
        isAlive = false;
    }

    /**
     * update
     *
     * @param delta
     */
    @Override
    public void update(float delta) {
        collision();
        movement(delta);
        rotateFruit(delta);
    }

    /**
     * movement
     *
     * @param delta
     */
    protected void movement(float delta) {
        if (velocity.y > getTerminalVelocity()) {
            acceleration.y = getGravityWithWeight();
            //acceleration.y = getTerminalVelocity();
            acceleration.scl(delta);
            velocity.add(0, acceleration.y);
            acceleration.scl(1 / delta);
        }

        velocity.scl(delta);
        position.x += velocity.x;
        position.y += velocity.y;
        velocity.scl(1 / delta);

        // Set to Falling
        if (velocity.y < 0) {
            fruitState = FruitState.Falling;
        }
    }

    /**
     * collision
     */
    protected void collision() {
        collisionHitTrampoline(didObjectCollideWithTrampoline());
        collisionMissedTrampoline();
        collisionHitGround();
        collisionSaved();
    }

    /***/
    @Override
    protected void collisionHitTrampoline(boolean didFruitBounce) {
        //      *** BOUNCE ***      //
        if (didFruitBounce) {

            // Advances the Fruit 's Trampoline Position.
            advanceFruitTrampolinePosition();

            // Get the launch velocity from the point in which the fruit bounces
            float vi = correctLaunchVelocity(peakHeight);

            // If this fruit has bounced is last bounce, and is about to be saved, we
            // Normalize the launch velocity.
            if (fruitTrampolinePosition == Trampoline.TrampolinePosition.Saved) {
                vi = correctLaunchVelocity(GameValues.MEDIUM_PEAK);
            }

            float nextHit = (
                    Trampoline.getTrampolineXLocGivenPosition(fruitTrampolinePosition)
                            - Util.getMiddle(width)) - position.x + Util.getMiddle(GameValues.TRAMPOLINE_WIDTH);

            float velX = getXVelocity(0, nextHit, vi);
            velocity.x = velX;
            velocity.y = vi;

            fruitState = FruitState.Rising;
        }
    }

    /***/
    @Override
    protected boolean didObjectCollideWithTrampoline() {
        // Did the fruit BOUNCE on the trampoline?
        if (getY() <= GameValues.TRAMPOLINE_TOP_COLLISION_Y &&
                getY() >= GameValues.TRAMPOLINE_BOTTOM_COLLISION_Y &&
                fruitState != FruitState.Rising &&
                fruitTrampolinePosition == gameMode.getTrampoline().getTrampolinePosition()) {
            gameMode.getTrampoline().turnAnimationOn();
            return true;
        }
        return false;
    }

    /***/
    @Override
    protected void collisionMissedTrampoline() {
        //      *** MISSED TRAMPOLINE ***      //
        if (getY() <= GameValues.TRAMPOLINE_BOTTOM_COLLISION_Y &&
                fruitState == FruitState.Falling &&
                fruitTrampolinePosition != Trampoline.TrampolinePosition.Saved) {

            // Set state to Dropped
            fruitState = FruitState.Dropped;
        }
    }

    /**
     * collisionHitGround
     */
    protected void collisionHitGround() {
        //      *** HIT GROUND ***      //
        if (getY() <= GameValues.DROPPED_Y_LOC &&
                fruitState == FruitState.Dropped &&
                fruitTrampolinePosition != Trampoline.TrampolinePosition.Saved) {

            // Destroy/Remove Fruit, by setting the alive = false.
            isAlive = false;

            clearStreak();
            gameMode.subtractLivesLeft(1);
        }
    }

    /**
     * clearStreak
     */
    protected void clearStreak(){
        gameMode.clearStreak();
    }

    /**
     * collisionSaved
     */
    protected void collisionSaved() {
        //      *** SAVED ***      //
        if (getY() <= GameValues.SAVED_FRUIT_Y &&
                fruitState == FruitState.Falling &&
                fruitTrampolinePosition == Trampoline.TrampolinePosition.Saved) {

            // Add the score
            gameMode.addFruitScore(scoreValue);
            isAlive = false;

            // Start the floating text animation
            gameMode.addFloatingText();
        }
    }

    /**
     * advanceFruitTrampolinePosition
     */
    protected void advanceFruitTrampolinePosition() {
        if (fruitTrampolinePosition == Trampoline.TrampolinePosition.Position1) {
            fruitTrampolinePosition = Trampoline.TrampolinePosition.Position2;
        } else if (fruitTrampolinePosition == Trampoline.TrampolinePosition.Position2) {
            fruitTrampolinePosition = Trampoline.TrampolinePosition.Position3;
        } else if (fruitTrampolinePosition == Trampoline.TrampolinePosition.Position3) {
            fruitTrampolinePosition = Trampoline.TrampolinePosition.Saved;
        }
    }

    /**
     * correctLaunchVelocity
     *
     * @param mlaunchVelocity
     * @return
     */
    protected float correctLaunchVelocity(float mlaunchVelocity) {
        return mlaunchVelocity * getGravityDecay();
    }

    /**
     * draw
     *
     * @param runTime
     * @param renderer
     */
    @Override
    public void draw(float runTime,  GameRenderer renderer) {
        renderer.getSpriteBatch().draw(fruitImage, getX(), getY(),width/2, height/2,
                getWidth(), getHeight(),1, 1, rotation, true);
    }

    /**
     * Returns the Velocity X need when a fruit bounces off of the trampoline<br>
     * by adding three different time values. <br> <br>
     * <b>Time 1:</b>  From bounce to the peak height. <br>
     * <b>Time 2:</b>  From peak height to terminal velocity. <br>
     * <b>Time 3:</b>  From terminal velocity to the next bounce.
     *
     * @param distanceX
     * @return
     */
    protected float getXVelocity(float initialHeight, float distanceX, float vi) {
        float upDistanceY = Util.howHigh(vi, getGravityWithWeight());
        float timeOne = Util.timeUntil(upDistanceY, getGravityWithWeight());

        float tvDistanceY = Util.howHigh(getTerminalVelocity(), getGravityWithWeight());
        float timeTwo = Util.timeUntil(tvDistanceY, getGravityWithWeight());

        float d = (initialHeight + upDistanceY) - tvDistanceY;
        float timeThree = d / Math.abs(getTerminalVelocity());

        float rVelX = Math.abs(distanceX) / (timeOne + timeTwo + timeThree);
        if (distanceX < 0) {
            rVelX *= -1;
        }
        return rVelX;
    }

    /**
     * @return the currentGravityDecay
     */
    protected float getGravityDecay() {
        // Returns the gravity's decay value based on the trampoline's state.
        switch (fruitTrampolinePosition) {
            case Position3:
                return (float) Math.pow(GRAVITY_DECAY, 1);

            default:
                return 1;
        }
    }

    /**
     * getTerminalVelocity
     *
     * @return
     */
/*    protected float getTerminalVelocity() {
        return TERMINAL_VELOCITY ;
    }*/
    protected float getTerminalVelocity() {
        return TERMINAL_VELOCITY + fruitWeight;
    }

    /**
     * updateReady
     *
     * @param runTime
     */
    public void updateReady(float runTime) {
        /*position.y = 2 * (float) Math.sin(7 * runTime) + originalY;*/
    }

    protected float getGravityWithWeight() {
/*        float calculatedGravity = GRAVITY + fruitWeight;
        return calculatedGravity;*/
        return GRAVITY + fruitWeight;
    }

    public float getRotation() {
        return rotation;
    }


}
