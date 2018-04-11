package com.vyl.traygame.helpers;

import com.vyl.traygame.entities.Entity;
import com.vyl.traygame.enums.DialogType;

public class Dialog {

    private Entity entity;
    private String text;
    private Dialog answer, option1, option2;
    private DialogType type;

    public Dialog(Entity entity, String text, DialogType type) {
        this.entity = entity;
        this.text = text;
        this.type = type;
    }

    public boolean hasNextDialogue() {
        return type != DialogType.END && type != DialogType.GAME_OVER;
    }

    public Dialog getAnswer() {
        return answer;
    }

    public DialogType getType() {
        return type;
    }

    public void setAnswer(Dialog answer) {
        this.answer = answer;
    }

    public void setOptions(Dialog optionA, Dialog optionB) {
        option1 = optionA;
        option2 = optionB;
    }

    public Entity getEntity() {
        return entity;
    }

    public String getText() {
        return text;
    }

    public Dialog getOption1() {
        return option1;
    }

    public Dialog getOption2() {
        return option2;
    }
}
