package drawer;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Launcher implements ActionListener {
	
	JPanel cards;
	int teams = 2;
	int teammates;
	int turn = 1;
	int topicNum;
	String[] teamNums = {"2","3","4"};
	String[] teammateNums = {"2","3","4","5"};
	String[] topics = {"Person/Place/Animal", "Object", "Action", "Difficult Words", "Free Choice"};
	String topic;
	
	public void addComponentToPane(Container pane) {
		
		JPanel masterMenuPane = new JPanel(new GridBagLayout());
		
		// MAIN MENU SETUP
		
		JPanel mainMenu = new JPanel();
		mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.Y_AXIS));
		JLabel welcome = new JLabel("Welcome to Pictionary!");
		welcome.setFont(new Font("Arial", Font.BOLD, 40));
		welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenu.add(welcome);
		mainMenu.add(Box.createRigidArea(new Dimension(25,25)));
		
		JButton play = new JButton("Start Game");
		play.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.show(cards, "start");
				}
			}
		);
		play.setFont(new Font("Arial", Font.PLAIN, 40));
		play.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenu.add(play);
		mainMenu.add(Box.createRigidArea(new Dimension(25,25)));
		JButton howto = new JButton("How to Play and Rules");
		howto.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.show(cards, "inst1");
				}
			}
		);
		howto.setFont(new Font("Arial", Font.PLAIN, 40));
		howto.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenu.add(howto);
		mainMenu.add(Box.createRigidArea(new Dimension(25,25)));
		JButton quit = new JButton("Quit");
		quit.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			}
		);
		quit.setFont(new Font("Arial", Font.PLAIN, 40));
		quit.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenu.add(quit);
		masterMenuPane.add(mainMenu);
		
		// INSTRUCTIONS
		
		JPanel inst1 = new JPanel(new BorderLayout());
		inst1.setSize(new Dimension(700,700));
		
		JButton back = new JButton("Back");
		back.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.previous(cards);
				}
			}
		);
		inst1.add(back, BorderLayout.WEST);
		
		JLabel howto1 = new JLabel();
		howto1.setText("<html>" + "1)	Players must select the total number of rounds they would like the game to continue for. A single player may make this selection by selecting 1 to 10 rounds.  The default behavior is 10 rounds.<br><br>2)	Players are to be divided into teams by selecting from the possible teams. The first sketching artist is the youngest player on the team and the order of determining the sketching artist goes next youngest to oldest from there. The sketching artist is the person who attempts to illustrate the word using the interface to draw it. Everyone else on the team will try to guess the word that the sketching artist draws.<br><br>3)	A team will be randomly selected to go first.<br><br>4)	At the beginning of a team’s turn to sketch, a category card will be randomly generated for the team. The category card will determine which word or phrase the sketching artist has to draw. The different categories are Person/Place/Animal, Object, Action, Difficult words, and Free Choice.  Only the sketching artist may see the word or phrase to be drawn. Upon Free Choice, the sketching artist may choose any word or phrase they would like to draw. The sketching artist must input their selected word or phrase into the provided field.<br><br>5)	Once the sketching artist is given their word or phrase, the timer will start as soon as the next button is pressed and the canvas is shown. The sketching artist must begin to draw their image using the canvas while their team members try to guess the word or phrase they are trying to draw. Team members must guess through the guess input field and submitting their answer by clicking the provided button or hitting the enter key.<br><br>6)	Points will be given to the team depending on how quickly they guess the word or phrase correctly. Upon a correct guess, the timer will stop, the score will be added to the team’s total score, and the team’s turn will be complete. It will now be another team’s turn until all have had their turn in order to complete a round. If a team does not succeed in guessing the word or phrase, 0 points will be given to the team.<br><br>7)	Game play will continue in such way until the total number of rounds have been reached. The team with the highest score at the end of the rounds will be declared the winner.<br><br>8)	Should a tie occur, then the game ends in a tie.  " + "</html>");
		inst1.add(howto1, BorderLayout.CENTER);
		
		//GAME START
		
		JPanel start = new JPanel(new BorderLayout());
		
		JButton back1 = new JButton("Back");
		back1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.first(cards);
				}
			}
		);
		start.add(back1, BorderLayout.WEST);
		JButton next1 = new JButton("Next");
		next1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					initializeTurn();
					c1.next(cards);
				}
			}
		);
		start.add(next1, BorderLayout.EAST);
		
		JPanel teamSelect = new JPanel();
		teamSelect.setLayout(new BoxLayout(teamSelect, BoxLayout.Y_AXIS));
		JComboBox select1 = new JComboBox(teamNums);
		select1.setSelectedIndex(0);
		select1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JComboBox cb = (JComboBox)e.getSource();
						teams = cb.getSelectedIndex()+2;
						DrawingEditor.numberTeams = Integer.parseInt((String)cb.getSelectedItem());
					}
				}
			);
		JComboBox select2 = new JComboBox(teammateNums);
		select2.setSelectedIndex(0);
		select2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JComboBox cb = (JComboBox)e.getSource();
						teams = cb.getSelectedIndex()+2;
					}
				}
			);
		JLabel selectTeam = new JLabel("Teams:");
		selectTeam.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel selectTeammates = new JLabel("Players in Teams:");
		selectTeammates.setFont(new Font("Arial", Font.PLAIN, 20));
		teamSelect.add(Box.createRigidArea(new Dimension(200,200)));
		selectTeam.setAlignmentX(Component.CENTER_ALIGNMENT);
		teamSelect.add(selectTeam);
		select1.setAlignmentX(Component.CENTER_ALIGNMENT);
		teamSelect.add(select1);
		selectTeammates.setAlignmentX(Component.CENTER_ALIGNMENT);
		teamSelect.add(selectTeammates);
		select2.setAlignmentX(Component.CENTER_ALIGNMENT);
		teamSelect.add(select2);
		start.add(teamSelect, BorderLayout.CENTER);
		teamSelect.add(Box.createRigidArea(new Dimension(200,200)));
		
		// NEXT GAME SCREENS
		
		JPanel screen2 = new JPanel(new BorderLayout());
		JLabel teamTurn = new JLabel("<html><div style='text-align: center;'>" + "Team " + turn + " goes first!</html>", SwingConstants.CENTER);
		teamTurn.setFont(new Font("Arial", Font.PLAIN, 20));
		screen2.add(teamTurn, BorderLayout.CENTER);
		JButton back3 = new JButton("Back");
		back3.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.previous(cards);
				}
			}
		);
		screen2.add(back3, BorderLayout.WEST);
		JButton next3 = new JButton("Next");
		next3.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.next(cards);
				}
			}
		);
		screen2.add(next3, BorderLayout.EAST);
		
		JPanel screen1 = new JPanel(new BorderLayout());
		JLabel prepareRotations = new JLabel("<html><div style='text-align: center;'>Remember:<br>Youngest to oldest rotation for drawing.<br><br>Prepare the teams' rotations, then click Next to begin!</html>", SwingConstants.CENTER);
		prepareRotations.setFont(new Font("Arial", Font.PLAIN, 20));
		screen1.add(prepareRotations, BorderLayout.CENTER);
		JButton back2 = new JButton("Back");
		back2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.previous(cards);
				}
			}
		);
		screen1.add(back2, BorderLayout.WEST);
		JButton next2 = new JButton("Next");
		next2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.next(cards);
				}
			}
		);
		screen1.add(next2, BorderLayout.EAST);
		
		JPanel screen3 = new JPanel(new BorderLayout());
		JLabel turnConfirm = new JLabel("<html><div style='text-align: center;'>It is now Team " + turn + "'s turn.<br>Team " + turn + " should click Next when ready!</html>", SwingConstants.CENTER);
		turnConfirm.setFont(new Font("Arial", Font.PLAIN, 20));
		screen3.add(turnConfirm, BorderLayout.CENTER);
		JButton back4 = new JButton("Back");
		back4.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.previous(cards);
				}
			}
		);
		screen3.add(back4, BorderLayout.WEST);
		JButton next4 = new JButton("Next");
		next4.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.next(cards);
				}
			}
		);
		screen3.add(next4, BorderLayout.EAST);
		
		JPanel screen4 = new JPanel(new BorderLayout());
		JLabel drawConfirm = new JLabel("<html><div style='text-align: center;'>The drawing will be shown on the next screen. If you are not drawing, please close your eyes now.</html>", SwingConstants.CENTER);
		drawConfirm.setFont(new Font("Arial", Font.PLAIN, 20));
		screen4.add(drawConfirm, BorderLayout.CENTER);
		JButton back5 = new JButton("Back");
		back5.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.previous(cards);
				}
			}
		);
		screen4.add(back5, BorderLayout.WEST);
		JButton next5 = new JButton("Next");
		next5.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.next(cards);
				}
			}
		);
		screen4.add(next5, BorderLayout.EAST);
		
		JPanel screen5 = new JPanel(new BorderLayout());
		Random topicPick = new Random();
		topicNum = topicPick.nextInt(5)+1;
		topic = topics[topicNum];
		JLabel drawingTopic = new JLabel("<html><div style='text-align: center;'>You will be drawing:<br>" + topic + "<br><br>After you click Next, announce it to your team.</html>", SwingConstants.CENTER);
		drawingTopic.setFont(new Font("Arial", Font.PLAIN, 20));
		screen5.add(drawingTopic, BorderLayout.CENTER);
		JButton back6 = new JButton("Back");
		back6.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.previous(cards);
				}
			}
		);
		screen5.add(back6, BorderLayout.WEST);
		JButton next6 = new JButton("Next");
		next6.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DrawingEditor.main(null);
					CardLayout c1 = (CardLayout)(cards.getLayout());
					c1.next(cards);
				}
			}
		);
		screen5.add(next6, BorderLayout.EAST);
		
		cards = new JPanel(new CardLayout());
		cards.add(masterMenuPane, "MainMenu");
		cards.add(inst1, "inst1");
		cards.add(start, "start");
		cards.add(screen1, "screen2");
		cards.add(screen2, "screen1");
		cards.add(screen3, "screen3");
		cards.add(screen4, "screen4");
		cards.add(screen5, "screen5");
		
		pane.add(cards, BorderLayout.CENTER);
	}

	public static void launchGUI() {
		
		JFrame jf = new JFrame();
		Launcher launcher = new Launcher();

		jf.setSize(700,700);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		launcher.addComponentToPane(jf.getContentPane());
		
		jf.setVisible(true);
		
	}
	
	public void initializeTurn() {
		
		Random rand = new Random();
		turn = rand.nextInt(teams)+1;
		
	}
	
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				launchGUI();
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
