package game;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import cardDeck.Card;
import cardDeck.CardDeck;

public class GameController {
	
	private String invalidGuess;
	
	public GameController(){
		invalidGuess = "";
	}
	
	public void enterPlayers(LinkedList<Player> players, int numPlayers){
		
		String userName = JOptionPane.showInputDialog(null, "Enter your name", 
				"Player Information", JOptionPane.QUESTION_MESSAGE);
		Player user = new Player(userName, true);
		players.add(user);
		for(int i = 1; i < numPlayers; i++){
			String computerName = JOptionPane.showInputDialog(null, "Enter your opponent name (Player " + i + ")", 
					"Player Information", JOptionPane.QUESTION_MESSAGE);
			Player computer = new Player(computerName, false);
			players.add(computer);
		}
		
	}
	
	public void dealCards(int numTricks, CardDeck cardDeck, LinkedList<Player> players){
		for(int i = 0; i < players.size(); i++){
			for(int j = 0; j < numTricks; j++){
				players.get(i).getCardsOnHand().add(cardDeck.deal());
			}
		}
	}
	
	public int getGuesses(int totalGuess, int numTricks, int roundNum, LinkedList<Player> players){
		
		//get players' guesses
		for(int i = 0; i < players.size(); i++){
			int guess;
			String input;
			boolean isValid;
			
			//get user's guess --- need to validate input
			if(players.get(i).isHuman()){
				input = JOptionPane.showInputDialog(null, "Enter your guess for round " 
						+ roundNum, "Player Guess", JOptionPane.QUESTION_MESSAGE);
				isValid = isValidGuess(input, totalGuess, numTricks, players.get(i));
				
				while(!isValid){
					JOptionPane.showMessageDialog(null, "Invalid Guess - " + invalidGuess);
					input = JOptionPane.showInputDialog(null, "Enter your guess for round " 
							+ roundNum, "Player Guess", JOptionPane.QUESTION_MESSAGE);
					isValid = isValidGuess(input, totalGuess, numTricks, players.get(i));
				}
				
				guess = Integer.parseInt(input);
				players.get(i).setGuess(guess);
				totalGuess += guess;
				
			} else{
				//get computer's guess
				guess = (int) (Math.random() * (numTricks + 1));
				input = Integer.toString(guess);
				isValid = isValidGuess(input, totalGuess, numTricks, players.get(i));
				
				while(!isValid){
					guess = (int) (Math.random() * (numTricks + 1));
					input = Integer.toString(guess);
					isValid = isValidGuess(input, totalGuess, numTricks, players.get(i));
				}
				
				players.get(i).setGuess(guess);
				totalGuess += guess;
			}
			
		}
		
		return totalGuess;
	}
	
	private boolean isValidGuess(String input, int totalGuess, int numTricks, Player player){
		int guess;
		
		//check if input is null
		if(input == null){
			invalidGuess = "You did not enter your guess";
			return false;
		}
		
		//check if input is an integer
		try{
			guess = Integer.parseInt(input);
		} catch(NumberFormatException e){
			invalidGuess = "Your input is not a number";
			return false;
		}
		
		//check if guess is smaller than zero
		if(guess < 0){
			invalidGuess = "Your guess cannot be less than zero";
			return false;
		}
		
		//check if guess is larger than the number of tricks
		if(guess > numTricks){
			invalidGuess = "Guess is larger than the number of tricks";
			return false;
		}
		
		//check if the total guess is equal to number of tricks
		if(player.isDealer()){
			if(guess + totalGuess == numTricks){
				invalidGuess = "The total guess cannot be equal to the number of tricks";
				return false;
			}
		}
		
		return true;
	}
	
	public void checkValidCards(List<Card> cardsOnHand, Card first){
		
	}
	
	public void findTrickWinner(){
		
	}
	
	public void addPoints(){
		
	}

}