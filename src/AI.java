import java.util.Random;

public class AI {
    private int num;
    public AI() {
    }
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

    public boolean userInsert(String[][] data, int loc, String sym) {


        if (loc == 1) { data[0][0] = sym; return true; }
        if (loc == 2) { data[0][1] = sym; return true; }
        if (loc == 3) { data[0][2] = sym; return true; }
        if (loc == 4) { data[1][0] = sym; return true; }
        if (loc == 5) { data[1][1] = sym; return true; }
        if (loc == 6) { data[1][2] = sym; return true; }
        if (loc == 7) { data[2][0] = sym; return true; }
        if (loc == 8) { data[2][1] = sym; return true; }
        if (loc == 9) { data[2][2] = sym; return true; }


        return false;
    }
    public boolean compInsert(String[][]data, String sym){
        Random random = new Random();

        while (true){
            int rand = random.nextInt(1,10);

            if (rand == 1) {
                if (data[0][0].equals("X") || data[0][0].equals("O")){
                    continue;
                }else{
                    data[0][0] = sym;
                    System.out.println("AI has inserted '" + sym + "' into " + 1);
                    break;
                }
            }
            if (rand == 2) {
                if (data[0][1].equals("X") || data[0][1].equals("O")){
                    continue;
                }else{
                    data[0][1] = sym;
                    System.out.println("AI has inserted '" + sym + "' into " + 2);
                    break;
                }
            }
            if (rand == 3) {
                if (data[0][2].equals("X") || data[0][2].equals("O")){
                    continue;
                }else{
                    data[0][2] = sym;
                    System.out.println("AI has inserted '" + sym + "' into " + 3);
                    break;
                }
            }
            if (rand == 4) {
                if (data[1][0].equals("X") || data[1][0].equals("O")){
                    continue;
                }else{
                    data[1][0] = sym;
                    System.out.println("AI has inserted '" + sym + "' into " + 4);
                    break;
                }
            }
            if (rand == 5) {
                if (data[1][1].equals("X") || data[1][1].equals("O")){
                    continue;
                }else{
                    data[1][1] = sym;
                    System.out.println("AI has inserted '" + sym + "' into " + 5);
                    break;
                }
            }
            if (rand == 6) {
                if (data[1][2].equals("X") || data[1][2].equals("O")){
                    continue;
                }else{
                    data[1][2] = sym;
                    System.out.println("AI has inserted '" + sym + "' into " + 6);
                    break;
                }
            }
            if (rand == 7) {
                if (data[2][0].equals("X") || data[2][0].equals("O")){
                    continue;
                }else{
                    data[2][0] = sym;
                    System.out.println("AI has inserted '" + sym + "' into " + 7);
                    break;
                }
            }
            if (rand == 8) {
                if (data[2][1].equals("X") || data[2][1].equals("O")){
                    continue;
                }else{
                    data[2][1] = sym;
                    System.out.println("AI has inserted '" + sym + "' into " + 8);
                    break;
                }
            }
            if (rand == 9) {
                if (data[2][2].equals("X") || data[2][2].equals("O")){
                    continue;
                }else{
                    data[2][2] = sym;
                    System.out.println("AI has inserted '" + sym + "' into " + 9);
                    break;
                }
            }


        }


        return true;
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
