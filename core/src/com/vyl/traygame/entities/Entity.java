package com.vyl.traygame.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

    protected Rectangle bounds;

    protected Entity(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public abstract void interact(Interaction interaction);

    public void setPosition(float x, float y) {
        bounds.setPosition(x, y);
    }

    public Vector2 getPosition() {
        return new Vector2(bounds.x, bounds.y);
    }
}
