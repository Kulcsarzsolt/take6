package Nimmt6;

import java.util.Set;

public class Player {
    Set<Card> cards;
    int numberOfCattleHeads;

    Player(Set<Card> cards) {
        this.cards = cards;
        this.numberOfCattleHeads = 0;
    }
}
