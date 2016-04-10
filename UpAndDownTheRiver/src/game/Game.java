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
	
	public Game(){
		
		totalGuess = 0;
		controller = new GameController();
		players = new LinkedList<Player>();
		gameWindow = new GameWindow();
		
		controller.enterPlayers(players, NUM_PLAYERS);
		userNum = players.size();
		
		/*for(int i = 1; i <= NUM_ROUNDS; i++){
			startNewRound(i, i);
		}
		
		for(int i = 1; i < NUM_ROUNDS; i++){
			startNewRound(10 - i, 10 + i);
		}*/
		
		startNewRound(5, 5);

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
		/*totalGuess = controller.getGuesses(totalGuess, numTricks, roundNum, players);
		
		//start laying down cards
		gameWindow.enableCardsOnHand();
		
		for(int i = 1; i <= numTricks; i++){
			startNewTrick(i);
		}
		
		//userNum++;
		/*if(userNum > players.size()){
			userNum -= players.size();
		}*/
	}
	
	private void startNewTrick(int trickNum){
		if(trickNum == 1){
			
			//first player pick any card
			if(players.getFirst().isHuman()){
				JOptionPane.showMessageDialog(null, "Pick any card to lay down");
			} else{
				players.getFirst().getRandomCard();
			}
			
			first = players.getFirst().getCardOnTable();
			
			//for the rest of the players...
			for(int j = 1; j < players.size(); j++){
				
				//users get to choose the card to lay down
				if(players.get(j).isHuman()){
					JOptionPane.showMessageDialog(null, "Your turn");
				} else{
					//each computer player lays down one card
					players.get(j).layCardOnTable();
				}
				
			}
		} else{
			
		}
	}

}
