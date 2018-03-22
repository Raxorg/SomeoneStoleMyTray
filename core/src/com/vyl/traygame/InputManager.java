package com.vyl.traygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter{

    private TrayGame game;

    public InputManager(TrayGame game) {
        this.game = game;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenY = Gdx.graphics.getHeight() - screenY;

        game.touchDown(screenX,screenY);

        return true;
    }
}
