/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 03/29/20
// Description: This program selects a random mystery number between 1-100 inclusive then plays a
// guessing game with the user in which they get five tries to guess the mystery number. The
// program gives the user a hint each time they guess incorrectly and displays the number of
// tries it took the user to guess correctly.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;

public class GuessingGame {

   private static final int SEED = 100; //constant for seed of pseudorandom number generator
   private static final int MAX = 100; //constant for range of secret guess
   private static final int MAX_GUESSES = 5; //constant for number of guesses allowed

   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      Random rand = new Random();

      //generate pseudorandom number
      rand.setSeed(SEED);
      int hiddenNum = rand.nextInt(MAX) + 1;

      displayInstructions();
      playTheGame(keyboard, hiddenNum);

   } //end main method

   /**
    * displayInstructions -
    * Print game instructions to console
    */
   public static void displayInstructions() {

      //display instructions
      System.out.println();
      System.out.println("I'll pick a number between 1-100. You try to guess it.");
      System.out.println("If you don't guess it right, I'll give you a hint to help you.");
      System.out.println("You get 5 guesses. Let's play!");
      System.out.println();

      System.out.println("I am thinking of a number between 1 & " + MAX + ".");

   } //end displayInstructions()

   /**
    * playTheGame -
    * Play one round of the guessing game and display the post-game stats.
    *
    * @param keyboard  -- Scanner object pointing to the console
    * @param hiddenNum -- int value representing the secret number
    */
   public static void playTheGame(Scanner keyboard, int hiddenNum) {
      int whichGuess = playOneRound(keyboard, hiddenNum);

      //user guessed correctly. Display stats
      if (whichGuess != -1) {
         System.out.println("Correct! You got it in " + whichGuess + " guesses.");
      } else {
         System.out.println("Sorry, you lose. The number I was thinking of was " + hiddenNum);
      }
   } //end playTheGame

   /**
    * playOneRound -
    * Play one round of the guessing game and return the number of guesses it took the user
    * to guess correctly or -1 to indicate that the user did not guess correctly.
    *
    * @param keyboard  -- scanner object pointing to console
    * @param hiddenNum -- int value representing secret number
    * @return -- int value representing the number of guesses it took the user to guess correctly
    */
   public static int playOneRound(Scanner keyboard, int hiddenNum) {
      int whichGuess = 1;  //guess number

      //get the user's guess
      int guess = getGuess(keyboard, whichGuess);

      //Give user up to MAX_GUESSES tries to get it right
      while ((guess != hiddenNum) && (whichGuess < MAX_GUESSES)) {
         System.out.println("Sorry, that guess is incorrect.");

         //Guess is incorrect. Give the user a hint
         if (guess < hiddenNum) {
            System.out.println("The number I am thinking of is higher.");
         } else if (guess > hiddenNum) {
            System.out.println("The number I am thinking of is lower.");
         }
         whichGuess++;     //update guess number

         //reprompt and update user's guess
         guess = getGuess(keyboard, whichGuess);
      }

      if (guess != hiddenNum) {  //check if user guessed correctly
         whichGuess = -1;
      }

      return whichGuess;      //return -1 if user did not guess secret number
   } //end playOneRound()

   /**
    * getGuess -
    * Prompts user to guess the mystery number and validates and returns the user's guess.
    *
    * @param keyboard   -- Scanner object pointing to console
    * @param whichGuess -- int value representing the guess number that the user is on
    * @return -- int value representing the user's validated guess
    */
   public static int getGuess(Scanner keyboard, int whichGuess) {
      boolean isValidGuess = false;
      String guessStr = "";
      int guessInt = -1;

      //get the user's guess
      System.out.println("Guess #" + whichGuess + ": What's your guess?");

      while (!isValidGuess) {
         guessStr = keyboard.nextLine().trim();
         Scanner stringScnr = new Scanner(guessStr);  //scanner pointing to line of input

         if (guessStr.length() != 0 && stringScnr.hasNextInt()) {
            guessInt = stringScnr.nextInt();

            if (guessInt >= 1 && guessInt <= 100) {
               isValidGuess = true;
            } else {
               System.out.println("Your guess must be in the range 1-100. Try again.");
               System.out.println("Your guess?");
            }

         } else {
            System.out.println("Your guess must be in the range 1-100. Try again.");
            System.out.println("Your guess?");
         }
      }

      return guessInt;
   }
}