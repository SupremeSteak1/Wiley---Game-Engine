package other;

import java.util.ArrayList;

import engine.backend.GameObjectHandler;
import engine.backend.Renderer;
import engine.frontend.Renderable;
import engine.physics.PhysicsController;
import game.ControllableEntity;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args){
		Renderer r = new Renderer(1280, 720);
		GameObjectHandler goh = new GameObjectHandler();
		ControllableEntity player = new ControllableEntity(1,1,20,10,10);
		PhysicsController pc = new PhysicsController();
		player.setFilePath("res/testPlayer.png");
		player.setSpeed(2);
		player.setProjectileSpeed(5);
		goh.registerGameObject(player);
		pc.registerRigidBody(player);
		while(true){
			pc.update();
			r.setQueue(new ArrayList<Renderable>());
			goh.updateGameObjects();
			goh.renderGameObjects(r);
			r.refreshQueue();
			r.repaint();
			r.revalidate();
			r.setVisible(true);
		}
		
	}
	
}
