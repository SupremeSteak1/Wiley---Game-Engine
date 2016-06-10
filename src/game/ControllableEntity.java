package game;

import java.awt.Point;

import engine.input.Keyboard;
import engine.physics.RigidBody;
import engine.physics.Vector;
import other.Utilities;

public class ControllableEntity extends RigidBody{
	
	Vector velocity = super.getVelocity();
	private double speed;
	private double projectileSpeed;
	
	public ControllableEntity(int x, int y, int m, int xLength, int yLength) {
		super(x, y, m, xLength, yLength);
		this.speed = 1;
		this.projectileSpeed = 1;
	}
	
	public double getProjectileSpeed() {
		return projectileSpeed;
	}

	public void setProjectileSpeed(double projectileSpeed) {
		this.projectileSpeed = projectileSpeed;
	}

	public void setSpeed(double value){
		this.speed = value;
	}
	
	public double getSpeed(){
		return this.speed;
	}
	
	@Override
	public void move(){
		if(Keyboard.isKeyPressed('w')){
			velocity = Utilities.addVectors(velocity, new Vector(0,speed));
		}
		if(Keyboard.isKeyPressed('s')){
			velocity = Utilities.addVectors(velocity, new Vector(0,-speed));
		}
		if(Keyboard.isKeyPressed('d')){
			velocity = Utilities.addVectors(velocity, new Vector(speed,0));
		}
		if(Keyboard.isKeyPressed('a')){
			velocity = Utilities.addVectors(velocity, new Vector(-speed,0));
		}
		else{
			velocity = new Vector (0,0);
		}
		super.setVelocity(velocity);
	}
	
	public void directedAction(Point p){
		Vector direction = Utilities.subtractVectors(new Vector(p.x, p.y), super.getPosition()).normalize();
		//Default action:
		Projectile toFire = new Projectile((int) Math.round(this.getPosition().getxComp()), 
				(int) Math.round(this.getPosition().getyComp()));
		toFire.fire(direction.scalarMultiply(projectileSpeed));
		
	}

}
