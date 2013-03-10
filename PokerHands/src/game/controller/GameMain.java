package game.controller;


import game.view.GameFrame;

import javax.swing.JFrame;

public class GameMain {

	public static void main(String[] args) {
		GameFrame gFrame = new GameFrame();
        gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gFrame.setVisible(true);
		
		//GameController game = new GameController();
		//game.begin();
	}

}
