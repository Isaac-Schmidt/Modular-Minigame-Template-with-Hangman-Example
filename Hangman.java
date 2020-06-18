import java.util.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Hangman {

    //class variables
    public final String gameName = "Hangman";//Identifies game
    private ArrayList<String> gameWords;
    private int attempts;
    private String word;
    private Scanner sc;

    /*
    Main hangman minigame method. Game takes place inside this method.
     */
    public void hangman(){

        //Asks player if they wish to play hangman
        boolean playing = false;
        sc = new Scanner(System.in);
        String play = "";
        while(!play.equals("Y") && !play.equals("N")){
            System.out.println("Do you wish to play " + gameName + "? [(y)es or (n)o]");
            play = sc.nextLine().toUpperCase();
            if(play.equals("Y")){
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
        sc.close();

        //Main Game loop
        while(playing){

            playing = false;
        }
    }

    /*
    Creates an iterable ArrayList with given words
     */
    private ArrayList<String> generateWords(String wordList){
        ArrayList<String> parsedWords = new ArrayList<String>();
        for(String itWord: wordList.split(" ")){
            parsedWords.add(itWord);
        }
        return parsedWords;
    }

    /*
    A list of words to use if the players don't have their own
     */
    private void setDefault(){
        String words = "abruptly absurd abyss affix askew avenue awkward axiom azure bagpipes bandwagon banjo bayou beekeeper bikini blitz blizzard boggle bookworm boxcar boxful buckaroo buffalo buffoon buxom buzzard buzzing buzzwords caliph cobweb cockiness croquet crypt curacao cycle daiquiri dirndl disavow dizzying duplex dwarves embezzle equip espionage exodus faking fishhook fixable fjord flapjack flopping fluffiness flyby foxglove frazzled frizzled fuchsia funny gabby galaxy galvanize gazebo gizmo glowworm glyph gnarly gnostic gossip grogginess haiku haphazard hyphen iatrogenic icebox injury ivory ivy jackpot jaundice jawbreaker jaywalk jazziest jazzy jelly jigsaw jinx jiujitsu jockey jogging joking jovial joyful juicy jukebox jumbo kayak kazoo keyhole khaki kilobyte kiosk kitsch kiwifruit klutz knapsack larynx lengths lucky luxury lymph marquis matrix megahertz microwave mnemonic mystify naphtha nightclub nowadays numbskull nymph onyx ovary oxidize oxygen pajama peekaboo phlegm pixel pizazz pneumonia polka pshaw psyche puppy puzzling quartz queue quips quixotic quiz quizzes quorum razzmatazz rhubarb rhythm rickshaw schnapps scratch shiv snazzy sphinx spritz squawk staff strength strengths stretch stronghold stymied subway swivel syndrome thriftless thumbscrew topaz transcript transgress transplant twelfth twelfths unknown unworthy unzip uptown vaporize vixen vodka vortex walkway waltz wave wavy waxy wellspring wheezy whiskey whizzing whomever wimpy witchcraft wizard woozy wristwatch wyvern xylophone yachtsman yippee yoked youthful yummy zephyr zigzag zigzagging zilch zipper zodiac zombie";
        gameWords = generateWords(words);
    }

    /*
    Called before every game to set word and attempts
     */
    private void resetGame(){
        String setType = "";
        Scanner sc = new Scanner(System.in);




        while(!(setType.equals("CUSTOM") || setType.equals("DEFAULT"))){
            System.out.println("Please choose whether you would like to play with [custom] settings or [default] settings");
            setType = sc.nextLine().toUpperCase();

            if (setType.equals("CUSTOM")) {
                //player inputs custom words to use separated by a space
                System.out.println("Please enter words you'd like the computer to choose from. If more than one, separate with a space e.g: [hello train monkey]");
                gameWords = generateWords(sc.nextLine());
            } else if (setType.equals("DEFAULT")) {
                setDefault();
                attempts = 5;
            } else {
                System.out.println("Invalid input");
                gameWords = generateWords("else");
            }
        }

        sc.close();

        word = gameWords.get((int) (Math.random() * gameWords.size()));
        System.out.println(word);
    }

}


