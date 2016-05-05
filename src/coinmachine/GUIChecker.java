package coinmachine;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/** This class check if the coin has been add to the MachineGUI
 *  and notify user by display how many coin has been add.
 * 
 *  @author Keetawat Srichompoo - 5810545840
 *
 */

public class GUIChecker {
	
	// Main class that run a program and observer
	
	public static void main(String[] args) {
		
		MainCheck start = new MainCheck();
		start.run();
		
		MachineGUI start2 = new MachineGUI();
		start2.run();

		start2.addObserver(start);
		
	}
}

/** This is a GUI panel for checking if the coin has been add
 *  by the user.
 */

class MainCheck implements Observer {
	
	//instance variables
	
	private JFrame frame = new JFrame() ;
	
	private JLabel coinCountText = new JLabel("#Coins: ") ;
	private JLabel textAccept = new JLabel("Accepting Coins") ;
	private JTextField countTextField = new JTextField(10) ;
	
	private MachineGUI machineStart = new MachineGUI() ;

	
	public MainCheck () {
		frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE ) ;
		initComponents() ;
		
	}
	
	
	private void initComponents () {
		
		//set the layout panel
		
		frame.setLayout( new GridLayout( 3, 0 ) ) ;
		
		Container contents = new Container () ;
		contents.setLayout( new FlowLayout() ) ;
		
		Container contents2 = new Container() ;
		contents2.setLayout( new FlowLayout() ) ;

		frame.add(contents) ;
		frame.add(contents2) ;
		
		//set color font
		
		Color darkGreen = new Color( 20, 200, 20 ) ;
		textAccept.setForeground(darkGreen) ;
		
		//add all components to the frame
		contents.add(coinCountText) ;
		contents.add(countTextField) ;
		contents2.add(textAccept) ;
		
		//adjust the program display size
		
		frame.pack() ;
	}
	
	public void run() {
		frame.setVisible(true) ;
	}

	@Override
	public void update( Observable object, Object arg1 ) {
		machineStart = ( MachineGUI )object ;
		countTextField.setText( machineStart.getCountCoin() + "" ) ;

	}
}


