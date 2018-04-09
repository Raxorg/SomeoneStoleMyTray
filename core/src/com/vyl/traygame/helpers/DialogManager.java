package com.vyl.traygame.helpers;

import com.vyl.traygame.screens.restaurant.RestaurantStuff;

public class DialogManager {

    private RestaurantStuff stuff;
    private Dialog[] dialogs;

    public DialogManager(RestaurantStuff stuff) {
        this.stuff = stuff;
        dialogs = new Dialog[1];
        dialogs[0] = new Dialog(stuff.getCustomers().get(0), "I have your tray");
        dialogs[0].setOptions(
                new Dialog(stuff.getWaiter(), "Punch him in the face"),
                new Dialog(stuff.getWaiter(), "Ok thanks")
        );
    }
}
