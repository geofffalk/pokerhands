package game.controller;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.view.GameFrame;

/**Contains Main method, opens initial frame
 */
public class GameMain {
	
	  final static int FRAME_WIDTH = 1000;
	  final static int FRAME_HEIGHT = 700;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				 GameFrame gFrame = new GameFrame();
				 gFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
				 gFrame.setTitle("Poker - Geoff Falk, Claire Fennell");
				 gFrame.setVisible(true);
				 gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
	});
		
	}
}
