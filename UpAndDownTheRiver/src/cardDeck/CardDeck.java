package cardDeck;

import javax.swing.ImageIcon;

import cardDeck.Card.Ranks;
import cardDeck.Card.Suits;

public class CardDeck {
	public static final int NUM_CARDS = 52;		//number of cards in a deck
	private Card[] cardDeck;
	private int currentCard;
	
	public CardDeck(){
		cardDeck = new Card[NUM_CARDS];
		
		//add cards to the deck
		int i = 0;
		for (Ranks r : Ranks.values()){
			for (Suits s: Suits.values()){
				Card newCard = new Card(r, s);
				newCard.setIcon(new ImageIcon("cardImages/" + newCard.getRank().getValue()
						+ newCard.getSuit().getAbbr() + ".gif"));
				cardDeck[i++] = newCard;
			}
		}
		
		//set current card
		currentCard = 0;
		
	}
	
	public void shuffle(int numExchanges){
		int j = 0, 
			k = 0;
		
		//swap randomly picked cards
		for (int i = 0; i < numExchanges; i++){
			j = (int) (Math.random() * NUM_CARDS);
			k = (int) (Math.random() * NUM_CARDS);
			Card temp = cardDeck[j];
			cardDeck[j] = cardDeck[k];
			cardDeck[k] = temp;
		}
	}
	
	public Card deal(){
		if (currentCard < NUM_CARDS){
			return cardDeck[currentCard++];
		}
		else {
			System.out.println("Out of Cards");
			return null;
		}
	}
	
	public String toString(){
		String cardValues = "";
		for (Card c : cardDeck){
			cardValues += "\n" + c.toString();
		}
		return cardValues;
	}

}
