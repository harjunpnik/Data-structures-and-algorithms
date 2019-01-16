//********************************************************************
//  Account.java    Author: Lewis/Loftus
//					Modified by: Niklas
//
//  Represents a bank account with basic services such as deposit
//  and withdraw.
//********************************************************************

import java.text.NumberFormat;

public class Account
{
   private double rate;  // interest rate of 3.5%

   private long acctNumber;
   private double balance;
   private String name;

   //-----------------------------------------------------------------
   //  Sets up the account by defining its owner, account number,
   //  and initial balance.
   //-----------------------------------------------------------------
   public Account (String name, long acctNumber, double balance, double rate)
   {
      this.name = name;
      this.acctNumber = acctNumber;
      this.balance = balance;
      this.rate = rate;
   }

   //-----------------------------------------------------------------
   //  Deposits the specified amount into the account. Returns the
   //  new balance.
   //-----------------------------------------------------------------
   public double deposit (double amount)
   {
      balance = balance + amount;

      return balance;
   }

   //-----------------------------------------------------------------
   //  Withdraws the specified amount from the account and applies
   //  the fee. The fee is 0,5% of the amount withdrawn.
   //Returns the new balance.
   //-----------------------------------------------------------------
   public double withdraw (double amount)
   {
	  double fee = amount * 0.0005;
      balance = balance - amount - fee;

      return balance;
   }

   //-----------------------------------------------------------------
   //  Adds interest to the account and returns the new balance.
   //-----------------------------------------------------------------
   public double addInterest ()
   {
      balance += (balance * rate);
      return balance;
   }

   //-----------------------------------------------------------------
   //  Returns the current balance of the account.
   //-----------------------------------------------------------------
   public double getBalance ()
   {
      return balance;
   }
   
   //-----------------------------------------------------------------
   //  Returns the account number
   //-----------------------------------------------------------------
   public long getAcctNumber ()
   {
      return acctNumber;
   }
   
   //-----------------------------------------------------------------
   //  Returns the account name
   //-----------------------------------------------------------------
   public String getName ()
   {
      return name;
   }


   //-----------------------------------------------------------------
   //  Returns a one-line description of the account as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      return (acctNumber + "\t" + name + "\t" + fmt.format(balance) + "\t" + rate);
   }
}
