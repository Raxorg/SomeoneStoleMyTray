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
    private float fontWidth, fontHeight, height;
    private boolean visible;
    private Entity currentSpeaker;
    private float time;

    public DialogBox(float height) {
        dialog = "";
        pixel = new Texture(Gdx.files.internal("pixel.png"));
        font = new BitmapFont();
        font.getData().scale(2);
        this.height = height;
    }

    public void render(SpriteBatch batch) {
        if (visible) {
            renderBackground(batch);
            renderBorders(batch);
            renderImage(batch);
            renderText(batch);
        }
    }

    private void renderBorders(SpriteBatch batch) {
        batch.setColor(0, 0, 0.7f, 1);
        // LEFT
        batch.draw(
                pixel,
                0,
                0,
                pixel.getWidth() / 2,
                pixel.getHeight() / 2,
                10,
                height,
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
                height,
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
                height,
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
    }

    private void renderBackground(SpriteBatch batch) {
        batch.setColor(0.2f, 0.2f, 0.5f, 0.5f);
        batch.draw(
                pixel,
                10,
                10,
                Gdx.graphics.getWidth() - 20,
                height - 10
        );
    }

    private void renderImage(SpriteBatch batch) {
        batch.setColor(0, 0, 0.7f, 1);
        batch.draw(
                pixel,
                height,
                0,
                pixel.getWidth() / 2,
                pixel.getHeight() / 2,
                10,
                height,
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
        batch.setColor(Color.WHITE);
        batch.draw(
                currentSpeaker.getImage(),
                10,
                10,
                currentSpeaker.getImage().getWidth() / 2,
                currentSpeaker.getImage().getHeight() / 2,
                height - 20,
                height - 20,
                1,
                1,
                0,
                0,
                0,
                currentSpeaker.getImage().getWidth(),
                currentSpeaker.getImage().getHeight(),
                false,
                false
        );
    }

    private void renderText(SpriteBatch batch) {
        font.draw(
                batch,
                dialog,
                Gdx.graphics.getWidth() / 2 - fontWidth / 2,
                Gdx.graphics.getHeight() * 0.1f + fontHeight / 2
        );
    }

    public void update(Entity speaker, String dialog) {
        time = 0;
        this.currentSpeaker = speaker;
        this.dialog = dialog;
        GlyphLayout glyph = new GlyphLayout(font, dialog);
        fontWidth = glyph.width;
        fontHeight = glyph.height;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
