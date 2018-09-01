package com.artworld.game.system.asset;

import com.artworld.game.Application;
import com.badlogic.gdx.audio.Sound;

public class SoundAsset extends BaseAsset<Sound> {
    public SoundAsset(Application app, String name) {
        super(app, name, Sound.class);
    }
}
