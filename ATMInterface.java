import java.util.Scanner;

// Class representing the bank account
class BankAccount {
    private double balance; // stores current account balance

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Rs" + amount + " deposited successfully.");
        } 
        else 
        {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Rs" + amount + " withdrawn successfully.");
        } 
        else if (amount > balance) 
        {
            System.out.println("Insufficient balance.");
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check account balance
    public void checkBalance() {
        System.out.printf("Current balance: Rs%.2f\n", balance);
    }
}

// Class representing the ATM interface and operations
public class ATMInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(10000); // starting with ₹10,000

        System.out.println("Welcome to the ATM Interface!");

        boolean continueBanking = true;

        // ATM menu loop
        while (continueBanking) {
            System.out.println("\nChoose an option:");
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Check Balance");
            System.out.println("4) Exit");
            System.out.print("Enter choice (1-4): ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    // Deposit operation
                    System.out.print("Enter amount to deposit: Rs");
                    double depositAmount = input.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;

                case 2:
                    // Withdraw operation
                    System.out.print("Enter amount to withdraw: Rs");
                    double withdrawAmount = input.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    // Check balance
                    userAccount.checkBalance();
                    break;

                case 4:
                    // Exit operation
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    continueBanking = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        input.close();
    }
}