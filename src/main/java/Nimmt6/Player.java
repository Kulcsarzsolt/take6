package Nimmt6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Player {
    private String name;
    private Set<Card> cards;
    private int numberOfCattleHeads;

    Player(String name, Set<Card> cards) {
        this.name = name;
        this.cards = cards;
        this.numberOfCattleHeads = 0;
    }

    public String getName() {
        return name;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public List<Card> getCardsList() {
        return new ArrayList<>(cards);
    }

    public int getNumberOfCattleHeads() {
        return numberOfCattleHeads;
    }

    public void setNumberOfCattleHeads(int numberOfCattleHeads) {
        this.numberOfCattleHeads = numberOfCattleHeads;
    }
}
