package gamescreens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TeamScoreBoard extends JPanel{
	JLabel scoreBoard;	
	TeamScoreBoard score;
	
	public TeamScoreBoard (int teamNumber){
		scoreBoard = new JLabel("Team " + teamNumber + ": 0 points");
		scoreBoard.setPreferredSize(new Dimension(200,75));
		scoreBoard.setBorder(BorderFactory.createLineBorder(Color.black));
		scoreBoard.setFont(new Font("Courier New", Font.BOLD, 20));
		add(scoreBoard);
	}
	
	public void updateScore(int teamNumber, int score){
		this.scoreBoard.setText(" Team " + teamNumber + ": " + score + " points");
		
	}
	
}
