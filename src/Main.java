import java.util.*;


public class Main {
    public static void main(String[] args){

        System.out.println("----------Tic-Tac-Toe game---------");
        System.out.println();
        Scanner keyboard = new Scanner(System.in);

        int turnCount = 0;
        String compSym = "";
        weakAI weak = new weakAI();

        while (true){

            String[][] board = { {"1", "2", "3"},
                                 {"4", "5", "6"},
                                 {"7", "8", "9"} };
            turnCount = 9;


            System.out.println("\nPlease enter your name: ");
            String name = keyboard.nextLine();
            System.out.println("Please enter your symbol ('X' or 'O')");
            String UserSymbol = keyboard.nextLine();

            if(UserSymbol.equals("X")){
                compSym = "O";
            }
            else if(UserSymbol.equals("O")){
                compSym = "X";
            }

            System.out.println("Please select the difficulty of the AI:");
            System.out.println("\n1 - Weak || 2 - Intelligent");
            int menu = keyboard.nextInt();


            while (menu < 1 || menu > 2) {
                System.out.println();
                System.out.println("That is not a valid option in the system, please try again");
                System.out.println();
                System.out.println("Please select the difficulty of the AI:");
                System.out.println("\n1 - Weak || 2 - Intelligent");
                menu = keyboard.nextInt();

            }


            System.out.println("Which player would you like to go first or later ?\n1 - First || 2 - Later");
            int order = keyboard.nextInt();

            if(menu == 1) {   // weak AI

                while (order == 1) {

                    weak.boardDisplay(board);
                    System.out.println();
                    System.out.println(name + "'s turn !");
                    System.out.println("\nPlease enter the number of the board you would like to insert your symbol:");
                    int location = keyboard.nextInt();
                    weak.userInsert(board, location, UserSymbol);
                    turnCount--;
                    if (weak.stateIdentifier (board,UserSymbol, compSym, name)){
                        break;
                    }
                    if (turnCount == 0){
                        weak.boardDisplay(board);
                        System.out.println("\nEnd of the game\nIts a draw !");
                        break;
                    }
                    System.out.println("\nAI's turn !\n");
                    weak.compInsert(board, compSym);
                    turnCount--;
                    if (weak.stateIdentifier (board,UserSymbol, compSym, name)){
                        break;
                    }

                }


                while (order == 2){
                    System.out.println();
                    System.out.println("\nAI's turn !\n");
                    weak.compInsert(board, compSym);
                    turnCount--;
                    if (weak.stateIdentifier (board,UserSymbol, compSym, name)){
                        break;
                    }
                    if (turnCount == 0){
                        weak.boardDisplay(board);
                        System.out.println("\nEnd of the game\nIts a draw !");
                        break;
                    }
                    weak.boardDisplay(board);
                    System.out.println();
                    System.out.println(name + "'s turn !");
                    System.out.println("\nPlease enter the number of the board you would like to insert your symbol:");
                    int location = keyboard.nextInt();
                    weak.userInsert(board, location, UserSymbol);
                    turnCount--;
                    if (weak.stateIdentifier (board,UserSymbol, compSym, name)){
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

                if(again.equals("Y") || again.equals("y")){
                    continue;
                }else if(again.equals("N") || again.equals("n")){
                    break;
                }

            }

            if(menu == 2){  // intelligent AI
                System.out.println("2 works");
            }

        }

        System.out.println("Thank you for playing our game!");


    }
}
