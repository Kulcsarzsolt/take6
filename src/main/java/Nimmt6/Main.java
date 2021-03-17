package Nimmt6;

import java.util.Set;

// TODO: Remove this - Just for testing
public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        System.out.println(game);

        Player player1 = game.getPlayers().get(0);
        Player player2 = game.getPlayers().get(1);
        Player player3 = game.getPlayers().get(2);
        Player player4 = game.getPlayers().get(3);

        Set<Card> cardsPlayer1 = player1.getCards();
        Set<Card> cardsPlayer2 = player2.getCards();
        Set<Card> cardsPlayer3 = player3.getCards();
        Set<Card> cardsPlayer4 = player4.getCards();

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

        Table table = game.getTable();

        table.addCardToTable(new Card(77, 5), player1);
    }
}
