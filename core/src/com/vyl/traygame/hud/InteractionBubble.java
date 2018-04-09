package com.vyl.traygame.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vyl.traygame.entities.Customer;

public class InteractionBubble {

    private Texture pressA1, pressA2, current;
    private float time, xPosition;
    private Customer customer;

    public InteractionBubble() {
        pressA1 = new Texture("pressA1.png");
        pressA2 = new Texture("pressA2.png");
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void render(SpriteBatch batch, int interactionKey) {
        // Preparation
        batch.setColor(Color.WHITE);
        time += Gdx.graphics.getDeltaTime();
        // Current color
        if (time <= 0.5f) {
            current = pressA2;
        } else if (time <= 1) {
            current = pressA1;
        } else {
            time = time - 1;
            current = pressA2;
        }
        // Position according to where the waiter is facing
        if (customer.isFacingLeft()) {
            xPosition = customer.getBounds().x + customer.getBounds().width;
        } else {
            xPosition = customer.getBounds().x - customer.getBounds().width * 1.5f;
        }
        // Draw the action bubble
        batch.draw(
                current,
                xPosition,
                customer.getBounds().y + customer.getBounds().height,
                current.getWidth() / 2,
                current.getHeight() / 2,
                current.getWidth(),
                current.getHeight(),
                1,
                1,
                0,
                0,
                0,
                current.getWidth(),
                current.getHeight(),
                !customer.isFacingLeft(),
                false
        );
    }
}
