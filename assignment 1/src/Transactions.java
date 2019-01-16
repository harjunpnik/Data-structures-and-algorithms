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
		   			System.out.print("Rate: ");
		   			double rate = scanner.nextDouble();
		   	
		   			accountList.add(new Account (name, accountNr, balance, rate));
		   			System.out.println ( "\n" + "A new account was created: " + "\n" + new Account (name, accountNr, balance, rate));
		   			//System.out.println(accountList);
		   			break;
		   			
		   		//Withdraw money from account
		   		case "2" :
		   			System.out.println("\n" + "case 2");
		   			break;
		   			
		   		//Deposit money to account
		   		case "3" :
		   			System.out.println("\n" + "case 3");
		   			//System.out.println(((Account) accountList.get(0)).deposit(200));
		   			//System.out.println(accountList.get(0));
		   			break;
		   			
		   		//Show balance of account
		   		case "4" :
		   			boolean caseFourLoop = true;	//Boolean for the do{}while(); loop
		   			boolean accountNotFound = true;	//Boolean for the account search
		   			do {
		   				//Gives the option to search by account name or number
		   				System.out.println("\n" + "Do you want to search by" + "\n" + "1. Account Name" + "\n" + "2. Account Number");
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
