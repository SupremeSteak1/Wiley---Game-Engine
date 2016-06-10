package game;

import java.util.ArrayList;

import engine.frontend.Renderable;
import engine.frontend.RenderableImage;
import engine.physics.RigidBody;
import engine.physics.Vector;

public class Projectile extends RigidBody {

	private boolean inMotion;
	private String filePath;
	
	public Projectile(int x, int y) {
		super(x, y, 1, 1, 1);
		super.setVelocity(new Vector(0,0));
		inMotion = false;
		filePath = "res/emptyTexture.png";
	}
	
	public void setFilePath(String s){
		filePath = s;
	}
	
	public void fire(Vector velocity){
		super.setVelocity(velocity);
		inMotion = true;
	}
	
	public boolean getInMotion(){
		return inMotion;
	}
	
	@Override
	public ArrayList<Renderable> render(){
		ArrayList<Renderable> toRender = new ArrayList<>();
		RenderableImage sprite = new RenderableImage(filePath,(int) Math.round(super.getPosition().getxComp()),(int) Math.round(super.getPosition().getyComp()), 1);
		toRender.add(sprite);
		return toRender;
	}
	
	@Override
	public void act(){
		if(super.getCollisionBox().getCollisionInProgress()){
			inMotion = false;
		}
	}

}
