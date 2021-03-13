package Nimmt6;

import java.util.List;

public class Game {
    List<Player> players;
    Deck deck;

    Game(int numberOfPlayers) {
        this.deck = new Deck();
        for(int i=1; i<=numberOfPlayers; i++){
            players.add(new Player(deck.getTenRandomCard()));
        }

    }
}
