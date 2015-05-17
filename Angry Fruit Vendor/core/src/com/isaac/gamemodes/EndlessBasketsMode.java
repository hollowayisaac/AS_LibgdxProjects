package com.isaac.gamemodes;

import com.badlogic.gdx.math.MathUtils;
import com.isaac.gamemodes.levels.EndlessBaskets_Level;
import com.isaac.gamemodes.levels.Level;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.gameworld.GameRenderer;
import com.isaac.gameworld.GameWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Isaac Holloway on 3/24/2015.
 */
public class EndlessBasketsMode extends GameMode {

    protected int currentLevelIndex;
    protected List<Level> levels;

    /**
     * [CONSTRUCTOR]
     */
    public EndlessBasketsMode(GameWorld world) {
        super(world);
        createLevel();
    }

    /***/
    private void createLevel() {
        setLevels(new ArrayList<Level>());
        getLevels().add(new EndlessBaskets_Level(this));
    }

    /***/
    @Override
    public Fruit getRandomFruit() {
        Fruit.FruitType selectedFruitType = null;
        Integer randFruitIndex = MathUtils.random(0, 100);
        int percentageSum = 0;
        for (Map.Entry<Fruit.FruitType, Integer> entry : getCurrentLevel().getAllowedFruits().entrySet()) {
            Integer percentage = entry.getValue();
            if (randFruitIndex >= percentageSum
                    && randFruitIndex <= (percentage + percentageSum)) {
                selectedFruitType = entry.getKey();
                break;
            }
            percentageSum += percentage;
        }
        return world.getFruitGivenType(selectedFruitType);
    }

    /***/
    @Override
    public void init() {
        setCurrentLevel(0);
    }

    /***/
    public void renderGameMode(float delta, GameRenderer renderer) {
        getCurrentLevel().drawLevel(delta, renderer);
    }

    /***/
    @Override
    public void renderGameModeBG(float delta, GameRenderer renderer) {
        getCurrentLevel().drawLevelBG(delta, renderer);
    }

    /***/
    public void setCurrentLevel(int index) {
        world.resetWorld();
        this.setCurrentLevelIndex(index);
        this.getCurrentLevel().init();
    }

    /***/
    public void advanceCurrentLevel() {
        if (getCurrentLevelIndex() >= levels.size() - 1) {
            setCurrentLevel(0);
        } else {
            setCurrentLevel(getCurrentLevelIndex() + 1);
        }
    }

    /***/
    @Override
    public void levelComplete() {
        if (getCurrentLevelIndex() == getLevels().size() - 1) {
            allStagesCompleted();
        } else {
            advanceCurrentLevel();
        }
    }

    /***/
    @Override
    public void restartGame() {
        world.resetWorld();
        world.clearStreak();
        // TODO: Display a message that indicates the I Lost and the level is restarting.

        setCurrentLevel(this.getCurrentLevelIndex());
    }

    /***/
    @Override
    public void update(float delta) {
        getCurrentLevel().update(delta);
    }

    /** **/
    public void allStagesCompleted() {
        // TODO: Stages complete! animation
        // TODO: Go to menu screen (GameMode selection OR stage selection)


        setCurrentLevel(0);
    }

    /***/
    protected Level getCurrentLevel() {
        return getLevels().get(getCurrentLevelIndex());
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public void setCurrentLevelIndex(int currentLevelIndex) {
        this.currentLevelIndex = currentLevelIndex;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
}
