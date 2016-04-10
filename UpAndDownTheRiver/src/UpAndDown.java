import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.StartupWindow;

public class UpAndDown {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				launchApp();
				
			}
			
		});

	}
	
	private static void launchApp(){
		@SuppressWarnings("unused")
		StartupWindow start = new StartupWindow();
	}

}
