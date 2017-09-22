/////////////// Directory
package gui;

/////////////// project libraries
import gui.panels.*;

/////////////// Event Libraries         
import java.awt.*;
import java.awt.event.*;

/////////////// 
import java.util.*;
import java.time.*;
import java.text.*;

/////////////// General Java Libraries
import java.util.*;
import java.io.*;

////////////// GUI Libraries
import javax.swing.*; 
import javax.swing.plaf.metal.*;
import javax.swing.border.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;


/*******************************************************************************
* @desc        The main gui interface for the chat client
*
* @date        9/15/2017
* @author      Amber Normand, Erika Tobias, Kristen Merritt
*******************************************************************************/



public class ClientGUI extends JFrame{
	private String chat_user = "";
	
	private JFrame jf = new JFrame("Chat Client - NSSA 290"); //main frame
   
	//all the panels/elements needed for this application
   private MenuBar menuBar;
   private LoginPanel loginPanel;
	private ChatPanel chatPanel;
	
	
	/**
	* @CONSTRUCTOR
	*/
	public ClientGUI(){
		//////////////////// set some preferences on the GUI
      this.jf.setSize(600,500);
      this.jf.setLayout(new BorderLayout());
      this.jf.setLocationRelativeTo(null);
      this.jf.setResizable(false);
		
		
		//////////////////// Needed Elements
      this.menuBar = new MenuBar();
   	//////////////////// Initialize all Panels
      this.loginPanel = new LoginPanel();
		this.chatPanel = new ChatPanel();
	
	  	//////////////////// Lets get the program up for the first time
      jf.add(BorderLayout.PAGE_START, this.menuBar.getMenubar());//menu bar
      jf.add(this.loginPanel.getPanel());//login panel
   	
   	
   	
      	//////////////////// Show it to the user
      jf.setVisible(true); // display jf
      jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //close by default
		
		
		loginPanel.getConnectButton().addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent e){
               
					connectToSocket();
					
            }//end action performed
      });//end action listener
	
	}//end constructor
	
	public Boolean connectToSocket(){
		this.jf.remove(this.loginPanel.getPanel());
		
		this.jf.add(this.chatPanel.getPanel());
		
		this.jf.revalidate();
      this.jf.repaint();
      pack();		
		return true;
	}
	
	
	
	
	
	

}//end class: ClientGUI