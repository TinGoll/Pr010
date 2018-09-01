package com.artworld.game.system.asset;

import com.artworld.game.Application;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SkinAsset extends BaseAsset<Skin> {
    public SkinAsset(Application app, String name) {
        super(app, name, Skin.class);
    }
}
