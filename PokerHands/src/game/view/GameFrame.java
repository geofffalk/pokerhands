package game.view;

import game.controller.GameController;
import game.view.playerDisplay;

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
    private JPanel mainPanel  = new JPanel();
    private JLabel picLabel = new JLabel();
    private GameController game;
 
    /**Constructor that builds basic elements of the frame
     */
    public GameFrame()
    {
    	this.obs = new DelegatedObservable();
        add(topPanel, BorderLayout.PAGE_START);
        add(mainPanel, BorderLayout.CENTER);
        topPanel.setBackground(Color.black);
        topPanel.setLayout(new FlowLayout());
        mainPanel.setBackground(Color.black);
        mainPanel.setLayout(new FlowLayout());
        topPanel.add(buttonNew);
        topPanel.add(picLabel);
        topPanel.add(buttonExit);
        topPanel.setVisible(true);
        picLabel.setIcon(new ImageIcon("cards.jpg"));
        picLabel.setVisible(true);
        buttonExit.addActionListener(new ClickListener()); 
        buttonNew.addActionListener(new ClickListener());      
        buttonNew.setVisible(true);
    }
    
    
    /**Inner Class allows for exit and new game buttons to be pressed.
	 */
    public class ClickListener implements ActionListener 
    {  
    	private playerDisplay computerDisplay = new playerDisplay();
    	private playerDisplay humanDisplay = new playerDisplay();
    	
        public void actionPerformed(ActionEvent e) 
        {
            String command = e.getActionCommand();

            if(command == "Exit Game")
            {
                        System.exit(0);
            }
                
            if(command == "New Game" )
            {
            	buttonNew.setText("Start Again"); 
                
                game = new GameController(humanDisplay, computerDisplay);
                game.begin();
                mainPanel.add(humanDisplay);
                mainPanel.add(computerDisplay);
                computerDisplay.setVisible(false);
                obs.setChanged();
                revalidate();
                repaint();        
           }
           if(command == "Start Again")
           {    	 
              mainPanel.removeAll();
              computerDisplay = new playerDisplay();
              humanDisplay = new playerDisplay();
              mainPanel.add(humanDisplay);
              mainPanel.add(computerDisplay);
	          computerDisplay.setVisible(false);
	          game = new GameController(humanDisplay, computerDisplay);
	          game.begin();
	          obs.setChanged();
              revalidate();
              repaint();          	
            }
        }
    }
    
}


            
      