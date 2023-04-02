import java.util.*;


public class Main {
    public static void main(String[] args){

        System.out.println("----------Tic-Tac-Toe game---------");
        System.out.println();

        Scanner keyboard = new Scanner(System.in);

        int turnCount = 0;
        weakAI weak = new weakAI();
        Master mas = new Master();
        IntelligentAi smartAi = new IntelligentAi();

        while (true) {
            String[][] board = {{"1", "2", "3"},
                                {"4", "5", "6"},
                                {"7", "8", "9"}};
            turnCount = 9;
            System.out.println("Select your mode(1 for with AI, 2 is with another player,3 to exit the game)");
            int mode = keyboard.nextInt();
            while (mode < 1 || mode > 3) {
                System.out.println("Invalid option, please select the mode you would like to play:\n 1 - With AI || 2 - Two players");
                mode = keyboard.nextInt();
            }
            if (mode == 3){
                System.out.println("Thank you for playing our game!");
                break;
            }
            if (mode == 1) { // with AI mode
                String compSym = "";

                System.out.println("Please enter your name: ");
                String name;

                try {
                    name = keyboard.nextLine();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                name = keyboard.nextLine();
                System.out.println("Please enter your symbol ('X' or 'O')");
                String UserSymbol = keyboard.nextLine().toUpperCase();

                while (!UserSymbol.equals("X") && !UserSymbol.equals("O")) {
                    System.out.println("\nInvalid option,Please enter your symbol ('X' or 'O')");
                    UserSymbol = keyboard.nextLine();
                }

                if (UserSymbol.equals("X")) {
                    compSym = "O";
                } else {
                    compSym = "X";
                }

                System.out.println("Select your AI(1 for dumb AI, 2 for smart AI)");
                int menu = keyboard.nextInt();
                while (menu < 1 || menu > 2) {
                    System.out.println("\nInvalid option, select 1 for dumb AI, 2 for smart AI");
                    menu = keyboard.nextInt();
                }

                System.out.println("Would you like to go first? (1 for yes, 2 for no)");
                int order = keyboard.nextInt();
                while (order < 1 || order > 2) {
                    System.out.println("Invalid option, would you like to go first? (1 for yes, 2 for no)");
                    order = keyboard.nextInt();
                }

                if (menu == 1) {   // weak AI
                    System.out.println("Game starts !");
                    while (order == 1) {  // user go first
                        mas.boardDisplay(board);
                        System.out.println();
                        System.out.println(name + "'s turn !");
                        while (true) {
                            System.out.println("\nChoose a position to play:");
                            int location = keyboard.nextInt();

                            while (location < 1 || location > 9) {
                                System.out.println("\nInvalid option, please enter the number of the board you would like to insert your symbol:");
                                location = keyboard.nextInt();
                            }
                            if (weak.userInsert(board, location, UserSymbol)) {
                                break;
                            }
                        }
                        turnCount--;
                        if (mas.stateIdentifier(board, UserSymbol, compSym, name, "AI")) {
                            break;
                        }
                        if (turnCount == 0) {
                            mas.boardDisplay(board);
                            System.out.println("\nEnd of the game\nIts a draw !");
                            break;
                        }
                        System.out.println("\nAI's turn !\n");
                        weak.compInsert(board, compSym);
                        turnCount--;
                        if (mas.stateIdentifier(board, UserSymbol, compSym, name, "AI")) {
                            break;
                        }

                    }

                    while (order == 2) {  // user go later
                        System.out.println();
                        mas.boardDisplay(board);
                        System.out.println("\nAI's turn !\n");
                        weak.compInsert(board, compSym);
                        turnCount--;
                        if (mas.stateIdentifier(board, UserSymbol, compSym, name, "AI")) {
                            break;
                        }
                        if (turnCount == 0) {
                            mas.boardDisplay(board);
                            System.out.println("\nEnd of the game\nIts a draw !");
                            break;
                        }
                        mas.boardDisplay(board);
                        System.out.println();
                        System.out.println(name + "'s turn !");
                        while (true) {
                            System.out.println("\nChoose a position to play:");
                            int location = keyboard.nextInt();

                            while (location < 1 || location > 9) {
                                System.out.println("\nInvalid option, please enter the number of the board you would like to insert your symbol:");
                                location = keyboard.nextInt();
                            }
                            if (weak.userInsert(board, location, UserSymbol)) {
                                break;
                            }
                        }
                        turnCount--;
                        if (mas.stateIdentifier(board, UserSymbol, compSym, name, "AI")) {
                            break;
                        }
                    }

                    System.out.println("\nPlay again?\nY/y for Yes || N/n for NO");
                    String again;

                    try {
                        again = keyboard.nextLine();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    again = keyboard.nextLine();

                    if (again.equals("Y") || again.equals("y")) {
                        continue;
                    } else if (again.equals("N") || again.equals("n")) {
                        break;
                    }

                }

                if (menu == 2) {  // intelligent AI
                    while (order == 1){
                        smartAi.playerMark = UserSymbol;
                        smartAi.computerMark = compSym;
                        IntelligentAi.createBoard();
                        IntelligentAi.drawBoard();
                        smartAi.currentPlayerMark = UserSymbol;
                        IntelligentAi.isHumanTurn = true;
                        while (!IntelligentAi.checkForWin() && !IntelligentAi.checkForTie()) {
                            if (IntelligentAi.isHumanTurn) {
                                IntelligentAi.getPlayerMove();
                            } else {
                                System.out.println("AI's move");
                                IntelligentAi.getComputerMove();
                            }
                            IntelligentAi.drawBoard();
                            IntelligentAi.changePlayer();
                        }
                        if (IntelligentAi.checkForWin()) {
                            if (IntelligentAi.isHumanTurn) {
                                System.out.println("The computer won. Better luck next time," + name + ".");
                            } else {
                                System.out.println("Congratulation, " + name + " has won!.");
                            }
                        } else {
                            System.out.println("It's a tie.");
                        }
                        System.out.println("\nPlay again?\nY/y for Yes || N/n for NO");
                        String again;

                        try {
                            again = keyboard.nextLine();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        again = keyboard.nextLine();

                        if (again.equals("Y") || again.equals("y")) {
                            continue;
                        } else if (again.equals("N") || again.equals("n")) {
                            break;
                        }
                    }
                    while (order == 2){
                        smartAi.playerMark = compSym;
                        smartAi.computerMark = UserSymbol;
                        IntelligentAi.createBoard();
                        smartAi.currentPlayerMark = compSym;
                        IntelligentAi.isHumanTurn = true;
                        while (!IntelligentAi.checkForWin() && !IntelligentAi.checkForTie()) {
                            if (IntelligentAi.isHumanTurn == false) {
                                IntelligentAi.getPlayerMove();
                            } else {
                                System.out.println("AI's move");
                                IntelligentAi.getComputerMove();
                            }
                            IntelligentAi.drawBoard();
                            IntelligentAi.changePlayer();
                        }
                        if (IntelligentAi.checkForWin()) {
                            if (IntelligentAi.isHumanTurn) {
                                System.out.println("Congratulation, " + name + " has won!.");
                            } else {
                                System.out.println("The computer won. Better luck next time," + name + ".");
                            }
                        } else {
                            System.out.println("It's a tie.");
                        }
                        System.out.println("\nWould you like to start again ?\nY/y for Yes || N/n for NO");
                        String again;
                        try {
                            again = keyboard.nextLine();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        again = keyboard.nextLine();
                        if (again.equals("Y") || again.equals("y")) {
                            continue;
                        } else if (again.equals("N") || again.equals("n")) {
                            break;
                        }
                    }


                }

            }
            if (mode == 2) { // 2 player mode

                String first = "";
                String later = "";
                String firstSym = "";
                String laterSym = "";
                String player2Sym = "";

                System.out.println("Please enter the name of the player 1:");
                String player1;
                try {
                    player1 = keyboard.nextLine();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                player1 = keyboard.nextLine();
                System.out.println("Please enter your symbol ('X' or 'O')");
                String player1Sym = keyboard.nextLine().toUpperCase();

                while (!player1Sym.equals("X") && !player1Sym.equals("O")) {
                    System.out.println("Invalid option, please enter your symbol ('X' or 'O')");
                    player1Sym = keyboard.nextLine();
                }

                if (player1Sym.equals("X")) {
                    player2Sym = "O";
                } else {
                    player2Sym = "X";
                }

                System.out.println("\nPlease enter the name of the player 2:");
                String player2 = keyboard.nextLine();
                System.out.println();
                System.out.println(player1 + "'s symbol is '" + player1Sym + "'" );
                System.out.println(player2 + "'s symbol is '" + player2Sym + "'" );
                System.out.println("\nWhich player would like to go first ?");
                System.out.println("1 - " + player1 + " || 2 - " + player2);
                int turn = keyboard.nextInt();
                while (turn < 1 || turn > 2){
                    System.out.println("\nThat is not the valid option, please try again");
                    System.out.println("\n Which player would like to go first ?");
                    System.out.println("1 - " + player1 + " || 2 - " + player2);
                    turn = keyboard.nextInt();
                }

                if (turn == 1){
                    first = player1;
                    later = player2;
                    firstSym = player1Sym;
                    laterSym = player2Sym;
                }
                if (turn == 2){
                    first = player2;
                    later = player1;
                    firstSym = player2Sym;
                    laterSym = player1Sym;
                }

                while (true){
                    mas.boardDisplay(board);
                    System.out.println();
                    System.out.println(first + "'s turn !");
                    while (true) {
                        System.out.println("\nPlease enter the number of the board you would like to insert your symbol:");
                        int location = keyboard.nextInt();

                        while (location < 1 || location > 9) {
                            System.out.println("\nThat is not a valid option in the system, please try again");
                            System.out.println("\nPlease enter the number of the board you would like to insert your symbol:");
                            location = keyboard.nextInt();
                        }
                        if (weak.userInsert(board, location, firstSym)) {
                            break;
                        }
                    }
                    turnCount--;
                    if (mas.stateIdentifier(board, player1Sym, player2Sym, player1, player2)) {
                        break;
                    }
                    if (turnCount == 0) {
                        mas.boardDisplay(board);
                        System.out.println("\nEnd of the game\nIts a draw !");
                        break;
                    }
                    mas.boardDisplay(board);
                    System.out.println();
                    System.out.println(later + "'s turn !");
                    while (true) {
                        System.out.println("\nPlease enter the number of the board you would like to insert your symbol:");
                        int location = keyboard.nextInt();

                        while (location < 1 || location > 9) {
                            System.out.println("\nThat is not a valid option in the system, please try again");
                            System.out.println("\nPlease enter the number of the board you would like to insert your symbol:");
                            location = keyboard.nextInt();
                        }
                        if (weak.userInsert(board, location, laterSym)) {
                            break;
                        }
                    }
                    turnCount--;
                    if (mas.stateIdentifier(board, player1Sym, player2Sym, player1, player2)) {
                        break;
                    }

                }

                System.out.println("\nWould you like to start again ?\nY/y for Yes || N/n for NO");
                String again;

                try {
                    again = keyboard.nextLine();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                again = keyboard.nextLine();

                if (again.equals("Y") || again.equals("y")) {
                    continue;
                } else if (again.equals("N") || again.equals("n")) {
                    break;
                }

            }
        }
    }
}
