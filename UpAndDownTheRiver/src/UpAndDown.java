import cardDeck.CardDeck;

public class UpAndDown {

	public static void main(String[] args) {
		CardDeck cardDeck;
		
		cardDeck = new CardDeck();
		cardDeck.shuffle(30);
		System.out.println(cardDeck.deal());

	}

}