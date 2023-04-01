import java.util.Random;

public class weakAI {
    public weakAI() {}

    Master mas = new Master();

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

    public boolean compInsert(String[][]data, String sym){
        Random random = new Random();
        int nRows = data.length;
        int nCols = data[0].length;
        int numCells = nRows * nCols;
        while (true){
            int rand = random.nextInt(numCells);
            int row = rand / nCols;
            int col = rand % nCols;

            if (data[row][col].equals("X") || data[row][col].equals("O")) {
                continue;
            } else {
                data[row][col] = sym;
                System.out.println("AI has inserted '" + sym + "' into " + (rand + 1));
                break;
            }
        }
        return true;
    }


}

