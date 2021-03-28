package atm;

import transaction.Transaction;

public class ATMTransaction {
    private ATM atm;
    private Transaction transaction;

    public ATMTransaction(ATM atm, Transaction transaction) {
        this.atm = atm;
        this.transaction = transaction;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
