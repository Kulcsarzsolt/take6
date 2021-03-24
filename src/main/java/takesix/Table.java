package takesix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
    // TODO: Convert this Lists to Map (key, value) => firstRow -> List<Card> firstRow
    private List<Card> firstRow;
    private List<Card> secondRow;
    private List<Card> thirdRow;
    private List<Card> fourthRow;

    Table(Deck deck) {
        List<Card> randomCards = new ArrayList<>(deck.getFourRandomCard());

        firstRow = new ArrayList<>();
        secondRow = new ArrayList<>();
        thirdRow = new ArrayList<>();
        fourthRow = new ArrayList<>();

        firstRow.add(randomCards.get(0));
        secondRow.add(randomCards.get(1));
        thirdRow.add(randomCards.get(2));
        fourthRow.add(randomCards.get(3));
    }

    public void addCardToTable(Card card, Player player) {
        List<Card> lastCardsOnTable = Arrays.asList(getLastCard(firstRow), getLastCard(secondRow), getLastCard(thirdRow), getLastCard(fourthRow));

        int row = 0;
        int difference = 104;

        for (int i = 0; i < lastCardsOnTable.size(); i++) {
            Card currentRowLastCard = lastCardsOnTable.get(i);
            int currentDifference = card.getCardNumber() - currentRowLastCard.getCardNumber();

            if (currentDifference < difference && currentDifference > 0) {
                difference = currentDifference;
                row = i + 1;
            }
        }

        switch (row) {
            case 0:
                selectAndPickARow(card, player);
                break;
            case 1:
                addCardToRow(card, firstRow, player);
                break;
            case 2:
                addCardToRow(card, secondRow, player);
                break;
            case 3:
                addCardToRow(card, thirdRow, player);
                break;
            case 4:
                addCardToRow(card, fourthRow, player);
                break;
            default:
                // valami nincs rendben

        }
    }

    private void selectAndPickARow(Card card, Player player) {
        // TODO: implement message to player

        int selectedRow = 1;

        pickARow(card, firstRow, player);
    }


    private void addCardToRow(Card card, List<Card> row, Player player) {
        if (row.size() < 5) {
            row.add(card);
        } else {
            pickARow(card, row, player);
        }
    }

    private void pickARow(Card card, List<Card> row, Player player) {
        int totalNumberOfCattleHeads = 0;
        for (Card rowCard : row) {
            totalNumberOfCattleHeads += rowCard.getNumberOfCattleHeads();
        }
        row.clear();
        row.add(card);
        player.setNumberOfCattleHeads(player.getNumberOfCattleHeads() + totalNumberOfCattleHeads);
    }


    private Card getLastCard(List<Card> row) {
        return row.get(row.size() - 1);
    }
}
