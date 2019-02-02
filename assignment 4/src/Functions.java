import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Functions {

	static Scanner scanner = new Scanner(System.in);
	
	private String[] mainMenuOptions = {"Create a new account" , "Withdraw money from account", "Deposit money to account", "Show balance of account", "Show all accounts", "Exit" };
	//-----------------------------------------------------------------
	//	Main Menu print. Prints the main menu options.
	//-----------------------------------------------------------------
	public void mainMenu() {
		System.out.println("");
		for(int i=1; i <= mainMenuOptions.length; i++) {
			System.out.println(i + ". "+ mainMenuOptions[i-1]);
		}
	}
	
	//-----------------------------------------------------------------
	//	exit. Prints the exit message and closes the application.
	//-----------------------------------------------------------------
	public void exit() {
		System.out.println("\n" + "Goodbye!");
		System.exit(0);
	}
	
	//-----------------------------------------------------------------
	//	accountCreator. Asks the user for input for the account.
	//-----------------------------------------------------------------
	public String[] accountCreator(boolean isCreditAccount) {
			System.out.println("Please enter the following information: ");
			System.out.print("\n" + "Name: ");
			String name = scanner.next();
			double balance = 0;
			if(!isCreditAccount) balance = Functions.dataValidationDouble("Balance: ", "Please enter a number with or without a comma");
			String [] account = new String[3];
			account[0] = name;
			account[1] = Double.toString(balance);
			
			return account;
	}

	//-----------------------------------------------------------------
	//	dataValidationDouble. Validates the input so that the result 
	//	will be a double variable.
	//-----------------------------------------------------------------
	public static double dataValidationDouble (String helpMsg, String errorMsg) {
		double doubleToValidate = 0;
		while(doubleToValidate < 1) {
			if(doubleToValidate < 0)System.out.println("\n" + "Please enter a positive number.");
   			try {
   			System.out.print(helpMsg); 
   			doubleToValidate = scanner.nextDouble();
   			
   			} catch(InputMismatchException ex) {
   				System.out.println("\n" + errorMsg);
   				scanner.next();
   			}
			}
		return doubleToValidate;
	}
	
	//-----------------------------------------------------------------
	//	dataValidationLong. Validates the input so that the result 
	//	will be a Long variable.
	//-----------------------------------------------------------------
	public static long dataValidationLong (String helpMsg, String errorMsg) {
		long longToValidate = 0;
		while(longToValidate < 1) {
			if(longToValidate < 0)System.out.println("\n" + "Please enter a positive number.");
			try {
   			System.out.print(helpMsg); 
   			longToValidate = scanner.nextLong();
   			
   			} catch(InputMismatchException ex) {
   				System.out.println("\n" + errorMsg);
   				scanner.next();
   			}
			}
		return longToValidate;
	}
	
	//-----------------------------------------------------------------
	//	showBalance method that is called in the accountSearch
	//	Depending on if the account is a savings or checking account
	//	this will also show the total interest or the net deposits.
	//-----------------------------------------------------------------
	public boolean showBalance(Account account) {
		DecimalFormat deciamlFormat = new DecimalFormat("##.##");
		
		if (account instanceof SavingsAccount)System.out.println("\n" + "Total interest: " + deciamlFormat.format(((SavingsAccount) account).getTotalInterest()) + " €");
		if (account instanceof CheckingAccount)System.out.println("\n" + "Net Deposits: " + deciamlFormat.format(((CheckingAccount) account).getNetDeposits()) + " €");
		
		System.out.println("Balance: " + deciamlFormat.format(account.getBalance()) + "€");
		return false;
	}
	
	//-----------------------------------------------------------------
	//	Deposit method that is called in the accountSearch.
	//-----------------------------------------------------------------
	public boolean deposit(Account account) {
		double amount = dataValidationDouble("Amount to deposit:", "Please enter a number with or without a comma");
		
		amount = account.deposit(amount);				   				
		System.out.println("\n" + amount + "€ was deposited to " + account.getAcctNumber());
		return false;
	}
	
	//-----------------------------------------------------------------
	//	Withdraw method that is called in the accountSearch.
	//-----------------------------------------------------------------
	public boolean withdraw(Account account) {
			double amount = dataValidationDouble("Amount to withdraw:", "Please enter a number with or without a comma");
			
			amount = account.withdraw(amount);				   				
			System.out.println("\n" + amount + "€ was withdrawn from " + account.getAcctNumber());
			return false;
	}
	
	public long accountSearcher(HashMap<Long, Account> accountList) {
		System.out.println("\n" + "Please enter the");
		long accountNr = dataValidationLong("Account Number: ", "Please enter a number");
		if(accountList.containsKey(accountNr)) {
			return accountNr;
		}else {
   			System.out.println("\n" + "No account was found with that account number");
   			return 0;
		}
		
	}
	
}
