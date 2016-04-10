package cardDeck;

import javax.swing.ImageIcon;

public class Card {
	
	public enum Suits{
		SPADES("Spades", "s"),
		HEART("Heart", "h"),
		DIAMOND("Diamond", "d"),
		CLUBS("Clubs", "c");
		
		private final String desc;
		private final String abbr;
		
		Suits(String desc, String abbr){
			this.desc = desc;
			this.abbr = abbr;
		}
		
		public String getAbbr() {
			return abbr;
		}

		public String toString(){
			return desc;
		}
	}
	
	public enum Ranks{
		ACE(1, "Ace"),
		TWO(2, "Two"),
		THREE(3, "Three"),
		FOUR(4, "Four"),
		FIVE(5, "Five"),
		SIX(6, "Six"),
		SEVEN(7, "Seven"),
		EIGHT(8, "Eight"),
		NINE(9, "Nine"),
		TEN(10, "Ten"),
		JACK(11, "Jack"),
		QUEEN(12, "Queen"),
		KING(13, "King");
		
		private final int value;
		private final String desc;
		
		Ranks(int value, String desc){
			this.value = value;
			this.desc = desc;
		}
		
		public int getValue(){
			return value;
		}
		
		public String toString(){
			return desc;
		}
	}
	
	private Suits suit;
	private Ranks rank;
	private ImageIcon icon;
	
	public Card(Ranks r, Suits s){
		this.rank = r;
		this.suit = s;
	}
	
	public Suits getSuit() {
		return suit;
	}
	public void setSuit(Suits suit) {
		this.suit = suit;
	}
	public Ranks getRank() {
		return rank;
	}
	public void setRank(Ranks rank) {
		this.rank = rank;
	}
	
	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public String toString(){
		return rank.toString() + " of " + suit.toString();
	}
	
}