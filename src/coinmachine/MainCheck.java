package coinmachine;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.List;

/** 
 * 	This class check if the coin has been add to the MachineGUI
 *  and notify user by display how many coin has been add.
 *
 *  @author Keetawat Srichompoo - 5810545840
 */

class MainCheck implements Observer {
	
	//instance variables
	
	private JFrame frame = new JFrame() ;
	
	private JLabel coinCountText = new JLabel("#Coins: ") ;
	private JLabel textAccept = new JLabel("Accepting Coins") ;
	private JTextField countTextField = new JTextField(10) ;
	
	public MainCheck () {
		
		//Makes the program close properly
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
		
		//Cast an Oberservable object for checking the coinMachine
		CoinMachine machine = (CoinMachine)object;
		
		/*
		 * If the machine is got coin inserted then set the String
		 * to show how many coin has been added.
		 */
		
		countTextField.setText( machine.getCount() + "" ) ;
		
		//if the machine is full then tell the user that is full
		
		if( machine.isFull() ) { textAccept.setText("FULL"); }
		boolean fullCapacity = !machine.isFull();;
		countTextField.setEnabled(fullCapacity);

	}
}


