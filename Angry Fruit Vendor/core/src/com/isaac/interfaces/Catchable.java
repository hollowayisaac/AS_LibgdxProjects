package com.isaac.interfaces;

/**
 * Created by Isaac Holloway on 7/22/2015.
 */
public interface Catchable {
    public void collisionHitTrampoline(boolean didObjBounce);
    public boolean didObjectCollideWithTrampoline(boolean hasObjectDroppedTooLow);
}
