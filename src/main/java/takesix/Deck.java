package takesix;

import java.util.*;
import java.util.stream.Collectors;

public class Deck {
    private List<Card> cards;
    private static final int NUMBER_OF_CARDS = 104;
    private static final List<Integer> CARDS_WITH_SEVEN_CATTLE_HEADS = Arrays.asList(55);
    private static final List<Integer> CARDS_WITH_FIVE_CATTLE_HEADS = Arrays.asList(11, 22, 33, 44, 66, 77, 88, 99);
    private static final List<Integer> CARDS_WITH_THREE_CATTLE_HEADS = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
    private static final List<Integer> CARDS_WITH_TWO_CATTLE_HEADS = Arrays.asList(5, 15, 25, 35, 45, 65, 75, 85, 95);

    Deck() {
        initCards();
    }

    private void initCards() {
        this.cards = new LinkedList<>();

        for (int i = 1; i <= NUMBER_OF_CARDS; i++) {
            int numberOfCattleHeads;

            if (CARDS_WITH_SEVEN_CATTLE_HEADS.contains(i)) {
                numberOfCattleHeads = 7;
            } else if (CARDS_WITH_FIVE_CATTLE_HEADS.contains(i)) {
                numberOfCattleHeads = 5;
            } else if (CARDS_WITH_THREE_CATTLE_HEADS.contains(i)) {
                numberOfCattleHeads = 3;
            } else if (CARDS_WITH_TWO_CATTLE_HEADS.contains(i)) {
                numberOfCattleHeads = 2;
            } else {
                numberOfCattleHeads = 1;
            }

            Card card = new Card(i, numberOfCattleHeads);
            cards.add(card);
        }

        Collections.shuffle(cards);
    }

    public List<Card> getFourRandomCard() {
        return getCards(4);
    }

    public List<Card> getTenRandomCard() {
        return getCards(10);
    }

    private List<Card> getCards(int numberOfCards) {
        List<Card> result = cards.stream().limit(numberOfCards).collect(Collectors.toList());

        cards.subList(0, numberOfCards).clear();

        return result;
    }
}
