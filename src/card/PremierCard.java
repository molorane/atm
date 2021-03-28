package card;

import account.Account;

public class PremierCard extends Card {

    public PremierCard(Account account, String cardNumber) {
        super(account, cardNumber);
    }

    public PremierCard(Account account, String cardNumber, CardType cardType) {
        super(account, cardNumber, cardType);
    }
}
