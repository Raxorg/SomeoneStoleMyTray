package com.vyl.traygame.screens.restaurant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.vyl.traygame.entities.Customer;
import com.vyl.traygame.entities.Table;
import com.vyl.traygame.enums.Action;
import com.vyl.traygame.enums.Interaction;
import com.vyl.traygame.helpers.Dialog;

public class RestaurantObserver {

    private RestaurantStuff stuff;
    private boolean showingDialog, againstTime;

    public RestaurantObserver(RestaurantStuff stuff) {
        this.stuff = stuff;
    }

    public void update() {
        stuff.getWaiter().update();

        if (!showingDialog) {
            checkWaiter();
            if (againstTime) {
                stuff.getTimer().update();
            }
        } else {
            // TODO remember what to do here
        }
    }

    public void showDialog(Dialog dialog) {
        showingDialog = true;
        stuff.getDialogBox().update(dialog.getEntity(), dialog.getText());
        stuff.getDialogBox().setVisible(true);
        stuff.getWaiter().setAction(Action.TALKING);
    }

    public void showOptions(Dialog option1, Dialog option2) {
        showingDialog = true;
        stuff.getDialogBox().update(stuff.getWaiter(), option1.getText(), option2.getText());
        stuff.getDialogBox().setVisible(true);
        stuff.getWaiter().setAction(Action.TALKING);
    }

    public void hideDialog() {
        showingDialog = false;
        stuff.getDialogBox().setVisible(false);
    }

    public void checkWaiter() {
        Rectangle waiterBounds = stuff.getWaiter().getBounds();
        checkTables(waiterBounds);
        checkInteractions(waiterBounds);
        checkCounter(waiterBounds);
    }

    private void checkTables(Rectangle waiterBounds) {
        for (Table t : stuff.getTables()) {
            if (waiterBounds.overlaps(t.getBounds())) {
                stuff.getWaiter().setPosition(
                        stuff.getWaiter().getPosition().x - stuff.getWaiter().getVelocity().x,
                        stuff.getWaiter().getPosition().y - stuff.getWaiter().getVelocity().y
                );
            }
        }
    }

    private void checkInteractions(Rectangle waiterBounds) {
        boolean interactionIsPossible = false;
        for (Customer c : stuff.getCustomers()) {
            if (waiterBounds.overlaps(c.getDialogBounds())) {
                stuff.showPossibleInteraction(Input.Keys.A, Interaction.TALK, c);
                interactionIsPossible = true;
                break;
            }
        }
        stuff.setInteractionIsPossible(interactionIsPossible);
    }

    private void checkCounter(Rectangle waiterBounds) {
        if (waiterBounds.overlaps(stuff.getCounter().getBottomBounds())) {
            stuff.getWaiter().setPosition(
                    stuff.getWaiter().getPosition().x - stuff.getWaiter().getVelocity().x,
                    stuff.getWaiter().getPosition().y - stuff.getWaiter().getVelocity().y
            );
        }
    }

    public void setAgainstTime(boolean againstTime) {
        this.againstTime = againstTime;
        stuff.getTimer().setVisible(againstTime);
    }
}
