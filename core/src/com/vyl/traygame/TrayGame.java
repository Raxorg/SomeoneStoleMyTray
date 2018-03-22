package com.vyl.traygame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vyl.traygame.screens.MainMenu;

public class TrayGame extends Game {

    private MainMenu mainMenu;

    @Override
    public void create() {
        mainMenu = new MainMenu(this);
        setScreen(mainMenu);
        Gdx.input.setInputProcessor(new InputManager(this));
    }

    public void touchDown(float screenX, float screenY) {
        mainMenu.touchDown(screenX,screenY);
    }
}
