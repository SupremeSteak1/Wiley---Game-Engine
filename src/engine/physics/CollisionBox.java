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
	
	public void collide(CollisionBox other){
		Vector p1 = rb.getMomentum();
		Vector p2 = other.getRB().getMomentum();
		double angleOfCollision = Utilities.getAngleBetweenVectors(p1, p2);
		double normalAngle = Math.PI/2 - angleOfCollision;
		double adjustedXComp = Math.cos(angleOfCollision) * p1.getxComp();
		double adjustedYComp = Math.sin(angleOfCollision) * p1.getyComp();
		//Implement polar to rectangular vector conversion. Use it to define new momentum.
		//http://stackoverflow.com/questions/345838/ball-to-ball-collision-detection-and-handling
	}

}
