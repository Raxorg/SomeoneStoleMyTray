package com.vyl.traygame.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vyl.traygame.entities.Waiter;

public class InteractionBubble {

    private Waiter waiter;
    private Texture pressA1, pressA2, current;
    private float time, xPosition;

    public InteractionBubble(Waiter waiter) {
        this.waiter = waiter;
        pressA1 = new Texture("pressA1.png");
        pressA2 = new Texture("pressA2.png");
    }

    public void render(SpriteBatch batch, int interactionKey) {
        // Preparation
        batch.setColor(Color.WHITE);
        time += Gdx.graphics.getDeltaTime();
        // Current color
        if (time <= 1) {
            current = pressA2;
        } else if (time <= 2) {
            current = pressA1;
        } else {
            time = time - 2;
            current = pressA2;
        }
        // Position according to where the waiter is facing
        if (waiter.isFacingLeft()) {
            xPosition = waiter.getBounds().x + waiter.getBounds().width;
        } else {
            xPosition = waiter.getBounds().x - waiter.getBounds().width * 1.5f;
        }
        // Draw the action bubble
        batch.draw(
                current,
                xPosition,
                waiter.getBounds().y + waiter.getBounds().height,
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
                !waiter.isFacingLeft(),
                false
        );
    }
}
