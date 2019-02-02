import java.util.ArrayList;
import java.util.Scanner;

public class Transactions
{

   public static void main (String[] args)
   {

	   Functions funcs = new Functions();
	   Scanner scanner = new Scanner(System.in);
	   
	   //Initialization of the array list and some accounts to the bank 
	   ArrayList<Account>  accountList = new ArrayList<Account>();	
	   accountList.add(new SavingsAccount("nick", 911, 1000));
	   accountList.add(new CheckingAccount("john", 711, 100));
	   accountList.add(new CreditAccount("felix", 666, 0));
	   
	   //Initialization of variables
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
		   					newAccount = funcs.accountCreator();
		   					accountList.add(new SavingsAccount(newAccount[0], Long.parseLong(newAccount[1]), Double.parseDouble(newAccount[2])));
		   					loopIsActive = false;
		   					break;
		   					
		   				//Checking Account
		   				case "2" :
		   					//Calls a method to get the user inputed data in a String array then adds the account to the account list
		   					newAccount = funcs.accountCreator();
			   				accountList.add(new CheckingAccount(newAccount[0], Long.parseLong(newAccount[1]), Double.parseDouble(newAccount[2])));
			   				loopIsActive = false;
		   					break;
		   					
		   				//Credit Account
		   				case "3" :
		   					//Calls a method to get the user inputed data in a String array then adds the account to the account list
		   					newAccount = funcs.accountCreator();
			   				accountList.add(new CheckingAccount(newAccount[0], Long.parseLong(newAccount[1]), 0));
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
		   			funcs.accountSearch(accountList, "withdraw", "What account do you want to withdraw money from?" , true, false, false);
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//	Deposit money to account.
		   		//-----------------------------------------------------------------
		   		case "3" :
		   			funcs.accountSearch(accountList, "deposit", "What account do you want to deposit money to?" , false, true, false);
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//	Show balance of account.
		   		//-----------------------------------------------------------------
		   		case "4" :
		   			funcs.accountSearch(accountList, "balance", "Show balance from account?" , false, false, true);
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//	Show all accounts.
		   		//-----------------------------------------------------------------
		   		case "5" :
		   			//Prints out all the accounts
		   			System.out.println();
		   			for(Account str: accountList) {
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