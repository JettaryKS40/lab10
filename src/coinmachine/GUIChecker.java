package coinmachine;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class GUIChecker {
	
	public static void main(String[] args) {
		
		MainCheck start = new MainCheck();
		start.run();
		
		MachineGUI start2 = new MachineGUI();
		start2.run();

		start2.addObserver(start);
		
	}
}

class MainCheck implements Observer {
	
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
		
		frame.setLayout( new GridLayout( 3, 0 ) ) ;
		
		Container contents = new Container () ;
		contents.setLayout( new FlowLayout() ) ;
		
		Container contents2 = new Container() ;
		contents2.setLayout( new FlowLayout() ) ;

		frame.add(contents) ;
		frame.add(contents2) ;
		
		Color darkGreen = new Color( 20, 200, 20 ) ;
		textAccept.setForeground(darkGreen) ;
		
		contents.add(coinCountText) ;
		contents.add(countTextField) ;
		contents2.add(textAccept) ;
		
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


