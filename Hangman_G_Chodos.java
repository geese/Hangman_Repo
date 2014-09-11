package hangman_g_chodos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman_G_Chodos
{

    static Scanner keyboard = new Scanner(System.in);
    static String wordToGuess;                         
    static String wrongMisses = "";
    static char[] correctLetters;
    static char playersGuess = ' ';
    static char playersGuess1 = ' ';
    static int guessesRemaining;
    static char[] wordToGuessArray;
    static Boolean solved;
    static ArrayList<String> words = new ArrayList<>();

    private static void stringToArray()
    {
        wordToGuessArray = new char[wordToGuess.length()];
        wordToGuessArray = wordToGuess.toCharArray();
    }

    private static void initUnderscores(String s)
    {
        guessesRemaining = 6;  //initialized here so that new games can be started
        correctLetters = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
        {
            correctLetters[i] = '_';
        }
        printGallows();  // this is case '6', printing an empty gallows and blank underscores when a new game begins
    }

    private static void playGame()
    {
        solved = false;        

        while (!solved & guessesRemaining > 0)
        {
            promptForGuess();
            checkGuess(playersGuess, playersGuess1);
            printGallows();
        }
        if (solved)
        {
            System.out.print("\n\nYou won the game!  You're so incredible and awesome!");
        }
    }

    private static void promptForGuess()
    {
        System.out.println("\n\nEnter your guess here:");
        playersGuess = keyboard.next().charAt(0);
        if (playersGuess >= 65 & playersGuess <= 90)    //making it case insensitive
        {
            playersGuess1 = (char) (playersGuess + 32);
        } else if (playersGuess >= 97 & playersGuess <= 122)
        {
            playersGuess1 = (char) (playersGuess - 32);
        }
    }

    private static void checkGuess(char c, char c1)
    {
        Boolean found = false;
        for (int i = 0; i < wordToGuessArray.length; i++)
        {
            if (c == wordToGuessArray[i])   //checking for a letter match whether uppercase or lowercase
            {
                correctLetters[i] = c;
                found = true;
            }
            if (c1 == wordToGuessArray[i])
            {
                correctLetters[i] = c1;
                found = true;
            }

        }
        if (!found)
        {
            wrongMisses += c + " ";
            guessesRemaining--;
        }
    }

    private static void printCorrectLetters()
    {
        solved = true;
        for (int i = 0; i < correctLetters.length; i++)
        {
            if (correctLetters[i] == '_')
            {
                solved = false;
            }
            System.out.print(correctLetters[i] + " ");
        }
    }

    private static void printGallows()
    {
        switch (guessesRemaining)
        {
            case 6:
                System.out.print("\n ;-----,------                    "
                        + "Letters Missed: " + wrongMisses + "\n |"
                        + "                                   Misses Left: "
                        + guessesRemaining
                        + "      \n |\n |\n |\n |\n_|______________    ");
                break;
            case 5:
                System.out.print("\n ;-----,------                    "
                        + "Letters Missed: " + wrongMisses + "\n |"
                        + "     O                             Misses Left: "
                        + guessesRemaining
                        + "      \n |\n |\n |\n |\n_|______________    ");
                break;
            case 4:
                System.out.print("\n ;-----,------                    "
                        + "Letters Missed: " + wrongMisses + "\n |"
                        + "     O                             Misses Left: "
                        + guessesRemaining
                        + "      \n |     |\n |\n |\n |\n_|______________    ");
                break;
            case 3:
                System.out.print("\n ;-----,------                    "
                        + "Letters Missed: " + wrongMisses + "\n |"
                        + "     O                             Misses Left: "
                        + guessesRemaining
                        + "      \n |    /|\n |\n |\n |\n_|______________    ");
                break;
            case 2:
                System.out.print("\n ;-----,------                    "
                        + "Letters Missed: " + wrongMisses + "\n |"
                        + "     O                             Misses Left: "
                        + guessesRemaining
                        + "      \n |    /|\\\n |\n |\n |\n_|______________    ");
                break;
            case 1:
                System.out.print("\n ;-----,------                    "
                        + "Letters Missed: " + wrongMisses + "\n |"
                        + "     O                             Misses Left: "
                        + guessesRemaining
                        + "      \n |    /|\\\n |    /\n |\n |\n_|______________    ");
                break;
            case 0:
                System.out.print("\n ;-----,------                    "
                        + "Letters Missed: " + wrongMisses + "\n |"
                        + "     O                             Misses Left: "
                        + guessesRemaining
                        + "      \n |    /|\\\n |    / \\"
                        + "                    Sorry, you couldn't save him!  :`("
                        + "\n |                               The word was "
                        + "\"" + wordToGuess + "\"." + "\n |\n_|______________    ");
                break;
        }

        printCorrectLetters();

    }

    public static void main(String[] args)
    {
        Boolean playAgain = true;
        Random randNum = new Random();
        initWordsList();

        while (playAgain)
        {
            wordToGuess = words.get(randNum.nextInt(words.size()));
            initUnderscores(wordToGuess);
            stringToArray();

            playGame();
            System.out.println("\n\n");
            System.out.println("Play again?  Enter 'y' for a new word, or anything else to quit.");
            if (!(keyboard.next().equalsIgnoreCase("y")))
            {
                playAgain = false;
            }
            wrongMisses = "";  //clearing the board
        }
    }

    static private void initWordsList()
    {
        words.add("mighty");
        words.add("powder");
        words.add("liquor");
        words.add("beanbag");
        words.add("Minecraft");
        words.add("kitchen");
        words.add("textbook");
        words.add("computer");
        words.add("weekday");
        words.add("fortune");
        words.add("spider");
        words.add("quilt");
        words.add("Indigo");
        words.add("hazard");
        words.add("choice");
        words.add("television");
        words.add("homework");
        words.add("dinner");
        words.add("blanket");
        words.add("dishwasher");
        words.add("laundry");
        words.add("lawnmower");
        words.add("particle");
        words.add("practical");
        words.add("sweetheart");
        words.add("candy");
        words.add("chocolate");
        words.add("rice");
        words.add("necessary");
        words.add("entertainment");
        words.add("legend");
        words.add("calculator");
        words.add("tomato");
        words.add("wild");
        words.add("sort");
        words.add("potato");
        words.add("upstream");
        words.add("sixth");
        words.add("peacock");
        words.add("airplane");
        words.add("enormous");
        words.add("Athens");
        words.add("charge");
        words.add("chair");
        words.add("paper");
        words.add("claw");
        words.add("nobody");
        words.add("midnight");
        words.add("paint");
        words.add("soap");
        words.add("grass");
        words.add("garage");
        words.add("comedy");
        words.add("ancient");
        words.add("Vienna");
        words.add("super");
        words.add("under");
        words.add("language");
        words.add("time");
        words.add("sport");

    }

}