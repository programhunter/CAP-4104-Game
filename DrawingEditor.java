package drawer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class DrawingEditor extends JFrame {
	private MousePencil pen;
	private Canvas view;
	String Update;
	private JButton clear, drawErase, red, blue, green, black, white, yellow, floodfill;
	private CountDownTimer timer;
	
	public DrawingEditor(boolean drawer) {
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		view = new Canvas();
		if(drawer == true){
			pen = new MousePencil(view, this);
			addViewByLabel();
			addTimer();
		}
		
		this.add(view, BorderLayout.CENTER);
		
	}
		
	public static void main(String[] args) {
		DrawingEditor gui = new DrawingEditor(true);
		gui.setVisible(true);
	}
	
			
	private class Clearer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.clear();
			pen.draw();
			drawErase.setText("Erase");
		}
	}
	
	private void addViewByLabel() {

		JPanel dataPanel = new JPanel();
		dataPanel.setBorder(BorderFactory.createBevelBorder(0));
				
		clear = new JButton("Clear");
		clear.addActionListener(new Clearer());
		dataPanel.add(clear);
		
		drawErase = new JButton("Erase");
		drawErase.addActionListener(new DrawEraser());
		dataPanel.add(drawErase);
		
		black = new JButton (" ");
		black.setBackground(Color.black);
		black.addActionListener(new changeColorBlack());
		dataPanel.add(black);
		
		red = new JButton (" ");
		red.setBackground(Color.RED);
		red.addActionListener(new changeColorRed());
		dataPanel.add(red);
		
		blue = new JButton (" ");
		blue.setBackground(Color.BLUE);
		blue.addActionListener(new changeColorBlue());
		dataPanel.add(blue);
		
		green = new JButton (" ");
		green.setBackground(Color.GREEN);
		green.addActionListener(new changeColorGreen());
		dataPanel.add(green);
		
		white = new JButton (" ");
		white.setBackground(Color.WHITE);
		white.addActionListener(new changeColorWhite());
		dataPanel.add(white);
		
		yellow = new JButton (" ");
		yellow.setBackground(Color.YELLOW);
		yellow.addActionListener(new changeColorYellow());
		dataPanel.add(yellow);
		
		
			
		view.add(dataPanel, BorderLayout.NORTH);
	}
		
	private class DrawEraser implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (pen.isDrawing()) {
				drawErase.setText("Draw");
				pen.erase();
			} else {
				drawErase.setText("Erase");
				pen.draw();
			}
			
		}
	}
	MousePencil getPencil(){
		return pen;
	}
	private class changeColorBlack implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			pen.c = Color.BLACK;
		}		
	}
	
	private class changeColorRed implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			pen.c = Color.RED;
		}		
	}
	
	private class changeColorBlue implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			pen.c = Color.BLUE;
		}		
	}
	
	private class changeColorGreen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			pen.c = Color.GREEN;
		}		
	}
	
	private class changeColorWhite implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			pen.c = Color.WHITE;
		}		
	}
	
	private class changeColorYellow implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			pen.c = Color.YELLOW;
		}		
	}
	
	private void addTimer(){
		timer = new CountDownTimer();
		view.add(timer, BorderLayout.NORTH);
	}
	
	

}
