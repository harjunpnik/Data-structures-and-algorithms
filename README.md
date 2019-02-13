# Data-structures-and-algorithms

Data structures and algorithms course work. 

All the assignments have a ".bat" file for running the program in a command console. The src files can be also put in an IDE and run from there.

## Table of Contents

[Learning points of course](#learning-points-of-course) - TODO

[Assignment 1](#assignment-1) - Basic Bank account application

[Assignment 2](#assignment-2) - Expansion of previous with new SavingsAccount, CheckingAccount and interest calculation.

[Assignment 3](#assignment-3) - Expansion of previous with new CreditAccount.

[Assignment 4](#assignment-4) - Expansion of previous with HashMap instead of Arraylist and automatic account number generation.

[Assignment 5](#assignment-5) - Expansion of previous with FileHandler that saves and loads a .txt file database.


## Learning points of course

TODO

## Assignment 1
Assignment 1 is a bank account application where you are able to:

* Create a new account
* Withdraw money from account
* Deposit money to account
* Show balance of account
* Show all accounts
* Add interest
* Exit

## Assignment 2
Assignment 2 expands on the first assignment. The Account class is now a abstract class that is extended by the SavingsAccount and the CheckingAccount classes. In this application the interest is calculated in a separate thread every 10 seconds. In this version of the application you are able to 

* Create a new account
  * Savings Account 
  * Checking Account
* Withdraw money from account
* Deposit money to account
* Show balance of account
  * Total interest and balance of Savings Accounts
  * Net deposits and balance of Checking Accounts
* Show all accounts
* Exit

## Assignment 3

Assignment 3 expands on the second assignment. A new account has been added and it is the CreditAccount. The credit account has a upper and lower limit of -1000 € to 0 €. The interest is still calculated in a separate thread every 10 seconds.

In this version of the application you are able to 

* Create a new account
  * Savings Account 
  * Checking Account
  * Credit Account
* Withdraw money from account
* Deposit money to account
* Show balance of account
  * Total interest and balance of Savings Accounts
  * Net deposits and balance of Checking Accounts
  * Balance of Credit Accounts
* Show all accounts
* Exit

## Assignment 4

Assignment 4 expands on the third assignment. The accounts are now saved in an HashMap instead of an array. Major parts of the application have been made faster with HashMap. The accounts now automatically get their account number. The interest is still calculated in a separate thread every 10 seconds.

In this version of the application you are able to 

* Create a new account
  * Savings Account 
  * Checking Account
  * Credit Account
* Withdraw money from account
* Deposit money to account
* Show balance of account
  * Total interest and balance of Savings Accounts
  * Net deposits and balance of Checking Accounts
  * Balance of Credit Accounts
* Show all accounts
* Exit

## Assignment 5

Assignment 5 expands on the fourth assignment. This is exactly the same application as the last one, except it creates a .txt file as the database. I have added a "FileHandler.java" That reads the so called "database" and writes over it on exit. Some small tweaks have been made so that the accounts still get account numbers automatically. The interest is still calculated in a separate thread every 10 seconds.

In this version of the application you are able to 

* Create a new account
  * Savings Account 
  * Checking Account
  * Credit Account
* Withdraw money from account
* Deposit money to account
* Show balance of account
  * Total interest and balance of Savings Accounts
  * Net deposits and balance of Checking Accounts
  * Balance of Credit Accounts
* Show all accounts
* Exit