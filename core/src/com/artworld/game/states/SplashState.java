package com.artworld.game.states;

import com.artworld.game.system.asset.BaseAsset;
import com.artworld.game.system.asset.I18NBundleAsset;
import com.artworld.game.system.asset.SkinAsset;
import com.artworld.game.system.asset.TextureAsset;
import com.artworld.game.system.asset.TextureAtlasAsset;
import com.artworld.game.system.managers.GameStateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class SplashState extends BaseState {

    float timer;
    private SkinAsset skinAsset;
    private TextureAtlasAsset textureAtlasSkinAsset;
    private I18NBundleAsset i18NBundleAsset;
    private TextureAsset textureAsset;

    @Override
    public void create(GameStateManager gsm) {
        super.create(gsm);

    }


    @Override
    public void initAssets() {
        skinAsset = new SkinAsset(app, "ui/skin.json");
        textureAtlasSkinAsset = new TextureAtlasAsset(app, "ui/skin.atlas");
        i18NBundleAsset = new I18NBundleAsset(app, "locale/locale");
        textureAsset = new TextureAsset(app, "graphics/Splash.png");

        assets = new BaseAsset[]{
                skinAsset,
                textureAtlasSkinAsset,
                i18NBundleAsset,
                textureAsset};
    }
    @Override
    public void act(float delta) {
        timer += delta;
        if(timer >= 5)
            gsm.setState(GameStateManager.State.PLAY);
    }
    @Override
    public void render() {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(textureAsset.get(), 100, 100);
        batch.end();
    }

    @Override
    public void assetsReady() {
        super.assetsReady();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

}
