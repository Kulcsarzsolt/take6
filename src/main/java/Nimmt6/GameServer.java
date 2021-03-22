package Nimmt6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {
    private static final int PORT = 9090;

    private static ArrayList<ClientHandler> playerSockets = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);
        Game game = new Game();

        System.out.println("[SERVER] Waiting for players ...");
        while (game.getPlayers().size() != 4) {
            Socket playerSocket = listener.accept();
            ClientHandler clientThread = new ClientHandler(playerSocket, game);
            playerSockets.add(clientThread);
            pool.execute(clientThread);
        }
    }

    //send to all(message/data)
    //send to player(request with data) -> type data
}
