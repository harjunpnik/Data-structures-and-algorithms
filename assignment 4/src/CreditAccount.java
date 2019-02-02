
public class CreditAccount extends Account {

	private double rate = 0.2;
	private final double limit = 1000;
	
	public CreditAccount(String name, long acctNumber, double balance) {
		super(name,acctNumber,balance, "CreditAccount");
	}
	
	@Override
	public double deposit (double amount){
		if(-amount >= this.getBalance()) {
	     this.setBalance(this.getBalance() + amount);
		   return this.getBalance();
		}else {
			System.out.println("\n" + "You cannot deposit more money than you are in debt");
			return 0;
		}
	}
	
	@Override
	public double withdraw (double amount){
		double fee = amount * 0.0005;
		double totalAmount = this.getBalance() - amount - fee;
		if(totalAmount >= -limit && totalAmount <= 0) {
			this.setBalance(this.getBalance() - amount - fee);
			System.out.print("\n" + "You are currently " + this.getBalance() + "€ in debt");
			return amount;
		}else {
			System.out.println("\n" + "Your withdrawal was not accepted. Your withdrawal would exeed the credit limit");
			return 0;
		}
	}	
	
	@Override
	public void addInterest() {
		double newBalance = this.getBalance() + (this.getBalance() * rate);
		this.setBalance(newBalance);
	}

}
