package Nimmt6;

public class Card {
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