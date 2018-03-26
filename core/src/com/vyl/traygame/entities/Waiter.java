package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;

public class Waiter extends Entity {

    private Vector2 velocity;
    private Texture texture, shirt;
    private boolean facingLeft;

    public Waiter() {
        super(new Rectangle(
                0,
                (int) (Gdx.graphics.getHeight() * 0.2f),
                13 * 5,
                29 * 5
        ));
        velocity = new Vector2();
        texture = new Texture(Gdx.files.internal("guy.png"));
        shirt = new Texture(Gdx.files.internal("shirt.png"));
    }

    public void keyAction(int keycode, boolean down) {
        switch (keycode) {
            case Input.Keys.W:
                if (down)
                    velocity.y += 5;
                else
                    velocity.y -= 5;
                break;
            case Input.Keys.A:
                if (down)
                    velocity.x -= 5;
                else
                    velocity.x += 5;
                break;
            case Input.Keys.S:
                if (down)
                    velocity.y -= 5;
                else
                    velocity.y += 5;
                break;
            case Input.Keys.D:
                if (down)
                    velocity.x += 5;
                else
                    velocity.x -= 5;
                break;
        }
        if (velocity.x > 0) {
            facingLeft = false;
        }
        if (velocity.x < 0) {
            facingLeft = true;
        }
    }

    public void update() {
        bounds.x += velocity.x;
        bounds.y += velocity.y;
    }

    public void render(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        // Texture texture, float x, float y, float originX, float originY, float width, float height, float scaleX,
        // float scaleY, float rotation, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY
        batch.draw(
                texture,
                bounds.x,
                bounds.y,
                texture.getWidth() / 2,
                texture.getHeight() / 2,
                texture.getWidth() * 5,
                texture.getHeight() * 5,
                1,
                1,
                0,
                0,
                0,
                texture.getWidth(),
                texture.getHeight(),
                facingLeft,
                false
        );
        batch.draw(
                shirt,
                bounds.x,
                bounds.y,
                texture.getWidth() / 2,
                texture.getHeight() / 2,
                texture.getWidth() * 5,
                texture.getHeight() * 5,
                1,
                1,
                0,
                0,
                0,
                texture.getWidth(),
                texture.getHeight(),
                facingLeft,
                false
        );
    }
}
