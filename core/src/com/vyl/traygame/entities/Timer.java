package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Timer {

    private BitmapFont font;
    private float time, timerWidth, timerHeight;
    private boolean visible;

    public Timer() {
        font = new BitmapFont();
        font.getData().scale(3);
        time = 60;
    }

    public void update() {
        time -= Gdx.graphics.getDeltaTime();
        GlyphLayout glyph = new GlyphLayout(font, (int) time + "");
        timerWidth = glyph.width;
        timerHeight = glyph.height;
    }

    public void render(SpriteBatch batch) {
        if (!visible) {
            return;
        }
        font.setColor(Color.RED);
        font.draw(
                batch,
                (int) time + "",
                Gdx.graphics.getWidth() / 2 - timerWidth / 2,
                Gdx.graphics.getHeight() - timerHeight / 2
        );
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
