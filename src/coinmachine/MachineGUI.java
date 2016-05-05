package coinmachine;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/** This is the main panel GUI, it's a program that let the user
 *  add a coin in to the machine with the limit capacity
 *  and it provide an observer to check on how many coin has been add.
 * 
 *  @Keetawat Srichompoo - 5810545840
 *
 */

public class MachineGUI extends Observable {

	//instance variable with the default value
	
	private JFrame frame = new JFrame() ;
	
	private JLabel balanceText ;
	private JLabel statusText = new JLabel ( "Status: " ) ;
	private JLabel insertCoin = new JLabel ( "insert Money" ) ;
	private JProgressBar progressBar;
	
	private JButton oneBaht ;
	private JButton fiveBaht ;
	private JButton tenBaht ;
	
	private int countCoin = 0 ;
	private int countBalance = 0 ;
	
	public MachineGUI () {
		
		//construct the method
		
		frame.setDefaultCloseOperation ( frame.EXIT_ON_CLOSE ) ;
		initComponents() ;
		
	}
	
	private void initComponents () {
		
		//set the frame layout
		
		frame.setLayout( new GridLayout( 3, 0 ) ) ;
		
		Container contents = new Container () ;
		contents.setLayout( new FlowLayout() ) ;
		
		Container contents2 = new Container () ;
		contents2.setLayout( new GridLayout( 0, 3 ) ) ;
		
		Container contents3 = new Container () ;
		contents3.setLayout( new GridLayout( 0, 3 ) ) ;
		
		//add a contents to the frame
		
		frame.add(contents) ;
		frame.add(contents2) ;
		frame.add(contents3) ;

		frame.setPreferredSize( new Dimension( 300, 310 ) ) ;
		
		
		// add image to the ImageIcon for use.
		ImageIcon oneCoin = new ImageIcon( "C:\\Users\\8.1\\Desktop\\Work\\lab10\\src\\images\\1baht.png" );
		ImageIcon fiveCoin = new ImageIcon( "C:\\Users\\8.1\\Desktop\\Work\\lab10\\src\\images\\5baht.png" );
		ImageIcon tenCoin = new ImageIcon( "C:\\Users\\8.1\\Desktop\\Work\\lab10\\src\\images\\10baht.png" );
		
		// add the image to the button
		oneBaht = new JButton( oneCoin );
		fiveBaht = new JButton( fiveCoin );
		tenBaht = new JButton( tenCoin );
		
		//set the font color
		Color darkGreen = new Color( 20, 100, 20 ) ;
		
		balanceText = new JLabel ( "Balance: " + countBalance ) ;
		balanceText.setForeground(darkGreen) ;
		
		//set the default value for the prograssbar
		progressBar = new JProgressBar( 0, 10 ) ;
		progressBar.setValue(0) ;
		progressBar.setString( countCoin + "" ) ;
		progressBar.setStringPainted(true) ;
		progressBar.setForeground( Color.GREEN ) ;
		
		//add all components to the frame
		contents.add(balanceText) ;
		contents.add(statusText) ;
		contents.add(progressBar) ;
		contents2.add(insertCoin) ;
		contents3.add(oneBaht) ;
		contents3.add(fiveBaht) ;
		contents3.add(tenBaht) ;

		/** add a actionListener to all of the button to use with a notify from observer
		 *  and check if the capacity hits a limit or not
		 */
		
		// add an ActionListener to the button
		oneBaht.addActionListener( new ActionListener() {
			
		       public void actionPerformed( ActionEvent evt ) {
		    	   
		    	   if( countCoin < 10 ) {
						countCoin++ ;
						countBalance++ ;
						balanceText.setText( "Balance: " + countBalance ) ;
						progressBar.setValue( countCoin ) ;
						progressBar.setString( countCoin + "" ) ;
						setChanged() ;
				        notifyObservers( countCoin ) ;
						
					}
					
					if( countCoin == 10 ) {
						oneBaht.setEnabled(false) ;
						fiveBaht.setEnabled(false) ;
						tenBaht.setEnabled(false) ;
					}
		       }
		});
		
		// add an ActionListener to the button
		fiveBaht.addActionListener( new ActionListener() {
		       public void actionPerformed( ActionEvent evt ) {
		    	   
		    	   if( countCoin < 10 ) {
						countCoin++ ;
						countBalance += 5 ;
						balanceText.setText( "Balance: " + countBalance ) ;
						progressBar.setValue( countCoin ) ;
						progressBar.setString( countCoin + "" ) ;
						setChanged() ;
				        notifyObservers( countCoin ) ;
						
					}
					
					if( countCoin == 10 ) {
						oneBaht.setEnabled( false ) ;
						fiveBaht.setEnabled( false ) ;
						tenBaht.setEnabled( false ) ;
					}
		       }
		});
		
		// add an ActionListener to the button
		tenBaht.addActionListener( new ActionListener() {
		       public void actionPerformed( ActionEvent evt ) {
		    	   
		    	   if( countCoin < 10 ) {
						countCoin++ ;
						countBalance += 10 ;
						balanceText.setText( "Balance: " + countBalance ) ;
						progressBar.setValue( countCoin ) ;
						progressBar.setString( countCoin + "" ) ;
						setChanged() ;
				        notifyObservers( countCoin ) ;
						
					}
					
					if( countCoin == 10){
						oneBaht.setEnabled(false) ;
						fiveBaht.setEnabled(false) ;
						tenBaht.setEnabled(false) ;
					}
		       }
		});
		
		frame.pack() ;
	}
	
	public void run() {
		frame.setVisible(true) ;
	}
	
	public int getCountCoin() {
		return countCoin ;
	}

	public int getCountBalance() {
		return countBalance ;
	}
	
}
