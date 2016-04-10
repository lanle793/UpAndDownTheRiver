package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cardDeck.Card;
import game.Player;

public class GameWindow {
	private JFrame gameWindow;
	private JPanel cardDisplay;
	private JPanel tableDisplay;
	private Map<Card, JButton> cardsOnHand;
	
	public GameWindow(){
		gameWindow = new JFrame("New Game");
		cardDisplay = new JPanel();
		tableDisplay = new JPanel();
		cardsOnHand = new HashMap<Card, JButton>();
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setPreferredSize(new Dimension(400,300));
		gameWindow.add(cardDisplay, BorderLayout.SOUTH);
		gameWindow.add(tableDisplay, BorderLayout.CENTER);
		gameWindow.pack();
		
	}
	
	public void displayUserHand(Player player){
		for(Card c : player.getCardsOnHand()){
			JButton card = new JButton(c.getIcon());
			card.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					player.setCardOnTable(c);
					cardDisplay.remove(card);
					cardDisplay.revalidate();
					cardDisplay.repaint();
					player.getCardsOnHand().remove(c);
					
				}
				
			});
			card.setEnabled(false);
			cardsOnHand.put(c, card);
			cardDisplay.add(card);
		}
		
	}
	
	public void enableCardsOnHand(){
		for(JButton btn : cardsOnHand.values()){
			btn.setEnabled(true);
		}
	}
	
	public void disableInvalidCards(Player player){
		for(Card c: player.getCardsOnHand()){
			if(!c.isValid()){
				for(Map.Entry<Card, JButton> entry: cardsOnHand.entrySet()){
					Card card = entry.getKey();
					JButton btn = entry.getValue();
					if(card.equals(c)){
						btn.setEnabled(false);
					}
				}
			}
		}
	}
	
	public void displayTrumpCard(Card trump){
		JLabel trumpCard = new JLabel(trump.getIcon());
		tableDisplay.add(trumpCard);
	}
	
	public void displayCardsOnTable(){
		
	}

}
