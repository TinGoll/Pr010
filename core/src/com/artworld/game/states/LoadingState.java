package com.artworld.game.states;

import com.artworld.game.system.asset.BaseAsset;
import com.artworld.game.system.asset.I18NBundleAsset;
import com.artworld.game.system.asset.SkinAsset;
import com.artworld.game.system.asset.TextureAsset;
import com.artworld.game.system.asset.TextureAtlasAsset;
import com.artworld.game.system.managers.GameStateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;

public class LoadingState extends BaseState {

    private float progress;
    private BaseState parent;
    private ProgressBar bar;
    private Skin skin;
    private I18NBundle bundle;

    private SkinAsset skinAsset;
    private TextureAtlasAsset textureAtlasSkinAsset;
    private I18NBundleAsset i18NBundleAsset;

    @Override
    public void create(GameStateManager gsm) {
        super.create(gsm);
        skinAsset = new SkinAsset(app, "ui/skin.json");
        textureAtlasSkinAsset = new TextureAtlasAsset(app, "ui/skin.atlas");
        i18NBundleAsset = new I18NBundleAsset(app, "locale/locale");
        assets = new BaseAsset[]{
                skinAsset,
                textureAtlasSkinAsset,
                i18NBundleAsset};
        loadAssets();
        if (app.sDebug) {
            app.print("ExampleLoaderScreen = " + this);
        }
    }
    @Override
    public void initAssets() {

    }

    public float getProgress(){
        progress = MathUtils.lerp(progress, getApp().getCoreResources().getProgress(), .15f);
        return progress;
    }
    public void setParent(BaseState parent){
        this.parent = parent;
    }

    protected void loadParentAssets() {
        if(parent == null)
            return;
        parent.loadAssets();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        app.getCoreResources().update(delta);
    }

    @Override
    public void act(float delta) {
        bar.setValue(getProgress());
        if(getApp().getCoreResources().update(delta) && getProgress() >= getApp().getCoreResources().getProgress()-0.0001f){
            gsm.deleteTopScreen();
        }
    }
    @Override
    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }
    @Override
    public void pause() {
        setActive(false);
    }
    @Override
    public void resume() {
        setActive(true);
    }

    @Override
    public void resize(int w, int h) {
        super.resize(w,h);
    }

    @Override
    public void assetsReady() {
        super.assetsReady();
        skin = skinAsset.get();
        bar = new ProgressBar(0f, 1f, 0.01f, false, skin);
        bar.setPosition((viewport.getWorldWidth() / 2) - (viewport.getWorldWidth() / 2 / 2), 260);
        bar.setSize(viewport.getWorldWidth() / 2, 50);
        stage.addActor(bar);
        loadParentAssets();
    }

    @Override
    protected void unloadAssets() {
        isAssetsInitialized = false;
        BaseAsset<?>[] parentAssets = parent.getAssets();

        for (BaseAsset<?> asset : assets) {
                asset.unloadCheck(parentAssets);
            }
        }

    @Override
    public LoadingState createLoaderScreen(GameStateManager gsm) {
        return null;
    }


}
