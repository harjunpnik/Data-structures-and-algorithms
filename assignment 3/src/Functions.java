import java.text.DecimalFormat;
import java.util.ArrayList;
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
	public String[] accountCreator() {
			System.out.println("Please enter the following information: ");
			System.out.print("\n" + "Name: ");
			String name = scanner.next();
			long accountNr = Functions.dataValidationLong("Account Number: ", "Please enter a number");
			double balance = Functions.dataValidationDouble("Balance: ", "Please enter a number with or without a comma");
			String [] account = new String[3];
			account[0] = name;
			account[1] = Long.toString(accountNr);
			account[2] = Double.toString(balance);
			
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
	private boolean showBalance(Account account) {
		DecimalFormat deciamlFormat = new DecimalFormat("##.##");
		
		if (account instanceof SavingsAccount)System.out.println("\n" + "Total interest: " + deciamlFormat.format(((SavingsAccount) account).getTotalInterest()) + " €");
		if (account instanceof CheckingAccount)System.out.println("\n" + "Net Deposits: " + deciamlFormat.format(((CheckingAccount) account).getNetDeposits()) + " €");
		
		System.out.println("Balance: " + deciamlFormat.format(account.getBalance()) + "€");
		return false;
	}
	
	//-----------------------------------------------------------------
	//	Deposit method that is called in the accountSearch.
	//-----------------------------------------------------------------
	private boolean deposit(Account account) {
		double amount = dataValidationDouble("Amount to deposit:", "Please enter a number with or without a comma");
		
		amount = account.deposit(amount);				   				
		System.out.println("\n" + amount + "€ was deposited to " + account.getAcctNumber());
		return false;
	}
	
	//-----------------------------------------------------------------
	//	Withdraw method that is called in the accountSearch.
	//-----------------------------------------------------------------
	private boolean withdraw(Account account) {
			double amount = dataValidationDouble("Amount to withdraw:", "Please enter a number with or without a comma");
			
			amount = account.withdraw(amount);				   				
			System.out.println("\n" + amount + "€ was withdrawn from " + account.getAcctNumber());
			return false;
	}
	
	//-----------------------------------------------------------------
	//	accountSearch. Searches the right account and executes 
	//	withdraw, deposit or balance method.
	//-----------------------------------------------------------------
	public void accountSearch(ArrayList<Account> accountList, String action, String helpMsg, boolean withdrawBoolean, boolean depositBoolean, boolean balanceBoolean) { 
			
			boolean loopIsActive = true;	//Boolean for the do{}while(); loop
			boolean accountNotFound = true;	//Boolean for the account search
			
			do{
			//	Gives the option to search by account name or number
				System.out.println("\n" + action.toUpperCase() + "\n" + helpMsg + "\n" + "Seach account by" + "\n" + "1. Account Name" + "\n" + "2. Account Number");
				String option = scanner.next();
   			switch(option){
   			
   			//Account Name search
   			case "1":
   				System.out.println("\n" + "Please enter the");
	   			System.out.print("Account Name: "); 
	   			String name = scanner.next();
	   			for(Account str: accountList) {
	   				//if account is found execute one of the following methods depending on the boolean that is true
	   				if(str.getName().equals(name)) {
	   					if(withdrawBoolean) accountNotFound = withdraw(str);
	   					if(depositBoolean) accountNotFound = deposit(str);
	   					if(balanceBoolean) accountNotFound = showBalance(str);
	   					break;
	   				}
	   			}
	   			//If no account was found this will be printed out
	   			if(accountNotFound) {
	   			System.out.println("\n" + "No account was found with that account name");
	   			}
   				
	   			loopIsActive = false;
   				break;

	   		///Account Number search	
   			case "2":
	   			System.out.println("\n" + "Please enter the");

	   			long accountNr = dataValidationLong("Account Number: ", "Please enter a number");
	   			
	   			for(Account str: accountList) {
	   			//if account is found execute one of the following methods depending on the boolean that is true
	   				if(str.getAcctNumber() == accountNr) {
	   					if(withdrawBoolean)accountNotFound = withdraw(str);
	   					if(depositBoolean) accountNotFound = deposit(str);
	   					if(balanceBoolean) accountNotFound = showBalance(str);
	   					break;
	   				}
	   			}
	   			//If no account was found this will be printed out
	   			if(accountNotFound) {
	   			System.out.println("\n" + "No account was found with that account number");
	   			}
	   			loopIsActive = false;
   				break;
   				
   			default:
   				System.out.println("Invalid input");	//Remind user that the input is wrong
   				break;
   			}
				
			}while(loopIsActive);
			
	}
	
}
