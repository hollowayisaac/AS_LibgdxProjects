package com.isaac.screens;

import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.renderers.MainMenuRenderer;
import com.isaac.ui._Menu;
import com.isaac.ui.mainmenus.GameModeMenu;
import com.isaac.ui.mainmenus.HomeMenu;
import com.isaac.ui.mainmenus.LevelSelectionMenu;

/**
 * Created by Isaac Holloway on 5/16/2015.
 */
public class MainMenuScreen extends _Screen {

    public _Menu homeMenu;
    public _Menu gameModeMenu;
    public _Menu levelSelectionMenu;
    public _Menu optionsMenu;

    /**
     *      [CONSTRUCTOR]
     */
    public MainMenuScreen(AngryFVGame game) {
        super(game);
        this.renderer = new MainMenuRenderer(this);
    }

    /***/
    @Override
    public void init(){
        // Set initial menu
        setCurrentMenu(gameModeMenu);
    }

    /***/
    protected void createMenus() {
        this.homeMenu = new HomeMenu(this);
        this.gameModeMenu = new GameModeMenu(this);
        this.levelSelectionMenu = new LevelSelectionMenu(this);
/*        this.optionsMenu = new OptionsMenu(this);
        */
    }
}
