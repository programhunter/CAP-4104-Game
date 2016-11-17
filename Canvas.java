package drawer;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private ArrayList<DrawToCanvas> toDraw;
	
	
	public Canvas(){
		super();
		setBackground(Color.white);
		toDraw = new ArrayList<DrawToCanvas>();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(DrawToCanvas circle : toDraw){
			g.setColor(circle.color);
			g.fillOval(circle.x, circle.y, circle.rad, circle.rad);
		}
	}
	public void clear(){
		toDraw = new ArrayList<DrawToCanvas>();
		repaint();
	}
	public void addDrawPoint(DrawToCanvas d){
		toDraw.add(d);
		repaint();
	}
	public void addDrawString(String s){ 
		String[] first = s.split(":");
		
		Color color = stringToColor(first[0]);
		
		String[] all = first[1].split("&");
		for(String buildString : all){
			toDraw.add(new DrawToCanvas(buildString, color));
		}
	}
	public Color stringToColor(String s){
		return Color.BLACK;
	}
}