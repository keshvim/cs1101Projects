/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 04/04/2020
// Description: This program prompts the user to enter five pairs of numbers representing jersey
// numbers and player ratings corresponding to five players. It then creates a player roster from
// this input and displays a menu of options allowing the user to modify the roster.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;

public class PlayerRoster {

   private static final int NUM_PLAYERS = 5;    //constant for number of players on roster

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      char menuChoice;

      //set up parallel arrays for player jersey number/rating
      int[] playerJerseys = new int[NUM_PLAYERS];
      int[] playerRatings = new int[NUM_PLAYERS];

      //load parallel arrays
      getRoster(playerJerseys, playerRatings, console);

      //display initial roster
      displayRoster(playerJerseys, playerRatings);

      do {  //execute until user quits
         displayMenu();
         menuChoice = getValidMenuChoice(console);    //update menu choice
         processMenuChoice(menuChoice, playerJerseys, playerRatings, console);
      } while (menuChoice != 'Q');
   }

   /**
    * getValidJersey -
    * Prompts the user to enter a jersey number and validates the input
    *
    * @param console -- Scanner object pointing to console
    * @return -- int representing a valid jersey number entered by the user
    */
   public static int getValidJersey(Scanner console) {
      int jerseyInt = -1;
      boolean isValidJersey = false;

      //validate jersey number
      while (!isValidJersey) {
         String jerseyStr = console.nextLine().trim();
         Scanner stringScnr = new Scanner(jerseyStr);    //secondary scanner

         //check if input in non-empty & an integer
         if (jerseyStr.length() != 0 && stringScnr.hasNextInt()) {
            jerseyInt = stringScnr.nextInt();

            //check if jersey number is between 0 and 99 (inclusive)
            if (jerseyInt >= 0 && jerseyInt <= 99) {
               isValidJersey = true;
            } else {
               System.out.println("Error: jersey number must be an integer between 0-99\n\n" +
                     "Enter a jersey number:");
            }

         } else {
            System.out.println("Error: jersey number must be an integer between 0-99\n\n" +
                  "Enter a jersey number:");
         }
      }

      return jerseyInt;
   }

   /**
    * getValidRating -
    * Prompts the user to enter a player rating and validates the input
    *
    * @param console -- Scanner object pointing to console
    * @return -- int representing a valid player rating entered by the user
    */
   public static int getValidRating(Scanner console) {
      int ratingInt = -1;
      boolean isValidRating = false;

      //validate rating
      while (!isValidRating) {
         String ratingStr = console.nextLine().trim();
         Scanner stringScnr = new Scanner(ratingStr);    //secondary scanner

         //check if input is non-empty & an integer
         if (ratingStr.length() != 0 && stringScnr.hasNextInt()) {
            ratingInt = stringScnr.nextInt();

            //check if rating is between 1 & 9 (inclusive)
            if (ratingInt >= 1 && ratingInt <= 9) {
               isValidRating = true;
            } else {
               System.out.println("Error: rating must be an integer between 1-9\n\nEnter a " +
                     "rating:");
            }

         } else {
            System.out.println("Error: rating must be an integer between 1-9\n\nEnter a " +
                  "rating:");
         }
      }

      return ratingInt;
   }

   /**
    * getRoster -
    * Loads parallel arrays with user-specified jersey numbers and player ratings, with each
    * index corresponding to one player
    * Precondition: arrays
    *
    * @param jersey  -- array of ints representing jersey numbers corresponding to each player
    * @param rating  -- array of ints representing ratings corresponding to each player
    * @param console -- Scanner object pointing to console
    */
   public static void getRoster(int[] jersey, int[] rating, Scanner console) {

      for (int playerNum = 1; playerNum <= NUM_PLAYERS; ++playerNum) {

         //load jersey numbers into array
         System.out.println("Enter player " + playerNum + "'s jersey number:");
         jersey[playerNum - 1] = getValidJersey(console);

         //load ratings into array
         System.out.println("Enter player " + playerNum + "'s rating:");
         rating[playerNum - 1] = getValidRating(console);

         System.out.println();
      }
   }

   /**
    * displayRoster -
    * Displays roster of five players with user-specified jersey numbers and ratings
    *
    * @param jersey -- array of ints representing jersey numbers corresponding to each player
    * @param rating -- array of ints representing ratings corresponding to each player
    */
   public static void displayRoster(int[] jersey, int[] rating) {
      System.out.println("ROSTER");

      //print each player's stats
      for (int playerNum = 1; playerNum <= NUM_PLAYERS; ++playerNum) {
         System.out.println("Player " + playerNum + " -- Jersey number: " + jersey[playerNum - 1] +
               ", Rating: " + rating[playerNum - 1]);
      }
   }

   /**
    * displayMenu -
    * Displays a menu of actions that can be performed on the roster
    */
   public static void displayMenu() {
      System.out.println();
      System.out.println("MENU");
      System.out.println("U - Update player rating");
      System.out.println("S - Select players above a rating");
      System.out.println("P - Print roster");
      System.out.println("Q - Quit");
      System.out.println();
   }

   /**
    * getValidMenuChoice -
    * Prompts the user to enter a menu choice and validates the input
    *
    * @param console -- Scanner object pointing to console
    * @return -- char representing the user's menu choice
    */
   public static char getValidMenuChoice(Scanner console) {
      String choice = "";
      boolean isValidChoice = false;

      //validate menu choice
      while (!isValidChoice) {
         System.out.print("Choose an option: ");

         //check if input is non-empty
         if (console.hasNext()) {
            choice = console.next().toUpperCase().trim();

            //check if input is a single character & one of the menu options
            if (choice.length() == 1 && "USPQ".contains(choice)) {
               isValidChoice = true;
            } else {
               System.out.println("Please choose a valid option\n");
            }

         } else {
            System.out.println("Please choose a valid option\n");
         }
      }
      console.nextLine();

      return choice.charAt(0);   //convert to char
   }

   /**
    * findPlayer -
    * Searches the roster for a user-specified jersey number and returns the index of the jersey
    * number if found
    *
    * @param jerseys      -- array of ints representing jersey numbers corresponding to each player
    * @param targetJersey -- int representing jersey number being searched for
    * @return -- int representing the array index of the target jersey number
    */
   public static int findPlayer(int[] jerseys, int targetJersey) {
      int jerseyIndex = -1;

      for (int i = 0; i < NUM_PLAYERS; ++i) {
         if (jerseys[i] == targetJersey) {
            jerseyIndex = i;
         }
      }

      return jerseyIndex;     //-1 if not found
   }

   /**
    * updatePlayerRating -
    * Prompts the user to enter a jersey number then replaces the player rating corresponding to
    * that jersey with a new user-specified rating
    *
    * @param jerseys -- array of ints representing jersey numbers corresponding to each player
    * @param ratings -- array of ints representing ratings corresponding to each player
    * @param console -- Scanner object pointing to console
    */
   public static void updatePlayerRating(int[] jerseys, int[] ratings, Scanner console) {
      boolean found = false;

      while (!found) {
         System.out.println("Enter a jersey number:");
         int playerJersey = getValidJersey(console);

         int playerIndex = findPlayer(jerseys, playerJersey);  //search roster for jersey number

         //check if jersey number not found in roster
         if (playerIndex == -1) {
            System.out.println("Error: jersey number " + playerJersey + " not found on roster\n");
         } else {
            System.out.println("\nEnter a new rating for this player:");
            int playerRating = getValidRating(console);
            ratings[playerIndex] = playerRating;            //update player rating
            found = true;
         }
      }
   }

   /**
    * displayAboveRating -
    * Displays players in the roster with ratings above a user-specified rating
    *
    * @param jerseyNums -- array of ints representing jersey numbers corresponding to each player
    * @param ratingNums -- array of ints representing ratings corresponding to each player
    * @param console    -- Scanner object pointing to console
    */
   public static void displayAboveRating(int[] jerseyNums, int[] ratingNums, Scanner console) {
      System.out.println("Enter a rating:");
      int playerRating = getValidRating(console);

      System.out.println("\nABOVE " + playerRating);

      //print each player with rating above playerRating
      for (int playerNum = 1; playerNum <= NUM_PLAYERS; ++playerNum) {
         if (ratingNums[playerNum - 1] > playerRating) {
            System.out.println("Player " + playerNum + " -- Jersey number: " +
                  +jerseyNums[playerNum - 1] + ", Rating: " + ratingNums[playerNum - 1]);
         }
      }
   }

   /**
    * processMenuChoice -
    * Performs an action on the roster corresponding to the user-specified menu choice
    *
    * @param choice     -- char representing the user's menu choice
    * @param jerseyNums -- array of ints representing jersey numbers corresponding to each player
    * @param ratingNums -- array of ints representing ratings corresponding to each player
    * @param console    -- Scanner object pointing to console
    */
   public static void processMenuChoice(char choice, int[] jerseyNums, int[] ratingNums,
                                        Scanner console) {
      if (choice == 'U') {
         updatePlayerRating(jerseyNums, ratingNums, console);
      } else if (choice == 'S') {
         displayAboveRating(jerseyNums, ratingNums, console);
      } else if (choice == 'P') {
         displayRoster(jerseyNums, ratingNums);
      }
   }
}