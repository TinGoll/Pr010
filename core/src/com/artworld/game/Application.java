package com.artworld.game;

import com.artworld.game.system.managers.GameStateManager;
import com.artworld.game.system.CoreResources;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.I18NBundle;

public class Application extends ApplicationAdapter {

	private GameStateManager gsm;
	private Boolean isPaused = false;
	private CoreResources res;
	public float w, h;

	public static volatile boolean sDebug = true;
	public static volatile boolean sCrypt = false;

	@Override
	public void create () {
		res = new CoreResources();
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		gsm = new GameStateManager(this);

	}
	@Override
	public void render () {
		super.render();
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render();
	}
	@Override
	public void dispose () {
		super.dispose();
		gsm.dispose();
		res.dispose();
	}
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		gsm.resize(width, height);
	}
	@Override
	public void pause() {
		super.pause();
		gsm.pause();
	}
	@Override
	public void resume() {
		super.resume();
		gsm.resume();
	}
	public GameStateManager getGsm() {
		return gsm;
	}
	public Boolean getPaused() {
		return isPaused;
	}
	public void setPaused(Boolean paused) {
		isPaused = paused;
	}
	public AssetManager getAssets(){
		return res.manager;
	}
	public CoreResources getCoreResources() {
		return res;
	}
	public void exit() {
		Gdx.app.exit();
	}

	public static void print(String text){
		System.out.println(text);
	}
}
