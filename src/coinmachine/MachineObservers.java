package coinmachine;
import java.util.Observable;
import java.util.Observer;

public class MachineObservers implements Observer{
	private CoinMachine coinCheck ;
	
	@Override
	public void update(Observable object, Object arg) {
		coinCheck = (CoinMachine)object;
		System.out.println( "Currently " + coinCheck.getBalance() + " baht in the machine.");
	}

	
}
