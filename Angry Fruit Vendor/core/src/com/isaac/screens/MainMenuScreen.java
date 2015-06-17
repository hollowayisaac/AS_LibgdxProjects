package com.isaac.screens;

import com.isaac.angryfruitvendor.AngryFVGame;
import com.isaac.input.MainMenuInput;
import com.isaac.renderers.MainMenuRenderer;
import com.isaac.ui.mainmenus.HomeMenu;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 5/16/2015.
 */
public class MainMenuScreen extends _Screen {

    private _Menu homeMenu;
    private _Menu mainMenu;
    private _Menu gameModeMenu;
    private _Menu optionsMenu;
    private _Menu stageSelectionMenu;

    private _Menu currentMenu;

    /**
     *      [CONSTRUCTOR]
     */
    public MainMenuScreen(AngryFVGame game) {
        super(game);
        this.renderer = new MainMenuRenderer(this);
        this.input = new MainMenuInput(this);

        createMenus();
    }

    /***/
    private void createMenus() {
        this.homeMenu = new HomeMenu(this);
/*        this.mainMenu = new MainMenu(this);
        this.gameModeMenu = new GameModeMenu(this);
        this.optionsMenu = new OptionsMenu(this);
        this.stageSelectionMenu = new StageSelectionMenu(this);       */

        // Set initial menu
        this.currentMenu = homeMenu;
    }

    /***/
    @Override
    public _Menu getCurrentMenu() {
        return currentMenu;
    }
}
