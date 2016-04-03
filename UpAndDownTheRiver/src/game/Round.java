package game;

public class Round {
	private int numTricks;
	private int roundNum;
	
	public Round(int numTricks, int roundNum){
		this.numTricks = numTricks;
		this.roundNum = roundNum;
	}

	public int getNumTricks() {
		return numTricks;
	}

	public void setNumTricks(int numTricks) {
		this.numTricks = numTricks;
	}

	public int getRoundNum() {
		return roundNum;
	}

	public void setRoundNum(int roundNum) {
		this.roundNum = roundNum;
	}

}
