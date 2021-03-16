package Nimmt6;

import java.util.Set;

// TODO: Remove this - Just for testing
public class Main {
    public static void main(String[] args) {
        Game game = new Game(4);

        System.out.println(game);

        Player player1 = game.players.get(0);
        Player player2 = game.players.get(1);
        Player player3 = game.players.get(2);
        Player player4 = game.players.get(3);

        Set<Card> cardsPlayer1 = player1.cards;
        Set<Card> cardsPlayer2 = player2.cards;
        Set<Card> cardsPlayer3 = player3.cards;
        Set<Card> cardsPlayer4 = player4.cards;

        System.out.println();
        for (Card card : cardsPlayer1) {
            System.out.print(card.getCardNumber() + " ");
        }
        System.out.println();
        for (Card card : cardsPlayer2) {
            System.out.print(card.getCardNumber() + " ");
        }
        System.out.println();
        for (Card card : cardsPlayer3) {
            System.out.print(card.getCardNumber() + " ");
        }

        System.out.println();
        for (Card card : cardsPlayer4) {
            System.out.print(card.getCardNumber() + " ");
        }

        Table table = game.table;

        table.addCardToTable(new Card(77, 5), player1);
    }
}
