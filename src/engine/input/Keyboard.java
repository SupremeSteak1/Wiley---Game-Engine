package engine.input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * 
 * @author Thomas Hayden
 * @version 6/02/16
 */
public class Keyboard implements KeyListener {
	
	private static ArrayList<Character> events;

	public static boolean isKeyPressed(char c) {
		for(char e : events) {
			if(e==c)
				return true;
		}
		return false;
	}
	
	public Keyboard() {
		events = new ArrayList<Character>();
	}
	
	public void keyPressed(KeyEvent e) {
		//System.out.println("Added " + e.toString());
		if(!events.contains(e)) {
			events.add(e.getKeyChar());
		}
		if(events.size() >= 10){
			events.remove(events.size()-1);
		}
	}

	public void keyReleased(KeyEvent e) {
		//System.out.println("Removed " + e.toString());
		events.remove(new Character(e.getKeyChar()));
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public static void update(){
		if(events.size() > 5){
			ArrayList<Character> newEvents = new ArrayList<>();
			for(int i = 0; i < 5; i++){
				newEvents.add(events.get(events.size() - i - 1));
			}
			events = newEvents;
		}
	}
	
}
