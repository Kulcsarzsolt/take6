package Nimmt6.request;

import Nimmt6.Card;

import java.io.Serializable;
import java.util.List;

public class ServerRequest implements Serializable {
    private Request requestType;
    private String playerName;
    private List<Card> cards;

    // TODO: Table -> Serializable

    public ServerRequest(String playerName, Request requestType, List<Card> cards) {
        this.playerName = playerName;
        this.requestType = requestType;
        this.cards = cards;
    }

    public Request getRequestType() {
        return requestType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Card> getCards() {
        return cards;
    }
}
