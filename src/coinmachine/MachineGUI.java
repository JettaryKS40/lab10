package coinmachine;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class MachineGUI extends Observable {

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
		
		frame.setDefaultCloseOperation ( frame.EXIT_ON_CLOSE ) ;
		initComponents() ;
		
	}
	
	private void initComponents () {
		
		frame.setLayout( new GridLayout( 3, 0 ) ) ;
		
		Container contents = new Container () ;
		contents.setLayout( new FlowLayout() ) ;
		
		Container contents2 = new Container () ;
		contents2.setLayout( new GridLayout( 0, 3 ) ) ;
		
		Container contents3 = new Container () ;
		contents3.setLayout( new GridLayout( 0, 3 ) ) ;
		
		frame.add(contents) ;
		frame.add(contents2) ;
		frame.add(contents3) ;

		frame.setPreferredSize( new Dimension( 300, 310 ) ) ;
		
		ImageIcon oneCoin = new ImageIcon( "C:\\Users\\8.1\\Desktop\\Work\\lab10\\src\\images\\1baht.png" );
		ImageIcon fiveCoin = new ImageIcon( "C:\\Users\\8.1\\Desktop\\Work\\lab10\\src\\images\\5baht.png" );
		ImageIcon tenCoin = new ImageIcon( "C:\\Users\\8.1\\Desktop\\Work\\lab10\\src\\images\\10baht.png" );
		
		oneBaht = new JButton( oneCoin );
		fiveBaht = new JButton( fiveCoin );
		tenBaht = new JButton( tenCoin );
		
		Color darkGreen = new Color( 20, 100, 20 ) ;
		
		
		balanceText = new JLabel ( "Balance: " + countBalance ) ;
		balanceText.setForeground(darkGreen) ;
		
		progressBar = new JProgressBar( 0, 10 ) ;
		progressBar.setValue(0) ;
		progressBar.setString( countCoin + "" ) ;
		progressBar.setStringPainted(true) ;
		progressBar.setForeground( Color.GREEN ) ;
		
		
		contents.add(balanceText) ;
		contents.add(statusText) ;
		contents.add(progressBar) ;
		contents2.add(insertCoin) ;
		contents3.add(oneBaht) ;
		contents3.add(fiveBaht) ;
		contents3.add(tenBaht) ;

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
