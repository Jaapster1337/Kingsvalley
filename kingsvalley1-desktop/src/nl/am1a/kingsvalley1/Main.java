package nl.am1a.kingsvalley1;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "kingsvalley1";
		cfg.useGL20 = true;
		cfg.width = 544;
		cfg.height = 480;
		
		new LwjglApplication(new KingsValley(), cfg);
	}
}
