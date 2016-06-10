package engine.physics;

import other.Utilities;

public abstract class RigidBody extends Entity{

	private int mass;
	private Vector acceleration;
	
	private double frictionCoefficient;
	
	private CollisionBox box;
	
	public RigidBody(int x, int y, int m, int xLength, int yLength) {
		super(x, y);
		this.mass = m;
		frictionCoefficient = 0;
		
		box = new CollisionBox(xLength, yLength, this);
	}
	
	public void applyForce(Vector f){
		acceleration = other.Utilities.addVectors(acceleration, f.scalarMultiply(1 / this.mass));
	}
	
	public void setFrictionCoefficient(double value){
		this.frictionCoefficient = value;
	}
	
	@Override
	public void act(){
		acceleration = Utilities.addVectors(acceleration, acceleration.getOppositeVector().normalize().scalarMultiply(frictionCoefficient *(mass * Utilities.g)));
		//The above line simulates friction by reducing the acceleration's magnitude an amount equal 
		//to the coefficient of friction multiplied by the mass and the acceleration due to gravity.
		super.setVelocity(Utilities.addVectors(super.getVelocity(), acceleration));
		//The above line simulates acceleration by incrementing the velocity vector by the acceleration vector
	}
	
	public Vector getMomentum(){
		return super.getVelocity().scalarMultiply(getMass());
	}
	
	public double getMass(){
		return mass;
	}
	
	public CollisionBox getCollisionBox(){
		return this.box;
	}

}
