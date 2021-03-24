package takesix;

import java.util.List;

// TODO: Remove this - Just for testing
public class Main {
    public static void main(String[] args) {
        Deck deck;


//
        deck = new Deck();

//        for (Integer randomNumber : deck.generateRandomNumbers(104, 10)) {
//            System.out.print(randomNumber + " ");
//        }
        for (int i = 0; i < 10; i++) {
            List<Card> cards = deck.getTenRandomCard();
            for (Card card : cards) {
                System.out.print(card.getCardNumber() + " ");
            }

            System.out.println();
        }

        for (Card card : deck.getFourRandomCard()) {
            System.out.print(card.getCardNumber() + " ");
        }
        System.out.println();
    }
}
