/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 04/04/2020
// Description: This program prompts the user to enter the weights of up to five riders, then
// performs safety checks on the raft based on these weights and determines whether the raft is
// safe to ride.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;

public class TennesseeTwister {

   private static final int MAX_RIDERS = 5;              //constant for max riders per raft
   private static final int MIN_RIDERS = 2;              //constant for min riders per raft
   private static final int MAX_WEIGHT = 900;            //constant for max weight per raft
   private static final int MIN_WEIGHT = 200;            //constant for min weight per raft
   private static final int MAX_WEIGHT_OVER_AVG = 100;   //constant for max rider weight over avg

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String sentinel;

      //set up array for weights of riders
      int[] riderWeights = new int[MAX_RIDERS];

      do {  //execute until user quits

         //calculate total weight, avg weight, & number of riders
         int numRiders = loadWeights(riderWeights, scnr);
         int totalWeight = totalWeights(riderWeights, numRiders);
         double avgWeight = calcAvgWeight(totalWeight, numRiders);

         //display total weight, avg weight, & number of riders
         displayStats(numRiders, totalWeight, avgWeight);

         if (numRiders != 0) {   //check if there are any riders

            //determine & display whether raft passed safety checks
            boolean isSafe = isSafeToRide(riderWeights, totalWeight, avgWeight, numRiders);

            //display whether ride is safe
            if (!isSafe) {
               System.out.println("Tennessee Twister is UNSAFE. DO NOT PROCEED!");
            } else {
               System.out.println("Tennessee Twister is good to go. Have fun!");
            }
         }

         System.out.println("\nDo you have another group of riders (y/n)?");
         sentinel = scnr.nextLine().trim();
      } while (!sentinel.equalsIgnoreCase("n"));
   }

   /**
    * loadWeights -
    * Prompts user to enter up to five valid rider weights and loads weights into an array
    *
    * @param userWeight -- array of ints representing the weights of the riders in a raft
    * @param scnr       -- Scanner object pointing to the console
    * @return -- int representing the number of riders in the raft
    */
   public static int loadWeights(int[] userWeight, Scanner scnr) {
      System.out.println("Enter weight of rider #1 (or -1 when done): ");
      int weight = getWeight(scnr);                //get weight of first rider
      int numRiders = 0;

      //reprompt until max number of riders reached or user enters -1
      while ((numRiders < MAX_RIDERS) && (weight != -1)) {
         numRiders++;                              //update number of riders
         userWeight[numRiders - 1] = weight;       //load array

         System.out.println("Enter weight of rider #" + (numRiders + 1) + " (or -1 when done): ");
         weight = getWeight(scnr);                 //update weight
      }

      return numRiders;
   }

   /**
    * getWeight -
    * Validates a user-specified rider weight
    *
    * @param scnr -- Scanner object pointing to the console
    * @return -- int representing a valid weight entered by the user
    */
   public static int getWeight(Scanner scnr) {
      boolean isValidInt = false;
      int weightInt = 0;

      //validate weight
      while (!isValidInt) {
         String weightStr = scnr.nextLine().trim();
         Scanner stringScnr = new Scanner(weightStr); //secondary scanner

         //check if input is non-empty & an integer
         if (weightStr.length() != 0 && stringScnr.hasNextInt()) {
            weightInt = stringScnr.nextInt();
            isValidInt = true;
         } else {
            System.out.println("Rider weight must be a value > 0 or -1 to stop. Enter the rider " +
                  "weight:");
         }
      }

      return weightInt;
   }

   /**
    * totalWeights -
    * Calculates total weight of riders
    *
    * @param userWeight -- array of ints representing the weights of the riders in a raft
    * @param numRiders  -- int representing the number of riders in the raft
    * @return -- int representing the total weight of the riders in the raft
    */
   public static int totalWeights(int[] userWeight, int numRiders) {
      int totalWeight = 0;

      //total the weights in the array
      for (int i = 0; i < numRiders; ++i) {
         totalWeight += userWeight[i];
      }

      return totalWeight;
   }

   /**
    * calcAvgWeight -
    * Calculates average weight of riders
    *
    * @param totalWeight -- int representing the total weight of the riders in the raft
    * @param numRiders   -- int representing the number of riders in the raft
    * @return -- double representing the average weight of the riders in the raft
    */
   public static double calcAvgWeight(int totalWeight, int numRiders) {
      return (double) totalWeight / numRiders;
   }

   /**
    * isBalanced -
    * Determines whether raft is balanced
    *
    * @param userWeight -- array of ints representing the weights of the riders in a raft
    * @param avgWeight  -- double representing the average weight of the riders in the raft
    * @return -- boolean representing whether the raft is balanced
    */
   public static boolean isBalanced(int[] userWeight, double avgWeight) {
      boolean isBalanced = true;

      for (int rider : userWeight) {   //execute for each rider in raft

         //check if rider weight is more than 100 lbs above avg rider weight
         if ((rider - avgWeight) > MAX_WEIGHT_OVER_AVG) {
            isBalanced = false;
         }
      }

      return isBalanced;
   }

   /**
    * displayStats -
    * Displays the number of riders, total weight of riders, and average weight of riders
    *
    * @param numRiders   -- int representing the number of riders in the raft
    * @param totalWeight -- int representing the total weight of the riders in the raft
    * @param avgWeight   -- double representing the average weight of the riders in the raft
    */
   public static void displayStats(int numRiders, int totalWeight, double avgWeight) {
      System.out.println("The number of riders is " + numRiders);

      if (numRiders != 0) {   //check if there are any riders
         System.out.println("Total ride weight: " + totalWeight);
         System.out.printf("Avg rider weight: %6.1f\n", avgWeight);
      }
   }

   /**
    * isSafeToRide -
    * Checks and returns whether safety requirements are met and displays corresponding error
    * message
    *
    * @param userWeight  -- array of ints representing the weights of the riders in the raft
    * @param totalWeight -- int representing the total weight of the riders in the raft
    * @param avgWeight   -- double representing the average weight of the riders in the raft
    * @param numRiders   -- int representing the number of riders in the raft
    * @return -- boolean representing whether the raft is safe to ride
    */
   public static boolean isSafeToRide(int[] userWeight, int totalWeight, double avgWeight,
                                      int numRiders) {
      boolean isSafe = false;
      String errorMsg = "SAFETY CHECK FAILED: ";      //initial error message

      System.out.println("\nPerforming Safety Tests...");

      if (numRiders < MIN_RIDERS) {             //check if number of riders below min riders
         errorMsg += "Ride must have at least two riders.";

      } else if (totalWeight < MIN_WEIGHT) {    //check if total weight below min weight
         errorMsg += "Ride weight UNDER minimum capacity.";

      } else if (totalWeight > MAX_WEIGHT) {    //check if total weight above max weight
         errorMsg += "Ride weight OVER maximum capacity.";

      } else if (!isBalanced(userWeight, avgWeight)) {   //check if raft is unbalanced
         errorMsg += "Ride weight UNBALANCED.";

      } else {    //if none of safety checks failed
         isSafe = true;
         errorMsg = "All safety checks passed.";   //safety checks passed "error" message
      }
      System.out.println(errorMsg);

      return isSafe;
   }
}