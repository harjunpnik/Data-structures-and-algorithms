
public class SavingsAccount extends Account {

	private double rate = 0.1;
	private double totalInterest = 0;
	   
	public SavingsAccount(String name, long acctNumber, double balance) {
		super(name,acctNumber,balance);
	}
	
	//-----------------------------------------------------------------
	//  Returns the total interest
	//-----------------------------------------------------------------
	public double getTotalInterest() {
		return totalInterest;
	}
	
	//-----------------------------------------------------------------
	//  Adds the interest to the balance and to the total interest
	//-----------------------------------------------------------------
	@Override
	public void addInterest() {
		double interest = this.getBalance() * rate;
		totalInterest += interest;
		double newBalance = this.getBalance() + interest;
		this.setBalance(newBalance);
	}

	//Returns the total interest
	@Override
	public double viewBalanceBonus() {
		
		return getTotalInterest();
	}


	
}
