package Nimmt6;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players;
    Deck deck;
    Table table;

    Game(int numberOfPlayers) {
        this.deck = new Deck();
        players = new ArrayList<>();
        for(int i=1; i<=numberOfPlayers; i++){
            players.add(new Player("Player" + i, deck.getTenRandomCard()));
        }
        this.table = new Table(deck);
    }

    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                ", deck=" + deck +
                ", table=" + table +
                '}';
    }
}
