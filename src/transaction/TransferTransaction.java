package transaction;

import account.Account;

public class TransferTransaction extends Transaction{

    private Account from;
    private Account to;
    private double charges;

    public TransferTransaction(Account account, double amount, TransactionType transactionType, Currency currency, Platform platform) {
        super(account, amount, transactionType, currency, platform);
    }
}
