package game.view;

import game.cardscoring.Scorer;
import game.model.Card;
import game.model.Hand;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


/**Creates a display panel relating to each player
 */
@SuppressWarnings("serial")
public class playerDisplay extends JPanel {
	
	private DelegatedObservable obs;
	private JPanel currentPanel = new JPanel();
	private JButton buttonExchange = new JButton("Confirm Exchange");
	private JButton buttonNoExchange = new JButton("Keep All Cards");
	private JTextArea beginComment = new JTextArea(AREA_ROWS, AREA_COLS);
	private JTextArea exchangeComment = new JTextArea(AREA_ROWS, AREA_COLS);
	private JTextArea finalComment = new JTextArea(AREA_ROWS, AREA_COLS);
	private JList<String> listbox1;
	private JList<String> listbox2;
	private JLabel winnerLabel= new JLabel();
	private int[] output = new int[5];

	//Constants for textArea size 
	private static final int AREA_ROWS = 5;
	private static final int AREA_COLS = 23;

	/**Constructor, adds different components to playerDisplay panel
	 */
	public playerDisplay() {
		this.obs = new DelegatedObservable();
		setBackground(Color.white);
		add(currentPanel);
		currentPanel.setBackground(Color.white);
		currentPanel.setPreferredSize(new Dimension(325,525));
		PrepareTextArea(beginComment);
	}

	
	/**Shows the first hand that is dealt to the player
	 * @param player, given player
	 * @param h, given hand
	 */
	public void showFirstHand(String player, Hand h){
		setBorder(new TitledBorder(player));
		listbox1 = new JList<String>(h.toStringArray());
		listbox1.setBorder(new TitledBorder(player + "'s First Hand"));
		PrepareListBox(listbox1);
			if(player =="Human"){
				PrepareButton(buttonExchange);
				PrepareButton(buttonNoExchange);
	    		beginComment.setText("Select cards to exchange and click CONFIRM EXCHANGE (or KEEP ALL CARDS).\n\nHold ctrl/cmd to select several");		  
				}
			else{
				beginComment.setText("\nComputer's hand is dealt...\n");
			}
	}

	public void showExchange(Boolean exchangeCards, ArrayList <Card>cardsToExchange, Hand computerHand){
		PrepareTextArea(exchangeComment);
		if(exchangeCards == true){
			for (Card c : cardsToExchange) {
			exchangeComment.append("Exchanged..." + c.toString() + "....\n");
			}
		}
		else{
			exchangeComment.setText("Exchanged no cards....\n");
		}
	}
	
	/**Shows the second hand that is dealt once players have changed cards
	 * @param player, given player
	 * @param h, given hand
	 */
	public void showSecondHand(String player, Hand h) {
		listbox1.setEnabled(false);
		listbox2 = new JList<String>(h.toStringArray());	
		listbox2.setBorder(new TitledBorder(player + "'s Final hand"));
		PrepareListBox(listbox2);
	}
	
	/**Displays the type of hand a player has
	 * @param player, given player
	 * @param handScorer, given scorer 
	 */
	public void showScore(String player, Scorer handScorer) {
		PrepareTextArea(finalComment);
		finalComment.setText("\n" + player + "'s " + handScorer.toString() + "\n ----------------------------\n");
	}
	
	/**Add Button to the Panel and creates actionlisteners
	 * @param button, given button
	 */
	public void PrepareButton(JButton button){
		button.setVisible(true);
		button.addActionListener(new ClickListener());
		currentPanel.add(button);
	}

	/**Prepares the JTextArea and adds it to panel
	 * @param textArea, given textArea
	 */
	public void PrepareTextArea(JTextArea comment){
		comment.setFont(new Font("SansSerif", Font.PLAIN,12));
		comment.setLineWrap(true);
		comment.setWrapStyleWord(true);
		comment.setVisible(true);
		currentPanel.add(comment);
	}

	/**Prepares the list boxes and adds to panel
	 * @param listbox, given list box
	 */
	@SuppressWarnings("rawtypes")
	public void PrepareListBox(JList listbox){
		listbox.setForeground(Color.gray.darker());
		listbox.setFont(new Font("SansSerif", Font.BOLD,12));
		listbox.setVisible(true);	
		listbox.setFixedCellWidth(250);
		currentPanel.add(listbox);
	}
	
	/**Displays the winner in a label
	 * @param winner, string of winner
	 */
	public void showWinner(String winner) {
		winnerLabel.setVisible(true);
		winnerLabel.setForeground(Color.red.darker());
		winnerLabel.setBackground(Color.white);
		winnerLabel.setText("\n" + (winner + " wins!!").toUpperCase());
		winnerLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
		currentPanel.add(winnerLabel);
	}

	
	/**Updates the Screen by adding text and hides buttons, notifies observers of selection
	 */
	public void UpdateScreen(){
		buttonExchange.setVisible(false);
    	buttonNoExchange.setVisible(false);
    	beginComment.setText("\nHuman's hand is dealt...\n");
    	obs.setChanged();
		obs.notifyObservers(output);	
	}
	
	/**Checks the value of observable
	 * @return obs
	 */
	public DelegatedObservable getObservable() {
		return obs;
	}

	/**Updates screen once exchange is confirmed and passes data to observer
	 */
	public class ClickListener implements ActionListener 
    {  
        public void actionPerformed(ActionEvent e) 
        {
            String command = e.getActionCommand();

            if (command == "Keep All Cards")
            {
            	output = new int[0];
            	UpdateScreen();
            }
            if((command == "Confirm Exchange") && (listbox1.isSelectionEmpty()==false))
            {
            	output = listbox1.getSelectedIndices();
            	UpdateScreen();
            }
            else 
            {
            	JOptionPane.showMessageDialog(null,"Please make at least one selection");
            }
        }
    }
}




