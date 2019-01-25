
public class SavingsAccount extends Account {

	private double rate = 0.1;
	   
	public SavingsAccount(String name, long acctNumber, double balance) {
		super(name,acctNumber,balance);
	}
	
	@Override
	public void addInterest() {
		double newBalance = this.getBalance() + (this.getBalance() * rate);
		this.setBalance(newBalance);
	}
	
}
