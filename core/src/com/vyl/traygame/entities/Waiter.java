package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.vyl.traygame.hud.InteractionBubble;
import com.vyl.traygame.screens.RestaurantScreen;

public class Waiter extends Entity {

    private RestaurantScreen restaurantScreen;
    private Vector2 velocity;
    private Texture texture, shirt;
    private boolean facingLeft, interactionIsPossible, interacting;
    private int interactionKey;
    private Interaction interaction;
    private Entity interactable;
    private InteractionBubble interactionBubble;
    private Action action;

    public Waiter(RestaurantScreen restaurantScreen) {
        super(new Rectangle(
                0,
                (int) (Gdx.graphics.getHeight() * 0.2f),
                13 * 5,
                29 * 5
        ));
        this.restaurantScreen = restaurantScreen;
        velocity = new Vector2();
        texture = new Texture(Gdx.files.internal("guy.png"));
        shirt = new Texture(Gdx.files.internal("shirt.png"));
        interactionBubble = new InteractionBubble(this);
    }

    public void keyAction(int keycode, boolean down) {
        if (action == Action.TALKING) {
            if (keycode == Input.Keys.B) {
                restaurantScreen.hideDialog();
                action = Action.WALKING;
                interacting = false;
            } else {
                return;
            }
        }

        handleArrows(keycode, down);

        if (keycode == interactionKey && !down) {
            interactable.interact(interaction);
            interacting = true;
        }

        updateFacingDirection();
    }

    private void handleArrows(int keycode, boolean down) {
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

    private void updateFacingDirection() {
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
        drawWaiter(batch);
        if (interactionIsPossible && !interacting) {
            interactionBubble.render(batch, interactionKey);
        }
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

    public void showPossibleInteraction(int key, Interaction interaction, Entity interactable) {
        interactionKey = key;
        this.interaction = interaction;
        this.interactable = interactable;
        interactionIsPossible = true;
    }

    public void setInteractionIsPossible(boolean interactionIsPossible) {
        this.interactionIsPossible = interactionIsPossible;
    }

    @Override
    public void interact(Interaction interaction) {
        // TODO something with restaurantScreen
    }

    public boolean isFacingLeft() {
        return facingLeft;
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
}
