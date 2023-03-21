public class Master {

    public Master(){};
    public void boardDisplay(String[][] data) {


        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                System.out.print(" " + data[row][col] + " ");
                if(col < 2) {
                    System.out.print("│"); // vertical line separator
                }
            }
            System.out.println();
            if(row < 2) {
                System.out.println("───┼───┼───"); // horizontal line separator
            }
        }
    }

    public boolean stateIdentifier (String[][] data, String userSym, String compSym, String username){

        String[][] board = { {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"} };

        if (data[0][0].equals(data[0][1]) && data[0][1].equals(data[0][2])){
            boardDisplay(data);
            if (data[0][0].equals(userSym)){
                System.out.println("\nEnd of the game");
                System.out.println(username + " has won the game, Congratulations !");
            } else if (data[0][0].equals(compSym)) {
                System.out.println("\nEnd of the game");
                System.out.println("AI has won the game, hope you win next time !");
            }
            return true;
        }
        if (data[1][0].equals(data[1][1]) && data[1][1].equals(data[1][2])){
            boardDisplay(data);
            if (data[1][0].equals(userSym)){
                System.out.println("\nEnd of the game");
                System.out.println(username + " has won the game, Congratulations !");
            } else if (data[1][0].equals(compSym)) {
                System.out.println("\nEnd of the game");
                System.out.println("AI has won the game, hope you win next time !");
            }
            return true;
        }
        if (data[2][0].equals(data[2][1]) && data[2][1].equals(data[2][2])){
            boardDisplay(data);
            if (data[2][0].equals(userSym)){
                System.out.println("\nEnd of the game");
                System.out.println(username + " has won the game, Congratulations !");
            } else if (data[2][0].equals(compSym)) {
                System.out.println("\nEnd of the game");
                System.out.println("AI has won the game, hope you win next time !");
            }
            return true;
        }
        if (data[0][0].equals(data[1][0]) && data[1][0].equals(data[2][0])){
            boardDisplay(data);
            if (data[0][0].equals(userSym)){
                System.out.println("\nEnd of the game");
                System.out.println(username + " has won the game, Congratulations !");
            } else if (data[0][0].equals(compSym)) {
                System.out.println("\nEnd of the game");
                System.out.println("AI has won the game, hope you win next time !");
            }
            return true;
        }
        if (data[0][1].equals(data[1][1]) && data[1][1].equals(data[2][1])){
            boardDisplay(data);
            if (data[0][1].equals(userSym)){
                System.out.println("\nEnd of the game");
                System.out.println(username + " has won the game, Congratulations !");
            } else if (data[0][1].equals(compSym)) {
                System.out.println("\nEnd of the game");
                System.out.println("AI has won the game, hope you win next time !");
            }
            return true;
        }
        if (data[0][2].equals(data[1][2]) && data[1][2].equals(data[2][2])){
            boardDisplay(data);
            if (data[0][2].equals(userSym)){
                System.out.println("\nEnd of the game");
                System.out.println(username + " has won the game, Congratulations !");
            } else if (data[0][2].equals(compSym)) {
                System.out.println("\nEnd of the game");
                System.out.println("AI has won the game, hope you win next time !");
            }
            return true;
        }
        if (data[0][0].equals(data[1][1]) && data[1][1].equals(data[2][2])){
            boardDisplay(data);
            if (data[0][0].equals(userSym)){
                System.out.println("\nEnd of the game");
                System.out.println(username + " has won the game, Congratulations !");
            } else if (data[0][0].equals(compSym)) {
                System.out.println("\nEnd of the game");
                System.out.println("AI has won the game, hope you win next time !");
            }
            return true;
        }
        if (data[0][2].equals(data[1][1]) && data[1][1].equals(data[2][0])){
            boardDisplay(data);
            if (data[0][2].equals(userSym)){
                System.out.println("\nEnd of the game");
                System.out.println(username + " has won the game, Congratulations !");
            } else if (data[0][2].equals(compSym)) {
                System.out.println("\nEnd of the game");
                System.out.println("AI has won the game, hope you win next time !");
            }
            return true;
        }
        return false;
    }
}
