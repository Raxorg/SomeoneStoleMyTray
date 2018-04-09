package com.vyl.traygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.vyl.traygame.helpers.Constants;
import com.vyl.traygame.helpers.InputManager;
import com.vyl.traygame.screens.mainmenu.MainMenuStuff;
import com.vyl.traygame.screens.restaurant.RestaurantStuff;

public class TrayGame extends Game {

    @Override
    public void create() {
        Constants.init();
        setScreen(new MainMenuStuff(this));
        Gdx.input.setInputProcessor(new InputManager(this));
    }

    public void touchDown(float screenX, float screenY) {
        if (screen instanceof MainMenuStuff) {
            ((MainMenuStuff) screen).touchDown(screenX, screenY);
        }
    }

    public void keyAction(int keycode, boolean down) {
        if (screen instanceof RestaurantStuff) {
            ((RestaurantStuff) screen).keyAction(keycode, down);
        }
    }
}
