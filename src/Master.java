public class Master {

    public Master(){}
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

    public boolean stateIdentifier (String[][] data, String user1Sym, String user2Sym, String username1, String username2){

        // check rows
        for (int i = 0; i < 3; i++) {
            if (data[i][0].equals(data[i][1]) && data[i][1].equals(data[i][2])) {
                boardDisplay(data);
                if (data[i][0].equals(user1Sym)) {
                    System.out.println("\nEnd of the game");
                    System.out.println(username1 + " has won the game, great game !");
                } else if (data[i][0].equals(user2Sym)) {
                    System.out.println("\nEnd of the game");
                    System.out.println(username2 + " has won the game, great game !");
                }
                return true;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (data[0][i].equals(data[1][i]) && data[1][i].equals(data[2][i])) {
                boardDisplay(data);
                if (data[0][i].equals(user1Sym)) {
                    System.out.println("\nEnd of the game");
                    System.out.println(username1 + " has won the game, great game !");
                } else if (data[0][i].equals(user2Sym)) {
                    System.out.println("\nEnd of the game");
                    System.out.println(username2 + " has won the game, great game !");
                }
                return true;
            }
        }

        // check diagonals
        if (data[0][0].equals(data[1][1]) && data[1][1].equals(data[2][2])) {
            boardDisplay(data);
            if (data[0][0].equals(user1Sym)) {
                System.out.println("\nEnd of the game");
                System.out.println(username1 + " has won the game, great game !");
            } else if (data[0][0].equals(user2Sym)) {
                System.out.println("\nEnd of the game");
                System.out.println(username2 + " has won the game, great game !");
            }
            return true;
        }

        if (data[0][2].equals(data[1][1]) && data[1][1].equals(data[2][0])) {
            boardDisplay(data);
            if (data[0][2].equals(user1Sym)) {
                System.out.println("\nEnd of the game");
                System.out.println(username1 + " has won the game, great game !");
            } else if (data[0][2].equals(user2Sym)) {
                System.out.println("\nEnd of the game");
                System.out.println(username2 + " has won the game, great game !");
            }
            return true;
        }
        return false;
    }
}
