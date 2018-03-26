package com.vyl.traygame.entities;

import java.awt.Rectangle;

public abstract class Entity {

    protected Rectangle bounds;

    protected Entity(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
