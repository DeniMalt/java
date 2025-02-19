package lab5;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;

public class TicTacToeClient {
    private static final String SERVER_ADDRESS = "0.0.0.0";
    private static final int SERVER_PORT = 8000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
                System.out.println(serverResponse);
                if (serverResponse.contains("Ваш ход")) {
                    String userInput = stdIn.readLine();
                    out.println(userInput);
                }
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            logger.info(e.getMessage());
        }
    }
}
