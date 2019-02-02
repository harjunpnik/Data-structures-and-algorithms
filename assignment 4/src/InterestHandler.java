import java.time.Clock;
import java.util.HashMap;

public class InterestHandler extends Thread {
	
	Clock clock;
	private HashMap<Long, Account> accountList;
	
	public InterestHandler(HashMap<Long, Account> accountList) {
		clock = Clock.systemDefaultZone();
		this.accountList = accountList;
	}
	
	private void interestCalculator() {
			//Adds interest to all the accounts
			for(Account str: accountList.values()) {
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
