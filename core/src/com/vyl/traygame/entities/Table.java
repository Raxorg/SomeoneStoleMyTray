package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Table extends Entity {

    private Texture texture;
    private Customer left, right;

    public Table(Vector2 position) {
        super(new Rectangle(
                (int) position.x,
                (int) position.y,
                17 * 8,
                12 * 8
        ));
        texture = new Texture(Gdx.files.internal("table.png"));
    }

    public void render(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                texture,
                bounds.x,
                bounds.y,
                texture.getWidth() * 8,
                texture.getHeight() * 8
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
                    bounds.x + texture.getWidth() * 8 - width,
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
