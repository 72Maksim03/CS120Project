package bank;
/**
 * Represents a bank that manages accounts.
 */
public class Bank {
    private Account[] accounts;
    private static final int MAX_ACCOUNTS = 500;
    private int num_accounts;
    /**
     * Constructs a new Bank object.
     */
    public Bank(){
        accounts = new Account[MAX_ACCOUNTS];
        num_accounts = 0;
    }
    /**
     * Retrieves the array of accounts in the bank.
     *
     * @return The array of accounts.
     */
    public Account[] getAccounts(){
        return this.accounts;
    }
    /**
     * Finds and returns the account with the specified account number.
     *
     * @param accNumber The account number to search for.
     * @return The account with the specified account number, or null if not found.
     */
    public Account findAccountByAccNumber(String accNumber){
        for(int i = 0; i < num_accounts; i++){
            if(accounts[i].getAccNumber().equals(accNumber)){
                return accounts[i];
            }
            if(accounts[i] == null){
                break;
            }
        }
        System.out.println("No such account");
        return null;
    }
    /**
     * Finds and returns the account of the specified account holder.
     *
     * @param accHolder The name of the account holder.
     * @return The account of the specified account holder, or null if not found.
     */
    public Account findAccountByAccHolder(String accHolder){
        for(int i = 0; i < num_accounts; i++){
            if(accounts[i].getAccHolder().equals(accHolder)){
                return accounts[i];
            }
            if(accounts[i] == null){
                break;
            }
        }
        System.out.println("No such account");
        return null;
    }
    /**
     * Adds an account to the bank.
     *
     * @param account The account to add.
     */
    public void addAccount(Account account){
        if(num_accounts < MAX_ACCOUNTS){
            accounts[num_accounts] = account;
            num_accounts++;
        } else{
            System.out.println("Cannot add more accounts. Bank is full.");
        }
    }
    /**
     * Removes an account from the bank if the pin code provided matches the account's pin code.
     *
     * @param account The account to be removed.
     * @param pinCode The pin code of the account.
     */
    public void removeAccount(Account account, String pinCode){
        if (account == null) {
            System.out.println("Invalid account: account is null.");
            return;
        }
        for(int i = 0; i < num_accounts; i++){
            if(accounts[i].getAccHolder().equals(account)){
                if(accounts[i].validatePin(pinCode)){
                    accounts[i] = accounts[num_accounts];
                    accounts[num_accounts] = null;
                    num_accounts--;
                } else{
                    break;
                }
            }
            if(accounts[i] == null){
                break;
            }
        }
        System.out.println("No such account");
    }
}