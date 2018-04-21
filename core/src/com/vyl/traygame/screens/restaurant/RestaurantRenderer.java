package com.vyl.traygame.screens.restaurant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vyl.traygame.entities.Customer;
import com.vyl.traygame.entities.Table;

public class RestaurantRenderer {

    private RestaurantStuff stuff;
    private SpriteBatch batch;
    private Texture floor, wall, wall2;

    public RestaurantRenderer(RestaurantStuff stuff) {
        this.stuff = stuff;
        batch = new SpriteBatch();
        floor = new Texture(Gdx.files.internal("floor3.png"));
        wall = new Texture(Gdx.files.internal("wall.png"));
        wall2 = new Texture(Gdx.files.internal("wall2.png"));
    }

    public void render() {
        batch.begin();
        drawFloor();
        drawWall();

        drawCustomersBottom();
        drawTables();
        stuff.getCounter().renderBottom(batch);
        stuff.getWaiter().render(batch);
        stuff.getCounter().renderTop(batch);
        drawCustomersTop();
        drawToppings();
        stuff.getDialogBox().render(batch);
        if (stuff.isInteractionIsPossible() && !stuff.isInteracting()) {
            stuff.getInteractionBubble().render(batch, stuff.getInteractionKey());
        }
        stuff.getTimer().render(batch);
        batch.end();
    }

    private void drawFloor() {
        batch.setColor(Color.WHITE);
        int c = 10;
        int r = c; // prev was c * 3
        float width = Gdx.graphics.getWidth() / c;
        float height = Gdx.graphics.getHeight() / r;
        for (int columns = 0; columns < c; columns++) {
            for (int rows = 0; rows < r; rows++) {
                float xPos = columns * Gdx.graphics.getWidth() / c;
                if (rows % 2 == 1) {
                    batch.draw(
                            floor,
                            xPos - width / 2,
                            rows * Gdx.graphics.getHeight() / r,
                            width,
                            height
                    );
                    xPos += width / 2;
                }
                batch.draw(
                        floor,
                        xPos,
                        rows * Gdx.graphics.getHeight() / r,
                        width,
                        height
                );
            }
        }
    }

    private void drawWall() {
        float height1 = 150;
        float height2 = 100;
        batch.setColor(188f / 255f, 32f / 255f, 35f / 255f, 1);
        batch.draw(
                wall,
                0,
                Gdx.graphics.getHeight() - height1 - height2,
                Gdx.graphics.getWidth(),
                height1
        );
        batch.setColor(236f / 255f, 160f / 255f, 136f / 255f, 1);
        batch.draw(
                wall2,
                0,
                Gdx.graphics.getHeight() - height2,
                Gdx.graphics.getWidth(),
                height2
        );
    }

    private void drawCustomersTop() {
        for (Customer c : stuff.getCustomers()) {
            c.renderTop(batch);
        }
    }

    private void drawToppings() {
        for (Table t : stuff.getTables()) {
            t.renderToppings(batch);
        }
    }

    private void drawCustomersBottom() {
        for (Customer c : stuff.getCustomers()) {
            c.renderBottom(batch);
        }
    }

    private void drawTables() {
        for (Table t : stuff.getTables()) {
            t.render(batch);
        }
    }
}
