import java.util.*;

public class Main {
    public static void main(String[] args){

        System.out.println("----------Welcome to our dictionary---------");
        System.out.println();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Do you want to start the system? \nPress Y/y for YES || N/n for NO");
        String choice = keyboard.nextLine();


        if (choice.equals("N") || choice.equals("n")){  // if user enter NO, it does nothing and go to the last line;
            System.out.println();
        }


        while(choice.equals("Y") || choice.equals("y")){

            System.out.println("Please select one of the following options:");
            System.out.println("\n1 - Add new Word || 2 - Delete Word || 3 - Get meaning || 4 - Dictionary list || 5 - Spell check a test file || 6 - Exit");
            int menu = Integer.parseInt(keyboard.nextLine());

            while (menu < 1 || menu > 6) {
                System.out.println();
                System.out.println("That is not a valid option in the system, please try again");
                System.out.println();
                System.out.println("Please select one of the following options:");
                System.out.println("\n1 - Add new Word || 2 - Delete Word || 3 - Get meaning || 4 - Dictionary list || 5 - Spell check a test file || 6 - Exit");
                menu = keyboard.nextInt();

            }


            if(menu == 1){
                System.out.println("2 works");
            }
            else if(menu == 2){
                System.out.println("2 works");
            }
            else if(menu == 3){
                System.out.println("3 works");

            }
            else if(menu == 4){
                System.out.println("4 works");

            }
            else if(menu == 5){
                System.out.println("5 works");

            }
            else if(menu == 6){
                System.out.println("6 works");
            }
        }

        System.out.println("Thank you for using our system !");



    }
}