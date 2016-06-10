package game;

import java.util.ArrayList;

import engine.frontend.Renderable;
import engine.frontend.RenderableImage;
import engine.physics.RigidBody;
import engine.physics.Vector;

public class Projectile extends RigidBody {

	private boolean inMotion;
	private String filePath;
	
	/**
	 * Constructs a new projectile at coordinates (x,y)
	 * @param x the x position of the projectile
	 * @param y the y position of the projectile
	 */
	public Projectile(int x, int y) {
		super(x, y, 1, 1, 1);
		super.setVelocity(new Vector(0,0));
		inMotion = false;
		filePath = "res/emptyTexture.png";
	}
	
	/**
	 * Sets the projectile's image file path
	 * @param s the new file path
	 */
	public void setFilePath(String s) {
		filePath = s;
	}
	
	/**
	 * Fires this projectile with given velocity
	 * @param velocity the velocity to fire this projectile at
	 */
	public void fire(Vector velocity) {
		super.setVelocity(velocity);
		inMotion = true;
	}
	
	/**
	 * Checks if this projectile is in motion
	 * @return 
	 */
	public boolean getInMotion() {
		return inMotion;
	}
	
	/**
	 * The render method inherited from RigidBody
	 */
	@Override
	public ArrayList<Renderable> render() {
		ArrayList<Renderable> toRender = new ArrayList<>();
		RenderableImage sprite = new RenderableImage(filePath,(int) Math.round(super.getPosition().getxComp()),(int) Math.round(super.getPosition().getyComp()), 1);
		toRender.add(sprite);
		return toRender;
	}
	
	/**
	 * The act method inherited from RigidBody
	 */
	@Override
	public void act() {
		if(super.getCollisionBox().getCollisionInProgress()){
			inMotion = false;
		}
	}

}
