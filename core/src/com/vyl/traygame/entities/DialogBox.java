package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DialogBox {

    private Texture pixel;
    private BitmapFont font;

    public DialogBox() {
        pixel = new Texture(Gdx.files.internal("pixel.png"));
    }

    public void render(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        // LEFT
        batch.draw(
                pixel,
                0,
                0,
                pixel.getWidth() / 2,
                pixel.getHeight() / 2,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight() * 0.2f,
                1,
                1,
                0,
                0,
                0,
                pixel.getWidth(),
                pixel.getHeight(),
                false,
                false
        );
        // TOP
        batch.draw(
                pixel,
                0,
                0,
                pixel.getWidth() / 2,
                pixel.getHeight() / 2,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight() * 0.2f,
                1,
                1,
                0,
                0,
                0,
                pixel.getWidth(),
                pixel.getHeight(),
                false,
                false
        );
    }
}
