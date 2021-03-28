package card;

import account.Account;

public class BlackCard extends Card{

    public BlackCard(Account account, String cardNumber) {
        super(account, cardNumber);
    }

    public BlackCard(Account account, String cardNumber, CardType cardType) {
        super(account, cardNumber, cardType);
    }
}
