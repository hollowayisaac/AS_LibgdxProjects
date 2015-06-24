package com.isaac.ui.mainmenus;

import com.isaac.screens.MainMenuScreen;
import com.isaac.screens._Screen;
import com.isaac.ui._Menu;

/**
 * Created by Isaac Holloway on 6/21/2015.
 */
public class _MainMenu extends _Menu {
    /**
     * @param screen
     */
    public _MainMenu(_Screen screen) {
        super(screen);
    }

    /***/
    @Override
    protected void setMenuPanel() {
    }

    /***/
    @Override
    protected void setButtons() {
    }

    /***/
    protected MainMenuScreen getMainMenuScreen() {
        return (MainMenuScreen) screen;
    }
}
