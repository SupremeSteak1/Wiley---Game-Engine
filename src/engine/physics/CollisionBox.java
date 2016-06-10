package engine.physics;

import java.awt.Rectangle;

import other.Utilities;

public class CollisionBox {
	
	private Rectangle box;
	private RigidBody rb;
	
	public CollisionBox(int x, int y, RigidBody rb){
		this.rb = rb;
		this.box = new Rectangle((int)Math.round(rb.getPosition().getxComp()- x/2),(
				int)Math.round(rb.getPosition().getyComp()- y/2), 
				(int)Math.round(rb.getPosition().getxComp()+ x/2), 
				(int)Math.round(rb.getPosition().getyComp()- y/2));
	}
	
	public Rectangle getCollisionBox(){
		return box;
	}
	
	public boolean isColliding(CollisionBox other){
		return this.box.intersects(other.getCollisionBox());
	}
	
	public RigidBody getRB(){
		return rb;
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
	}

}
