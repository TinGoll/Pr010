package com.artworld.game.system.asset;

import com.artworld.game.Application;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;

public class ParticleAsset extends BaseAsset<ParticleEffect> {
    public ParticleAsset(Application app, String name) {
        super(app, name, ParticleEffect.class);
    }
}
