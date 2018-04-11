package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.vyl.traygame.enums.Interaction;
import com.vyl.traygame.helpers.Constants;

public class Counter extends Entity {

    private Texture counter, counter2, counter3, bottle, whiskey, computer;
    private Rectangle bottomBounds;

    public Counter() {
        super(
                "Counter",
                new Rectangle(
                        Gdx.graphics.getWidth() - 480 * 1.25f,
                        Gdx.graphics.getHeight() - Constants.WALL_HEIGHT - 30 * (360 / 90),
                        480,
                        360
                ),
                new Texture("counter.png")
        );
        bottomBounds = new Rectangle(
                Gdx.graphics.getWidth() - 480 * 1.25f,
                Gdx.graphics.getHeight() - Constants.WALL_HEIGHT - 30 * (360 / 90),
                480,
                80
        );
        counter = new Texture("counter.png");
        counter2 = new Texture("counter2.png");
        counter3 = new Texture("counter3.png");
        bottle = new Texture("bottle.png");
        whiskey = new Texture("whiskey.png");
        computer = new Texture("registradora.png");
    }

    public void renderBottom(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                counter,
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height
        );
        batch.draw(
                computer,
                bounds.x,
                bounds.y + 37 * (360 / 90),
                72 * 2,
                41 * 2
        );
    }

    public void renderTop(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                counter3,
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height
        );
        batch.draw(
                counter2,
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height
        );
        // 72, 34 botellas y
        // 47, 65 botellas x
        drawTopBottles(batch);
        drawBottomBottles(batch);
    }

    private void drawTopBottles(SpriteBatch batch) {
        float x = 57;
        batch.draw(
                bottle,
                bounds.x + x * (480 / 120),
                bounds.y + 72 * (360 / 90),
                15 * 1.4f,
                44 * 1.4f
        );
        batch.draw(
                bottle,
                bounds.x + (x + 8) * (480 / 120),
                bounds.y + 72 * (360 / 90),
                15 * 1.4f,
                44 * 1.4f
        );
        batch.draw(
                bottle,
                bounds.x + (x + 16) * (480 / 120),
                bounds.y + 72 * (360 / 90),
                15 * 1.4f,
                44 * 1.4f
        );
        batch.draw(
                whiskey,
                bounds.x + (x + 24) * (480 / 120),
                bounds.y + 72 * (360 / 90),
                23,
                58
        );
        batch.draw(
                bottle,
                bounds.x + (x + 32) * (480 / 120),
                bounds.y + 72 * (360 / 90),
                15 * 1.4f,
                44 * 1.4f
        );
        batch.draw(
                bottle,
                bounds.x + (x + 40) * (480 / 120),
                bounds.y + 72 * (360 / 90),
                15 * 1.4f,
                44 * 1.4f
        );
        batch.draw(
                bottle,
                bounds.x + (x + 48) * (480 / 120),
                bounds.y + 72 * (360 / 90),
                15 * 1.4f,
                44 * 1.4f
        );
    }

    private void drawBottomBottles(SpriteBatch batch) {
        float x = 73;
        batch.draw(
                whiskey,
                bounds.x + x * (480 / 120),
                bounds.y + 56 * (360 / 90),
                23,
                58
        );
        batch.draw(
                whiskey,
                bounds.x + (x + 9) * (480 / 120),
                bounds.y + 56 * (360 / 90),
                23 * 0.7f,
                58 * 0.7f
        );
        batch.draw(
                whiskey,
                bounds.x + (x + 16) * (480 / 120),
                bounds.y + 56 * (360 / 90),
                23,
                58
        );
        batch.draw(
                whiskey,
                bounds.x + (x + 25) * (480 / 120),
                bounds.y + 56 * (360 / 90),
                23 * 0.7f,
                58 * 0.7f
        );
        batch.draw(
                whiskey,
                bounds.x + (x + 32) * (480 / 120),
                bounds.y + 56 * (360 / 90),
                23,
                58
        );
    }

    @Override
    public void interact(Interaction interaction) {

    }

    public Rectangle getBottomBounds() {
        return bottomBounds;
    }
}
