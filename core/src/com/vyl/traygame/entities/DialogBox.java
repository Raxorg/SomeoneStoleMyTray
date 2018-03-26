package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DialogBox {

    private String dialog;
    private Texture pixel;
    private BitmapFont font;
    private float fontWidth, fontHeight;

    public DialogBox() {
        dialog = "";
        pixel = new Texture(Gdx.files.internal("pixel.png"));
        font = new BitmapFont();
        font.getData().scale(3);
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
                10,
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
        // RIGHT
        batch.draw(
                pixel,
                Gdx.graphics.getWidth() - 10,
                0,
                pixel.getWidth() / 2,
                pixel.getHeight() / 2,
                10,
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
                Gdx.graphics.getHeight() * 0.2f,
                pixel.getWidth() / 2,
                pixel.getHeight() / 2,
                Gdx.graphics.getWidth(),
                10,
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
        // BOTTOM
        batch.draw(
                pixel,
                0,
                0,
                pixel.getWidth() / 2,
                pixel.getHeight() / 2,
                Gdx.graphics.getWidth(),
                10,
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

        font.draw(
                batch,
                dialog,
                Gdx.graphics.getWidth() / 2 - fontWidth / 2,
                Gdx.graphics.getHeight() * 0.1f + fontHeight / 2
        );
    }

    public void update(String dialog) {
        this.dialog = dialog;
        GlyphLayout glyph = new GlyphLayout(font, dialog);
        fontWidth = glyph.width;
        fontHeight = glyph.height;
    }
}
