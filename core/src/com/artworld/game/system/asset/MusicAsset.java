package com.artworld.game.system.asset;

import com.artworld.game.Application;
import com.badlogic.gdx.audio.Music;

public class MusicAsset extends BaseAsset<Music> {
    public MusicAsset(Application app, String name) {
        super(app, name, Music.class);
    }
}
