package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cardDeck.Card;

public class Player {
	private String name;
	private List<Card> cardsOnHand;
	private Card cardOnTable;
	private boolean isHuman;
	private boolean isTrickWinner;
	private boolean isDealer;
	private boolean isGameWinner;
	private int numPoints;
	private int guess;
	private int numTricksWon;
	
	public Player(String name, boolean isHuman){
		this.name = name;
		this.setHuman(isHuman);
		setNumPoints(0);
		setCardsOnHand(new ArrayList<Card>());
		cardOnTable = null;
	}
	
	public void getRandomCard(){
		int rand = (int)(Math.random() * cardsOnHand.size());
		cardOnTable = cardsOnHand.get(rand);
		cardsOnHand.remove(rand);
		
	}
	
	public void layCardOnTable(){
		for (Iterator<Card> iterator = cardsOnHand.iterator(); iterator.hasNext();) {
			Card c = iterator.next();
			if (c.isValid()) {
				cardOnTable = c;
				iterator.remove();
			}
		}
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

	public int getNumTricksWon() {
		return numTricksWon;
	}

	public void setNumTricksWon(int numTricksWon) {
		this.numTricksWon = numTricksWon;
	}

	public boolean isGameWinner() {
		return isGameWinner;
	}

	public void setGameWinner(boolean isGameWinner) {
		this.isGameWinner = isGameWinner;
	}

	public String toString(){
		return name;
	}

}
