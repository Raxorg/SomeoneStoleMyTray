package com.vyl.traygame.helpers;

import com.vyl.traygame.enums.DialogType;
import com.vyl.traygame.screens.restaurant.RestaurantStuff;

public class DialogManager {

    private Dialog[] dialogs;
    private Dialog currentDialog;
    private DialogType currentDialogType;

    public DialogManager(RestaurantStuff stuff) {
        dialogs = new Dialog[3];
        initFredSDialog(stuff);
        initTysonSDialog(stuff);
        initHansDialog(stuff);
    }

    private void initFredSDialog(RestaurantStuff stuff) {
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
                stuff.getCustomers().get(0),
                "SOMEONE HELP ME PLEASE!",
                DialogType.GAME_OVER
        );
        Dialog answer2212 = new Dialog(
                stuff.getCustomers().get(0),
                "No problem kiddo",
                DialogType.END
        );

        option2211.setAnswer(answer2211);
        option2212.setAnswer(answer2212);
        answer221.setOptions(option2211, option2212);
        option221.setAnswer(answer221);
        option222.setAnswer(answer222);
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

    private void initTysonSDialog(RestaurantStuff stuff) {
        dialogs[1] = new Dialog(
                stuff.getCustomers().get(1),
                "I would like the special please",
                DialogType.START
        );
        Dialog option1 = new Dialog(
                stuff.getWaiter(),
                "I would love to give you your order sir but I can´t serve you without my tray",
                DialogType.OPTION
        );
        Dialog option2 = new Dialog(
                stuff.getWaiter(),
                "But sir I have a big problem with that order",
                DialogType.OPTION
        );
        Dialog answer1 = new Dialog(
                stuff.getCustomers().get(1),
                "That’s not my problem at all, you have to bring my order now",
                DialogType.ANSWER
        );
        Dialog answer2 = new Dialog(
                stuff.getCustomers().get(1),
                "What would that problem be?",
                DialogType.ANSWER
        );
        Dialog option11 = new Dialog(
                stuff.getWaiter(),
                "But sir I can´t",
                DialogType.OPTION
        );
        Dialog option12 = new Dialog(
                stuff.getWaiter(),
                "Are you deaf? I can't serve you without my tray",
                DialogType.OPTION
        );
        Dialog answer11 = new Dialog(
                stuff.getCustomers().get(1),
                "You will bring me my order now or else you will pay",
                DialogType.TIMER
        );
        Dialog answer12 = new Dialog(
                stuff.getCustomers().get(1),
                "I'm not deaf but you must be blind because who can lose something as big as a tray?",
                DialogType.ANSWER
        );
        Dialog option121 = new Dialog(
                stuff.getWaiter(),
                "You are right sir, sorry for bothering you",
                DialogType.OPTION
        );
        Dialog option122 = new Dialog(
                stuff.getWaiter(),
                "Indeed I'm blind because I have seen your shitty face here",
                DialogType.OPTION
        );
        Dialog answer121 = new Dialog(
                stuff.getCustomers().get(1),
                "SORRY? LET ME TEACH YOU A LESSON COWARD",
                DialogType.GAME_OVER
        );
        Dialog answer122 = new Dialog(
                stuff.getCustomers().get(1),
                "Hahahaha that was a good one... like your mother",
                DialogType.ANSWER
        );
        Dialog option1221 = new Dialog(
                stuff.getWaiter(),
                "I'm going to kill you",
                DialogType.OPTION
        );
        Dialog option1222 = new Dialog(
                stuff.getWaiter(),
                "That's nice, at least she didn't left you a bad taste not like your mother did with me",
                DialogType.OPTION
        );
        Dialog answer1221 = new Dialog(
                stuff.getCustomers().get(1),
                "COME RIGHT AT ME BITCH",
                DialogType.GAME_OVER
        );
        Dialog answer1222 = new Dialog(
                stuff.getCustomers().get(1),
                "Hahahah you are funny I hope you find your tray",
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
                stuff.getCustomers().get(1),
                "And it´s my fault? I´ll give you an advice little guy. Don´t mess with guys like me, you don´t now who you are messing with",
                DialogType.ANSWER
        );
        Dialog answer22 = new Dialog(
                stuff.getCustomers().get(1),
                "A reward? That sounds very nice. May I know what is that reward?",
                DialogType.ANSWER
        );
        Dialog option211 = new Dialog(
                stuff.getWaiter(),
                "Sorry my bad",
                DialogType.OPTION
        );
        Dialog option212 = new Dialog(
                stuff.getWaiter(),
                "I’m messing with a pussy, that´s what I know",
                DialogType.OPTION
        );
        Dialog answer211 = new Dialog(
                stuff.getCustomers().get(1),
                "Be glad that I’m in a good mood",
                DialogType.END
        );
        Dialog answer212 = new Dialog(
                stuff.getCustomers().get(1),
                "You have some balls",
                DialogType.ANSWER
        );
        Dialog option2121 = new Dialog(
                stuff.getWaiter(),
                "More balls than you have",
                DialogType.OPTION
        );
        Dialog option2122 = new Dialog(
                stuff.getWaiter(),
                "Not as big as yours",
                DialogType.OPTION
        );
        Dialog answer2121 = new Dialog(
                stuff.getCustomers().get(1),
                "Damn! You don´t fear anything I appreciate that in a person. I wish you good luck in your search",
                DialogType.END
        );
        Dialog answer2122 = new Dialog(
                stuff.getCustomers().get(1),
                "YOU ARE RIGHT AND YOU WILL PAY FOR YOUR DISRESPECT",
                DialogType.GAME_OVER
        );
        Dialog option221 = new Dialog(
                stuff.getWaiter(),
                "We have a special dessert that it´s too expensive but its so delicious that your mouth is going to melt",
                DialogType.OPTION
        );
        Dialog option222 = new Dialog(
                stuff.getWaiter(),
                "The reward is my fist in your mouth because I would know that you stole my tray",
                DialogType.OPTION
        );
        Dialog answer221 = new Dialog(
                stuff.getCustomers().get(1),
                "That sounds pretty amazing. I would love to have any  information that would help you but I don´t have any kid",
                DialogType.ANSWER
        );
        Dialog answer222 = new Dialog(
                stuff.getCustomers().get(1),
                "LET ME SHOW YOU A REAL FIST!",
                DialogType.GAME_OVER
        );
        Dialog option2211 = new Dialog(
                stuff.getWaiter(),
                "Don't you dare to lie! I'll find answers breaking your head with a bottle",
                DialogType.OPTION
        );
        Dialog option2212 = new Dialog(
                stuff.getWaiter(),
                "Sorry for taking your time",
                DialogType.OPTION
        );
        Dialog answer2211 = new Dialog(
                stuff.getCustomers().get(1),
                "BRIGHT IT ON!",
                DialogType.GAME_OVER
        );
        Dialog answer2212 = new Dialog(
                stuff.getCustomers().get(1),
                "No problem son",
                DialogType.END
        );

        option2211.setAnswer(answer2211);
        option2212.setAnswer(answer2212);
        answer221.setOptions(option2211, option2212);
        option221.setAnswer(answer221);
        option222.setAnswer(answer222);
        answer22.setOptions(option221, option222);
        option2121.setAnswer(answer2121);
        option2122.setAnswer(answer2122);
        answer212.setOptions(option2121, option2122);
        option211.setAnswer(answer211);
        option212.setAnswer(answer212);
        answer21.setOptions(option211, option212);
        option21.setAnswer(answer21);
        option22.setAnswer(answer22);
        answer2.setOptions(option21, option22);
        option1221.setAnswer(answer1221);
        option1222.setAnswer(answer1222);
        answer122.setOptions(option1221, option1222);
        option121.setAnswer(answer121);
        option122.setAnswer(answer122);
        answer12.setOptions(option121, option122);
        option11.setAnswer(answer11);
        option12.setAnswer(answer12);
        answer1.setOptions(option11, option12);
        option1.setAnswer(answer1);
        option2.setAnswer(answer2);
        dialogs[1].setOptions(option1, option2);
    }

