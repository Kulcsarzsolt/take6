package Nimmt6;

import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private List<Player> players;
    private Deck deck;
    private Table table;

    Game() {
        this.deck = new Deck();
        players = new ArrayList<>();
        this.table = new Table(deck);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Table getTable() {
        return table;
    }

    public void addNewPlayer(String playerName, Socket playerSocket) {
        players.add(new Player(playerName, deck.getTenRandomCard(), playerSocket));
    }

    @Override
    public String toString() {
        return "Number of players: " + players.size();
    }
}
