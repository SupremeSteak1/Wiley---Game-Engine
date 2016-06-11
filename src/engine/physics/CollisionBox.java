package engine.physics;

import java.awt.Rectangle;
import java.awt.geom.Line2D;

import game.Level;
import game.Mob;
import other.Main;
import other.Utilities;

public class CollisionBox {
	
	private Rectangle box;
	private RigidBody rb;
	
	@SuppressWarnings("rawtypes")
	private Class recentCollisionType;
	
	private boolean collisionInProgress;
	
	public CollisionBox(int x, int y, RigidBody rb){
		collisionInProgress = false;
		this.rb = rb;
		this.box = new Rectangle((int)Math.round(rb.getPosition().getxComp()- x/2),(
				int)Math.round(rb.getPosition().getyComp()- y/2), 
				(int)Math.round(rb.getPosition().getxComp()+ x/2), 
				(int)Math.round(rb.getPosition().getyComp()- y/2));
		recentCollisionType = rb.getClass();
	}
	
	public Rectangle getCollisionBox(){
		return box;
	}
	
	public boolean isColliding(CollisionBox other){
		for(Line2D.Double l : Level.getBounds()){
			System.out.println("On bounds!");
			if(box.intersectsLine(l)) return true;
		}
		collisionInProgress = this.box.intersects(other.getCollisionBox());
		return collisionInProgress;
	}
	
	public RigidBody getRB(){
		return rb;
	}
	
	@SuppressWarnings("rawtypes")
	public Class getRecentCollisionType(){
		return recentCollisionType;
	}
	
	public void collide(CollisionBox other){ //For the love of God, don't ask.
											 //This may have been the single most
											 //difficult line of code I've ever written.
		Vector fuck = Utilities.subtractVectors(rb.getVelocity(),Utilities.subtractVectors(rb.getPosition(), 
				other.getRB().getPosition()).scalarMultiply(((2 * other.getRB().getMass()) / (rb.getMass() + other.getRB().getMass())) * 
				(Utilities.subtractVectors(rb.getVelocity(), other.getRB().getVelocity()).dotProduct
				(Utilities.subtractVectors(rb.getPosition(), other.getRB().getPosition()))/
				Math.pow(Utilities.subtractVectors(rb.getPosition(), other.getRB().getPosition()).getMagnitude(),2))));
		rb.setVelocity(fuck);
		collisionInProgress = false;
		recentCollisionType = other.getRB().getClass();
	}
	
	public boolean getCollisionInProgress(){
		return collisionInProgress;
	}

}
