package other;

import java.util.ArrayList;

import engine.backend.GameObjectHandler;
import engine.backend.Renderer;
import engine.frontend.Renderable;
import game.ControllableEntity;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args){
		Renderer r = new Renderer(1, 1280, 720);
		GameObjectHandler goh = new GameObjectHandler();
		ControllableEntity player = new ControllableEntity(1,1,20,5,5);
		player.setFilePath("res/kimoon.jpg");
		goh.registerGameObject(player);
		while(true){
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
