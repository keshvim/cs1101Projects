/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/04/2020
// Description: This program prompts the user for an item description, weight, and shipping method
// then calculates and displays the shipping cost invoice.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;     // access to utilities class

public class WeShipIt {

   private static final int OVERNIGHT_CHARGE = 5;  // overnight shipping cost per lb
   private static final int TWO_DAY_CHARGE = 2;    // two day shipping cost per lb
   private static final int ECONOMY_CHARGE = 1;    // economy shipping cost per lb

   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);  // scanner object to pass around

      //get item description
      String itemDescription = getItemDescription(keyboard);

      //validate item description
      if (itemDescription.equals("")) {
         System.out.println("Invalid description. Program cannot continue");
      } else {

         //get item weight
         double shipWeight = getShipWeight(keyboard);

         //validate item weight
         if (shipWeight <= 0.0) {
            System.out.println("Invalid shipping weight. Program cannot continue");
         } else {

            //get shipping method
            char shipMethod = getShipClass(keyboard);
            shipMethod = Character.toUpperCase(shipMethod);

            //validate shipping method
            if (shipMethod != 'O' && shipMethod != 'T' && shipMethod != 'E') {
               System.out.println("Invalid shipping method. Program cannot continue");
            } else {

               //calculate shipping cost and display invoice
               double shipCost = calculateShipping(shipMethod, shipWeight);
               displayResults(itemDescription, shipWeight, shipMethod, shipCost);
            }
         }
      }
   }

   // ************************************************************************
   // DESCRIPTION - getItemDescription() - get item description and return it
   // PARAMETERS:
   //      Scanner keyboard - access to input scanner
   // RETURNS: String description of shipping item
   // ************************************************************************
   public static String getItemDescription(Scanner keyboard) {
      System.out.println("Enter item description:");
      String description = keyboard.nextLine();

      return description;
   }

   // ************************************************************************
   // DESCRIPTION - getShipWeight() - get item weight and return it
   // PARAMETERS:
   //      Scanner console - access to input scanner
   // RETURNS: double shipping item weight
   // ************************************************************************
   public static double getShipWeight(Scanner console) {

      //get shipping weight
      System.out.println("Enter item weight in lbs:");
      double weight = console.nextDouble();

      return weight;
   }

   // ************************************************************************
   // DESCRIPTION - getShipClass() - get user's choice for shipping method and return it
   // PARAMETERS:
   //      Scanner keyboard - access to input scanner
   // RETURNS: char user choice of shipping method
   // ************************************************************************
   public static char getShipClass(Scanner keyboard) {
      char shipMethod;

      //get shipping method
      System.out.println();
      System.out.println("How fast would you like to ship your package:");
      System.out.println("(O)vernight");
      System.out.println("(T)wo Days");
      System.out.println("(E)conomy (may take up to 7 days)");
      System.out.print("Choose an option: ");
      shipMethod = keyboard.next().charAt(0);

      return shipMethod;
   }

   // ************************************************************************
   // DESCRIPTION - calculateShipping() - calculate and return shipping charge
   // PARAMETERS:
   //      char shipMethod - choice of shipping method
   //      double weight - weight of shipping item
   // RETURNS: double shipping cost
   // ************************************************************************
   public static double calculateShipping(char shipMethod, double weight) {
      double shipCharge = 0.0;

      if (shipMethod == 'O') {
         shipCharge = weight * OVERNIGHT_CHARGE;
      } else if (shipMethod == 'T') {
         shipCharge = weight * TWO_DAY_CHARGE;
      } else {
         shipCharge = weight * ECONOMY_CHARGE;
      }

      return (shipCharge);
   }

   // ************************************************************************
   // DESCRIPTION - displayResults() - display shipping charge invoice
   // PARAMETERS:
   //      String itemDescription - description of shipping item
   //      double shipWeight - weight of shipping item
   //      char shipMethod - choice of shipping method
   //      double shipCost - shipping cost
   // ************************************************************************
   public static void displayResults(String itemDescription, double shipWeight, char shipMethod,
                                     double shipCost) {
      System.out.println();
      System.out.println("*** WE SHIP INVOICE ***");
      System.out.println("Item Description: " + itemDescription);
      System.out.printf("Item Weight: %.2f\n", shipWeight);
      System.out.println("Ship Method: " + shipMethod);
      System.out.printf("Total Cost: $%.2f\n", shipCost);
   }
}