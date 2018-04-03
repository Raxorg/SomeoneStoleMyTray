package com.vyl.traygame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.vyl.traygame.entities.Action;
import com.vyl.traygame.entities.Customer;
import com.vyl.traygame.entities.DialogBox;
import com.vyl.traygame.entities.Table;
import com.vyl.traygame.entities.Waiter;
import com.vyl.traygame.helpers.WaiterObserver;

import java.util.Random;

public class RestaurantScreen extends ScreenAdapter {

    private DialogBox dialogBox;
    private Waiter waiter;
    private Texture floor, wall;
    private DelayedRemovalArray<Customer> customers;
    private DelayedRemovalArray<Table> tables;
    private Random random;
    private SpriteBatch batch;
    private WaiterObserver observer;
    private boolean showingDialog;

    public RestaurantScreen() {
        dialogBox = new DialogBox(Gdx.graphics.getHeight() * 0.18f);
        waiter = new Waiter(this);
        floor = new Texture(Gdx.files.internal("floor.png"));
        wall = new Texture(Gdx.files.internal("wall.png"));
        random = new Random();
        batch = new SpriteBatch();
    }

    @Override
    public void show() {
        generateTables();
        generateCustomers(5 + random.nextInt(11));
        observer = new WaiterObserver(this, waiter, customers, tables);
    }

    @Override
    public void render(float delta) {
        waiter.update();

        if (!showingDialog) {
            observer.checkWaiter();
        }

        batch.begin();
        drawFloor();
        drawWall();
        waiter.render(batch);
        drawCustomers();
        drawTables();
        dialogBox.render(batch);
        batch.end();
    }

    private void drawFloor() {
        batch.setColor(Color.WHITE);
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

    private void drawWall() {
        float height = 250;
        batch.draw(
                wall,
                0,
                Gdx.graphics.getHeight() - height,
                Gdx.graphics.getWidth(),
                height
        );
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

    private void generateTables() {
        tables = new DelayedRemovalArray<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                tables.add(new Table(
                        new Vector2(
                                Gdx.graphics.getWidth() * 0.05f + i * 300,
                                Gdx.graphics.getHeight() * 0.2f + j * 250
                        )
                ));
            }
        }
    }

    private void generateCustomers(int quantity) {
        if (quantity > tables.size * 2) {
            return;
        }
        customers = new DelayedRemovalArray<>();
        for (int i = 0; i < quantity; i++) {
            boolean male = random.nextBoolean();
            boolean customerAssigned = false;
            while (!customerAssigned) {
                int randomTableIndex = random.nextInt(tables.size - 1);
                if (!tables.get(randomTableIndex).isFull()) {
                    Customer customer = new Customer(
                            this,
                            male,
                            tables.get(randomTableIndex).getPosition()
                    );
                    boolean leftChair = random.nextBoolean();
                    if (tables.get(randomTableIndex).chairFree(leftChair)) {
                        tables.get(randomTableIndex).sitCustomer(
                                customer,
                                leftChair
                        );
                    } else {
                        tables.get(randomTableIndex).sitCustomer(
                                customer,
                                !leftChair
                        );
                    }
                    customers.add(customer);
                    customerAssigned = true;
                }
            }
        }
    }

    public void keyAction(int keycode, boolean down) {
        waiter.keyAction(keycode, down);
    }

    public void showDialog(String dialog) {
        showingDialog = true;
        dialogBox.update(dialog);
        dialogBox.setVisible(true);
        waiter.setAction(Action.TALKING);
    }

    public void hideDialog() {
        showingDialog = false;
        dialogBox.setVisible(false);
    }
}
