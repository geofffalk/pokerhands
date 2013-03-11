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


/**Display panel that will show the detail of the game.
 */
@SuppressWarnings("serial")
public class GameDisplay extends JPanel {
	//Declare components as variables 
	private DelegatedObservable obs;
	private JPanel textPanel = new JPanel();
	private JPanel player1Panel = new JPanel();
	private JPanel player2Panel = new JPanel();
	private JTextArea gameArea = new JTextArea(AREA_ROWS, AREA_COLS);
	private JLabel winnerLabel = new JLabel();
	private JButton buttonExchange = new JButton("Confirm Exchange");
	private JButton buttonNoExchange = new JButton("Keep All Cards");
	private JList<String> listbox1;
	private JList<String> listbox2;
	private int[] output = new int[5];
	
	//Constants for textArea size 
	private static final int AREA_ROWS = 20;
	private static final int AREA_COLS = 20;

	/**Constructor, adds different components to display panel
	 */
	public GameDisplay () {
		this.obs = new DelegatedObservable();
		setBackground(Color.black);
		add(player1Panel);
		add(textPanel);
		add(player2Panel);
		
		textPanel.setBackground(Color.white);
		textPanel.setPreferredSize(new Dimension(325,400));
		textPanel.setBorder(new TitledBorder("WELCOME TO POKER!"));
		textPanel.add(gameArea);
		textPanel.add(winnerLabel);
		winnerLabel.setVisible(true);
		
		player1Panel.setBackground(Color.white);
		player1Panel.setPreferredSize(new Dimension(325,400));
		player1Panel.setBorder(new TitledBorder("HUMAN"));
		player1Panel.add(buttonExchange);
		player1Panel.add(buttonNoExchange);
		
		buttonExchange.setVisible(false);
		buttonNoExchange.setVisible(false);
		buttonExchange.addActionListener(new ClickListener());
		buttonNoExchange.addActionListener(new ClickListener());
		
		player2Panel.setBackground(Color.white);
		player2Panel.setPreferredSize(new Dimension(325,400));
		player2Panel.setBorder(new TitledBorder("COMPUTER"));
		player2Panel.setVisible(false);

		gameArea.setFont(new Font("SansSerif", Font.BOLD,12));
		gameArea.setLineWrap(true);
	    gameArea.setWrapStyleWord(true);
		gameArea.setVisible(true);
	}
	
	

	/**Shows the first hand that is dealt to the player
	 * @param player, given player
	 * @param h, given hand
	 */
	public void showFirstHand(String player, Hand h) {
		listbox1 = new JList<String>(h.PopulateJList());
		FormatListBox(listbox1);
		listbox1.setBorder(new TitledBorder(player + "'s First Hand"));
			if(player == "Human"){
				gameArea.append("Please select the cards to exchange and click CONFIRM EXCHANGE\n\nHold ctrl/cmd to select several");
				player1Panel.add(listbox1);
			   	buttonExchange.setVisible(true);
	        	buttonNoExchange.setVisible(true);
				}
			else{
				gameArea.append("\nComputer's hand is dealt...\n");
				player2Panel.add(listbox1);
				player2Panel.setVisible(true);
			}
	}
	
	/**Updates screen once exchange is confirmed and passes data to observer
	 */
	public class ClickListener implements ActionListener 
    {  
        public void actionPerformed(ActionEvent e) 
        {
            String command = e.getActionCommand();

            if((command == "Confirm Exchange") && (listbox1.isSelectionEmpty()==false))
            {
            	output = listbox1.getSelectedIndices();
            	buttonExchange.setVisible(false);
            	buttonNoExchange.setVisible(false);
            	gameArea.setText("\nHuman's hand is dealt...\n");
            	obs.setChanged();
				obs.notifyObservers(output);
            }
            else if (command == "Keep All Cards")
            {
            	output = new int[0];
            	buttonExchange.setVisible(false);
            	buttonNoExchange.setVisible(false);
            	gameArea.setText("\nHuman's hand is dealt...");
            	obs.setChanged();
				obs.notifyObservers(output);
            }
            else 
            {
            	JOptionPane.showMessageDialog(null,"Please make at least one selection");
            }
        }
    }


	/**Displays the cards exchanged
	 * @param c, card that will be exchanged
	 */
	public void showCardExchange(Card c) {
		gameArea.append("Exchanged..." + c.toString() + "....\n");
	}

	/**Displays the type of hand a player has
	 * @param player, given player
	 * @param handScorer, given scorer 
	 */
	public void showScore(String player, Scorer handScorer) {
		gameArea.append("\n" + player + "'s " + handScorer.toString() + "\n ----------------------------\n");
	}

	/**Shows the second hand that is dealt once players have changed cards
	 * @param player, given player
	 * @param h, given hand
	 */
	public void showSecondHand(String player, Hand h) {
		listbox1.setEnabled(false);
		listbox2 = new JList<String>(h.PopulateJList());	
		FormatListBox(listbox2);
		listbox2.setBorder(new TitledBorder(player + "'s Final hand"));
			if(player == "Human"){
				player1Panel.add(listbox2);
			}
			else{
				player2Panel.add(listbox2);
			}
	}


	/**Formats the listboxes used to a uniform look
	 * @param listbox, given listbox
	 */
	@SuppressWarnings("rawtypes")
	public void FormatListBox(JList listbox){
		listbox.setForeground(Color.gray.darker());
		listbox.setFont(new Font("SansSerif", Font.BOLD,12));
		listbox.setVisible(true);	
		listbox.setFixedCellWidth(300);
	}
	
	/**Displays the winner in a label
	 * @param winner, string of winner
	 */
	public void showWinner(String winner) {
		winnerLabel.setVisible(true);
		winnerLabel.setForeground(Color.red.darker());
		winnerLabel.setBackground(Color.white);
		winnerLabel.setText("\n" + (winner + " wins!!").toUpperCase());
		winnerLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
	}

	/**Displays message if no cards are exchanged
	 */
	public void showNoCardExchange() {
		gameArea.append("Exchanged no cards");
	}
	
	
	/**Checks the value of observable
	 * @return obs
	 */
	public DelegatedObservable getObservable() {
		return obs;
	}
}




