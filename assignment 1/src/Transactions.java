import java.util.Scanner;

//********************************************************************
//  Transactions.java       Author: Lewis/Loftus
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
	   
	   boolean isRunning = true;
      
	   System.out.println ("Welcome to Generic Bank!" + "\n" + "What would you like to do?");
	   
	   while(isRunning) {
		   System.out.println ();
		   System.out.println ("1. Create a new account");
		   System.out.println ("2. Withdraw money from account");
		   System.out.println ("3. Deposit money to account");
		   System.out.println ("4. Show balanace of account");
		   System.out.println ("5. Exit");
		   
		   String input = scanner.next();
		   
		   switch(input){
		   
		   		case "1" :
		   			System.out.println ("\n" + "case 1");
		   			break;
		   		case "2" :
		   			System.out.println ("\n" + "case 2");
		   			break;
		   		case "3" :
		   			System.out.println ("\n" + "case 3");
		   			break;
		   		case "4" :
		   			System.out.println ("\n" + "case 4");
		   			break;
		   		case "5" :
		   			System.out.println ("\n" + "Goodbye!");
		   			isRunning = false;
		   			break;
		   		default :
		   		 System.out.println ("Invalid input");
		   			
		   
		   }
	   }
   }
}
