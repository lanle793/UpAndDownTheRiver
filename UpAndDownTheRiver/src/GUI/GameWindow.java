package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

import game.Game;

public class GameWindow {
	private JFrame gameWindow;
	
	public GameWindow(){
		Game newGame = new Game();
		
		gameWindow = new JFrame("New Game");
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setPreferredSize(new Dimension(400,300));
		gameWindow.pack();
	}

}
