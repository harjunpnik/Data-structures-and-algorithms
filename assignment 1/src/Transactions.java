import java.util.ArrayList;
import java.util.Scanner;

public class Transactions
{

   public static void main (String[] args)
   {

	   Functions funcs = new Functions();
	   Scanner scanner = new Scanner(System.in);
	   
	   //Initialization of variables
	   long accountNr = 0;
	   double balance = 0;
	   double rate = 0;

	   
	   //Initialization of the array list and some accounts to the bank 
	   ArrayList<Account>  accountList = new ArrayList<Account>();	
	   accountList.add(new Account("nick", 911, 1000, 3.5));
	   accountList.add(new Account("john", 711, 5000, 5.5));
      
	   System.out.println ("Welcome to Generic Bank!" + "\n" + "What would you like to do?");
	   
	   //Loop until the user enters "7" as his input
	   do{
		   //Prints the main menu
		   funcs.mainMenu();		 
		   //The user input for the main menu
		   String input = scanner.next();
		   
		   switch(input){
		   		
		   		//-----------------------------------------------------------------
		   		//Create a new Account
		   		//-----------------------------------------------------------------
		   		case "1" :
		   			System.out.print("\n" + "Name: ");
		   			String name = scanner.next();
		   			accountNr = Functions.dataValidationLong("Account Number: ", "Please enter a number");
		   			balance = Functions.dataValidationDouble("Balance: ", "Please enter a number with or without a comma");
		   			rate = Functions.dataValidationDouble("Interest rate: ", "Please enter a number with or without a comma");
		   			
		   			accountList.add(new Account (name, accountNr, balance, rate));
		   			System.out.println ( "\n" + "A new account was created: " + "\n" + new Account (name, accountNr, balance, rate));
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//Withdraw money from account
		   		//-----------------------------------------------------------------
		   		case "2" :
		   			funcs.accountSearch(accountList, "withdraw", "What account do you want to withdraw money from?" , true, false, false);
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//Deposit money to account
		   		//-----------------------------------------------------------------
		   		case "3" :
		   			funcs.accountSearch(accountList, "deposit", "What account do you want to deposit money to?" , false, true, false);
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//Show balance of account
		   		//-----------------------------------------------------------------
		   		case "4" :
		   			funcs.accountSearch(accountList, "balance", "Show balance from account?" , false, false, true);
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//Show all accounts
		   		//-----------------------------------------------------------------
		   		case "5" :
		   			//Prints out all the accounts
		   			System.out.println();
		   			for(Account str: accountList) {
		   				System.out.println(str);
		   			}
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//Add interest
		   		//-----------------------------------------------------------------
		   		case "6" :
		   			//Adds interest to all the accounts
		   			System.out.println();
		   			for(Account str: accountList) {
		   				str.addInterest();
		   			}
	   				System.out.println("Interest has been added to the accounts");
		   			break;
		   			
		   		//-----------------------------------------------------------------
		   		//Exit
		   		//-----------------------------------------------------------------
		   		case "7" :
		   			//Closes the application
		   			scanner.close();
		   			funcs.Exit();
		   			break;
		   			
		   		default :
		   		 System.out.println("Invalid input");	//Remind user that the input is wrong
		   			
		   }
	   } while(true);
   }
}
