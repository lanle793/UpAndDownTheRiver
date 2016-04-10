package game;

import java.util.ArrayList;
import java.util.List;

import cardDeck.Card;

public class Player {
	private String name;
	private List<Card> cardsOnHand;
	private Card cardOnTable;
	private boolean isHuman;
	private boolean isTrickWinner;
	private boolean isDealer;
	private int numPoints;
	private int guess;
	
	public Player(String name, boolean isHuman){
		this.name = name;
		this.setHuman(isHuman);
		setNumPoints(0);
		setCardsOnHand(new ArrayList<Card>());
		
	}
	
	public void getRandomCard(){
		int rand = (int)(Math.random() * cardsOnHand.size());
		cardOnTable = cardsOnHand.get(rand);
		cardsOnHand.remove(rand);
	}
	
	public void layCardOnTable(){
		
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

	public boolean isTrickWinner() {
		return isTrickWinner;
	}

	public void setTrickWinner(boolean isTrickWinner) {
		this.isTrickWinner = isTrickWinner;
	}

	public List<Card> getCardsOnHand() {
		return cardsOnHand;
	}

	public void setCardsOnHand(List<Card> cardsOnHand) {
		this.cardsOnHand = cardsOnHand;
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
