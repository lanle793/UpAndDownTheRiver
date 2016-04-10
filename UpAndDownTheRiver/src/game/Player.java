package game;

import java.util.ArrayList;

import cardDeck.Card;

public class Player {
	private String name;
	private ArrayList<Card> cardsOnHand;
	private boolean isHuman;
	private int numPoints;
	
	public Player(String name, boolean isHuman){
		this.name = name;
		this.isHuman = isHuman;
		numPoints = 0;
		setCardsOnHand(new ArrayList<Card>());
		
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

	public String toString(){
		return name;
	}

}
