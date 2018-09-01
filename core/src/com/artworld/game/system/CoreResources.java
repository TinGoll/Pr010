package com.artworld.game.system;

import com.artworld.game.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;

public class CoreResources {

    public AssetManager manager;
    public CoreResources() {
        clear();
    }
    public void clear() {
        if (manager != null) {
            manager.clear();
        }
        if (Application.sCrypt) {
          //  FileHandleResolver fileHandleResolver = new CryptFileResolver(new InternalFileHandleResolver());
          //  manager = new AssetManager(fileHandleResolver);
          //  manager.setLoader(TextureAtlas.class, ".atlascrypt", new CryptTextureAtlasLoader(fileHandleResolver));
            manager = new AssetManager();
        } else {
            manager = new AssetManager();
        }
        setLoaderTmxClass();
    }
    public void setLoaderTmxClass(){
        manager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
    }
    public void unload(String name) {
        if (manager.isLoaded(name)) {
            manager.unload(name);
        }
    }
    public boolean update(float delta) {
        return manager.update();
    }
    public float getProgress() {
        return manager.getProgress();
    }
    public boolean isLoaded(String name) {
        return manager.isLoaded(name);
    }
    public void dispose(){
        manager.dispose();
    }

}
