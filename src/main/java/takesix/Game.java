package takesix;

import java.util.ArrayList;
import java.util.List;

public class Game {
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

    public void addNewPlayer(String playerName) {
        players.add(new Player(playerName, deck.getTenRandomCard()));
    }

    @Override
    public String toString() {
        return "Number of players: " + players.size();
    }
}
