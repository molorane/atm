package card;

import account.Account;

public abstract class Card {

    private Account account;
    private String cardNumber;
    private CardType cardType;

    public Card(Account account, String cardNumber){
        this.account = account;
        this.cardNumber = cardNumber;
        this.cardType = CardType.DEBIT;
    }

    public Card(Account account, String cardNumber, CardType cardType) {
        this.account = account;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
