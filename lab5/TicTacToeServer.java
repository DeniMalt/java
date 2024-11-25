import java.io.*;
import java.net.*;
import java.util.logging.Logger;


public class TicTacToeServer {
    private static final char[][] board = new char[3][3];
    private static char currentPlayer;

    public static void main(String[] args) {
        initializeBoard();
        currentPlayer = 'X';

        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Сервер запущен. Ожидание игроков...");
            Socket player1 = serverSocket.accept();
            System.out.println("Игрок 1 подключен!");
            Socket player2 = serverSocket.accept();
            System.out.println("Игрок 2 подключен!");

            PrintWriter out1 = new PrintWriter(player1.getOutputStream(), true);
            PrintWriter out2 = new PrintWriter(player2.getOutputStream(), true);
            BufferedReader in1 = new BufferedReader(new InputStreamReader(player1.getInputStream()));
            BufferedReader in2 = new BufferedReader(new InputStreamReader(player2.getInputStream()));

            PrintWriter currentOut = out1;

            while (true) {
                currentOut.println(getBoard());
                currentOut.println("Ваш ход (формат: строка столбец):");

                String move = (currentOut == out1 ? in1 : in2).readLine();
                if (makeMove(move)) {
                    if (checkWin()) {
                        currentOut.println("Поздравляем, вы выиграли!");
                        break;
                    } else if (isBoardFull()) {
                        out1.println("Игра окончена, ничья!");
                        out2.println("Игра окончена, ничья!");
                        break;
                    }
                    currentOut = (currentOut == out1) ? out2 : out1;
                } else {
                    currentOut.println("Неверный ход, попробуйте снова.");
                }
            }

        } catch (IOException e) {
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            logger.info(e.getMessage());
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static String getBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append('|');
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]).append('|');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private static boolean makeMove(String move) {
        String[] parts = move.split(" ");
        if (parts.length != 2) return false;

        try {
            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;

            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
                return false;
            }

            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') ||
                    (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')) {
                return true;
            }
        }
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ');
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
}
