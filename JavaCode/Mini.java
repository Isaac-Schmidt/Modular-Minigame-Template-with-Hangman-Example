import java.util.Arrays;
import java.util.Scanner;

public class Mini {

    private static String[] gameList = new String[] {"hangman"};

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to the game of games!");
        boolean playing = true;

        while(playing) {
            chooseGame();
            playing = playAgain();
        }
        scn.close();
    }

    private static void chooseGame(){
        Scanner scn = new Scanner(System.in);

        String chosen = "";
        while(!Arrays.asList(gameList).contains(chosen)){
            System.out.println("Please Choose a game to play: " +
                    "\n1) Hangman");
            chosen = scn.nextLine().toLowerCase();

            if(chosen.equals("quit")){
                System.exit(0);
            }
            else if(chosen.equals("hangman") || chosen.equals("1")) {
                chosen = "hangman";
                System.out.println("Starting Hangman");
                Hangman game = new Hangman();
                game.hangman();
            }
            else{
                System.out.println("That is invalid input. Please enter the name or number of the game you wish to play.");
            }
        }
    }

    private static boolean playAgain(){

        Scanner sc = new Scanner(System.in);
        String again = "";

        while(!(again.equals("Y") || again.equals("N"))){
            System.out.println("Would you like to Choose another game? [(y)es or (n)o]");
            again = sc.nextLine().toUpperCase();

            if(again.equals("QUIT")){
                System.exit(0);
            }
            else if(again.equals("Y")){
                return true;
            }
            else if(again.equals("N")){
                System.out.println("Leaving Game Collection");
                return false;
            }
            else{
                System.out.println("Invalid input.");
            }
        }
        return false;
    }
}
