package coinmachine;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/**
 * This is the main panel GUI, it's a program that let the user add a coin in to
 * the machine with the limit capacity and it provide an observer to check on
 * how many coin has been add.
 * 
 * @Keetawat Srichompoo - 5810545840
 */

public class MachineGUI implements Observer {

	// instance variable with the default value

	private JFrame frame = new JFrame();

	private JLabel balanceText;
	private JLabel statusText = new JLabel("Status: ");
	private JLabel insertCoin = new JLabel("insert Money");
	private JProgressBar progressBar;

	private JButton oneBaht;
	private JButton fiveBaht;
	private JButton tenBaht;

	private final CoinMachine coinMachine;

	public MachineGUI(CoinMachine machine) {
		this.coinMachine = machine;
		// construct the method

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		initComponents();

	}

	private void initComponents() {
		
		int count = coinMachine.getCount();
		int balance = coinMachine.getBalance();
		int capacity = coinMachine.getCapacity();
		
		// set the frame layout

		frame.setLayout(new GridLayout(3, 0));

		Container contents = new Container();
		contents.setLayout(new FlowLayout());

		Container contents2 = new Container();
		contents2.setLayout(new GridLayout(0, 3));

		Container contents3 = new Container();
		contents3.setLayout(new GridLayout(0, 3));

		// add a contents to the frame

		frame.add(contents);
		frame.add(contents2);
		frame.add(contents3);

		frame.setPreferredSize(new Dimension(300, 310));

		ClassLoader loader = this.getClass().getClassLoader();
		
		URL OneBaht = loader.getResource( "images/1baht.png" );
		URL FiveBaht = loader.getResource( "images/5baht.png" );
		URL TenBaht = loader.getResource( "images/10baht.png" );
		
		ImageIcon image_1baht_png = new ImageIcon( OneBaht );
		ImageIcon image_5baht_png = new ImageIcon( FiveBaht );
		ImageIcon image_10baht_png = new ImageIcon( TenBaht );
		
		// add the image to the button
		oneBaht = new JButton(image_1baht_png);
		fiveBaht = new JButton(image_5baht_png);
		tenBaht = new JButton(image_10baht_png);

		// set the font color
		Color darkGreen = new Color(20, 100, 20);

		balanceText = new JLabel("Balance: " + balance);
		balanceText.setForeground(darkGreen);

		// set the default value for the prograssbar
		progressBar = new JProgressBar(0, capacity);
		progressBar.setValue(count);
		progressBar.setString(count + "");
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.GREEN);

		// add all components to the frame
		contents.add(balanceText);
		contents.add(statusText);
		contents.add(progressBar);
		contents2.add(insertCoin);
		contents3.add(oneBaht);
		contents3.add(fiveBaht);
		contents3.add(tenBaht);

		/**
		 * add a actionListener to all of the button to use with a notify from
		 * observer and check if the capacity hits a limit or not
		 */

		// add an ActionListener to the all buttons
		oneBaht.addActionListener(new DepositCoinAction(1));
		fiveBaht.addActionListener(new DepositCoinAction(5));
		tenBaht.addActionListener(new DepositCoinAction(10));

		frame.pack();
	}

	public void run() {
		frame.setVisible(true);
	}

	//This action perfrom when the user use the button
	class DepositCoinAction implements ActionListener {
		private int value;

		public DepositCoinAction(int value) {
			this.value = value;
		}
		
		//after the user hit the button, then insert the coin to the CoinMachine
		public void actionPerformed(ActionEvent evt) {
			coinMachine.insert(new Coin(value));
		}
	}

	@Override
	public void update(Observable subject, Object optional) {
		
		int balance = coinMachine.getBalance();
		int count = coinMachine.getCount();
		
		// update the display ... by asking the coin machine
		balanceText.setText("Balance: " + balance);
		progressBar.setValue(count);
		progressBar.setString(count + "");

		// if the machine is full then disable the buttons
		// BUT don't forget to enable them again when the machine is NOT full
		
		boolean notFull = !coinMachine.isFull();
		
		oneBaht.setEnabled(notFull);
		fiveBaht.setEnabled(notFull);
		tenBaht.setEnabled(notFull);
		
	}

}
