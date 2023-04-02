import java.util.Scanner;

public class IntelligentAi {
    static String[][] board;
    static String currentPlayerMark;
    static String playerMark, computerMark;
    static boolean isHumanTurn;

    //Creating the board
    public static void createBoard() {
        board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.toString(i * 3 + j + 1);
            }
        }
    }
    //Drawing the board
    public static void drawBoard() {
        System.out.println("─────────────");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("─────────────");
        }
    }
    //check for win
    public static boolean checkForWin() {
        //Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(Integer.toString(i * 3 + 1))) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals(Integer.toString(i + 1))) {
                return true;
            }
        }
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("1")) {
            return true;
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("3")) {
            return true;
        }
        return false;
    }
    //check for ties
    public static boolean checkForTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(Integer.toString(i * 3 + j + 1))) {
                    return false;
                }
            }
        }
        return true;
    }
    //switch turns
    public static void changePlayer() {
        if (currentPlayerMark.equals(playerMark)) {
            currentPlayerMark = computerMark;
            isHumanTurn = false;
        } else {
            currentPlayerMark = playerMark;
            isHumanTurn = true;
        }
    }
    //get player's move
    public static void getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int position;
        do {
            System.out.print("Enter the position (1-9) of your move: ");
            position = scanner.nextInt();

        } while (position < 1 || position > 9 || !board[(position-1)/3][(position-1)%3].equals(Integer.toString(position)));
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        board[row][col] = currentPlayerMark;
    }
    public static void getComputerMove() {
            int[] bestMove = getBestMove();
            board[bestMove[0]][bestMove[1]] = currentPlayerMark;
    }
    public static int[] getBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[]{-1, -1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(Integer.toString(i * 3 + j + 1))) {
                    board[i][j] = computerMark;
                    int score = minimax(0, false);
                    board[i][j] = Integer.toString(i * 3 + j + 1);
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove;
    }
    //Evaluate the algo's moves
    public static int evaluate() {
        int score = 0;
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                if (board[i][0].equals(computerMark)) {
                    score += 10;
                } else if (board[i][0].equals(playerMark)) {
                    score -= 10;
                }
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])) {
                if (board[0][i].equals(computerMark)) {
                    score += 10;
                } else if (board[0][i].equals(playerMark)) {
                    score -= 10;
                }
            }
        }
        // Check diagonals
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            if (board[0][0].equals(computerMark)) {
                score += 10;
            } else if (board[0][0].equals(playerMark)) {
                score -= 10;
            }
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            if (board[0][2].equals(computerMark)) {
                score += 10;
            } else if (board[0][2].equals(playerMark)) {
                score -= 10;
            }
        }
        return score;
    }
    public static int minimax(int depth, boolean isMaximizingPlayer) {
        if (checkForWin()) {
            return evaluate();
        }
        if (checkForTie()) {
            return 0;
        }
        int bestScore;
        if (isMaximizingPlayer) {
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals(Integer.toString(i * 3 + j + 1))) {
                        board[i][j] = computerMark;
                        int score = minimax(depth + 1, false);
                        board[i][j] = Integer.toString(i * 3 + j + 1);
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals(Integer.toString(i * 3 + j + 1))) {
                        board[i][j] = playerMark;
                        int score = minimax(depth + 1, true);
                        board[i][j] = Integer.toString(i * 3 + j + 1);
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
        }
        return bestScore;
    }



}

