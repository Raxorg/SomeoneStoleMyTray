package com.vyl.traygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.vyl.traygame.entities.Customer;
import com.vyl.traygame.entities.DialogBox;
import com.vyl.traygame.entities.Table;
import com.vyl.traygame.entities.Waiter;

import java.util.Random;

public class RestaurantScreen extends ScreenAdapter {

    private DialogBox dialogBox;
    private Waiter waiter;
    private Texture floor;
    private DelayedRemovalArray<Customer> customers;
    private DelayedRemovalArray<Table> tables;
    private Random random;
    private SpriteBatch batch;

    public RestaurantScreen() {
        dialogBox = new DialogBox();
        waiter = new Waiter();
        floor = new Texture(Gdx.files.internal("floor.png"));
        random = new Random();
        batch = new SpriteBatch();
    }

    @Override
    public void show() {
        generateCustomers();
        generateTables();
    }

    @Override
    public void render(float delta) {
        waiter.update();

        batch.begin();
        drawFloor();
        drawCustomers();
        waiter.render(batch);
        drawTables();
        dialogBox.render(batch);
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
        for (Table t : tables) {
            t.render(batch);
        }
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

    private void generateTables() {
        tables = new DelayedRemovalArray<>();
        for (int i = 0; i < 5; i++) {
            tables.add(new Table(
                    new Vector2(
                            random.nextFloat() * Gdx.graphics.getWidth(),
                            random.nextFloat() * Gdx.graphics.getHeight()
                    )
            ));
        }
    }

    public void keyAction(int keycode, boolean down) {
        waiter.keyAction(keycode, down);
    }
}
