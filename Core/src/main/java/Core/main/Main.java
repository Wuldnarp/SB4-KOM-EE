package Core.main;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
	
	public static void main(String[] args) {
		
		Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
		cfg.setWindowedMode(500,400);
		cfg.setTitle("Asteroids");
		cfg.setResizable(false);
		
		new Lwjgl3Application(new Game(), cfg);
		
	}
	
}
