import java.util.*;


public class Main {
    public static void main(String[] args){

        System.out.println("----------Tic-Tac-Toe game---------");
        System.out.println();
        Scanner keyboard = new Scanner(System.in);

        int turnCount = 0;
        String compSym = "";
        String player2Sym = "";
        weakAI weak = new weakAI();
        Master mas = new Master();

        while (true) {

            String[][] board = {{"1", "2", "3"},
                                {"4", "5", "6"},
                                {"7", "8", "9"}};
            turnCount = 9;

            System.out.println("Please select the mode you would like to play:\n 1 - With AI || 2 - Two players");
            int mode = keyboard.nextInt();

            while (mode < 1 || mode > 2) {
                System.out.println("\nThat is not a valid option in the system, please try again");
                System.out.println("Please select the mode you would like to play:\n 1 - With AI || 2 - Two players");
                mode = keyboard.nextInt();
            }

            if (mode == 1) { // with AI mode

                System.out.println("Please enter your name: ");
                String name;

                try {
                    name = keyboard.nextLine();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                name = keyboard.nextLine();
                System.out.println("Please enter your symbol ('X' or 'O')");
                String UserSymbol = keyboard.nextLine();

                while (!UserSymbol.equals("X") && !UserSymbol.equals("O")) {
                    System.out.println("\nThat is not a valid option in the system, please try again");
                    System.out.println("Please enter your symbol ('X' or 'O')");
                    UserSymbol = keyboard.nextLine();
                }

                if (UserSymbol.equals("X")) {
                    compSym = "O";
                } else {
                    compSym = "X";
                }

                System.out.println("Please select the difficulty of the AI:");
                System.out.println("\n1 - Weak || 2 - Intelligent");
                int menu = keyboard.nextInt();

                while (menu < 1 || menu > 2) {
                    System.out.println("\nThat is not a valid option in the system, please try again");
                    System.out.println("\nPlease select the difficulty of the AI:");
                    System.out.println("\n1 - Weak || 2 - Intelligent");
                    menu = keyboard.nextInt();
                }


                System.out.println("Would you like to go first or later ?\n1 - First || 2 - Later");
                int order = keyboard.nextInt();

                while (order < 1 || order > 2) {
                    System.out.println("\nThat is not a valid option in the system, please try again");
                    System.out.println("Would you like to go first or later ?\n1 - First || 2 - Later");
                    order = keyboard.nextInt();
                }

                if (menu == 1) {   // weak AI
                    System.out.println("Game starts !");
                    while (order == 1) {  // user go first
                        mas.boardDisplay(board);
                        System.out.println();
                        System.out.println(name + "'s turn !");
                        while (true) {
                            System.out.println("\nPlease enter the number of the board you would like to insert your symbol:");
                            int location = keyboard.nextInt();

                            while (location < 1 || location > 9) {
                                System.out.println("\nThat is not a valid option in the system, please try again");
                                System.out.println("\nPlease enter the number of the board you would like to insert your symbol:");
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
                            System.out.println("\nPlease enter the number of the board you would like to insert your symbol:");
                            int location = keyboard.nextInt();

                            while (location < 1 || location > 9) {
                                System.out.println("\nThat is not a valid option in the system, please try again");
                                System.out.println("\nPlease enter the number of the board you would like to insert your symbol:");
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

                if (menu == 2) {  // intelligent AI
                    System.out.println("2 works");
                }

            }
            if (mode == 2) { // 2 player mode
                String first = "";
                String later = "";
                String firstSym = "";
                String laterSym = "";

                System.out.println("Please enter the name of the player 1:");
                String player1;
                try {
                    player1 = keyboard.nextLine();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                player1 = keyboard.nextLine();
                System.out.println("Please enter your symbol ('X' or 'O')");
                String player1Sym = keyboard.nextLine();

                while (!player1Sym.equals("X") && !player1Sym.equals("O")) {
                    System.out.println("\nThat is not a valid option in the system, please try again");
                    System.out.println("Please enter your symbol ('X' or 'O')");
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


            }

        }

        System.out.println("Thank you for playing our game!");


    }
}
