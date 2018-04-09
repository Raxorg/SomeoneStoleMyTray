package com.vyl.traygame.helpers;

import com.vyl.traygame.entities.Entity;

public class Dialog {

    private Entity entity;
    private String text;
    private Dialog option1, option2;

    public Dialog(Entity entity, String text) {
        this.entity = entity;
        this.text = text;
    }

    public void setOptions(Dialog a, Dialog b) {
        option1 = a;
        option2 = b;
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
