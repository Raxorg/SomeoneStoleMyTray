package com.vyl.traygame.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.vyl.traygame.entities.Customer;
import com.vyl.traygame.entities.Interaction;
import com.vyl.traygame.entities.Table;
import com.vyl.traygame.entities.Waiter;
import com.vyl.traygame.screens.RestaurantScreen;

public class WaiterObserver {

    private RestaurantScreen restaurantScreen;
    private Waiter waiter;
    private DelayedRemovalArray<Customer> customers;
    private DelayedRemovalArray<Table> tables;

    public WaiterObserver(RestaurantScreen restaurantScreen, Waiter waiter,
                          DelayedRemovalArray<Customer> customers,
                          DelayedRemovalArray<Table> tables) {
        this.restaurantScreen = restaurantScreen;
        this.waiter = waiter;
        this.customers = customers;
        this.tables = tables;
    }

    public void checkWaiter() {
        for (Customer c : customers) {
            if (waiter.getBounds().intersects(c.getBounds())) {
                waiter.showPossibleInteraction(Input.Keys.A, Interaction.TALK, c);
                return;
            }
        }
        waiter.setInteractionIsPossible(false);
        restaurantScreen.hideDialog();
    }
}
