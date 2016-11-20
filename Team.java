package gamescreens;

public class Team {
	
	int teamScore;
	int teamNumber;
	boolean currentTurn = false;
	TeamScoreBoard scoreLabel;
	String active = "(Active)";
	String idle = "(Idle)";
	
	
	
	public Team(int teamNumber){
		this.teamNumber = teamNumber;
		this.teamScore = 0;
		scoreLabel = new TeamScoreBoard(this.teamNumber);
		
	}
	
	public void addPoint(){
		this.teamScore++;
		this.scoreLabel.updateScore(this.teamNumber,this.teamScore);
	}
	
	public TeamScoreBoard getScoreBoard(){
		return this.scoreLabel;
		
	}
	
	public void isCurrentTurn(){
		this.currentTurn = true;
		
	}
	
	public void notCurrentTurn(){
		this.currentTurn = false;
	}
	
}
