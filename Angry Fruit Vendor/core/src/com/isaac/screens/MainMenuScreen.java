package com.isaac.screens;

import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.input.MainMenuInput;
import com.isaac.renderers.MainMenuRenderer;
import com.isaac.ui._Menu;
import com.isaac.ui.mainmenus.GameModeMenu;
import com.isaac.ui.mainmenus.HomeMenu;
import com.isaac.ui.mainmenus.StageSelectionMenu;

/**
 * Created by Isaac Holloway on 5/16/2015.
 */
public class MainMenuScreen extends _Screen {

    public _Menu homeMenu;
    public _Menu gameModeMenu;
    public _Menu stageSelectionMenu;
    public _Menu optionsMenu;

    /**
     *      [CONSTRUCTOR]
     */
    public MainMenuScreen(AngryFVGame game) {
        super(game);
        this.renderer = new MainMenuRenderer(this);
        this.input = new MainMenuInput(this);        
    }

    /***/
    protected void createMenus() {
        this.homeMenu = new HomeMenu(this);
        this.gameModeMenu = new GameModeMenu(this);
        this.stageSelectionMenu = new StageSelectionMenu(this);
/*        this.optionsMenu = new OptionsMenu(this);
        */

        // Set initial menu
        setCurrentMenu(homeMenu);
    }
}
