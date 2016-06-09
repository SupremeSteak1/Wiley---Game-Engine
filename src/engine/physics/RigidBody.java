package engine.physics;

import other.Utilities;

public abstract class RigidBody extends Entity{

	private int mass;
	private Vector acceleration;
	
	private double frictionCoefficient;
	
	public RigidBody(int x, int y, int m) {
		super(x, y);
		this.mass = m;
		frictionCoefficient = 0;
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
		super.setVelocity(Utilities.addVectors(super.getVelocity(), acceleration));
	}

}
