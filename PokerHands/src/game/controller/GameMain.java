package game.controller;


import java.awt.EventQueue;
import javax.swing.JOptionPane;
import game.view.GameFrame;

public class GameMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	 new GameFrame().setVisible(true);
                } catch (Exception e) {
                	JOptionPane.showMessageDialog(null,"Poker Application will not load");
                }
            }
        });
	}
}
