package drawer;

import gamescreens.Team;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


@SuppressWarnings("serial")
public class DrawingEditor extends JFrame {
	private MousePencil pen;
	private Canvas view;
	String Update;
	private JButton clear, drawErase, red, blue, green, black, yellow, floodfill, submit;
	
	private CountDownTimer timer;
	private Team[] teams;
	int numberTeams = 2;	
	
	public DrawingEditor(boolean drawer) {
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		JPanel toSubmit = new JPanel();
		toSubmit.setLayout(new BoxLayout(toSubmit, BoxLayout.LINE_AXIS));
		toSubmit.setBorder(BorderFactory.createTitledBorder("What's your guess?"));
		
		JTextField submit = new JTextField(" ");
	    submit.setBounds(new Rectangle(400, 350, 100, 20));
	    toSubmit.add(submit);
		
		
		//Creates JPanel to collect each teams scores panel
		JPanel allTeamScoreBoards = new JPanel();		
		allTeamScoreBoards.setLayout(new BoxLayout(allTeamScoreBoards, BoxLayout.Y_AXIS));
		allTeamScoreBoards.setBorder(BorderFactory.createTitledBorder("Team Scores"));
		
		//Change this once the DrawingEditor is implemented into Launcher
		//Needs to receive total number of teams from launcher
		//Adds each teams scoreLabel to allScoreBoards
		teams = new Team[2];
		for(int i = 1; i <= 2; i++){
			teams[i - 1] = new Team(i);
			teams[i - 1].getScoreBoard().setMaximumSize(new Dimension(210, 85));
			allTeamScoreBoards.add(teams[i - 1].getScoreBoard());
		}
		
		view = new Canvas();
		if(drawer == true){
			pen = new MousePencil(view, this);
			addViewByLabel();
			addTimer();
		}
		
		this.add(view, BorderLayout.CENTER);
		this.add(allTeamScoreBoards, BorderLayout.EAST);
		this.add(toSubmit, BorderLayout.SOUTH);
		
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
		
		yellow = new JButton (" ");
		yellow.setBackground(Color.YELLOW);
		yellow.addActionListener(new changeColorYellow());
		dataPanel.add(yellow);
		

		floodfill = new JButton(" ");
		try{
			Image img = ImageIO.read(getClass().getResource("/images/bucket.png"));
			floodfill.setIcon(new ImageIcon(img));
		}catch (IOException ex) {}
		//floodfill.setBounds(0,0,100,100);
		floodfill.addActionListener(new Floodfill());
		dataPanel.add(floodfill);
		
		
			
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
	
	private class Floodfill implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
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
