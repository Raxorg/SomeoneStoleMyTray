package com.vyl.traygame.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.vyl.traygame.TrayGame;

public class InputManager extends InputAdapter {

    private TrayGame game;

    public InputManager(TrayGame game) {
        this.game = game;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenY = Gdx.graphics.getHeight() - screenY;

        game.touchDown(screenX, screenY);

        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        game.keyAction(keycode, true);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        game.keyAction(keycode, false);
        return true;
    }
}
