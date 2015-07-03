package com.isaac.gamemodes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isaac.gamemodes.levels.Endless_Level;
import com.isaac.gamemodes.levels._Level;
import com.isaac.screens.GameScreen;

import java.util.List;

/**
 * Created by Isaac Holloway on 3/24/2015.
 */
public class EndlessMode extends _GameMode {

    protected int currentLevelIndex;
    protected List<_Level> levels;

    /**
     * [CONSTRUCTOR]
     *
     * @param gameScreen
     */
    public EndlessMode(GameScreen gameScreen) {
        super(gameScreen);
    }

    /***/
    @Override
    protected void createLevelPool() {
        getLevels().add(new Endless_Level(this));
    }

    /***/
    @Override
    public void init() {
        super.init();
        setCurrentLevel(0);
    }

    /***/
    public void renderGameMode(float delta, SpriteBatch batch) {
        getCurrentLevel().drawLevel(delta, batch);
    }

    /***/
    @Override
    public void renderGameModeBG(float delta, SpriteBatch batch) {
        getCurrentLevel().drawLevelBG(delta, batch);
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
