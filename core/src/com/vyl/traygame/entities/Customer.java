package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Customer {

    private Vector2 position;
    private Texture texture;

    public Customer(boolean male, Vector2 position) {
        if (male) {
            texture = new Texture(Gdx.files.internal("guy.png"));
        } else {
            texture = new Texture(Gdx.files.internal("girl.png"));
        }
        this.position = position;
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                texture,
                position.x,
                position.y,
                texture.getWidth() * 5,
                texture.getHeight() * 5
        );
    }
}
