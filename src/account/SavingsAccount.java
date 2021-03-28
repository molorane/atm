package account;

import account.Account;

public final class SavingsAccount extends Account {

    public SavingsAccount(){
        super("Savings Account",300, 5000);
    }

    public SavingsAccount(String accountName, double monthlyCharge, double dailyLimit){
        super(accountName, monthlyCharge, dailyLimit);
    }

    public SavingsAccount(int accountNumber){
        super(accountNumber);
    }

}
