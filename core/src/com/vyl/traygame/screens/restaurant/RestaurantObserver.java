package com.vyl.traygame.screens.restaurant;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.vyl.traygame.entities.Action;
import com.vyl.traygame.entities.Customer;
import com.vyl.traygame.entities.Entity;
import com.vyl.traygame.entities.Interaction;
import com.vyl.traygame.entities.Table;

public class RestaurantObserver {

    private RestaurantStuff stuff;
    private boolean showingDialog;

    public RestaurantObserver(RestaurantStuff stuff) {
        this.stuff = stuff;
    }

    public void update() {
        stuff.getWaiter().update();

        if (!showingDialog) {
            checkWaiter();
        }
    }

    public void showDialog(Entity speaker, String dialog) {
        showingDialog = true;
        stuff.getDialogBox().update(speaker, dialog);
        stuff.getDialogBox().setVisible(true);
        stuff.getWaiter().setAction(Action.TALKING);
    }

    public void hideDialog() {
        showingDialog = false;
        stuff.getDialogBox().setVisible(false);
    }

    public void checkWaiter() {
        Rectangle waiterBounds = stuff.getWaiter().getBounds();
        for (Table t : stuff.getTables()) {
            if (waiterBounds.overlaps(t.getBounds())) {
                stuff.getWaiter().setPosition(
                        stuff.getWaiter().getPosition().x - stuff.getWaiter().getVelocity().x,
                        stuff.getWaiter().getPosition().y - stuff.getWaiter().getVelocity().y
                );
            }
        }
        boolean interactionIsPossible = false;
        for (Customer c : stuff.getCustomers()) {
            if (waiterBounds.overlaps(c.getDialogBounds())) {
                stuff.showPossibleInteraction(Input.Keys.A, Interaction.TALK, c);
                interactionIsPossible = true;
                break;
            }
        }
        stuff.setInteractionIsPossible(interactionIsPossible);

        if (stuff.getWaiter().getBounds().overlaps(stuff.getCounter().getBottomBounds())) {
            stuff.getWaiter().setPosition(
                    stuff.getWaiter().getPosition().x - stuff.getWaiter().getVelocity().x,
                    stuff.getWaiter().getPosition().y - stuff.getWaiter().getVelocity().y
            );
        }
    }
}
