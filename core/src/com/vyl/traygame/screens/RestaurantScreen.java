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
import com.vyl.traygame.helpers.WaiterObserver;

import java.util.Random;

public class RestaurantScreen extends ScreenAdapter {

    private DialogBox dialogBox;
    private Waiter waiter;
    private Texture floor;
    private DelayedRemovalArray<Customer> customers;
    private DelayedRemovalArray<Table> tables;
    private Random random;
    private SpriteBatch batch;
    private WaiterObserver observer;

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
        observer = new WaiterObserver(this, waiter, customers, tables);
    }

    @Override
    public void render(float delta) {
        waiter.update();

        observer.checkWaiter();

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
        float xSpace = Gdx.graphics.getWidth() - 13 * 5;
        float ySpace = Gdx.graphics.getHeight() * 0.8f - 29 * 5;
        for (int i = 0; i < 5; i++) {
            customers.add(new Customer(
                    random.nextBoolean(),
                    new Vector2(
                            random.nextFloat() * xSpace,
                            random.nextFloat() * ySpace + Gdx.graphics.getHeight() * 0.2f
                    )
            ));
        }
    }

    private void generateTables() {
        tables = new DelayedRemovalArray<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                tables.add(new Table(
                        new Vector2(
                                Gdx.graphics.getWidth() / 3 + i * 300,
                                Gdx.graphics.getHeight() * 0.3f + j * 250
                        )
                ));
            }
        }
    }

    public void keyAction(int keycode, boolean down) {
        waiter.keyAction(keycode, down);
    }

    public void showDialog(String dialog) {
        dialogBox.update(dialog);
    }
}
