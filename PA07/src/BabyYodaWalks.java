/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 03/14/2020
// Description: This program performs five simulation walks for Baby Yoda then displays
// statistical information to help predict the likelihood of various outcomes based upon the
// simulations.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;

public class BabyYodaWalks extends Point3d {

   //coordinates to be added to current location when a step is taken in the corresponding direction
   private static final Point3d FORWARD = new Point3d(0, 1, 0);
   private static final Point3d BACKWARD = new Point3d(0, -1, 0);
   private static final Point3d RIGHT = new Point3d(1, 0, 0);
   private static final Point3d LEFT = new Point3d(-1, 0, 0);

   //coordinates of red button
   private static final Point3d RED_BUTTON = new Point3d(0, 2, 0);

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);    //access to user input
      Random rand = new Random();               //access to pseudorandom sequence

      //get initial seed from user
      int seed = getSeed(scnr);

      //set the predictable random sequence
      rand.setSeed(seed);

      //# of simulations (out of 5) that ended in naps, saving the world, and being caught
      int numNaps = 0;
      int numRedButtons = 0;
      int numBounty = 0;

      //print five simulation walks
      for (int simNum = 1; simNum <= 5; ++simNum) {

         int zVal = printSimulation(rand, simNum);    //display simulation & get final z coordinate

         //count # of occurrences of each type of simulation ending
         if (zVal == -1) {          //if z is -1, baby yoda took nap
            ++numNaps;
         } else if (zVal == 2) {    //if z is 2, baby yoda was caught
            ++numBounty;
         } else if (zVal == 3) {    //if z is 3, baby yoda saved world
            ++numRedButtons;
         }
      }

      printTotals(numNaps, numBounty, numRedButtons);    //display simulation totals
   }

   /**
    * This method prompts the user for a random seed and reprompts until a seed within the valid
    * range is entered, then returns the seed.
    *
    * @param scnr access to user input
    * @return random seed number
    */
   public static int getSeed(Scanner scnr) {
      boolean isValidSeed = false;     //set to true once seed input is valid
      int seedInt = -1;                //seed number to be returned
      String seedStr = "";             //console line input to be read by secondary scanner

      System.out.println("Enter the seed (1-100) to begin the simulation:");

      //validate seed input
      while (!isValidSeed) {
         seedStr = scnr.nextLine().trim();
         Scanner stringScnr = new Scanner(seedStr);      //secondary scanner

         //check if input is non-blank, non-empty, and numeric
         if (seedStr.length() != 0 && stringScnr.hasNextInt()) {
            seedInt = stringScnr.nextInt();     //assign seed number input

            if (seedInt >= 1 && seedInt <= 100) {  //check if seed input is in valid range
               isValidSeed = true;
            } else {
               System.out.println("Seed must be a value between 1-100 inclusive. Enter the seed:");
            }
         } else {
            System.out.println("Seed must be a value between 1-100 inclusive. Enter the seed:");
         }
      }
      System.out.println();

      return seedInt;
   }

   /**
    * This method displays baby yoda's current coordinates, current step number,
    * direction of movement, and new coordinates for a single step in a simulation walk. It
    * calculates and returns baby yoda's new coordinates after taking a step.
    *
    * @param rndNum    pseudorandom number used to determine direction of baby yoda's next step
    * @param whichStep step number in simulation walk (1-11)
    * @param babyYoda  baby yoda's current coordinates
    * @return baby yoda's new coordinates
    */
   public static Point3d babyWalks(int rndNum, int whichStep, Point3d babyYoda) {
      Point3d newBabyYoda = new Point3d(babyYoda.getX(), babyYoda.getY(), babyYoda.getZ());
      String dir = "";

      //display current location, status, step #
      System.out.println("Baby Yoda's current position is: " + babyYoda);
      if (babyYoda.getZ() == 1) {      //check if baby yoda is levitating
         System.out.println("Baby Yoda is levitating!");
      }
      System.out.println("About to take Step #" + whichStep);

      //generate step
      if (whichStep != 11) {        //calc new coordinates if NOT step #11

         //determine step direction using pseudorandom number
         int mod = (rndNum % 4) + 1;
         if (mod == 1) {
            dir = "FORWARD";
            newBabyYoda.setY(babyYoda.getY() + FORWARD.getY());
         } else if (mod == 2) {
            dir = "BACKWARD";
            newBabyYoda.setY(babyYoda.getY() + BACKWARD.getY());
         } else if (mod == 3) {
            dir = "RIGHT";
            newBabyYoda.setX(babyYoda.getX() + RIGHT.getX());
         } else {
            dir = "LEFT";
            if (babyYoda.getX() != -2) {
               newBabyYoda.setX(babyYoda.getX() + LEFT.getX());
            }
         }

         //display step direction, new location
         System.out.println("Baby Yoda steps: " + dir);
         System.out.println("babyYoda's new position is: " + newBabyYoda);
      }

      //check if baby yoda encounters or escapes stormtrooper, change z value accordingly
      if (newBabyYoda.getX() == -2 && babyYoda.getX() == -1) {
         newBabyYoda.setZ(1);
         System.out.println("Oh no! It's a Stormtrooper with a flame thrower!");
         System.out.println("Baby Yoda succesfully levitates about the flame!!!");
      } else if (newBabyYoda.getX() == -1 && babyYoda.getX() == -2) {
         newBabyYoda.setZ(0);
      }

      return newBabyYoda;
   }

   /**
    * This method prints a simulation baby yoda walk. It calculates the new coordinates for baby
    * yoda and returns the z value of
    *
    * @param rand          pseudorandom number generator
    * @param simulationNum simulation number (1-5)
    * @return z value of baby yoda at end of simulation
    */
   public static int printSimulation(Random rand, int simulationNum) {
      Point3d babyYoda = new Point3d(0, 0, 0);     //start at position (0, 0, 0)
      boolean simulationOver = false;                       //set to true when simulation ends
      int rndNum = 0;
      int stepNum = 1;

      System.out.println("************************************************\n" +
            "            SIMULATION # " + simulationNum + "\n" +
            "************************************************\n");

      //generate simulation
      while (!simulationOver) {
         rndNum = rand.nextInt();               //generate next random number in the sequence
         babyYoda = babyWalks(rndNum, stepNum, babyYoda);   //calc new coordinates of baby yoda

         //update z value when simulation ends
         if (babyYoda.equals(RED_BUTTON)) {
            System.out.println("Baby Yoda steps on the red button. Rescue ship en route!");
            System.out.println("Baby Yoda saves the universe!!!");
            babyYoda.setZ(3);          //set z to 3 if baby yoda saves universe
            simulationOver = true;
         } else if (babyYoda.getX() == 2) {
            System.out.println("Oh no! Baby Yoda got snatched by bounty hunter and disappeared " +
                  "down a sewer grate!");
            babyYoda.setZ(2);          //set z to 2 if baby yoda caught by bounty hunter
            simulationOver = true;
         } else if (stepNum == 11) {
            System.out.println("Baby Yoda needs a nap");
            babyYoda.setZ(-1);         //set z to -1 if baby yoda takes nap
            simulationOver = true;
         }
         System.out.println();

         ++stepNum;                    //increase step number by 1
      }
      return babyYoda.getZ();    //return z val of baby yoda to indicate how simulation ended
   }

   /**
    * This method prints the simulation totals at the end of five simulations.
    *
    * @param numNaps       # of simulations (out of 5) that ended in naps
    * @param numBounty     # of simulations (out of 5) that ended in being caught by bounty hunter
    * @param numRedButtons # of simulations (out of 5) that ended in saving the world
    */
   public static void printTotals(int numNaps, int numBounty, int numRedButtons) {

      //calculate the percentages of each simulation ending
      double napsPercent = numNaps / 5.0 * 100;
      double bountyPercent = numBounty / 5.0 * 100;
      double redButtonsPercent = numRedButtons / 5.0 * 100;

      System.out.println("------ SIMULATION TOTALS ------");
      System.out.println("Total number of simulations run: 5");

      //display num and percent of simulations that ended with nap
      System.out.print("Baby Yoda took a nap: " + numNaps + " times (");
      System.out.printf("%.2f%s", napsPercent, "% probability)\n");

      //display num and percent of simulations that ended with bounty hunter
      System.out.print("Baby Yoda was snatched by a bounty hunter: " + numBounty + " times (");
      System.out.printf("%.2f%s", bountyPercent, "% probability)\n");

      //display num and percent of simulations that ended with red button / saved world
      System.out.print("Baby Yoda saved the universe: " + numRedButtons + " times (");
      System.out.printf("%.2f%s", redButtonsPercent, "% probability)\n");
   }
}