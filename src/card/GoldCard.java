package card;

import account.Account;

public class GoldCard extends Card {

    public GoldCard(Account account, String cardNumber) {
        super(account, cardNumber);
    }

    public GoldCard(Account account, String cardNumber, CardType cardType) {
        super(account, cardNumber, cardType);
    }
}
