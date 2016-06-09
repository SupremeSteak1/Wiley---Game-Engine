package engine.physics;

import java.util.ArrayList;

import engine.backend.GameObject;
import engine.frontend.Renderable;
import other.Utilities;

public abstract class Entity implements GameObject{

	private Vector position, velocity;
	
	public Entity(int x, int y){
		this.position = new Vector(x,y);
	}

	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	public Vector getPosition() {
		return position;
	}
	
	@Override
	public ArrayList<Renderable> render(){
		return null;
	}
	
	public void act(){
		this.position = Utilities.addVectors(position, velocity);
	}
	
	@Override
	public void update(){
		act();
	}
	
}
