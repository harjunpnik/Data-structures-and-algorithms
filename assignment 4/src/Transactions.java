import java.util.HashMap;
import java.util.Scanner;

public class Transactions
{

   public static void main (String[] args)
   {

	   Functions funcs = new Functions();
	   Scanner scanner = new Scanner(System.in);
	   
	   //Initialization of the array list and some accounts to the bank 
	   HashMap<Long, Account> accountList = new HashMap<Long, Account>();
	   long tempAccountNumber = Account.newAccountNumber();
	   accountList.put(tempAccountNumber, new SavingsAccount("nick", tempAccountNumber, 1000));
	   tempAccountNumber = Account.newAccountNumber();
	   accountList.put(tempAccountNumber, new CheckingAccount("john", tempAccountNumber, 100));
	   tempAccountNumber = Account.newAccountNumber();
	   accountList.put(tempAccountNumber,new CreditAccount("felix", tempAccountNumber, 0));
	   
	   //Initialization of variables
	   Account tempAccount;
	   String[] newAccount;
	   InterestHandler interestHandlerTimer = new InterestHandler(accountList);
	   interestHandlerTimer.start();
	   

	   System.out.println ("Welcome to Generic Bank!" + "\n" + "What would you like to do?");
	   
	   //Loop until the user enters "6" as his input
	   do{
		   //Prints the main menu
		   funcs.mainMenu();		 
		   //The user input for the main menu
		   String input = scanner.next();
		   
		   switch(input){
		   		
		   		//-----------------------------------------------------------------
		   		//	Create a new Account.
		   		//-----------------------------------------------------------------
		   		case "1" :
		   			boolean loopIsActive = true;
		   			
		   			do {
		   				//Asks the user to choose whether they want to create a Savings account or a Checking account
		   				System.out.println("\n" + "CREATA A ACCOUNT" + "\n" + "Do you want to create a" + "\n" + "1. Savings Account" + "\n" + "2. Checking Account" + "\n" + "3. Credit Account");
		   				input = scanner.next();
		   				switch(input) {
		   				
		   				//Savings Account
		   				case "1" :
		   					//Calls a method to get the user inputed data in a String array then adds the account to the account list
		   					newAccount = funcs.accountCreator(false);
		   					tempAccountNumber = Account.newAccountNumber();
		   					accountList.put(tempAccountNumber, new SavingsAccount(newAccount[0], tempAccountNumber, Double.parseDouble(newAccount[1])));
		   					loopIsActive = false;
		   					break;
		   					
		   				//Checking Account
		   				case "2" :
		   					//Calls a method to get the user inputed data in a String array then adds the account to the account list
		   					newAccount = funcs.accountCreator(false);
		   					tempAccountNumber = Account.newAccountNumber();
			   				accountList.put(tempAccountNumber, new CheckingAccount(newAccount[0],tempAccountNumber, Double.parseDouble(newAccount[1])));
			   				loopIsActive = false;
		   					break;
		   					
		   				//Credit Account
		   				case "3" :
		   					//Calls a method to get the user inputed data in a String array then adds the account to the account list
		   					newAccount = funcs.accountCreator(true);
		   					tempAccountNumber = Account.newAccountNumber();
			   				accountList.put(tempAccountNumber, new CheckingAccount(newAccount[0], tempAccountNumber, 0));
			   				loopIsActive = false;
		   					break;
		   					
		   				default :
		   					System.out.println("Invalid input");	//Remind user that the input is wrong
		   					break;
		   					
		   				}
		   
		   			}while(loopIsActive);
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//	Withdraw money from account.
		   		//-----------------------------------------------------------------
		   		case "2" :
		   			tempAccountNumber = funcs.accountSearcher(accountList);
		   			//if account is not a match we return a "0" and that is why we compare to "0"
		   			if(!(tempAccountNumber == 0)) {
		   				tempAccount = accountList.get(tempAccountNumber);
			   			funcs.withdraw(tempAccount);
		   			}
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//	Deposit money to account.
		   		//-----------------------------------------------------------------
		   		case "3" :
		   			tempAccountNumber = funcs.accountSearcher(accountList);
		   			//if account is not a match we return a "0" and that is why we compare to "0"
		   			if(!(tempAccountNumber == 0)) {
		   				tempAccount = accountList.get(tempAccountNumber);
			   			funcs.deposit(tempAccount);
		   			}
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//	Show balance of account.
		   		//-----------------------------------------------------------------
		   		case "4" :
		   			tempAccountNumber = funcs.accountSearcher(accountList);
		   			//if account is not a match we return a "0" and that is why we compare to "0"
		   			if(!(tempAccountNumber == 0)) {
		   				tempAccount = accountList.get(tempAccountNumber);
			   			funcs.showBalance(tempAccount);
		   			}
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//	Show all accounts.
		   		//-----------------------------------------------------------------
		   		case "5" :
		   			//Prints out all the accounts
		   			System.out.println();
		   			System.out.println(String.format("%1s%9s%15s%20s", "Nr" , "Name" , "Balance" , "Type"));
		   			for(Account str: accountList.values()) {
		   				System.out.println(str.toString());
		   			}
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//	Exit.
		   		//-----------------------------------------------------------------
		   		case "6" :
		   			//Closes the application
		   			scanner.close();
		   			interestHandlerTimer.interrupt();
		   			funcs.exit();
		   			break;
		   			
		   		default :
		   		 System.out.println("Invalid input");	//Remind user that the input is wrong
		   			
		   }
	   } while(true);
   }
}
