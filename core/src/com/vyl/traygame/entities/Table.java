package com.vyl.traygame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Table {

    private Vector2 position;
    private Texture texture;
    private Customer left, right;

    public Table(Vector2 position) {
        texture = new Texture(Gdx.files.internal("table.png"));
        this.position = position;
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                texture,
                position.x,
                position.y,
                texture.getWidth() * 8,
                texture.getHeight() * 8
        );
    }

    public Vector2 getPosition() {
        return position;
    }

    public void sitCustomer(Customer customer, boolean left) {
        if (left) {
            this.left = customer;
            customer.setPosition(position);
        } else {
            this.right = customer;
            float width = customer.isMale() ? 13 * 5 : 11 * 5;
            customer.setPosition(new Vector2(
                    position.x + texture.getWidth() * 8 - width,
                    position.y
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
}
