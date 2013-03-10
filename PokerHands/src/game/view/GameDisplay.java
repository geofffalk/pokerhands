package game.view;

import game.cardscoring.Scorer;
import game.model.Card;
import game.model.Hand;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class GameDisplay extends JPanel {

	private DelegatedObservable obs;
	private JPanel textPanel = new JPanel();
	private JPanel player1Panel = new JPanel();
	private JPanel player2Panel = new JPanel();
	private JTextArea gameArea = new JTextArea(AREA_ROWS, AREA_COLS);
	private JLabel winnerLabel = new JLabel();
	private JButton buttonExchange = new JButton("Confirm Exchange");
	private JList<String> listbox1;
	private JList<String> listbox2;
	private int[] listResults;
	
	private static final int AREA_ROWS = 23;
	private static final int AREA_COLS = 20;

	
	
	public GameDisplay() {
		this.obs = new DelegatedObservable();
		setBackground(Color.gray);
		add(textPanel);
		add(player1Panel);
		add(player2Panel);
		textPanel.setBackground(Color.white);
		textPanel.setPreferredSize(new Dimension(250,400));
		textPanel.setBorder(new TitledBorder("Welcome to Poker!"));
		player1Panel.setBackground(Color.white);
		player1Panel.setPreferredSize(new Dimension(325,400));
		player1Panel.setBorder(new TitledBorder("Human"));
		player2Panel.setBackground(Color.white);
		player2Panel.setPreferredSize(new Dimension(325,400));
		player2Panel.setBorder(new TitledBorder("Computer"));
		
		textPanel.add(gameArea);
		gameArea.setBackground(Color.white);
		gameArea.setForeground(Color.blue);
		gameArea.setLineWrap(true);
        gameArea.setWrapStyleWord(true);
		gameArea.setVisible(true);
		repaint();
	}

	public void showFirstHand(String player, Hand h) {
		if(player == "Human"){
		gameArea.append("Please select the cards to exchange and click Confirm Exchange\n\nNote: Hold ctrl/cmd to select several");
		listbox1 = new JList<String>(h.MakeList());
		player1Panel.add(listbox1);
		player1Panel.add(buttonExchange);
		buttonExchange.addActionListener(new ClickListener());
		}
		else{
			gameArea.append("\nComputer's hand is dealt...\n");
			listbox1 = new JList<String>(h.MakeList());
			player2Panel.add(listbox1);
		}
		listbox1.setVisible(true);	
		listbox1.setBorder(new TitledBorder("First hand"));
		listbox1.setFixedCellWidth(300);
	
	}
	
	public class ClickListener implements ActionListener 
    {  
        public void actionPerformed(ActionEvent e) 
        {
            String command = e.getActionCommand();

            if ((command == "Confirm Exchange") && (listbox1.isSelectionEmpty()==false))
            {
            	listResults = listbox1.getSelectedIndices();
            	remove(buttonExchange);
            	buttonExchange.setVisible(false);
            	textPanel.add(gameArea);
            	gameArea.setText("\nHuman's hand is dealt...\n");
        		ProcessUserDecision();
        		repaint();
            }
            else
            {
            	JOptionPane.showMessageDialog(null,"Please make at least one selection");

            }
        }
    }


	public void showCardExchange(Card c) {
		gameArea.append("Exchanged..." + c.toString() + "....\n");
		
	}

	public void showScore(String player, Scorer handScorer) {
		gameArea.append("\n" + player + "'s " + handScorer.toReadableString() + "\n");
	}


	public void showSecondHand(String player, Hand h) {
		listbox1.setEnabled(false);
		listbox2 = new JList<String>(h.MakeList());
		
		if(player == "Human"){
		player1Panel.add(listbox2);
		}
		else{
		player2Panel.add(listbox2);
		}
		
		listbox2.setVisible(true);	
		listbox2.setBorder(new TitledBorder(player + "'s final hand"));
		listbox2.setFixedCellWidth(300);
		repaint();

	}

	public void showWinner(String string) {
		winnerLabel.setVisible(true);
		winnerLabel.setForeground(Color.red);
		winnerLabel.setBackground(Color.gray);
		pokerLabel.setHorizontalAlignment(JLabel.LEFT);
		add(winnerLabel);
		winnerLabel.setText("\n" + (string + " is the winner!!").toUpperCase());
		winnerLabel.setFont(new Font("Serif", Font.BOLD, 30));

	}

	public void showNoCardExchange() {
		gameArea.append("Exchanged no cards");
		

	}

	public DelegatedObservable getObservable() {
		return obs;
	}

	public void ProcessUserDecision() {
		int[] output = new int[5];
		for (int i = 0; i < listResults.length; i++) {
			  if(listResults[i] == 5) {
				 output = new int[0];
			  }
			  else{
				output = listResults;
			}
		}
				obs.setChanged();
				obs.notifyObservers(output);
	}
}




