package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.vyl.traygame.enums.Action;
import com.vyl.traygame.enums.DialogType;
import com.vyl.traygame.enums.Interaction;
import com.vyl.traygame.helpers.Constants;
import com.vyl.traygame.helpers.Dialog;

public class Waiter extends Entity {

    private Vector2 velocity;
    private Texture texture, shirt;
    private boolean facingLeft;
    private Action action;
    private Dialog greetingsDialog;

    public Waiter() {
        super(
                "Sveen",
                new Rectangle(
                        0,
                        (int) (Gdx.graphics.getHeight() * 0.2f),
                        13 * 5,
                        29 * 5 / 2
                ), new Texture("waiterImage.png")
        );
        velocity = new Vector2();
        texture = new Texture(Gdx.files.internal("guy.png"));
        shirt = new Texture(Gdx.files.internal("shirt.png"));
        action = Action.WALKING;
        greetingsDialog = new Dialog(
                this,
                "Excuse me, may I have your order?",
                DialogType.GREETINGS
        );
    }

    public void handleArrows(int keycode, boolean down) {
        switch (keycode) {
            case Input.Keys.UP:
                if (down) {
                    if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                        velocity.y = 0;
                    } else {
                        velocity.y = 5;
                    }
                } else {
                    if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                        velocity.y = -5;
                    } else {
                        velocity.y = 0;
                    }
                }
                break;
            case Input.Keys.LEFT:
                if (down) {
                    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                        velocity.x = 0;
                    } else {
                        velocity.x = -5;
                    }
                } else {
                    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                        velocity.x = 5;
                    } else {
                        velocity.x = 0;
                    }
                }
                break;
            case Input.Keys.DOWN:
                if (down) {
                    if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                        velocity.y = 0;
                    } else {
                        velocity.y = -5;
                    }
                } else {
                    if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                        velocity.y = 5;
                    } else {
                        velocity.y = 0;
                    }
                }
                break;
            case Input.Keys.RIGHT:
                if (down) {
                    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                        velocity.x = 0;
                    } else {
                        velocity.x = 5;
                    }
                } else {
                    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                        velocity.x = -5;
                    } else {
                        velocity.x = 0;
                    }
                }
                break;
        }
    }

    public void updateFacingDirection() {
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

        bounds.x = Math.max(bounds.x, 0);
        bounds.x = Math.min(bounds.x, Gdx.graphics.getWidth() - 13 * 5);
        bounds.y = Math.max(bounds.y, 0);
        bounds.y = Math.min(bounds.y, Gdx.graphics.getHeight() - Constants.WALL_HEIGHT - 15);
    }

    public void render(SpriteBatch batch) {
        drawWaiter(batch);
    }

    private void drawWaiter(SpriteBatch batch) {
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

    @Override
    public void interact(Interaction interaction) {
        // TODO something with restaurantStuff
    }

    public void setAction(Action action) {
        switch (action) {
            case WALKING:
                break;
            case TALKING:
                velocity.set(0, 0);
                break;
        }
        this.action = action;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Action getAction() {
        return action;
    }

    public Rectangle getFullBounds() {
        return new Rectangle(
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height * 2
        );
    }

    public Dialog getGreetingsDialog() {
        return greetingsDialog;
    }
}
