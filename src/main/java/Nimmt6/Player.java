package Nimmt6;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Player {
    private String name;
    private Set<Card> cards;
    private Socket socket;
    private int numberOfCattleHeads;

    Player(String name, Set<Card> cards, Socket socket) {
        this.name = name;
        this.cards = cards;
        this.socket = socket;
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

    public Socket getSocket() {
        return socket;
    }

    public int getNumberOfCattleHeads() {
        return numberOfCattleHeads;
    }

    public void setNumberOfCattleHeads(int numberOfCattleHeads) {
        this.numberOfCattleHeads = numberOfCattleHeads;
    }
}
