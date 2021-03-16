package Nimmt6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket playerSocket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) throws IOException {
        this.playerSocket = socket;
        in = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));
        out = new PrintWriter(playerSocket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String request = in.readLine();

                if (request.equals("Q")) {
                    break;
                }

                System.out.println(request + " has joined");
            }
        } catch (IOException e) {
            System.err.println("IO exception in client handler");
        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
