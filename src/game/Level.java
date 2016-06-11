package game;

import java.awt.geom.Line2D;

import other.Main;

public class Level {
	
	private static Line2D.Double[] bounds = new Line2D.Double[4];
	
	public Level(){
		bounds[0] = new Line2D.Double(0,0,0,Main.WINDOW_HEIGHT);
		bounds[1] = new Line2D.Double(0,Main.WINDOW_HEIGHT,Main.WINDOW_HEIGHT,Main.WINDOW_WIDTH);
		bounds[2] = new Line2D.Double(Main.WINDOW_HEIGHT,Main.WINDOW_WIDTH,Main.WINDOW_WIDTH, 0);
		bounds[3] = new Line2D.Double(Main.WINDOW_WIDTH,0,0,0);
	}
	
	public static Line2D.Double[] getBounds(){
		return bounds;
	}
	
	/**
	 * Loads a level from a file
	 * @param filePath the file to load from
	 * @return the loaded Level
	 */
	public static Level loadLevel(String filePath) {
		return null;
	}

}
