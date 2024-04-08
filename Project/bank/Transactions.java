package bank;
/**
 * Represents transactions that can be performed on bank accounts.
 */
public class Transactions {
    /**
     * Deposits the specified amount into the given account.
     *
     * @param account The account to deposit funds into.
     * @param deposit The amount to deposit.
     */
    public void deposit(Account account, double deposit){
        double newBalance = account.getBalance() + deposit;
        account.setBalance(newBalance);
    }
    /**
     * Withdraws the specified amount from the given account.
     *
     * @param account The account to withdraw funds from.
     * @param withdraw The amount to withdraw.
     * @return True if the withdrawal was successful, false otherwise.
     */
    public boolean withdraw(Account account, double withdraw){
        if(account.getBalance() >= withdraw){
            double newBalance = account.getBalance() - withdraw;
            account.setBalance(newBalance);
            return true;
        } else{
            System.out.println("Invalid amount");
            return false;
        }
    }
    /**
     * Transfers funds from one account to another.
     *
     * @param account1 The account to transfer funds from.
     * @param account2 The account to transfer funds to.
     * @param amount The amount to transfer.
     */
    public void transfer(Account account1, Account account2, double amount){
        if(withdraw(account1, amount)){
            deposit(account2, amount);
        } else{
            System.out.println("Invalid amount");
        }
    }
}
