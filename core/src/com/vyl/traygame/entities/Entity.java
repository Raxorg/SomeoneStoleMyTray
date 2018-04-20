package com.vyl.traygame.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.vyl.traygame.enums.Interaction;

public abstract class Entity {

    private String name;
    Rectangle bounds;
    private TextureRegion image;

    Entity(String name, Rectangle bounds, TextureRegion image) {
        this.name = name;
        this.bounds = bounds;
        this.image = image;
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

    public String getName() {
        return name;
    }

    public TextureRegion getImage() {
        return image;
    }
}
