package com.artworld.game.system.asset;

import com.artworld.game.Application;
import com.badlogic.gdx.graphics.Texture;

public class TextureAsset extends BaseAsset<Texture> {
    public TextureAsset(Application app, String name) {
        super(app, name, Texture.class);
    }
}
