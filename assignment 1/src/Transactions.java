import java.util.ArrayList;
import java.util.Scanner;

//********************************************************************
//  Transactions.java       Author: Lewis/Loftus
//							Modified by: Niklas
//
//  Demonstrates the creation and use of multiple Account objects.
//********************************************************************

public class Transactions
{
   //-----------------------------------------------------------------
   //  Creates some bank accounts and requests various services.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
//      Account acct1 = new Account ("Ted Murphy", 72354, 102.56);
//      Account acct2 = new Account ("Jane Smith", 69713, 40.00);
//      Account acct3 = new Account ("Edward Demsey", 93757, 759.32);
//
//      acct1.deposit (25.85);
//
//      double smithBalance = acct2.deposit (500.00);
//      System.out.println ("Smith balance after deposit: " +
//                          smithBalance);
//
//      System.out.println ("Smith balance after withdrawal: " + 
//                          acct2.withdraw (430.75, 1.50));
//
//      acct1.addInterest();
//      acct2.addInterest();
//      acct3.addInterest();
//
//      System.out.println ();
//      System.out.println (acct1);
//      System.out.println (acct2);
//      System.out.println (acct3);
	   
	   
	   Scanner scanner = new Scanner(System.in);
	   
	   //Initialization of the array list and some accounts to the bank 
	   ArrayList<Account>  accountList = new ArrayList<Account>();	
	   accountList.add(new Account("nick", 911, 10000, 0.05));
	   accountList.add(new Account("john", 711, 50000, 5.5));
      
	   System.out.println ("Welcome to Generic Bank!" + "\n" + "What would you like to do?");
	   
