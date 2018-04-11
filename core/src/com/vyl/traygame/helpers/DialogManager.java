package com.vyl.traygame.helpers;

import com.vyl.traygame.enums.DialogType;
import com.vyl.traygame.screens.restaurant.RestaurantStuff;

public class DialogManager {

    private Dialog[] dialogs;
    private Dialog currentDialog;

    public DialogManager(RestaurantStuff stuff) {
        dialogs = new Dialog[1];
        dialogs[0] = new Dialog(
                stuff.getCustomers().get(0),
                "I would like a salad please",
                DialogType.START
        );
        Dialog option1 = new Dialog(
                stuff.getWaiter(),
                "I would love to give you your order sir, but I can't serve you without my tray",
                DialogType.OPTION
        );
        Dialog option2 = new Dialog(
                stuff.getWaiter(),
                "But sir I have a big problem with that order",
                DialogType.OPTION
        );
        Dialog answer1 = new Dialog(
                stuff.getCustomers().get(0),
                "I’m sorry to hear that son, if I see your tray I will tell you",
                DialogType.ANSWER
        );
        Dialog answer2 = new Dialog(
                stuff.getCustomers().get(0),
                "What would that problem be?",
                DialogType.ANSWER
        );
        Dialog option11 = new Dialog(
                stuff.getWaiter(),
                "Sir. I don´t want any trouble with you but that lady over there told me that you took my tray so please sir there will be no problem if you just return my tray now",
                DialogType.OPTION
        );
        Dialog option12 = new Dialog(
                stuff.getWaiter(),
                "Thank you sir. I’m sorry for bothering you. I’ll bring your order when I’ll encounter my tray. Please have patience",
                DialogType.OPTION
        );
        Dialog answer11 = new Dialog(
                stuff.getCustomers().get(0),
                "What?! You must be joking. I’m not a criminal. That lady is a liar",
                DialogType.ANSWER
        );
        Dialog answer12 = new Dialog(
                stuff.getCustomers().get(0),
                "Good luck kiddo",
                DialogType.END
        );
        Dialog option111 = new Dialog(
                stuff.getWaiter(),
                "You are the one who lies",
                DialogType.OPTION
        );
        Dialog option112 = new Dialog(
                stuff.getWaiter(),
                "Excuse me sir, I shouldn't have listen to that crazy lady",
                DialogType.OPTION
        );
        Dialog answer111 = new Dialog(
                stuff.getCustomers().get(0),
                "THAT´S NOT THE PROPER WAY TO TREAT A CUSTOMER. LET ME TALK WITH YOU MANAGER",
                DialogType.GAME_OVER
        );
        Dialog answer112 = new Dialog(
                stuff.getCustomers().get(0),
                "I hope that never happens again",
                DialogType.END
        );
        Dialog option21 = new Dialog(
                stuff.getWaiter(),
                "The problem is that you stole my goddam tray and I can’t do my fucking job if you don´t give me my tray",
                DialogType.OPTION
        );
        Dialog option22 = new Dialog(
                stuff.getWaiter(),
                "The problem is that I’m losing my memory and I can´t find my tray if someone find it i would give a nice reward to that person",
                DialogType.OPTION
        );
        Dialog answer21 = new Dialog(
                stuff.getCustomers().get(0),
                "YOU ARE NUTS KID. I DEMAND TO TALK WITH YOUR MANAGER",
                DialogType.GAME_OVER
        );
        Dialog answer22 = new Dialog(
                stuff.getCustomers().get(0),
                "A reward? That sounds very nice. May I know what is that reward?",
                DialogType.ANSWER
        );
        Dialog option221 = new Dialog(
                stuff.getWaiter(),
                "We have a special dessert that it´s too expensive but it’s so delicious that your mouth is going to melt",
                DialogType.OPTION
        );
        Dialog option222 = new Dialog(
                stuff.getWaiter(),
                "The reward is my fist in your mouth because I would know that you stole my tray",
                DialogType.OPTION);
        Dialog answer221 = new Dialog(
                stuff.getCustomers().get(0),
                "That sounds pretty amazing. I would love to have any information that would help you but I don´t have any kid",
                DialogType.ANSWER
        );
        Dialog answer222 = new Dialog(
                stuff.getCustomers().get(0),
                "SOMEONE CALL THE POLICE",
                DialogType.GAME_OVER
        );
        Dialog option2211 = new Dialog(
                stuff.getWaiter(),
                "Don’t you dare to lie! I’ll find answers breaking your head with a bottle",
                DialogType.OPTION
        );
        Dialog option2212 = new Dialog(
                stuff.getWaiter(),
                "Sorry for taking your time",
                DialogType.OPTION
        );
        Dialog answer2211 = new Dialog(
                stuff.getWaiter(),
                "SOMEONE HELP ME PLEASE!",
                DialogType.GAME_OVER
        );
        Dialog answer2212 = new Dialog(
                stuff.getWaiter(),
                "No problem kiddo",
                DialogType.END
        );

        option2211.setAnswer(answer2211);
        option2212.setAnswer(answer2212);
        answer221.setOptions(option2211, option2212);
        option221.setAnswer(answer221);
        option221.setAnswer(answer222);
        answer22.setOptions(option221, option222);
        option21.setAnswer(answer21);
        option22.setAnswer(answer22);
        answer2.setOptions(option21, option22);
        option111.setAnswer(answer111);
        option112.setAnswer(answer112);
        answer11.setOptions(option111, option112);
        option11.setAnswer(answer11);
        option12.setAnswer(answer12);
        answer1.setOptions(option11, option12);
        option1.setAnswer(answer1);
        option2.setAnswer(answer2);
        dialogs[0].setOptions(option1, option2);
    }

    public Dialog[] getDialogs() {
        return dialogs;
    }

    public Dialog getCurrentDialog() {
        return currentDialog;
    }

    public void nextDialog() {
        switch (currentDialog.getType()) {
            case START:
                break;
            case OPTION:
                break;
            case ANSWER:
                break;
            case GAME_OVER:
                break;
            case END:
                break;
        }
    }

    public void setDialog(int index) {
        currentDialog = dialogs[index];
    }
}
