package com.artworld.game.system.asset;

import com.artworld.game.Application;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TextureAtlasAsset extends BaseAsset<TextureAtlas> {
    public TextureAtlasAsset(Application app, String name) {
        super(app, name, TextureAtlas.class);
    }
}
