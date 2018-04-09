package com.vyl.traygame.screens.mainmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vyl.traygame.TrayGame;
import com.vyl.traygame.hud.Button;
import com.vyl.traygame.screens.restaurant.RestaurantStuff;

import java.util.ArrayList;

public class MainMenuStuff extends ScreenAdapter {

    private SpriteBatch batch;
    private BitmapFont font;
    private ArrayList<Button> buttons;
    private Texture bg1, bg2, button;
    private float time;
    private TrayGame game;

    public MainMenuStuff(final TrayGame game) {
        bg1 = new Texture(Gdx.files.internal("bg1.png"));
        bg2 = new Texture(Gdx.files.internal("bg2.png"));
        button = new Texture(Gdx.files.internal("button.png"));

        this.game = game;

        batch = new SpriteBatch();
        font = new BitmapFont();
        buttons = new ArrayList<>();
        buttons.add(new Button(
                button,
                Gdx.graphics.getWidth() / 2 - 150,
                Gdx.graphics.getHeight() / 2 - 50,
                300,
                100
        ) {
            @Override
            public void onAction() {
                game.setScreen(new RestaurantStuff());
            }
        });
    }

    @Override
    public void show() {
        time = 0;
    }

    @Override
    public void render(float delta) {
        // Derp stuff
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Time
        time += delta;

        // Drawing
        batch.begin();
        // BGs
        batch.setColor(0, 0, time / 4f, 1);
        batch.draw(
                bg1,
                0,
                0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );
        batch.setColor(0, 0, 1 - time / 4f, 1);
        batch.draw(
                bg2,
                0,
                0,
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );
        // Buttons
        for (Button b : buttons) {
            b.render(batch);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        bg1.dispose();
        bg2.dispose();
        button.dispose();
    }

    public void touchDown(float screenX, float screenY) {
        for (Button b : buttons) {
            if (b.isInside(screenX, screenY)) {
                b.onAction();
            }
        }
    }
}
