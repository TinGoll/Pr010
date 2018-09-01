package com.artworld.game.system.asset;

import com.artworld.game.Application;
import com.badlogic.gdx.utils.I18NBundle;

public class I18NBundleAsset extends BaseAsset<I18NBundle> {
    public I18NBundleAsset(Application app, String name) {
        super(app, name, I18NBundle.class);
    }
}
