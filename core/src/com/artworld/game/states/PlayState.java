package com.artworld.game.states;

import com.artworld.game.system.asset.BaseAsset;
import com.artworld.game.system.asset.I18NBundleAsset;
import com.artworld.game.system.asset.SkinAsset;
import com.artworld.game.system.asset.TextureAsset;
import com.artworld.game.system.asset.TextureAtlasAsset;
import com.artworld.game.system.asset.TiledMapAsset;
import com.artworld.game.system.managers.GameStateManager;
import com.artworld.game.world.GameMap;
import com.artworld.game.world.Levels;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class PlayState extends BaseState {

    private GameMap map;
    // ресурсы для зашрузки.
    private SkinAsset skinAsset;
    private TextureAtlasAsset textureAtlasSkinAsset;
    private I18NBundleAsset i18NBundleAsset;
    private TextureAsset textureAsset;
    private TiledMapAsset tiledMapAsset;

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
        tiledMapAsset = new TiledMapAsset(app, Levels.getLevel(1).getPath());

        assets = new BaseAsset[]{
                skinAsset,
                textureAtlasSkinAsset,
                i18NBundleAsset,
                textureAsset,
                tiledMapAsset};
    }
    @Override
    public void act(float delta) {
        map.update(delta);

    }
    @Override
    public void assetsReady() {
        super.assetsReady();
        createMap();
    }
    @Override
    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.3f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(isAssetsInitialized && isActive()) {
            map.render(camera, batch);
        }
    }
    @Override
    public void pause() {

    }
    @Override
    public void resume() {

    }
    @Override
    public void dispose() {
        super.dispose();
        map.dispose();
    }
    private void createMap(){
        map = Levels.createMap(app);
    }
    public TiledMapAsset getTiledMapAsset() {
        return tiledMapAsset;
    }
}
