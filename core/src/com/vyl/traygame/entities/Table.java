package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Table extends Entity {

    private Texture table, toppings;
    private Customer left, right;

    public Table(Vector2 position) {
        super(
                "Table",
                new Rectangle(
                        (int) position.x,
                        (int) position.y,
                        17 * 8,
                        12 * 8
                ),
                new Texture("table.png")
        );
        table = new Texture("table.png");
        toppings = new Texture("toppings.png");
    }

    public void render(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                table,
                bounds.x,
                bounds.y,
                table.getWidth() * 8,
                table.getHeight() * 8
        );
    }

    public void renderToppings(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                toppings,
                bounds.x,
                bounds.y,
                table.getWidth() * 8,
                table.getHeight() * 8
        );
    }

    public Vector2 getPosition() {
        return new Vector2(bounds.x, bounds.y);
    }

    public void sitCustomer(Customer customer, boolean left) {
        if (left) {
            this.left = customer;
            customer.setPosition(new Vector2(bounds.x, bounds.y));
        } else {
            this.right = customer;
            float width = customer.isMale() ? 13 * 5 : 11 * 5;
            customer.setPosition(new Vector2(
                    bounds.x + table.getWidth() * 8 - width,
                    bounds.y
            ));
            customer.setFacingDirection(true);
        }
    }

    public boolean isFull() {
        return left != null && right != null;
    }

    public boolean chairFree(boolean leftChair) {
        if (leftChair) {
            return this.left == null;
        } else {
            return this.right == null;
        }
    }

    @Override
    public void interact(Interaction interaction) {

    }
}
