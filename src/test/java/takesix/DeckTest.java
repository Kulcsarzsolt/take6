package takesix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeckTest {
    private Deck testDeck;

    @BeforeEach
    public void init() {
        testDeck = new Deck();
    }

    @Test
    @DisplayName("Test card distribution for one player")
    public void testCardDistribution() {
        List<Card> playerCard = testDeck.getTenRandomCard();

        assertEquals(playerCard.size(), 10);
    }

    @Test
    @DisplayName("Test card distribution to table")
    public void testCardDistributionToTable() {
        List<Card> tableCards = testDeck.getFourRandomCard();

        assertEquals(tableCards.size(), 4);
    }

    @Test
    @DisplayName("Test card distribution for 10 players")
    public void testCardDistributionForTenPlayers() {
        // TODO: Remove this - test in Game -> Add 10 players and check if they have different cards
        distributeCardsForTenPlayers();
    }

    @Test
    @DisplayName("Test card distribution for 11 players")
    public void testCardDistributionForElevenPlayers() {
        testDeck.getFourRandomCard();
        distributeCardsForTenPlayers();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            testDeck.getTenRandomCard();
        });

        String expectedMessage = "There are not enough cards found for card distribution";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    @DisplayName("Test when not enough cards to get 4 cards")
    public void testWhenNotEnoughCardsToGet4Cards() {
        distributeCardsForTenPlayers();
        testDeck.getFourRandomCard();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            testDeck.getFourRandomCard();
        });

        String expectedMessage = "There are not enough cards found for card distribution";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    private void distributeCardsForTenPlayers() {
        for (int i = 0; i < 10; i++) {
            testDeck.getTenRandomCard();
        }
    }
}
