package com.vyl.traygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.vyl.traygame.helpers.InputManager;
import com.vyl.traygame.screens.MainMenu;
import com.vyl.traygame.screens.RestaurantScreen;

public class TrayGame extends Game {

    private MainMenu mainMenu;

    @Override
    public void create() {
        mainMenu = new MainMenu(this);
        setScreen(mainMenu);
        Gdx.input.setInputProcessor(new InputManager(this));
    }

    public void touchDown(float screenX, float screenY) {
        if (screen instanceof MainMenu) {
            mainMenu.touchDown(screenX, screenY);
        }
    }

    public void keyAction(int keycode, boolean down) {
        if (screen instanceof RestaurantScreen) {
            ((RestaurantScreen) screen).keyAction(keycode, down);
        }
    }
}
