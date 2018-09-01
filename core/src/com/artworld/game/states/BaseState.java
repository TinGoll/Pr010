package com.artworld.game.states;

import com.artworld.game.Application;
import com.artworld.game.system.asset.BaseAsset;
import com.artworld.game.system.managers.GameStateManager;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class BaseState {

    protected Application app;
    protected GameStateManager gsm;
    protected SpriteBatch batch;
    protected Stage stage;

    protected BaseAsset<?>[] assets;
    protected boolean active = false;
    protected boolean isAssetsInitialized;
    protected float w, h;

    protected OrthographicCamera camera;
    protected Viewport viewport;

    public void create(GameStateManager gsm){
        this.gsm = gsm;
        this.app = gsm.application();
        batch = new SpriteBatch();
        w = app.w;
        h = app.h;
        camera = new OrthographicCamera();
        viewport = new FitViewport(w, h, camera);
        stage = new Stage(viewport, batch);
        stage.clear();
        initAssets();
    }

    public void loadAssets() {
        BaseAsset<?>[] assets = getAssets();
        for (BaseAsset<?> asset : assets) {
            if(!asset.isLoaded())
                asset.load();
        }
    }
    protected void unloadAssets() {
        isAssetsInitialized = false;
        for (BaseAsset<?> asset : assets) {
            asset.unload();
        }
    }
    public boolean isAssetsReady() {
        if (isAssetsInitialized) {
            return true;
        }
        BaseAsset<?>[] assets = getAssets();
        for (BaseAsset<?> asset : assets) {
            if (!asset.isLoaded()) {
                return false;
            }
        }
        return true;
    }

    public  void update(float delta){
        stage.act(delta);
        boolean isAssetsReady = isAssetsReady();
        if (isAssetsReady) {
            if (!isAssetsInitialized) {
                assetsReady();
                isAssetsInitialized = true;
            } else if (isActive()) {
                act(delta);
            }
        }
    }
    public void assetsReady() {
        setActive(true);
    }

    public LoadingState createLoaderScreen(GameStateManager gsm) {
        LoadingState loadingState = new LoadingState();
        loadingState.setParent(this);
        loadingState.create(gsm);
        return loadingState;
    }

    // Geters and Setters
    public Stage getStage() {
        return stage;
    }
    public Application getApp() {
        return app;
    }
    public GameStateManager getGsm() {
        return gsm;
    }
    public float getAspectRatio() {
        return h / w;
    }
    public AssetManager res(){
        return app.getAssets();
    }
    public void setActive(boolean active) {
        this.active = active;
        if (app.sDebug) {
            System.out.println("setActive = " + active + " ;" + this);
        }
    }
    public boolean isActive() {
        return active;
    }
    public BaseAsset<?>[] getAssets() {
        return assets;
    }
    public void dispose(){
        setActive(false);
        batch.dispose();
        stage.dispose();
        unloadAssets();
    }
    public  void resize(int w, int h){
        this.w =  w;
        this.h =  h;
        viewport.update(w, h);
        stage.getViewport().update(w, h, true);
    }
    // abstract
    public abstract void act(float delta);
    public abstract void render();
    public abstract void pause();
    public abstract void resume();
    public abstract void initAssets();




}
