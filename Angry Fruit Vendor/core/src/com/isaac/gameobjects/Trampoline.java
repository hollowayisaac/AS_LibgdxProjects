package com.isaac.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.isaac.renderers.GameRenderer;
import com.isaac.helpers.GameValues;
import com.isaac.helpers.AssetLoader;

/**
 * Created by Isaac Holloway on 11/17/2014.
 */
public class Trampoline extends GameObject {

    public enum TrampolinePosition {
        Position1,
        Position2,
        Position3,
        Saved
    }

    protected final float STUN_DURATION = 750;
    protected float currentTimeInStun;
    protected boolean stunned;

    private TrampolinePosition trampolinePosition;

    // TextureRegion
    protected TextureRegion trampolineImage;

    /**
     * [CONSTRUCTOR]
     * The 'Constructor' will initialize anything that will stay constant throughout the classes life.
     */
    public Trampoline() {
        this.width = GameValues.TRAMPOLINE_WIDTH;
        this.height = GameValues.TRAMPOLINE_HEIGHT;

        // Set the y position (this shouldn't change)
        position = new Vector2(0f, GameValues.TRAMPOLINE_Y);

        // Set image
        this.trampolineImage = AssetLoader.trTrampoline;
    }

    /**
     * init
     * 'init' will initialize anything that might have changed since the creation of the class.  Think of this as a 'Reset'
     */
    public void init() {
        this.currentTimeInStun = 0;
        this.stunned = false;

        // Set initial position
        setTrampolinePosition(TrampolinePosition.Position1);
    }

    /**
     * update
     *
     * @param delta
     */
    @Override
    public void update(float delta) {
        handleStunned(delta);
    }

    /**
     * checkStunned
     *
     * @param delta
     */
    private void handleStunned(float delta) {
        if (stunned) {
            if (currentTimeInStun < STUN_DURATION) {
                currentTimeInStun += delta * 1000;
            } else {
                stunned = false;
                this.currentTimeInStun = 0;
            }
        }
    }

    /**
     * stun
     */
    public void stun() {
        this.currentTimeInStun = 0;
        this.stunned = true;
    }

    /**
     * isStunned
     *
     * @return
     */
    public boolean isStunned() {
        return stunned;
    }

    /**
     * draw
     *
     * @param runTime
     * @param renderer
     */
    @Override
    public void draw(float runTime, GameRenderer renderer) {
        renderer.getSpriteBatch().draw(trampolineImage, getX(), getY(),
                getWidth(), getHeight());
    }

    /**
     * setTrampolinePosition
     */
    protected void setTrampolinePosition(TrampolinePosition newTrampolinePosition) {
        this.trampolinePosition = newTrampolinePosition;

        // Set location of the trampoline based on position
        position.x = getTrampolineXLocGivenPosition(this.trampolinePosition);
    }

    /**
     * getTrampolineXLocGivenPosition
     *
     * @param trampolinePosition
     * @return newX
     */
    public static float getTrampolineXLocGivenPosition(TrampolinePosition trampolinePosition) {
        // Set location of the trampoline based on position
        switch (trampolinePosition) {
            case Position1:
                return GameValues.TRAMPOLINE_CENTER_POSITION_X_1 - (GameValues.TRAMPOLINE_WIDTH / 2);

            case Position2:
                return GameValues.TRAMPOLINE_CENTER_POSITION_X_2 - (GameValues.TRAMPOLINE_WIDTH / 2);

            case Position3:
                return GameValues.TRAMPOLINE_CENTER_POSITION_X_3 - (GameValues.TRAMPOLINE_WIDTH / 2);

            default:
                return GameValues.SAVED_FRUIT_X - (GameValues.TRAMPOLINE_WIDTH / 2);
        }
    }

    /**
     * onInput_Left
     */
    public void onInput_Left() {
        // The trampoline cannot move it is stunned
        if (!stunned) {
            // If the position is not all the way to the left
            if (this.trampolinePosition != TrampolinePosition.Position1) {
                if (this.trampolinePosition == TrampolinePosition.Position2) {
                    setTrampolinePosition(TrampolinePosition.Position1);
                } else if (this.trampolinePosition == TrampolinePosition.Position3) {
                    setTrampolinePosition(TrampolinePosition.Position2);
                }
            }
        }
    }

    /**
     * onInput_Right
     */
    public void onInput_Right() {
        // The trampoline cannot move it is stunned
        if (!stunned) {
            // If the position is not all the way to the right
            if (this.trampolinePosition != TrampolinePosition.Position3) {
                if (this.trampolinePosition == TrampolinePosition.Position1) {
                    setTrampolinePosition(TrampolinePosition.Position2);
                } else if (this.trampolinePosition == TrampolinePosition.Position2) {
                    setTrampolinePosition(TrampolinePosition.Position3);
                }
            }
        }
    }

    /**
     * getTrampolinePosition
     *
     * @return TrampolinePosition
     */
    public TrampolinePosition getTrampolinePosition() {
        return trampolinePosition;
    }
}
