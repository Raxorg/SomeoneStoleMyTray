package com.vyl.traygame.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Button {

    private Texture texture;
    protected float x, y, width, height;

    public Button(Texture texture, float x, float y, float width, float height) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void onAction();

    public void render(SpriteBatch batch) {
        batch.setColor(Color.RED);
        batch.draw(
                texture,
                x,
                y,
                width,
                height
        );
    }

    public boolean isInside(float screenX, float screenY) {
        if (screenX >= x && screenX <= x + width) {
            if (screenY >= y && screenY <= y + height) {
                return true;
            }
        }
        return false;
    }
}
