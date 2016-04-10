package game;

import java.util.ArrayList;

import cardDeck.Card;

public class Player {
	private String name;
	private ArrayList<Card> cardsOnHand;
	private Card cardOnTable;
	private boolean isHuman;
	private int numPoints;
	private int guess;
	private boolean isDealer;
	
	public Player(String name, boolean isHuman){
		this.name = name;
		this.setHuman(isHuman);
		setNumPoints(0);
		setCardsOnHand(new ArrayList<Card>());
		
	}
	
	public int getNumPoints() {
		return numPoints;
	}

	public void setNumPoints(int numPoints) {
		this.numPoints = numPoints;
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	public boolean isHuman() {
		return isHuman;
	}

	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}

	public boolean isDealer() {
		return isDealer;
	}

	public void setDealer(boolean isDealer) {
		this.isDealer = isDealer;
	}

	public ArrayList<Card> getCardsOnHand() {
		return cardsOnHand;
	}

	public void setCardsOnHand(ArrayList<Card> cardsOnHand) {
		this.cardsOnHand = cardsOnHand;
	}
	
	public void showCardsOnHand(){
		for(Card c : cardsOnHand){
			System.out.println(c);
		}
	}

	public Card getCardOnTable() {
		return cardOnTable;
	}

	public void setCardOnTable(Card cardOnTable) {
		this.cardOnTable = cardOnTable;
	}

	public String toString(){
		return name;
	}

}
