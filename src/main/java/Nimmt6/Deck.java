package Nimmt6;

import java.util.*;

public class Deck {
    private List<Card> cards;
    private final int NUMBER_OF_CARDS = 104;
    private final List<Integer> CARDS_WITH_SEVEN_CATTLE_HEADS = Arrays.asList(55);
    private final List<Integer> CARDS_WITH_FIVE_CATTLE_HEADS = Arrays.asList(11, 22, 33, 44, 66, 77, 88, 99);
    private final List<Integer> CARDS_WITH_THREE_CATTLE_HEADS = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
    private final List<Integer> CARDS_WITH_TWO_CATTLE_HEADS = Arrays.asList(5, 15, 25, 35, 45, 65, 75, 85, 95);

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
    }

    public Set<Card> getFourRandomCard() {
        return getCards(4);
    }

    public Set<Card> getTenRandomCard() {
        return getCards(10);
    }

    private Set<Card> getCards(int numberOfCards) {
        int randomCardNumbers[] = generateTenRandomNumbers(cards.size(), numberOfCards);
        Set<Card> result = new HashSet<>();

        for (int randomCardNumber : randomCardNumbers) {
            Card currentCard = cards.get(randomCardNumber - 1);
//            cards.remove(currentCard);
            result.add(currentCard);
        }

        for (int randomCardNumber : randomCardNumbers) {
            cards.removeIf(card -> card.getCardNumber() == randomCardNumber);
        }

        return result;
    }


    private int[] generateTenRandomNumbers(int maxValue, int numberOfNumbers) {
        Random random = new Random();

        int i, j;
        int[] numbers = new int[numberOfNumbers];
        for (i = 0; i < numberOfNumbers; i++) {
            boolean added = false;
            while (!added) {
                int randomNumber = random.nextInt(maxValue + 1);
                boolean unique = true;

                for (j = 0; j < i; j++) {
                    if ((randomNumber == numbers[j]) || (randomNumber == 0)) {
                        unique = false;
                    }
                }

                if (unique) {
                    numbers[i] = randomNumber;
                    added = true;
                }
            }
        }

        return numbers;
    }
}
