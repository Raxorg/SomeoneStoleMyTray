package com.vyl.traygame.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();

    public RestaurantAssets restaurantAssets;

    private AssetManager assetManager;

    private Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constants.RESTAURANT_TEXTURES, Texture.class);
        assetManager.finishLoading();

        Texture restaurant = assetManager.get(Constants.RESTAURANT_TEXTURES);
        restaurantAssets = new RestaurantAssets(restaurant);
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class RestaurantAssets {

        public final TextureRegion table;
        public final TextureRegion toppings;
        public final TextureRegion bottomCounter;
        public final TextureRegion topCounter;
        public final TextureRegion shelve;
        public final TextureRegion counter;
        public final TextureRegion waiterImage;
        public final TextureRegion guy;
        public final TextureRegion girl;

        public RestaurantAssets(Texture restaurant) {
            // Table
            table = new TextureRegion(restaurant, 120, 81, 17, 9);
            toppings = new TextureRegion(restaurant, 120, 78, 17, 3);
            // Counter
            bottomCounter = new TextureRegion(restaurant, 0, 71, 120, 19);
            topCounter = new TextureRegion(restaurant, 0, 53, 120, 18);
            shelve = new TextureRegion(restaurant, 46, 0, 74, 35);
            counter = new TextureRegion(restaurant, 0, 0, 120, 90);
            // People
            waiterImage = new TextureRegion(restaurant, 0, 13, 13, 13);
            guy = new TextureRegion(restaurant, 0, 0, 13, 13);
            girl = new TextureRegion(restaurant, 13, 0, 11, 11);
        }
    }

}