    private void initHansDialog(RestaurantStuff stuff) {
        dialogs[2] = new Dialog(
                stuff.getCustomers().get(2),
                "I would like the special please",
                DialogType.START
        );
        Dialog option1 = new Dialog(
                stuff.getWaiter(),
                "I would love to give you your order sir but I can’t serve you without my tray",
                DialogType.OPTION
        );
        Dialog option2 = new Dialog(
                stuff.getWaiter(),
                "But sir I have a big problem with that order",
                DialogType.OPTION
        );
        Dialog answer1 = new Dialog(
                stuff.getCustomers().get(2),
                "That’s not my problem at all, you have to bring my order now",
                DialogType.ANSWER
        );
        Dialog answer2 = new Dialog(
                stuff.getCustomers().get(2),
                "What would that problem be?",
                DialogType.ANSWER
        );
        Dialog option11 = new Dialog(
                stuff.getWaiter(),
                "But sir I...",
                DialogType.OPTION
        );
        Dialog option12 = new Dialog(
                stuff.getWaiter(),
                "Are you deaf? I can´t serve you without my tray",
                DialogType.OPTION
        );
        Dialog answer11 = new Dialog(
                stuff.getCustomers().get(2),
                "But nothing that´s not an excuse find a way to bring me what I ordered",
                DialogType.ANSWER
        );
        Dialog answer12 = new Dialog(
                stuff.getCustomers().get(2),
                "Yes, you can. Stop being disrespectful and bring me my order",
                DialogType.ANSWER
        );
        Dialog option111 = new Dialog(
                stuff.getWaiter(),
                "You don’t have to be so rude, I will try to find a way",
                DialogType.OPTION
        );
        Dialog option112 = new Dialog(
                stuff.getWaiter(),
                "Fucking jerk, I’m trying to do my best!",
                DialogType.OPTION
        );
        Dialog answer111 = new Dialog(
                stuff.getCustomers().get(2),
                "(nods with closed eyes)",
                DialogType.END
        );
        Dialog answer112 = new Dialog(
                stuff.getCustomers().get(2),
                "I WILL NOT STAND THAT BEHAVIOUR, CALL YOUR SUPERIOR",
                DialogType.GAME_OVER
        );
        Dialog option121 = new Dialog(
                stuff.getWaiter(),
                "I will sir. Please excuse my behavior",
                DialogType.OPTION
        );
        Dialog option122 = new Dialog(
                stuff.getWaiter(),
                "Disrespectful? I think you are the disrespectful one, coming to a place just for the fun of making someone lose his job that´s worse than any swearword",
                DialogType.OPTION
        );
        Dialog answer121 = new Dialog(
                stuff.getCustomers().get(2),
                "Just bring my order",
                DialogType.TIMER
        );
        Dialog answer122 = new Dialog(
                stuff.getCustomers().get(2),
                "What are you talking about?",
                DialogType.ANSWER
        );
        Dialog option1221 = new Dialog(
                stuff.getWaiter(),
                "I’m talking about the tray you have stolen",
                DialogType.OPTION
        );
        Dialog option1222 = new Dialog(
                stuff.getWaiter(),
                "I saw you put something in your bag",
                DialogType.OPTION
        );
        Dialog answer1221 = new Dialog(
                stuff.getCustomers().get(2),
                "THAT’S ENOUGH . I AM GOING TO TALK WITH YOUR MANAGER",
                DialogType.GAME_OVER
        );
        Dialog answer1222 = new Dialog(
                stuff.getCustomers().get(2),
                "What? How? I'm sorry I was desperate!",
                DialogType.ANSWER
        );
        Dialog option12221 = new Dialog(
                stuff.getWaiter(),
                "So it was you all this time!",
                DialogType.OPTION
        );
        Dialog option12222 = new Dialog(
                stuff.getWaiter(),
                "Give it back!",
                DialogType.OPTION
        );
        Dialog answer12221 = new Dialog(
                stuff.getCustomers().get(2),
                "Yes I confess. I stole a rose from the entrance please forgive me",
                DialogType.END
        );
        Dialog answer12222 = new Dialog(
                stuff.getCustomers().get(2),
                "Here you have. Please don't tell anyone about this (gives a rose)",
                DialogType.END
        );
        Dialog option21 = new Dialog(
                stuff.getWaiter(),
                "The problem is that you stole my goddam tray and I can’t do my fucking job if you don´t give me my tray",
                DialogType.OPTION
        );
        Dialog option22 = new Dialog(
                stuff.getWaiter(),
                "The problem is that I’m losing my memory and I can´t find my tray if someone find it I would give a nice reward to that person",
                DialogType.OPTION
        );
        Dialog answer21 = new Dialog(
                stuff.getCustomers().get(2),
                "I’m not in the mood to keep tolerating this, please go away",
                DialogType.ANSWER
        );
        Dialog answer22 = new Dialog(
                stuff.getCustomers().get(2),
                "I’m not interested",
                DialogType.END
        );
        Dialog option211 = new Dialog(
                stuff.getWaiter(),
                "Sorry my bad",
                DialogType.OPTION
        );
        Dialog option212 = new Dialog(
                stuff.getWaiter(),
                "I won’t move until you give me my tray",
                DialogType.OPTION
        );
        Dialog answer211 = new Dialog(
                stuff.getCustomers().get(2),
                "No problem",
                DialogType.END
        );
        Dialog answer212 = new Dialog(
                stuff.getCustomers().get(2),
                "THEN I WILL CALL THE POLICE",
                DialogType.GAME_OVER
        );

        option212.setAnswer(answer212);
        option211.setAnswer(answer211);
        answer21.setOptions(option211, option212);
        option21.setAnswer(answer21);
        option22.setAnswer(answer22);
        answer2.setOptions(option21, option22);
        option2.setAnswer(answer2);

        option12221.setAnswer(answer12221);
        option12222.setAnswer(answer12222);
        answer1222.setOptions(option12221, option12222);
        option1222.setAnswer(answer1222);
        option1221.setAnswer(answer1221);
        answer122.setOptions(option1221, option1222);
        option122.setAnswer(answer122);
        option121.setAnswer(answer121);
        answer12.setOptions(option121, option122);
        option111.setAnswer(answer111);
        option112.setAnswer(answer112);
        answer11.setOptions(option111, option112);
        option12.setAnswer(answer12);
        option11.setAnswer(answer11);
        answer1.setOptions(option11, option12);
        option1.setAnswer(answer1);

        dialogs[2].setOptions(option1, option2);
    }

    public Dialog[] getDialogs() {
        return dialogs;
    }

    public Dialog getCurrentDialog() {
        return currentDialog;
    }

    public void setCurrentDialog(Dialog currentDialog) {
        this.currentDialog = currentDialog;
    }

    public void setDialog(int index) {
        currentDialog = dialogs[index];
        currentDialogType = DialogType.GREETINGS;
    }

    public DialogType getCurrentDialogType() {
        return currentDialogType;
    }

    public void setCurrentDialogType(DialogType currentDialogType) {
        this.currentDialogType = currentDialogType;
    }
}
