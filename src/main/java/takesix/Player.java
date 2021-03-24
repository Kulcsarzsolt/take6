package takesix;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards;
    private int numberOfCattleHeads;

    Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
        this.numberOfCattleHeads = 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
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
