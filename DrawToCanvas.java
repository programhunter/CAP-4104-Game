package drawer;

import java.awt.Color;
import java.awt.Point;

public class DrawToCanvas {
	public final int x, y, rad;
	public final Color color;
	
	public DrawToCanvas(int x, int y, int radius, Color c){
		this.x = x;
		this.y = y;
		rad = radius;
		color = c;
	}
	public DrawToCanvas(Point p, int size, Color c){
		x = p.x;
		y = p.y;
		rad = size;
		color = c;
	}
	public DrawToCanvas(String s, Color color){
		String[] all = s.split("|");
		this.rad = (int) Integer.parseInt(all[0]);
		this.x = (int) Integer.parseInt(all[1]);
		this.y = (int) Integer.parseInt(all[2]);
		this.color = color;
		
	}
	
	public String toString(){ 
		String updateSafe = new String();
		updateSafe = "&" + rad + "|" + x + "|" + y + "|" /*+ color.toString()*/;
		return updateSafe;
	}
}