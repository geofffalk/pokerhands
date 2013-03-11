package game.view;

import game.controller.GameController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**Creates the Main Game Frame with a top panel 
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame
{
	//Declare components as variables 
	private DelegatedObservable obs;
	private JButton buttonNew = new JButton("New Game");
    private JButton buttonExit= new JButton("Exit Game");
    private JPanel topPanel  = new JPanel(new BorderLayout());  
    private JLabel picLabel = new JLabel();
    private GameDisplay display = new GameDisplay();
    private GameController game = new GameController(display);
 
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 600;
    
    
    /**Constructor that builds basic elements of the frame
     */
    public GameFrame()
    {
    	this.obs = new DelegatedObservable();
        add(topPanel, BorderLayout.PAGE_START);
        topPanel.setBackground(Color.black);
        topPanel.setLayout(new FlowLayout());
        topPanel.add(buttonNew);
        topPanel.add(picLabel);
        topPanel.add(buttonExit);
        topPanel.setVisible(true);
        picLabel.setIcon(new ImageIcon("cards.jpg"));
        picLabel.setVisible(true);
        buttonExit.addActionListener(new ClickListener()); 
        buttonNew.addActionListener(new ClickListener());      
        buttonNew.setVisible(true);
        buttonExit.setVisible(true);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setTitle("Poker - Geoff Falk, Claire Fennell");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    /**Inner Class allows for exit and new game buttons to be pressed.
	 */
    public class ClickListener implements ActionListener 
    {  
        public void actionPerformed(ActionEvent e) 
        {
            String command = e.getActionCommand();

            if (command == "Exit Game")
            {
                        System.exit(0);
            }
                
            if(command == "New Game" )
            {
            	buttonNew.setText("Start Again"); 
                add(display);
                game.begin();
                obs.setChanged();
            }
            if(command == "Start Again" )
            {  
            	remove(display);
            	display = new GameDisplay();
            	game = new GameController(display);
            	add(display);
            	game.begin();
                obs.setChanged();
            }          
        }
    }
}

            
      