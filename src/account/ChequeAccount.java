package account;

import account.Account;

public final class ChequeAccount extends Account {

    public ChequeAccount(){
        super("Cheque Account",210, 10000);
    }

    public ChequeAccount(String accountName, double monthlyCharge, double dailyLimit){
        super(accountName, monthlyCharge, dailyLimit);
    }

    public ChequeAccount(int accountNumber){
        super(accountNumber);
    }

}
