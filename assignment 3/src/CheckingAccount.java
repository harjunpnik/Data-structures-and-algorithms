public class CheckingAccount extends Account {
	
	private double rate = 0.01;
	private double totalDeposits = 0;
	private double totalWithdraws = 0;
	
	public CheckingAccount(String name, long acctNumber, double balance) {
		super(name,acctNumber,balance, "CheckingAccount");
	}
	
	//-----------------------------------------------------------------
	//  Calculates the sum of the total deposits and withdraws
	//-----------------------------------------------------------------
	public double getNetDeposits() {
		double netDeposits = totalDeposits - totalWithdraws;
		return netDeposits;
	}

	//Overridden, also calculates the total deposits
	@Override
	public double deposit(double amount) {
		totalDeposits += amount;
		this.setBalance(this.getBalance() + amount );
		return this.getBalance();
	}
	
	//Overridden, also calculates the total withdraws   
	@Override
	public double withdraw(double amount) {
		totalWithdraws += amount;
		double fee = amount * 0.0005;
		this.setBalance(this.getBalance() - amount - fee);
		return this.getBalance();
	}

	//-----------------------------------------------------------------
	//  Adds the interest to the balance
	//----------------------------------------------------------------- 
	@Override
	public void addInterest() {
		double newBalance = this.getBalance() + (this.getBalance() * rate);
		this.setBalance(newBalance);
	}



}