package other;

import java.util.ArrayList;

import engine.frontend.Renderable;
import engine.frontend.RenderableText;
import engine.physics.Vector;

public class Utilities {
	
	public static final double g = 9.80665;
	
	/**
	 * Allows a string to wrap if it hits the end of a given area
	 * @param width the width of the text
	 * @param text the text to display
	 * @param x the x coordinate of the text
	 * @param y the y coordinate of the text
	 * @return an ArrayList<Renderable> of RenderableTexts that make up the given string
	 */
	public static ArrayList<Renderable> renderLongText(int width, String text, int x, int y) {
		int lines = (int) Math.ceil((double) text.length() / (double) width);
		ArrayList<Renderable> toRender = new ArrayList<>();
		for(int i = 0; i < lines; i++){
			try{
			toRender.add(new RenderableText(text.substring(i*width,(i+1)*width), x, y + i*10));
			}catch(Exception e){
				toRender.add(new RenderableText(text.substring(i*width,text.length()), x, y + i*10));
			}
		}
		return toRender;
	}
	
	public static double getAngleBetweenVectors(Vector v1, Vector v2){
		double cosine = v1.dotProduct(v2)/(v1.getMagnitude()*v2.getMagnitude());
		return Math.acos(cosine);
	}
	
	public static Vector addVectors(Vector v1, Vector v2){
		return new Vector(v1.getxComp() + v2.getxComp(), v1.getyComp() + v2.getyComp());
	}
}
