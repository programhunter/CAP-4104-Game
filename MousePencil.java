package drawer;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class MousePencil implements MouseMotionListener {
	private Canvas v;
	private boolean isDrawing;
	private int size = 10;
	public Color c;
	private final int erasersize = 40;
	private ArrayList<DrawToCanvas> updatePackage;
	private DrawingEditor main;
	
	public MousePencil(Canvas v, DrawingEditor main) {
		v.addMouseMotionListener(this);
		this.v = v;
		isDrawing = true;
		this.main = main;
	}
		
	public boolean isDrawing() {
		return isDrawing;
	}
	
	public void draw() {
		isDrawing = true;
	}
	
	public void erase() {
		isDrawing = false;
	}
	//Here's how updates will likely go down. When mouse clicked, it starts building a new array of points to be sent up to the editor.
	//The editor gets the list, puts everything into a string, and signals the tread that it is ready to hand over an update string.
	
	public void mouseDragged(MouseEvent e) {
		DrawToCanvas point;
		if(isDrawing){
			point = new DrawToCanvas(e.getPoint(), size, c);
			v.addDrawPoint(point);
		}else{
			point = new DrawToCanvas(e.getPoint(), erasersize, Color.white);
			v.addDrawPoint(point);
		}
		v.repaint();
	}
	
	public void mouseMoved(MouseEvent e) {}
}