package com.artworld.game.states;

import com.artworld.game.system.managers.GameStateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class MenuState extends  BaseState {


    @Override
    public void create(GameStateManager gsm) {
        super.create(gsm);
    }

    @Override
    public void initAssets() {

    }
    @Override
    public void act(float delta) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.3f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
