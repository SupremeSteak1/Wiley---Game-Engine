package engine.frontend;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class RenderableText implements Renderable {

	private String text;
	private int x;
	private int y;
	
	public RenderableText(String s, int x, int y) {
		this.text = s;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void render(Graphics2D g2d) {
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);
		g2d.drawString(text, x, y);
	}

	@Override
	public int getLevel() {
		return 1;
	}

}
