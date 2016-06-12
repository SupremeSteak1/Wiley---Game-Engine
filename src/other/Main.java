package other;

import java.util.ArrayList;

import engine.backend.GameObjectHandler;
import engine.backend.Renderer;
import engine.frontend.Renderable;
import engine.input.Keyboard;
import engine.physics.PhysicsController;
import game.ControllableEntity;
import game.Level;

public class Main {
	
	public static int WINDOW_WIDTH = 1280;
	public static int WINDOW_HEIGHT = 720;

	@SuppressWarnings("static-access")
	public static void main(String[] args){
		Renderer r = new Renderer(WINDOW_WIDTH, WINDOW_HEIGHT);
		GameObjectHandler goh = new GameObjectHandler();
		ControllableEntity player = new ControllableEntity(100,100,20,128,128);
		Level l = new Level();
		PhysicsController pc = new PhysicsController();
		player.setFilePath("res/testPlayer.png");
		player.setSpeed(2);
		player.setProjectileSpeed(5);
		goh.registerGameObject(player);
		goh.registerGameObject(l);
		pc.registerRigidBody(player);
		while(true){
			pc.update();
			Keyboard.update();
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
