package database;

import bank.Account;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountDatabase {

    public static final String databasePath = "database.txt";

    private ArrayList<Account> accounts;
    private int numberOfAccounts;

    public AccountDatabase(){
        load();
    }
    public void load() {
        try {
            Scanner sc = new Scanner(new FileInputStream(databasePath));
            numberOfAccounts= sc.nextInt();
            accounts = new ArrayList<>(numberOfAccounts);
            sc.nextLine();
            for (int i = 0; i < numberOfAccounts; i++) {
                Account current = new Account(sc.nextLine());
                if (!contains(current))
                    accounts.add(current);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open the database file.");
            System.exit(0);
        } catch (MalformedAccountException e) {
            System.out.println("Something is wrong with the account format");
            System.exit(0);
        }
    }

    public void save() {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(databasePath));
            pw.println(numberOfAccounts);
            for (Account account : accounts)
                pw.println(account.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save into the database file.");
            System.exit(0);
        }
    }

    public ArrayList<Account> getDatabase(){
        return accounts;
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }


    public void updateDatabase(ArrayList<Account> db, int num){
        accounts = new ArrayList<>(db);
        numberOfAccounts = num;
    }
    public void addAccountToDatabase(Account acc){
        numberOfAccounts++;
        accounts.add(acc);
    }
    public void removeAccountFromDatabase(Account acc){
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts.get(i).getAccNumber().equals(acc.getAccNumber())) {
                accounts.remove(i);
                numberOfAccounts--;
                return;
            }
        }
    }



    public Account findAccountByAccNumber(String accNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccNumber().equals(accNumber)) {
                return accounts.get(i);
            }
        }
            return null;
    }

    public void updateAccountInDatabase(Account otherAcc){
        accounts.set(accounts.indexOf(findAccountByAccNumber(otherAcc.getAccNumber())), new Account(otherAcc));

    }
    private boolean contains(Account acc) {
        for (int i = 0; i < accounts.size(); i++)
            if (accounts.get(i).equals(acc))
                return true;
        return false;
    }



}
