package Nimmt6;

import java.util.Set;

public class Player {
    private String name;
    Set<Card> cards;
    private int numberOfCattleHeads;

    Player(String name, Set<Card> cards) {
        this.name = name;
        this.cards = cards;
        this.numberOfCattleHeads = 0;
    }

    public int getNumberOfCattleHeads() {
        return numberOfCattleHeads;
    }

    public void setNumberOfCattleHeads(int numberOfCattleHeads) {
        this.numberOfCattleHeads = numberOfCattleHeads;
    }
}
