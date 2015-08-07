package com.isaac.gameobjects;

/**
 * Created by Isaac Lappy on 8/6/2015.
 */
public class MoveAnimEffect extends AnimEffect {

    protected float destX;
    protected float destY;


    /**
     * [CONSTRUCTOR]
     */
    public MoveAnimEffect(double animationDurationSeconds, float destX, float destY ) {
        super(animationDurationSeconds);
        this.destX = destX;
        this.destY = destY;
    }

    /***/
    @Override
    public void update(FloatingText floatingText, float delta) {
        if ((runTime) >= animationDurationSeconds){
            alive = false;
        }else{
            runTime += delta;
            double percAnimComplete = runTime/animationDurationSeconds;
            float travelDistanceX = destX - floatingText.startingX;
            float travelDistanceY = destY - floatingText.startingY;

            float newX = (float)(floatingText.startingX + (travelDistanceX * percAnimComplete));
            float newY = (float)(floatingText.startingY + (travelDistanceY * percAnimComplete));

            floatingText.setX(newX);
            floatingText.setY(newY);
        }
    }

    /***/
    protected void moveText(){

    }

    @Override
    public boolean isAlive() {
        return alive;
    }
}
