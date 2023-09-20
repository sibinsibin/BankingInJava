package MyThirdProject;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Bank {
    private static Map<Integer, Double> accounts;   //Hashmap method including accountNumber and initial balance and amount
    private static Map<Integer, String> userNames;  //hashmap method including accountNumber and username.

    public Bank() {
        accounts = new HashMap<>();
        userNames = new HashMap<>();
    }

    public void createAccount(Integer accountNumber, String userName, double initialBalance) {

        accounts.put(accountNumber, initialBalance);
        userNames.put(accountNumber, userName);
        System.out.println("=====================================");
        System.out.println("\n\t\t!Account created Successfully.");
        System.out.println("\n\tWelcome " + userName + "!\n");
        System.out.println("Your Account number is: " + accountNumber);
        System.out.println("Initial Balance₹: " + initialBalance);


    }

    public void deposit(Integer accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {

            double currentBalance = accounts.get(accountNumber);
            accounts.put(accountNumber, currentBalance + amount);
            String userName = userNames.get(accountNumber);
            System.out.println("========================================");
            System.out.println("\nAccount Holder: " + userName);
            System.out.println("\n₹" + amount + " successfully deposited in your account :" + accountNumber);
            currentBalance = accounts.get(accountNumber);
            System.out.println("your Account balance amount is: ₹" + currentBalance);
        } else {
            System.out.println("\nData Error!!! Account does not exist with account number " + accountNumber);
        }
    }

    public void withdraw(Integer accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                accounts.put(accountNumber, currentBalance - amount);
                String userName = userNames.get(accountNumber);
                System.out.println("===========================================");
                System.out.println("\nAccount Holder: " + userName);
                System.out.println("\nWithdrawal of " + amount + " successful for account:" + accountNumber);
                currentBalance = accounts.get(accountNumber);
                System.out.println("your Account balance amount is ₹" + currentBalance);
            } else {
                System.out.println("\nWithdraw cancel!! Insufficient balance for Withdrawing!!");
                currentBalance = accounts.get(accountNumber);
                System.out.println("your Account balance amount is: ₹" + currentBalance);
            }
        } else {
            System.out.println("\nData error!!! Account not find");
        }
    }

    public void checkBalance(Integer accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            String userName = userNames.get(accountNumber);
            System.out.println("===========================================");
            System.out.println("\nAccount Holder: " + userName);
            System.out.println("\nAccount number: " + accountNumber + ", Balance: ₹" + currentBalance);

        } else {
            System.out.println("\nAccount does not exist with account :" + accountNumber);
        }

    }

    public Map<Integer, Double> getAccounts() {
        return accounts;

    }
}

public class BankingSystem {
    public BankingSystem(Bank bank) {
    }

    public static void main(String[] args) {
        try {
            Bank bank = new Bank();

            Map<Integer, Double> accounts = bank.getAccounts();

            int accountNumber = 0;
            boolean validAccount = false;
            Scanner scanner = new Scanner(System.in);

            boolean exit = false;
            while (!exit) {
                System.out.println("------------------------------------------------------------------------\n");
                System.out.println("\t\t\t\t======== BANKING SYSTEM ========\n");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Check Balance");
                System.out.println("5. Exit\n");
                System.out.print("Enter your choice? : ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("___________________________________________\n");
                        System.out.println("\n\t\t\tCREATING ACCOUNT");
                        System.out.println("\t\t\t================\n");
                        System.out.print("Enter User Name: ");      //Asking personal information
                        String name = scanner.nextLine();

                        System.out.print("Enter your Father name: ");
                        String father = scanner.nextLine();

                        System.out.print("Enter your Account Type: ");
                        String type = scanner.nextLine();

                        System.out.println("Enter Your Date of Birth");
                        System.out.print("Enter Birth Date: ");

                        int age = scanner.nextInt();
                        System.out.print("Enter Birth Month: ");
                        int month = scanner.nextInt();

                        System.out.print("Enter Birth Year: ");
                        int year = scanner.nextInt();

                        Random random = new Random();
                        accountNumber = 100000000 + random.nextInt(900000000); //creating a nine digit random number.

                        System.out.print("Enter initial balance₹: ");
                        double initialBalance = scanner.nextDouble();
                        scanner.nextLine();
                        bank.createAccount(accountNumber, name, initialBalance);
                        break;


                    case 2:
                        System.out.print("___________________________________________\n");
                        System.out.println("\n\t\t\tDEPOSITING AMOUNT");
                        System.out.println("\t\t\t=================\n");
                        validAccount = false; // Flag to track if the account is valid
                        while (!validAccount) {
                            System.out.print("Enter account number: ");        //Asking the user to enter the correct account number
                            accountNumber = scanner.nextInt();                           //if the user enters an account which is not

                            if (accounts.containsKey(accountNumber)) {                        //created yet it ask repeatedly until a correct account number is given
                                validAccount = true;// Set the flag to true if the account exists
                            } else if (accountNumber == 0) {
                                System.out.println("\t\nCode found to go back");
                                break;
                            } else {
                                System.out.println("\nAccount not found! Invalid Account Number? Enter 0 if you forgot Ac No: \n");

                            }
                        }
                        if (accountNumber != 0) {

                            System.out.print("Enter deposit amount₹: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();

                            // Call the deposit method
                            bank.deposit(accountNumber, amount);
                        }
                        break;


                    case 3:
                        System.out.print("___________________________________________\n");
                        System.out.println("\n\t\t\tWITHDRAW MONEY");
                        System.out.println("\t\t\t==============\n");

                        validAccount = false;                    //same method as mentioned above
                        while (!validAccount) {
                            System.out.print("Enter account number: ");
                            accountNumber = scanner.nextInt();
                            if (accounts.containsKey(accountNumber)) {
                                validAccount = true;
                            } else if (accountNumber == 0) {
                                System.out.println("\t\nCode found to go back");
                                break;
                            } else {
                                System.out.println("\nAccount not found! Invalid Account Number? \n");
                            }
                        }
                        if (accountNumber != 0) {
                            System.out.print("Enter withdrawal amount₹: ");
                            double withdrawalAmount = scanner.nextDouble();
                            scanner.nextLine();
                            bank.withdraw(accountNumber, withdrawalAmount);
                        }
                        break;


                    case 4:
                        System.out.print("___________________________________________\n");
                        System.out.println("\n\t\t\tCHECKING BALANCE");
                        System.out.println("\t\t\t================\n");

                        validAccount = false;
                        while (!validAccount) {                           //Same method as mentioned above
                            System.out.print("Enter account number: ");
                            accountNumber = scanner.nextInt();
                            if (accounts.containsKey(accountNumber)) {
                                validAccount = true;
                            } else if (accountNumber == 0) {
                                System.out.println("\t\nCode found to go back");
                                break;

                            } else {
                                System.out.println("\nAccount not found! Invalid Account Number? \n");
                            }
                        }
                        if (accountNumber != 0) {
                            bank.checkBalance(accountNumber);
                        }
                        break;


                    case 5:
                        exit = true;             //passes the flag value to true which will stop the loop and prints the final statement

                        System.out.println("\n\t\tThank you for using my banking system!!Come again.");
                        break;
                    default:
                        System.out.println(" __________________________________");
                        System.out.println("!Invalid choice. Please try again. !");
                        System.out.println(" ----------------------------------");
                }

                System.out.println();
            }

            scanner.close();
        } catch (
                Exception e) {           //If any miss-value is gotten form the user the catch exception will print the statement
            System.out.println("\n!!! Invalid input ");

        }
    }
}




