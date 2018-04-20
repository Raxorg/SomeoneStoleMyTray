package com.vyl.traygame.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.vyl.traygame.enums.Interaction;
import com.vyl.traygame.util.Assets;

public class Table extends Entity {

    private TextureRegion table, toppings;
    private Customer left, right;

    public Table(Vector2 position) {
        super(
                "Table",
                new Rectangle(
                        (int) position.x,
                        (int) position.y,
                        17 * 8,
                        9 * 8
                ),
                Assets.instance.restaurantAssets.table
        );
        table = Assets.instance.restaurantAssets.table;
        toppings = Assets.instance.restaurantAssets.toppings;
    }

    public void render(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                table,
                bounds.x,
                bounds.y,
                table.getRegionWidth() * 8,
                table.getRegionHeight() * 8
        );
    }

    public void renderToppings(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                toppings,
                bounds.x,
                bounds.y + (table.getRegionHeight() * 8),
                toppings.getRegionWidth() * 8,
                toppings.getRegionHeight() * 8
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
                    bounds.x + table.getRegionWidth() * 8 - width,
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
