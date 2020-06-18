import java.util.ArrayList;
import java.util.Scanner;
 
public class ModularTemplate {
    private Scanner sc;
    public final String gameName = "Minigame";//identifies game. Replace with appropriate value.

    /*
    Main minigame method. Game takes place inside this method.
    Replace method name with name of the game
     */
    public void minigame(){

        //Asks player if they wish to play the minigame
        boolean playing = false;
        sc = new Scanner(System.in);
        String play = "";
        while(!play.equals("Y") && !play.equals("N")){
            System.out.println("Do you wish to play " + gameName + "? [(y)es or (n)o]");
            play = sc.nextLine().toUpperCase();
            if(play.equals("QUIT")){
                System.exit(0);
            }
            else if(play.equals("Y")){
                resetGame();
                playing = true;
            }
            else if(play.equals("N")){
                playing = false;
                System.out.println("Leaving " + gameName);
            }
            else {
                System.out.println("Invalid input");
            }
        }

        //Main Game loop
        while(playing){

            playing = playAgain();
        }
    }

    /*
    A list of words to use if the players don't have their own
     */
    private void setDefault(){
        //Default values are set
    }

    /*
    Called before every game to set game state
     */
    private void resetGame(){

        String setType = "";
        Scanner sc = new Scanner(System.in);

        while(!(setType.equals("CUSTOM") || setType.equals("DEFAULT"))){
            System.out.println("Please choose whether you would like to play with [custom] settings or [default] settings");
            setType = sc.nextLine().toUpperCase();

            if(setType.equals("QUIT")){
                System.exit(0);
            }
            else if (setType.equals("CUSTOM")) {
                //player inputs custom settings here
            } else if (setType.equals("DEFAULT")) {
                //default settings are set
                setDefault();
            } else {
                //error given
            }
        }
    }

    private boolean playAgain(){

        Scanner sc = new Scanner(System.in);
        String again = "";

        while(!(again.equals("Y") || again.equals("N"))){
            System.out.println("Would you like to play again? [(y)es or (n)o]");
            again = sc.nextLine().toUpperCase();
            if(again.equals("QUIT")){
                System.exit(0);
            }
            else if(again.equals("Y")){
                resetGame();
                return true;
            }
            else if(again.equals("N")){
                System.out.println("Leaving " + gameName);
                return false;
            }
            else{
                System.out.println("Invalid input.");
            }
        }
        return false;
    }

}
