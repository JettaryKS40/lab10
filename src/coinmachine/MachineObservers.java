package coinmachine;
import java.util.Observable;
import java.util.Observer;

/** This is an observer class for checking update on CoinMachine class
 *  and then print the String to notify user if it call by the CoinMachine method.
 *  
 *  @author Keetawat Srichompoo - 5810545840
 *
 */

public class MachineObservers implements Observer{
	private CoinMachine coinCheck ;
	
	@Override
	public void update(Observable object, Object arg) {
		coinCheck = (CoinMachine)object;
		System.out.println( "Currently " + coinCheck.getBalance() + " baht in the machine.");
	}

	
}
