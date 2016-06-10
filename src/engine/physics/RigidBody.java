package engine.physics;

import java.util.ArrayList;

import engine.frontend.Renderable;
import engine.frontend.RenderableImage;
import other.Utilities;

public abstract class RigidBody extends Entity {

	private int mass;
	private Vector acceleration;
	
	private double frictionCoefficient;
	
	private CollisionBox box;
	
	private String filePath;
	
	public RigidBody(int x, int y, int m, int xLength, int yLength) {
		super(x, y);
		this.mass = m;
		frictionCoefficient = 0;
		filePath = "res/emptyTexture";
		box = new CollisionBox(xLength, yLength, this);
	}
	
	public void setFilePath(String s){
		filePath = s;
	}
	
	@Override
	public ArrayList<Renderable> render(){
		ArrayList<Renderable> toRender = new ArrayList<>();
		RenderableImage sprite = new RenderableImage(filePath,(int) Math.round(super.getPosition().getxComp()),(int) Math.round(super.getPosition().getyComp()), 1);
		toRender.add(sprite);
		return toRender;
	}
	
	public void applyForce(Vector f){
		acceleration = other.Utilities.addVectors(acceleration, f.scalarMultiply(1 / this.mass));
	}
	
	public void setFrictionCoefficient(double value){
		this.frictionCoefficient = value;
	}
	
	public void move(){
		//For class heirarchy
	}
	
	@Override
	public void act(){
		move();
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
