package com.isaac.gameobjects;

/**
 * Created by Isaac Lappy on 8/6/2015.
 */
public class FadeAnimEffect extends AnimEffect {

    protected float startingOpacity;
    protected float endingOpacity;
    protected float currentOpacity;


    /**
     * [CONSTRUCTOR]
     */
    public FadeAnimEffect(double animationDurationSeconds, float startingOpacity, float endingOpacity) {
        super(animationDurationSeconds);
        this.startingOpacity = startingOpacity;
        this.endingOpacity = endingOpacity;
        this.currentOpacity = startingOpacity;
    }

    /***/
    @Override
    public void update(FloatingText floatingText, float delta) {
        if ((runTime) >= animationDurationSeconds){
            alive = false;
        }else{
            runTime += delta;
            double percAnimComplete = runTime/animationDurationSeconds;

            currentOpacity = (float)(endingOpacity - (endingOpacity * percAnimComplete));
            floatingText.font.setColor(floatingText.font.getColor().r,floatingText.font.getColor().b,floatingText.font.getColor().g, currentOpacity);
        }
    }

    @Override
    public boolean isAlive() {
        return alive;
    }
}
