package net.whiteye.lightmap;


import var3d.net.center.VGame;
import var3d.net.center.VListener;

public class Game extends VGame {
	public Game(VListener varListener) {
		super(varListener);
		setSize(1920,1080);
	}

	@Override
	public void init() {

		setStage(StageMain.class);

	}
}
