public class IntelligentAi {
    public IntelligentAi() {}
    static String computerMark,playerMark;

    Master mas = new Master();
    // The Minimax algorithm
    public boolean userInsert(String[][] data, int loc, String sym) {
        int row = (loc - 1) / 3;
        int col = (loc - 1) % 3;
        if (data[row][col].equals("X") || data[row][col].equals("O")) {
            System.out.println("This position has already been filled, please try another one!");
            return false;
        } else {
            data[row][col] = sym;
            return true;
        }
    }



}

