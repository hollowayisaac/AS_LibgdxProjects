package com.isaac.gamemodes;

import com.isaac.gamemodes.levels.StageMode_Level_1;
import com.isaac.gamemodes.levels.StageMode_Level_2;
import com.isaac.gamemodes.levels.StageMode_Level_3;
import com.isaac.gamemodes.levels.StageMode_Level_4;
import com.isaac.gamemodes.levels.StageMode_Level_5;
import com.isaac.gamemodes.levels.StageMode_Level_6;

/**
 * Created by Isaac Holloway on 12/9/2014.
 */
public class StageMode extends _GameMode {

    /***/
    protected void createLevelPool() {
        getLevels().add(new StageMode_Level_1(this));
        getLevels().add(new StageMode_Level_2(this));
        getLevels().add(new StageMode_Level_3(this));
        getLevels().add(new StageMode_Level_4(this));
        getLevels().add(new StageMode_Level_5(this));
        getLevels().add(new StageMode_Level_6(this));
    }

}
