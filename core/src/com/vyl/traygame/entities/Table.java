package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Table {

    private Vector2 position;
    private Texture texture;

    public Table(Vector2 position) {
        texture = new Texture(Gdx.files.internal("table.png"));
        this.position = position;
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                texture,
                position.x,
                position.y,
                texture.getWidth() * 8,
                texture.getHeight() * 8
        );
    }
}
