package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.vyl.traygame.enums.Interaction;
import com.vyl.traygame.screens.restaurant.RestaurantStuff;
import com.vyl.traygame.util.Assets;

public class Customer extends Entity {

    private RestaurantStuff restaurantStuff;
    private TextureRegion top, bottom, shirtTop, shirtBottom;
    private boolean male, facingLeft;
    private Rectangle dialogBounds;
    private int index;

    public Customer(String name, RestaurantStuff restaurantStuff,
                    boolean male, Vector2 position, int index) {
        super(
                name,
                new Rectangle(
                        (int) position.x,
                        (int) position.y,
                        13 * 5,
                        29 * 5
                ),
                male ? Assets.instance.restaurantAssets.guyImage : Assets.instance.restaurantAssets.girlImage
        );
        dialogBounds = new Rectangle(
                (int) position.x - 10,
                (int) position.y - 10,
                13 * 5 + 20,
                29 * 5 + 20
        );
        this.restaurantStuff = restaurantStuff;
        this.male = male;
        if (male) {
            Texture guy = new Texture(Gdx.files.internal("guy.png"));
            Texture shirt = new Texture(Gdx.files.internal("shirt.png"));
            top = new TextureRegion(guy, 0, 0, 13, 15);
            bottom = new TextureRegion(guy, 0, 14, 13, 14);
            shirtTop = new TextureRegion(shirt, 0, 0, 13, 15);
            shirtBottom = new TextureRegion(shirt, 0, 14, 13, 14);
        } else {
            Texture girl = new Texture(Gdx.files.internal("girl.png"));
            top = new TextureRegion(girl, 0, 0, 11, 14);
            bottom = new TextureRegion(girl, 0, 14, 11, 14);
        }
        this.index = index;
    }

    public void renderTop(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                top,
                bounds.x,
                bounds.y + 14.5f * 5,
                top.getRegionWidth() / 2,
                top.getRegionHeight() / 2,
                top.getRegionWidth() * 5,
                top.getRegionHeight() * 5,
                1,
                1,
                0
        );
        if (male) {
            batch.setColor(Color.BLUE);
            batch.draw(
                    shirtTop,
                    bounds.x,
                    bounds.y + 14.5f * 5,
                    shirtTop.getRegionWidth() / 2,
                    shirtTop.getRegionHeight() / 2,
                    shirtTop.getRegionWidth() * 5,
                    shirtTop.getRegionHeight() * 5,
                    1,
                    1,
                    0
            );
        }
    }

    public void renderBottom(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                bottom,
                bounds.x,
                bounds.y,
                bottom.getRegionWidth() / 2,
                bottom.getRegionHeight() / 2,
                bottom.getRegionWidth() * 5,
                bottom.getRegionHeight() * 5,
                1,
                1,
                0
        );
        if (male) {
            batch.setColor(Color.BLUE);
            batch.draw(
                    shirtBottom,
                    bounds.x,
                    bounds.y,
                    shirtBottom.getRegionWidth() / 2,
                    shirtBottom.getRegionHeight() / 2,
                    shirtBottom.getRegionWidth() * 5,
                    shirtBottom.getRegionHeight() * 5,
                    1,
                    1,
                    0
            );
        }
    }

    public void setFacingDirection(boolean left) {
        facingLeft = left;
        top.flip(facingLeft, false);
        bottom.flip(facingLeft, false);
        if (male) {
            shirtTop.flip(facingLeft, false);
            shirtBottom.flip(facingLeft, false);
        }
    }

    public void setPosition(Vector2 position) {
        bounds.set(new Rectangle(
                (int) position.x,
                (int) position.y,
                13 * 5,
                29 * 5
        ));
        dialogBounds.set(new Rectangle(
                (int) position.x - 10,
                (int) position.y - 10,
                13 * 5 + 20,
                29 * 5 + 20
        ));
    }

    public boolean isFacingLeft() {
        return facingLeft;
    }

    public boolean isMale() {
        return male;
    }

    @Override
    public void interact(Interaction interaction) {
        switch (interaction) {
            case TALK:
                restaurantStuff.startDialog(index);
                break;
        }
    }

    public Rectangle getDialogBounds() {
        return dialogBounds;
    }
}
