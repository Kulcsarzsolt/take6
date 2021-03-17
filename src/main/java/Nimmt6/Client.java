package Nimmt6;

import java.io.*;
import java.net.Socket;
import java.util.List;

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
        List<Card> cards = (List<Card>) objectInputStream.readObject();
        GameUtils.printCards(cards);
    }

    private static void readAndSetPlayerName(BufferedReader keyboard, PrintWriter out) throws IOException {
        System.out.println("Enter your name:");
        System.out.print(">> ");
        String playerName = keyboard.readLine();
        out.println(playerName);
    }
}
