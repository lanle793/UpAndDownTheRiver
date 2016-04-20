package game;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import GUI.GameWindow;
import cardDeck.Card;
import cardDeck.CardDeck;

public class Game {
	public static final int NUM_PLAYERS = 5;
	public static final int NUM_ROUNDS = 10;	//round # that has the max number of cards
	
	private CardDeck cardDeck;
	//private int numPlayers;
	//private int numRounds;
	private LinkedList<Player> players;
	private Card trump;
	private Card first;
	private int totalGuess;
	private GameWindow gameWindow;
	private int userNum;
	private GameController controller;
	private int startIndex;
	private int endIndex;
	private String[][] guessInfo;
	private int[][] pointInfo;
	
	public Game(){
		
		totalGuess = 0;
		controller = new GameController();
		players = new LinkedList<Player>();
		guessInfo = new String[2 * NUM_ROUNDS - 1][NUM_PLAYERS];
		pointInfo = new int[2 * NUM_ROUNDS - 1][NUM_PLAYERS];
		
		controller.enterPlayers(players, NUM_PLAYERS);
		gameWindow = new GameWindow();
		userNum = 1;
		
		/*for(int i = 1; i <= NUM_ROUNDS; i++){
			startNewRound(i, i);
		}
		
		for(int i = 1; i < NUM_ROUNDS; i++){
			startNewRound(10 - i, 10 + i);
		}*/
		
		startNewRound(1, 1);

	}
	
	private void startNewRound(int numTricks, int roundNum){
		
		//create a card deck and shuffle it
		cardDeck = new CardDeck();
		cardDeck.shuffle(30);
		
		//deal card(s) to each player
		controller.dealCards(numTricks, cardDeck, players);
		
		//display user's hand
		gameWindow.displayUserHand(players.get(userNum - 1));
		
		//determine the trump card
		trump = cardDeck.deal();
		gameWindow.displayTrumpCard(trump);
		
		//get players' guesses
		totalGuess = controller.getGuesses(totalGuess, numTricks, roundNum, players);
		
		//record guesses
		fillGuessInfo(roundNum);
		gameWindow.displayGuessInfo(this);
		
		//start laying down cards
		JOptionPane.showMessageDialog(null, "Let's Start!");
		gameWindow.enableCardsOnHand();
		
		startIndex = 1;
		
		/*for(int i = 1; i <= numTricks; i++){
			startNewTrick(i);
		}*/
		
		startNewTrick(1);
		
		//add points to players after each round
		/*for (Player p : players) {
			controller.addPoints(p);
		}*/
		
		//userNum++;
		/*if(userNum > players.size()){
			userNum -= players.size();
		}*/
	}
	
	private void startNewTrick(int trickNum){
		layFirstCard(players.get(startIndex - 1));
			
	}
	
	public void continueAfterUserTurn(){
		//for the rest of the players...
		layFollowingCards(players);
	}
	
	private void layFirstCard(Player player){
		endIndex = startIndex - 2;
		
		//first turn player pick any card
		if(player.isHuman()){
			JOptionPane.showMessageDialog(null, "Your turn - Pick any card to lay down");
			
			//add end turn button
			gameWindow.displayEndTurnBtn(this, player);
			
		} else{
			player.getRandomCard();
			setFirst(player.getCardOnTable());
			gameWindow.displayCardOnTable(player);
			layFollowingCards(players);
		}

	}
	
	private void layFollowingCards(LinkedList<Player> players){
		JOptionPane.showMessageDialog(null, "Continue");
		
		if (startIndex > endIndex) {
			for(int j = startIndex; j < players.size(); j++){
				controller.checkValidCards(players.get(j).getCardsOnHand(), first, trump);
				
				//users get to choose the card to lay down
				if(players.get(j).isHuman()){
					JOptionPane.showMessageDialog(null, "Your turn");
					
					//reset start index
					startIndex = j + 1;
					if (startIndex >= players.size()) {
						startIndex = 0;
					}
					
					//disable invalid cards
					gameWindow.disableInvalidCards(players.get(j));
					
					//add end turn button
					gameWindow.displayEndTurnBtn(this, players.get(j));
					
					break;
					
				} else{
					
					//each computer player lays down one card
					JOptionPane.showMessageDialog(null, players.get(j).getName() + "'s turn");
					players.get(j).layCardOnTable();
					System.out.println(players.get(j).getCardOnTable());
					gameWindow.displayCardOnTable(players.get(j));
				}
				
			}
			
			if (endIndex >= 0) {
				for(int j = 0; j <= endIndex; j++){
					controller.checkValidCards(players.get(j).getCardsOnHand(), first, trump);
					
					//users get to choose the card to lay down
					if(players.get(j).isHuman()){
						JOptionPane.showMessageDialog(null, "Your turn");
						
						//reset start index
						startIndex = j + 1;
						if (startIndex >= players.size()) {
							startIndex = 0;
						}
						
						//disable invalid cards
						gameWindow.disableInvalidCards(players.get(j));
						
						//add end turn button
						gameWindow.displayEndTurnBtn(this, players.get(j));
						
						break;
						
					} else{
						
						//each computer player lays down one card
						JOptionPane.showMessageDialog(null, players.get(j).getName() + "'s turn");
						players.get(j).layCardOnTable();
						System.out.println(players.get(j).getCardOnTable());
						gameWindow.displayCardOnTable(players.get(j));
					}
					
				}
			}
		
		} else {
			for(int j = startIndex; j < players.size(); j++){
				controller.checkValidCards(players.get(j).getCardsOnHand(), first, trump);
				
				//each computer player lays down one card
				JOptionPane.showMessageDialog(null, players.get(j).getName() + "'s turn");
				players.get(j).layCardOnTable();
				System.out.println(players.get(j).getCardOnTable());
				gameWindow.displayCardOnTable(players.get(j));
				
			}
		}
		
		//find trick winner
		startIndex = controller.findTrickWinner(players, first, trump) + 1;
		
		//declare trick winner
		gameWindow.declareTrickWinner(players.get(startIndex - 1));
	}
	
	private void fillGuessInfo(int roundNum) {
		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; j < NUM_PLAYERS; j++) {
				guessInfo[roundNum - 1][j] = Integer.toString(players.get(i).getGuess());
			}
			
		}
	}

	public Card getFirst() {
		return first;
	}

	public void setFirst(Card first) {
		this.first = first;
	}

	public LinkedList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(LinkedList<Player> players) {
		this.players = players;
	}

	public String[][] getGuessInfo() {
		return guessInfo;
	}

	public void setGuessInfo(String[][] guessInfo) {
		this.guessInfo = guessInfo;
	}

}
