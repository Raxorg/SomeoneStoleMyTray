package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.vyl.traygame.screens.RestaurantScreen;

public class Customer extends Entity {

    private RestaurantScreen restaurantScreen;
    private Texture texture, shirt;
    private boolean male, facingLeft;
    private String dialog;

    public Customer(RestaurantScreen restaurantScreen, boolean male, Vector2 position) {
        super(new Rectangle(
                (int) position.x,
                (int) position.y,
                13 * 5,
                29 * 5
        ));
        this.restaurantScreen = restaurantScreen;
        this.male = male;
        if (male) {
            texture = new Texture(Gdx.files.internal("guy.png"));
            shirt = new Texture(Gdx.files.internal("shirt.png"));
        } else {
            texture = new Texture(Gdx.files.internal("girl.png"));
        }
        dialog = "Your code works lol";
    }

    public void render(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
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
        if (male) {
            batch.setColor(Color.BLUE);
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

    public void setFacingDirection(boolean left) {
        facingLeft = left;
    }

    public void setPosition(Vector2 position) {
        bounds.set(new Rectangle(
                (int) position.x,
                (int) position.y,
                13 * 5,
                29 * 5
        ));
    }

    public boolean isMale() {
        return male;
    }

    @Override
    public void interact(Interaction interaction) {
        switch (interaction) {
            case TALK:
                restaurantScreen.showDialog(dialog);
                break;
        }
    }
}
