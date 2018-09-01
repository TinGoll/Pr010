package com.artworld.game.desktop;

import com.artworld.game.system.Constants;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.artworld.game.Application;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.V_WIDTH * Constants.SCALE;
		config.height = Constants.V_HEIGHT * Constants.SCALE;
		config.title = Constants.DEFAULT_TITLE + " v " + Constants.VERSION;

		new LwjglApplication(new Application(), config);
	}
}