	   //Loop until the user enters "6" as his input
	   do{
		   System.out.println("\n" + "1. Create a new account");
		   System.out.println("2. Withdraw money from account");
		   System.out.println("3. Deposit money to account");
		   System.out.println("4. Show balance of account");
		   System.out.println("5. Show all accounts");
		   System.out.println("6. Exit");
		   
		   //The user input for the main menu
		   String input = scanner.next();
		   
		   switch(input){
		   		
		   		//Create a new Account
		   		case "1" :
		   			System.out.print("\n" + "Name: ");
		   			String name = scanner.next();
		   			System.out.print("Account Number: "); 
		   			long accountNr = scanner.nextLong();
		   			System.out.print("Balance: ");
		   			double balance = scanner.nextDouble();
		   			System.out.print("Interest rate: ");
		   			double rate = scanner.nextDouble();
		   	
		   			accountList.add(new Account (name, accountNr, balance, rate));
		   			System.out.println ( "\n" + "A new account was created: " + "\n" + new Account (name, accountNr, balance, rate));
		   			//System.out.println(accountList);
		   			break;
		   			
		   		//Withdraw money from account
		   		case "2" :
		   			boolean caseTwoLoop = true;	//Boolean for the do{}while(); loop
		   			boolean accountNotFound = true;	//Boolean for the account search
		   			double amount = 0;
		   			
		   			do{
		   			//	Gives the option to search by account name or number
		   				System.out.println("\n" + "WITHDRAW MONEY" + "\n" + "To What account do you want to withdraw money from?" + "\n" + "Seach account by" + "\n" + "1. Account Name" + "\n" + "2. Account Number");
		   				String option = scanner.next();
			   			switch(option){
			   			
			   			//Account Name search
			   			case "1":
			   				System.out.println("\n" + "Please enter the");
				   			System.out.print("Account Name: "); 
				   			name = scanner.next();
				   			for(Account str: accountList) {
				   				//if account is found, print out the balance and change the boolean
				   				if(str.getName().equals(name)) {
				   					System.out.print("Amount to withdraw:");
				   					amount = scanner.nextDouble();
				   					str.withdraw(amount);				   				
				   					System.out.println("\n" + amount + "€ was withdrawn from " + str.getAcctNumber());
				   					accountNotFound = false;
				   					break;
				   				}
				   			}
				   			//If no account was found this will be printed out
				   			if(accountNotFound) {
				   			System.out.println("\n" + "No account was found with that account name");
				   			}
			   				
				   			caseTwoLoop = false;
			   				break;

				   		///Account Number search	
			   			case "2":
				   			System.out.println("\n" + "Please enter the");
				   			System.out.print("Account Number: "); 
				   			accountNr = scanner.nextLong();
				   			for(Account str: accountList) {
				   			//if account is found, print out the balance and change the boolean
				   				if(str.getAcctNumber() == accountNr) {
				   					System.out.print("Amount to withdraw:");
				   					amount = scanner.nextDouble();
				   					str.withdraw(amount);				   				
				   					System.out.println("\n" + amount + "€ was withdrawn from " + str.getAcctNumber());
				   					accountNotFound = false;
				   					break;
				   				}
				   			}
				   			//If no account was found this will be printed out
				   			if(accountNotFound) {
				   			System.out.println("\n" + "No account was found with that account number");
				   			}
				   			caseTwoLoop = false;
			   				break;
			   				
			   			default:
			   				System.out.println("Invalid input");	//Remind user that the input is wrong
			   				break;
			   			}
		   				
		   			}while(caseTwoLoop);
		   			
		   			break;
		   			
		   		//Deposit money to account
		   		case "3" :
		   			boolean caseThreeLoop = true;	//Boolean for the do{}while(); loop
		   			accountNotFound = true;	//Boolean for the account search
		   			amount = 0;				//Amount to deposit
		   			
		   			do {
		   				//Gives the option to search by account name or number
		   				System.out.println("\n" + "DEPOSIT MONEY" + "\n" + "To What account do you want to deposit money to?" + "\n" + "Seach account by" + "\n" + "1. Account Name" + "\n" + "2. Account Number");
		   				String option = scanner.next();
			   			switch(option){
			   			
			   			//Account Name search
			   			case "1":
			   				System.out.println("\n" + "Please enter the");
				   			System.out.print("Account Name: "); 
				   			name = scanner.next();
				   			for(Account str: accountList) {
				   				//if account is found, print out the balance and change the boolean
				   				if(str.getName().equals(name)) {
				   					System.out.print("Amount to deposit:");
				   					amount = scanner.nextDouble();
				   					str.deposit(amount);				   				
				   					System.out.println("\n" + amount + "€ was deposited to " + str.getAcctNumber());
				   					accountNotFound = false;
				   					break;
				   				}
				   			}
				   			//If no account was found this will be printed out
				   			if(accountNotFound) {
				   			System.out.println("\n" + "No account was found with that account name");
				   			}
			   				
				   			caseThreeLoop = false;
			   				break;

				   		///Account Number search	
			   			case "2":
				   			System.out.println("\n" + "Please enter the");
				   			System.out.print("Account Number: "); 
				   			accountNr = scanner.nextLong();
				   			for(Account str: accountList) {
				   			//if account is found, print out the balance and change the boolean
				   				if(str.getAcctNumber() == accountNr) {
				   					System.out.print("Amount to deposit:");
				   					amount = scanner.nextDouble();
				   					str.deposit(amount);				   				
				   					System.out.println("\n" + amount + "€ was deposited to " + str.getAcctNumber());
				   					accountNotFound = false;
				   					break;
				   				}
				   			}
				   			//If no account was found this will be printed out
				   			if(accountNotFound) {
				   			System.out.println("\n" + "No account was found with that account number");
				   			}
				   			caseThreeLoop = false;
			   				break;
			   				
			   			default:
			   				System.out.println("Invalid input");	//Remind user that the input is wrong
			   				break;
			   			}
		   				
		   			}while(caseThreeLoop);
		   			break;
		   			
		   		//Show balance of account
		   		case "4" :
		   			boolean caseFourLoop = true;	//Boolean for the do{}while(); loop
		   			accountNotFound = true;			//Boolean for the account search
		   			do {
		   				//Gives the option to search by account name or number
		   				System.out.println("\n" + "SHOW BALANCE" + "\n" + "Do you want to search by" + "\n" + "1. Account Name" + "\n" + "2. Account Number");
		   				String option = scanner.next();
			   			switch(option){
			   			
			   			//Account Name search
			   			case "1":
			   				System.out.println("\n" + "Please enter the");
				   			System.out.print("Account Name: "); 
				   			name = scanner.next();
				   			for(Account str: accountList) {
				   				//if account is found, print out the balance and change the boolean
				   				if(str.getName().equals(name)) {
				   					System.out.println("\n" + "Balance: " + str.getBalance());
				   					accountNotFound = false;
				   					break;
				   				}
				   			}
				   			//If no account was found this will be printed out
				   			if(accountNotFound) {
				   			System.out.println("\n" + "No account was found with that account name");
				   			}
			   				
			   				caseFourLoop = false;
			   				break;

				   		///Account Number search	
			   			case "2":
				   			System.out.println("\n" + "Please enter the");
				   			System.out.print("Account Number: "); 
				   			accountNr = scanner.nextLong();
				   			for(Account str: accountList) {
				   			//if account is found, print out the balance and change the boolean
				   				if(str.getAcctNumber() == accountNr) {
				   					System.out.println("\n" + "Balance: " + str.getBalance());
				   					accountNotFound = false;
				   					break;
				   				}
				   			}
				   			//If no account was found this will be printed out
				   			if(accountNotFound) {
				   			System.out.println("\n" + "No account was found with that account number");
				   			}
			   				caseFourLoop = false;
			   				break;
			   				
			   			default:
			   				System.out.println("Invalid input");	//Remind user that the input is wrong
			   				break;
			   			}
		   			}while(caseFourLoop);
		   			break;
		   			
		   		//Show all accounts
		   		case "5" :
		   			//Prints out all the accounts
		   			System.out.println();
		   			for(Account str: accountList) {
		   				System.out.println(str);
		   			}
		   			break;
		   			
		   		//Exit
		   		case "6" :
		   			//Closes the application
		   			System.out.println("\n" + "Goodbye!");
		   			scanner.close();
		   			System.exit(0);
		   			break;
		   			
		   		default :
		   		 System.out.println("Invalid input");	//Remind user that the input is wrong
		   			
		   
		   }
	   } while(true);
   }
}
