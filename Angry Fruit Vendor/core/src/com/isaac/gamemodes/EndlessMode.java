package com.isaac.gamemodes;

import com.badlogic.gdx.math.MathUtils;
import com.isaac.gamemodes.levels.Endless_Level;
import com.isaac.gamemodes.levels._Level;
import com.isaac.gameobjects.fruits.Fruit;
import com.isaac.renderers.GameRenderer;

import java.util.List;
import java.util.Map;

/**
 * Created by Isaac Holloway on 3/24/2015.
 */
public class EndlessMode extends _GameMode {

    protected int currentLevelIndex;
    protected List<_Level> levels;

    /***/
    @Override
    protected void createLevelPool() {
        getLevels().add(new Endless_Level(this));
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
        return getFruitGivenType(selectedFruitType);
    }

    /***/
    public void renderGameMode(float delta, GameRenderer renderer) {
        getCurrentLevel().drawLevel(delta, renderer);
    }

    /***/
    @Override
    public void renderGameModeBG(float delta,  GameRenderer renderer) {
        getCurrentLevel().drawLevelBG(delta, renderer);
    }

    /***/
    public void setCurrentLevel(int index) {
        restartLevel();
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
//
//    /***/
//    @Override
//    public void restart() {
//        restartLevel();
//        clearStreak();
//        // TODO: Display a message that indicates the I Lost and the level is restarting.
//
//        setCurrentLevel(this.getCurrentLevelIndex());
//    }

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
    protected _Level getCurrentLevel() {
        return getLevels().get(getCurrentLevelIndex());
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public void setCurrentLevelIndex(int currentLevelIndex) {
        this.currentLevelIndex = currentLevelIndex;
    }

    public List<_Level> getLevels() {
        return levels;
    }

    public void setLevels(List<_Level> levels) {
        this.levels = levels;
    }
}
