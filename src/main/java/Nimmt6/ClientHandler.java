package Nimmt6;

import Nimmt6.request.Request;
import Nimmt6.request.ServerRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ClientHandler implements Runnable {
    private Socket playerSocket;
    private BufferedReader in;
    private ObjectOutputStream out;
    private Game game;


    public ClientHandler(Socket socket, Game game) throws IOException {
        this.playerSocket = socket;
        this.game = game;
        in = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));
        out = new ObjectOutputStream(playerSocket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            String playerName = in.readLine();

            System.out.println(playerName + " has joined");

            game.addNewPlayer(playerName, playerSocket);


            Player currentPlayer = getPlayerByName(playerName);
            List<Card> currentPlayerCards = currentPlayer.getCardsList();

            out.writeObject(new ServerRequest(playerName, Request.LOOK_AT_YOUR_CARDS, currentPlayerCards));
        } catch (IOException e) {
            System.err.println("IO exception in client handler");
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: Move to Game.java
    private Player getPlayerByName(String playerName) {
        List<Player> players = game.getPlayers();
        Predicate<Player> byName = player -> player.getName().equals(playerName);

        // TODO: handle when player not found
        return players.stream().filter(byName)
                .collect(Collectors.toList()).get(0);
    }
}
