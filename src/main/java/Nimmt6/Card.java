package Nimmt6;

import java.io.Serializable;

public class Card implements Serializable {
    private int cardNumber;
    private int numberOfCattleHeads;

    public Card(int cardNumber, int numberOfCattleHeads) {
        this.cardNumber = cardNumber;
        this.numberOfCattleHeads = numberOfCattleHeads;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getNumberOfCattleHeads() {
        return numberOfCattleHeads;
    }
}