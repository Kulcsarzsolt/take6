package Nimmt6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameUtils {
    public static void printCards(List<Card> cards) {
        System.out.println("Your cards: ");
        for (Card card : cards) {
            System.out.print(card.getCardNumber() + " ");
        }
    }

    public static void printCards(Set<Card> cards) {
        printCards(new ArrayList<>(cards));
    }
}
