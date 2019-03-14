# Data-structures-and-algorithms

Data structures and algorithms course work. 

All the assignments have a ".bat" file for running the program in a command console. The src files can be also put in an IDE and run from there.

## Table of Contents

[Learning points of course](#learning-points-of-course) - Short summary of the course learning points

[Language Analysator](#language-analysator) - Language analysator application.

[Pathfinding](#pathfinding) - A*-algorithm adaptation for train routes in Finland.

[Assignment 1](#assignment-1) - Basic Bank account application.

[Assignment 2](#assignment-2) - Expansion of previous with new SavingsAccount, CheckingAccount and interest calculation.

[Assignment 3](#assignment-3) - Expansion of previous with new CreditAccount.

[Assignment 4](#assignment-4) - Expansion of previous with HashMap instead of Arraylist and automatic account number generation.

[Assignment 5](#assignment-5) - Expansion of previous with FileHandler that saves and loads a .txt file database.


## Learning points of course

The main learning points of this course were to learn more about object-oriented code and how to code algorithms. We also learned about different data-structures and when they should be used.

## Language Analysator

The Language Analysator application is based on naive bayes comparison. At the start of the program it reads all the language "databases" and splits them into three main categories: Single character, First Character and Three Character combination. It then takes the users input and does the same. After that it compares the values of each unique letter and combination and saves the total values. It then represents a table of which language it thinks the user has written in. 

This application works best with longer texts, since short sentences can have a very similar structure and character distribution as many other languages. This application will only suggest on of the following languages: German, Estoninan, English, French, Italian, Norwegian, Finnish and Swedish.

Here are the class diagrams

![class diagram picture](https://github.com/harjunpnik/Data-structures-and-algorithms/blob/master/LanguageAnalysator/ClassDiagram.JPG)

## Pathfinding

The pathfinding application is a adaptation of the A* search algorithm. This application will find the shortest route from a start node to the destination node. In this application the user enters the staring and destination city and the program will show the shortest path, city by city. 

Here below is a picture of the trainroutes.

![train map picture](https://github.com/harjunpnik/Data-structures-and-algorithms/blob/master/Pathfinding/map.JPG)

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