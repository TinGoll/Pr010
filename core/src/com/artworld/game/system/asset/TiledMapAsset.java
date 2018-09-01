package com.artworld.game.system.asset;

import com.artworld.game.Application;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class TiledMapAsset extends BaseAsset<TiledMap> {

    public TiledMapAsset(Application app, String name) {
        super(app, name, TiledMap.class);
    }
}
