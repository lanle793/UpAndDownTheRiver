package game;

import javax.swing.JOptionPane;

import GUI.StartupWindow;
import cardDeck.CardDeck;

public class Game {
	public static final int NUM_PLAYERS = 5;
	public static final int NUM_ROUNDS = 10;
	
	private CardDeck cardDeck;
	private StartupWindow startupWindow;
	//private int numPlayers;
	//private int numRounds;
	private Player[] players;
	private Round[] rounds;
	
	public Game(){
		cardDeck = new CardDeck();
		cardDeck.shuffle(30);
		System.out.println(cardDeck.deal());
		
		enterPlayers();
		
		rounds = new Round[NUM_ROUNDS];
		
		startupWindow = new StartupWindow();
	}
	
	private void enterPlayers(){
		players = new Player[NUM_PLAYERS];
		String userName = JOptionPane.showInputDialog(null, "Enter your name", "Player Information", JOptionPane.QUESTION_MESSAGE);
		Player user = new Player(userName, true);
		players[0] = user;
		for(int i = 1; i < NUM_PLAYERS; i++){
			
		}
	}

}