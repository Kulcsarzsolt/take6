package Nimmt6;

import Nimmt6.request.Request;
import Nimmt6.request.ServerRequest;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9090;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        BufferedReader keyboard = new BufferedReader((new BufferedReader(new InputStreamReader(System.in))));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        readAndSetPlayerName(keyboard, out);
        getAndPrintPlayerCards(socket);

        socket.close();
    }

    private static void getAndPrintPlayerCards(Socket socket) throws IOException, ClassNotFoundException {
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ServerRequest serverRequest = (ServerRequest) objectInputStream.readObject();

        if (serverRequest.getRequestType() == Request.LOOK_AT_YOUR_CARDS) {
            GameUtils.printCards(serverRequest.getCards());
        }
    }

    private static void readAndSetPlayerName(BufferedReader keyboard, PrintWriter out) throws IOException {
        System.out.println("Enter your name:");
        System.out.print(">> ");
        String playerName = keyboard.readLine();
        out.println(playerName);
    }
}
