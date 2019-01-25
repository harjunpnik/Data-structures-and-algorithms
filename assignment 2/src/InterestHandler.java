import java.time.Clock;
import java.util.ArrayList;

public class InterestHandler extends Thread {
	
	Clock clock;
	private ArrayList<Account> accountList;
	
	public InterestHandler(ArrayList<Account> accountList) {
		clock = Clock.systemDefaultZone();
		this.accountList = accountList;
	}
	
	public void interestCalculator() {
			//Adds interest to all the accounts
			for(Account str: accountList) {
				str.addInterest();
			}
			
	}
	
	public void run() {
		while(true) {
			try {
				//Every 10 seconds interestCalculator method is called
				Thread.sleep(10000);
				interestCalculator();
			}catch(InterruptedException e) {
				//System.out.println("Thread Exception. Cause of Exception: " + e.getMessage());
				break;
			}
			
		}
	}

}
