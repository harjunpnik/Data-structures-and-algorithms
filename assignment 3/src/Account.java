import java.text.NumberFormat;

public abstract class Account{
	
   private String accountType;
   private String name;
   private long accountNumber;
   private double balance;
  

   //-----------------------------------------------------------------
   //	Constructor. Sets up the account by defining its owner, 
   //	account number, and initial balance.
   //-----------------------------------------------------------------
   public Account (String name, long accountNumber, double balance, String accountType){
      setName(name);
      setAccountNumber(accountNumber);
      setBalance(balance);
      setAccountType(accountType);
   }

   //-----------------------------------------------------------------
   //  SET
   //-----------------------------------------------------------------
   private void setName(String name) {
	   this.name = name;
   }
   
   private void setAccountType(String accountType) {
	   this.accountType = accountType;
   }
   private void setAccountNumber(long accountNumber) {
	   this.accountNumber = accountNumber;
   }
   
   //PUBLIC
   public void setBalance(double balance) {
	   this.balance = balance;
   }
   
   //-----------------------------------------------------------------
   //  GET
   //-----------------------------------------------------------------
   public String getName(){
	      return name;
   }
   
   public String getAccountType (){
	      return accountType;
   }
   
   public long getAcctNumber (){
	      return accountNumber;
   }
   
   public double getBalance (){
	      return balance;
   }
   
   //-----------------------------------------------------------------
   //  METHODS
   //-----------------------------------------------------------------
   
   //ABSTRACT
   public abstract void addInterest ();
   
   //-----------------------------------------------------------------
   //  Deposits the specified amount into the account. Returns the
   //  new balance.
   //-----------------------------------------------------------------
   public double deposit (double amount){
      balance = balance + amount;

      return amount;
   }

   //-----------------------------------------------------------------
   //  Withdraws the specified amount from the account and applies
   //  the fee. The fee is 0,05% of the amount withdrawn.
   //  Returns the new balance.
   //-----------------------------------------------------------------
   public double withdraw (double amount){
	  double fee = amount * 0.0005;
      balance = balance - amount - fee;

      return amount;
   }

   //-----------------------------------------------------------------
   //  Returns a one-line description of the account as a string.
   //-----------------------------------------------------------------
   public String toString (){
	  NumberFormat fmt = NumberFormat.getCurrencyInstance();
	   
      return (accountNumber + "\t" + name + "\t" + fmt.format(balance) + "\t" + accountType);
   }
}
