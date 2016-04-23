package GUI;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;

public class StartupWindow{

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private JFrame startupWindow;
	private JPanel contentPane;
	private JButton newGameBtn, exitBtn, howToPlayBtn; 
	
	public StartupWindow(){
		startupWindow = new JFrame("Up And Down The River");
		contentPane = new JPanel();
		startupWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startupWindow.setPreferredSize(new Dimension(400,300));
		startupWindow.setContentPane(contentPane);
		startupWindow.setVisible(true);
		
		newGameBtn = new JButton("New Game");
		newGameBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				startupWindow.dispose();
				@SuppressWarnings("unused")
				Game newGame = new Game();
				
			}
			
		});
		contentPane.add(newGameBtn);
		
		howToPlayBtn = new JButton("How To Play");
		howToPlayBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(new File("UpAndDownRules.pdf"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		contentPane.add(howToPlayBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		contentPane.add(exitBtn);
		
		startupWindow.pack();
		
	}

}
