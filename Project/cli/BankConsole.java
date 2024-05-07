package cli;
import bank.Account;
import bank.Bank;
import bank.TransactionHistory;
import bank.Transactions;

import java.util.Scanner;

public class BankConsole {
    private Bank bank;
    private Scanner scanner;

    public BankConsole() {
        bank = new Bank();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Bank Console!");
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create an account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createAccount() {
        System.out.println("Enter account holder's name:");
        String accHolder = scanner.nextLine();
        System.out.println("Enter PIN code:");
        String pinCode = scanner.nextLine();
        Account account = new Account(accHolder, pinCode);
        bank.addAccount(account);
        System.out.println("Account created successfully with account number: " + account.getAccNumber());
    }

    private void deposit() {
        System.out.println("Enter account number:");
        String accNumber = scanner.nextLine();
        Account account = bank.findAccountByAccNumber(accNumber);
        if (account != null) {
            System.out.println("Enter amount to deposit:");
            double amount = scanner.nextDouble();
            new Transactions().deposit(account, amount);
        }
    }

    private void withdraw() {
        System.out.println("Enter account number:");
        String accNumber = scanner.nextLine();
        Account account = bank.findAccountByAccNumber(accNumber);
        if (account != null) {
            System.out.println("Enter amount to withdraw:");
            double amount = scanner.nextDouble();
            new Transactions().withdraw(account, amount);
        }
    }

    private void transfer() {
        System.out.println("Enter account number to transfer from:");
        String accNumberFrom = scanner.nextLine();
        Account accountFrom = bank.findAccountByAccNumber(accNumberFrom);
        if (accountFrom != null) {
            System.out.println("Enter account number to transfer to:");
            String accNumberTo = scanner.nextLine();
            Account accountTo = bank.findAccountByAccNumber(accNumberTo);
            if (accountTo != null) {
                System.out.println("Enter amount to transfer:");
                double amount = scanner.nextDouble();
                new Transactions().transfer(accountFrom, accountTo, amount);
            }
        }
    }

    public static void main(String[] args) {
        BankConsole bankConsole = new BankConsole();
        bankConsole.start();
    }

}
