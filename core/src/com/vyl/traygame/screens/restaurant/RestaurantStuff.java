package com.vyl.traygame.screens.restaurant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.vyl.traygame.entities.Counter;
import com.vyl.traygame.entities.Customer;
import com.vyl.traygame.entities.DialogBox;
import com.vyl.traygame.entities.Entity;
import com.vyl.traygame.entities.Table;
import com.vyl.traygame.entities.Waiter;
import com.vyl.traygame.enums.Action;
import com.vyl.traygame.enums.Interaction;
import com.vyl.traygame.helpers.DialogManager;
import com.vyl.traygame.hud.InteractionBubble;

import java.util.Random;

public class RestaurantStuff extends ScreenAdapter {

    private Random random;
    private RestaurantObserver observer;
    private RestaurantRenderer renderer;
    private DialogBox dialogBox;
    private Waiter waiter;
    private Counter counter;
    private DelayedRemovalArray<Customer> customers;
    private DelayedRemovalArray<Table> tables;

    private InteractionBubble interactionBubble;
    private boolean interactionIsPossible, interacting;
    private int interactionKey;
    private Interaction interaction;
    private Entity interactable;
    private DialogManager dialogManager;

    public RestaurantStuff() {
        random = new Random();

        observer = new RestaurantObserver(this);
        renderer = new RestaurantRenderer(this);

        dialogBox = new DialogBox(Gdx.graphics.getHeight() * 0.18f);
        waiter = new Waiter();
        counter = new Counter();

        generateTables();
        generateCustomers();

        interactionBubble = new InteractionBubble();

        dialogManager = new DialogManager(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        observer.update();
        renderer.render();
    }

    private void generateTables() {
        tables = new DelayedRemovalArray<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                tables.add(new Table(
                        new Vector2(
                                Gdx.graphics.getWidth() * 0.05f + i * 300,
                                Gdx.graphics.getHeight() * 0.2f + j * 250
                        )
                ));
            }
        }
    }

    private void generateCustomers() {
        customers = new DelayedRemovalArray<>();
        customers.add(new Customer(
                "Fred",
                this,
                true,
                new Vector2(),
                0
        ));
        for (Customer customer : customers) {
            boolean customerAssigned = false;
            while (!customerAssigned) {
                int randomTableIndex = random.nextInt(tables.size - 1);
                if (!tables.get(randomTableIndex).isFull()) {
                    boolean leftChair = random.nextBoolean();
                    if (tables.get(randomTableIndex).chairFree(leftChair)) {
                        tables.get(randomTableIndex).sitCustomer(
                                customer,
                                leftChair
                        );
                    } else {
                        tables.get(randomTableIndex).sitCustomer(
                                customer,
                                !leftChair
                        );
                    }
                    customerAssigned = true;
                }
            }
        }
    }

    public void showPossibleInteraction(int key, Interaction interaction, Entity interactable) {
        if (interactable instanceof Customer) {
            interactionBubble.setCustomer((Customer) interactable);
        }
        interactionKey = key;
        this.interaction = interaction;
        this.interactable = interactable;
        interactionIsPossible = true;
    }

    public void setInteractionIsPossible(boolean interactionIsPossible) {
        this.interactionIsPossible = interactionIsPossible;
    }

    public void keyAction(int keycode, boolean down) {
        if (waiter.getAction() == Action.TALKING) {
            if(down) {
                return;
            }
            switch (keycode) {
                case Input.Keys.A:
                    switch (dialogManager.getCurrentDialog().getType()) {
                        case START:
                            // TODO SHOW OPTIONS
                            observer.showDialog(dialogManager.getCurrentDialog());
                            System.out.println(dialogManager.getCurrentDialog().getText());
                            break;
                        case OPTION:
                            // TODO SHOW ANSWER
                            break;
                        case ANSWER:
                            // TODO SHOW OPTIONS
                            break;
                        case GAME_OVER:
                            // TODO SHOW GAME OVER SCREEN
                            break;
                        case END:
                            // TODO END CONVERSATION
                            break;
                    }
                    break;
                case Input.Keys.B:
                    observer.hideDialog();
                    waiter.setAction(Action.WALKING);
                    interacting = false;
                    break;
            }
            return;
        }

        waiter.handleArrows(keycode, down);

        if (keycode == interactionKey && !down && interactionIsPossible) {
            interactable.interact(interaction);
            interacting = true;
        }

        waiter.updateFacingDirection();
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public DialogBox getDialogBox() {
        return dialogBox;
    }

    public DelayedRemovalArray<Customer> getCustomers() {
        return customers;
    }

    public DelayedRemovalArray<Table> getTables() {
        return tables;
    }

    public RestaurantRenderer getRenderer() {
        return renderer;
    }

    public boolean isInteractionIsPossible() {
        return interactionIsPossible;
    }

    public boolean isInteracting() {
        return interacting;
    }

    public InteractionBubble getInteractionBubble() {
        return interactionBubble;
    }

    public int getInteractionKey() {
        return interactionKey;
    }

    public Counter getCounter() {
        return counter;
    }

    public void startDialog(int index) {
        observer.showDialog(waiter.getGreetingsDialog());
        dialogManager.setDialog(index);
    }
}
