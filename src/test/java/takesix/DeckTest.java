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
        List<Card> player1Cards = testDeck.getTenRandomCard();
        List<Card> player2Cards = testDeck.getTenRandomCard();
        List<Card> player3Cards = testDeck.getTenRandomCard();
        List<Card> player4Cards = testDeck.getTenRandomCard();
        List<Card> player5Cards = testDeck.getTenRandomCard();
        List<Card> player6Cards = testDeck.getTenRandomCard();
        List<Card> player7Cards = testDeck.getTenRandomCard();
        List<Card> player8Cards = testDeck.getTenRandomCard();
        List<Card> player9Cards = testDeck.getTenRandomCard();
        List<Card> player10Cards = testDeck.getTenRandomCard();
        testDeck.getFourRandomCard();

        assertFalse(player1Cards.equals(player2Cards));
        assertFalse(player3Cards.equals(player4Cards));
        assertFalse(player5Cards.equals(player6Cards));
        assertFalse(player7Cards.equals(player8Cards));
        assertFalse(player9Cards.equals(player10Cards));
    }

    @Test
    @DisplayName("Test card distribution for 11 players")
    public void testCardDistributionForElevenPlayers() {
        testDeck.getFourRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();

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
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getTenRandomCard();
        testDeck.getFourRandomCard();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            testDeck.getFourRandomCard();
        });

        String expectedMessage = "There are not enough cards found for card distribution";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }
}
