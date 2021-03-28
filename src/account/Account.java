package account;

import card.Card;
import customer.Customer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public abstract class Account {

    private int accountNumber;
    private String accountName;
    private LocalDateTime createDate;
    private double monthlyCharge;
    private AccountStatus accountStatus;
    private Customer owner;
    private List<Card> cardList;
    private double dailyLimit;
    private long balance;

    public Account(){
        this.createDate = LocalDateTime.now();
        this.accountStatus = AccountStatus.INACTIVE;
    }

    public Account(String accountName, double monthlyCharge, double dailyLimit){
        this.createDate = LocalDateTime.now();
        this.accountStatus = AccountStatus.INACTIVE;
        this.accountName = accountName;
        this.monthlyCharge = monthlyCharge;
        this.dailyLimit = dailyLimit;
    }

    public Account(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public double getMonthlyCharge() {
        return monthlyCharge;
    }

    public void setMonthlyCharge(double monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
