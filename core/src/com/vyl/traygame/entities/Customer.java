package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;

public class Customer extends Entity {

    private Texture texture, shirt;
    private boolean male;

    public Customer(boolean male, Vector2 position) {
        super(new Rectangle(
                (int) position.x,
                (int) position.y,
                13 * 5,
                29 * 5
        ));
        this.male = male;
        if (male) {
            texture = new Texture(Gdx.files.internal("guy.png"));
            shirt = new Texture(Gdx.files.internal("shirt.png"));
        } else {
            texture = new Texture(Gdx.files.internal("girl.png"));
        }
    }

    public void render(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                texture,
                bounds.x,
                bounds.y,
                texture.getWidth() * 5,
                texture.getHeight() * 5
        );
        if (male) {
            batch.setColor(Color.BLUE);
            batch.draw(
                    shirt,
                    bounds.x,
                    bounds.y,
                    texture.getWidth() * 5,
                    texture.getHeight() * 5
            );
        }
    }
}
