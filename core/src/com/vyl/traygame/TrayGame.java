package com.vyl.traygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.vyl.traygame.helpers.InputManager;
import com.vyl.traygame.screens.mainmenu.MainMenuStuff;
import com.vyl.traygame.screens.restaurant.RestaurantStuff;
import com.vyl.traygame.util.Assets;

public class TrayGame extends Game {

    @Override
    public void create() {
        AssetManager am = new AssetManager();
        Assets.instance.init(am);

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
