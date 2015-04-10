package com.isaac.gameobjects.fruits;

import com.badlogic.gdx.math.MathUtils;
import com.isaac.environment.EnvironmentValues;
import com.isaac.gameobjects.Trampoline;
import com.isaac.gameworld.GameWorld;
import com.isaac.helpers.AssetLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isaac Holloway on 12/12/2014.
 */
public class Banana extends Fruit {

    protected int bounceCount = 0;
    protected int bounceCountMax;
    protected int BOUNCE_COUNT_RANGE_LOW = 3;
    protected int BOUNCE_COUNT_RANGE_HIGH = 5;

    public Banana(GameWorld world) {
        super(
                world,
                EnvironmentValues.BANANA_WIDTH,
                EnvironmentValues.BANANA_WIDTH,
                EnvironmentValues.BANANA_ADDITIONAL_WEIGHT,
                AssetLoader.trBanana,
                EnvironmentValues.SMALL_PEAK,
                EnvironmentValues.BANANA_SCORE_VALUE);
        generateBounceCountMax();
    }

/*    @Override
    public void init(float x, float y) {
        super.init(x, y);
    }*/

    @Override
    /**
     * advanceFruitTrampolinePosition
     */
    protected void advanceFruitTrampolinePosition() {
        bounceCount++;

        // Randomize the destination position
        Integer currentLocationIndex = 0;
        int randomPositionIndex = MathUtils.random(0, 1);
        List<Integer> distanceTraveledIndices = new ArrayList<Integer>();
        List<Trampoline.TrampolinePosition> availablePositions = new ArrayList<Trampoline.TrampolinePosition>();
        if (fruitTrampolinePosition != Trampoline.TrampolinePosition.Position1) {
            availablePositions.add(Trampoline.TrampolinePosition.Position1);
            distanceTraveledIndices.add(1);
        }else {
            currentLocationIndex = 1;
        }
        if (fruitTrampolinePosition != Trampoline.TrampolinePosition.Position2) {
            availablePositions.add(Trampoline.TrampolinePosition.Position2);
            distanceTraveledIndices.add(2);
        }else{
            currentLocationIndex = 2;
        }
        if (fruitTrampolinePosition != Trampoline.TrampolinePosition.Position3) {
            availablePositions.add(Trampoline.TrampolinePosition.Position3);
            distanceTraveledIndices.add(3);
        }else{
            currentLocationIndex = 3;
        }
        fruitTrampolinePosition = availablePositions.get(randomPositionIndex);
        Integer destTraveledIndex = distanceTraveledIndices.get(randomPositionIndex);

        // This will either be 1 or 2
        Integer distanceTraveledIndex = Math.abs(currentLocationIndex - destTraveledIndex);

        Integer newHeightIndex = 0;

        // Randomize the peak
        int randomHeightIndex = MathUtils.random(1, 3);
        switch (randomHeightIndex) {
            case 1:
                peakHeight = EnvironmentValues.SMALL_PEAK;
                newHeightIndex = 3;
                break;

            case 2:
                peakHeight = EnvironmentValues.MEDIUM_PEAK;
                newHeightIndex = 2;
                break;

            default:
                peakHeight = EnvironmentValues.LARGE_PEAK;
                newHeightIndex = 1;
                break;
        }

        // Now multiply the newHeightIndex by the distanceTraveldIndex to get our Weight multiplier
        // Min = 1;
        // Max = 6
        Integer newWeightIndex = newHeightIndex * distanceTraveledIndex;

        // Now multiply by the offest and by -1 to get our new weight
        newWeightIndex = (newWeightIndex * 7) * -1;
        this.fruitWeight = newWeightIndex;

        // Saved
        if (bounceCount == bounceCountMax) {
            fruitTrampolinePosition = Trampoline.TrampolinePosition.Saved;
        }
    }

    /**
     * getGravityDecay
     */
    @Override
    protected float getGravityDecay() {
        return 1;
    }

    /**
     * generateBounceCountMax
     */
    protected void generateBounceCountMax() {
        bounceCountMax = MathUtils.random(BOUNCE_COUNT_RANGE_LOW, BOUNCE_COUNT_RANGE_HIGH);
    }
}
