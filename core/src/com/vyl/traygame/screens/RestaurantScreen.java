package com.vyl.traygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.vyl.traygame.entities.Customer;

import java.util.Random;

public class RestaurantScreen extends ScreenAdapter {

    private Texture table, floor;
    private DelayedRemovalArray<Customer> customers;
    private Random random;
    private SpriteBatch batch;

    public RestaurantScreen() {
        table = new Texture(Gdx.files.internal("table.png"));
        floor = new Texture(Gdx.files.internal("floor.png"));
        random = new Random();
        batch = new SpriteBatch();
    }

    @Override
    public void show() {
        generateCustomers();
    }

    @Override
    public void render(float delta) {
        batch.begin();
        drawFloor();
        drawCustomers();
        drawTables();
        batch.end();
    }

    private void drawFloor() {
        int c = 20;
        int r = c * 3;
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

    private void drawCustomers() {
        for (Customer c : customers) {
            c.render(batch);
        }
    }

    private void drawTables() {

    }

    private void generateCustomers() {
        customers = new DelayedRemovalArray<>();
        for (int i = 0; i < 5; i++) {
            customers.add(new Customer(
                    random.nextBoolean(),
                    new Vector2(
                            random.nextFloat() * Gdx.graphics.getWidth(),
                            random.nextFloat() * Gdx.graphics.getHeight()
                    )
            ));
        }
    }
}
