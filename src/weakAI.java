import java.util.Random;

public class weakAI {
    public weakAI() {
    }

    Master mas = new Master();

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


}

