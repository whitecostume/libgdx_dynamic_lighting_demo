package net.whiteye.lightmap.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.whiteye.lightmap.Game;

import var3d.net.center.desktop.VDesktopLauncher;

public class DesktopLauncher extends VDesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		float scale = 0.5f;
		config.width = (int) (1920 * scale);
		config.height = (int) (1080 * scale);

		new LwjglApplication(new Game(new DesktopLauncher()), config);
	}
}
