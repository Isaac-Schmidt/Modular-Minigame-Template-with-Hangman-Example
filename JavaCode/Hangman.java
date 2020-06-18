import java.util.Scanner;
import java.util.ArrayList;

public class Hangman {

    //class variables
    public final String gameName = "Hangman";//Identifies game
    private ArrayList<String> gameWords;
    private int attempts;
    private String word;
    private String wordSpace;
    private Scanner sc;

    /*
    Main hangman minigame method. Game takes place inside this method. Call this method in Main(in this case Mini) class.
     */
    public void hangman(){

        //Asks player if they wish to play hangman
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
        String guess;
        int letterCount;
        //System.out.println("There are " + letterCount + " letters in this word. You have " + attempts + " incorrect guesses before you lose.");

        boolean hit;

        while(playing){
            letterCount = word.length();
            System.out.println(attempts + " attempts remaining. Word: " + wordSpace);
            System.out.println("Please guess a letter: ");
            guess = "";
            while(!acceptableInput(guess)){
                guess = sc.nextLine().toLowerCase();
                if(guess.equals("quit")){
                    System.exit(0);
                }
                else if(!acceptableInput(guess)){
                    System.out.println("That is invalid input. Please enter a single character.");
                }
            }

            hit = false;
            for(int i = 0; i < letterCount; i++){
                /*System.out.println("Guess: " + guess + "   wordAtChar: " + word.charAt(i)); //Debugging*/
                if(guess.equals(Character.toString(word.charAt(i)))){
                    char[] newWord = wordSpace.toCharArray();
                    newWord[i] = guess.charAt(0);
                    wordSpace = String.valueOf(newWord);
                    hit = true;
                }
            }

            if(hit == true){
                System.out.println(guess + " is in the mystery word!");
            }
            else{
                System.out.println("Uh Oh, No " + guess.toUpperCase() + "'s in the mystery word. -1 attempt");
                attempts -= 1;
            }

            //Check win/lose conditions
            if(wordSpace.equals(word)) {
                System.out.println("YOU WIN");
                playing = playAgain();
            }
            else if(attempts < 1){
                System.out.println("YOU LOSE");
                playing = playAgain();
            }
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
    A list of words to use if the players don't have their own */
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

            if(setType.equals("QUIT")){
                System.exit(0);
            }
            else if (setType.equals("CUSTOM")) {
                //player inputs custom words to use separated by a space
                System.out.println("Please enter words you'd like the computer to choose from. For more than one, separate with a space e.g: [hello train monkey]");
                gameWords = generateWords(sc.nextLine());

                System.out.println("Please enter the number of attempts you'd like to have");
                //player inputs number of attempts
                attempts = sc.nextInt();
                sc.nextLine();
            } else if (setType.equals("DEFAULT")) {
                setDefault();
                attempts = 5;
            } else {
                System.out.println("Invalid input");
                gameWords = generateWords("else");
            }

        }


        //set word
        word = gameWords.get((int) (Math.random() * gameWords.size())).toLowerCase();

        //set wordSpace
        wordSpace = "";
        int n = word.length();
        for(int i = 0; i < n; i++){
            wordSpace += "_";
        }

        /*/Debugging
        System.out.println(word);
        System.out.println(wordSpace);//*/

        System.out.println("There are " + word.length() + " letters in this word. You have " + attempts + " incorrect guesses before you lose.");//*/
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

    private boolean acceptableInput(String in){

        return (!(in.equals(""))
                && (in != null)
                && !(in.length() > 1)
                && (in.matches("^[a-zA-Z]*$")));
    }



}


