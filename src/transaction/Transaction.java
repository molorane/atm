package transaction;

import account.Account;

import java.time.LocalDateTime;

public class Transaction {

    private long uuid;
    private Account account;
    private double amount;
    private TransactionType transactionType;
    private Currency currency;
    private LocalDateTime transactionDate;
    private Platform platform;

    public Transaction(Account account, double amount, TransactionType transactionType, Currency currency, Platform platform) {
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
        this.currency = currency;
        this.platform = platform;
        this.transactionDate = LocalDateTime.now();
    }
}
