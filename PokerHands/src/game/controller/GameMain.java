package game.controller;

import javax.swing.JFrame;

import game.view.GameFrame;

/**Contains Main method, opens initial frame
 */
public class GameMain {

	public static void main(String[] args) {
	     GameFrame gFrame = new GameFrame();
		 gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 gFrame.setVisible(true);
	}
}
