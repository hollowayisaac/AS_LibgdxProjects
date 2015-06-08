package com.isaac.gamemodes;

import com.isaac.gamemodes.levels.EndlessBaskets_Level;
import com.isaac.gamemodes.levels._Level;
import com.isaac.renderers.GameRenderer;

import java.util.List;

/**
 * Created by Isaac Holloway on 3/24/2015.
 */
public class EndlessBasketsMode extends _GameMode {

    protected int currentLevelIndex;
    protected List<_Level> levels;

    /***/
    @Override
    protected void createLevelPool() {
        getLevels().add(new EndlessBaskets_Level(this));
    }

    /***/
    @Override
    public void init() {
        super.init();
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
        initLevel();
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
            // TODO: Display score!

        } else {
            advanceCurrentLevel();
        }
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
