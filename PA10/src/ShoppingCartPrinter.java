/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 04/11/20
// Description: This program creates two ItemToPurchase objects and prompts the user to set their
// names, prices, and quantities using public helper methods. Then, it prints out the total cost
// of purchasing these items.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;

public class ShoppingCartPrinter {

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);

      //initialize item objects
      ItemToPurchase firstItem = new ItemToPurchase();
      ItemToPurchase secondItem = new ItemToPurchase();

      //prompt for item 1
      System.out.println("Item 1");

      System.out.println("Enter the item name:");
      firstItem.setName(console.nextLine().trim());

      System.out.println("Enter the item price:");
      firstItem.setPrice(console.nextInt());

      System.out.println("Enter the item quantity:");
      firstItem.setQuantity(console.nextInt());

      console.nextLine();

      //prompt for item 2
      System.out.println("\nItem 2");

      System.out.println("Enter the item name:");
      secondItem.setName(console.nextLine().trim());

      System.out.println("Enter the item price:");
      secondItem.setPrice(console.nextInt());

      System.out.println("Enter the item quantity:");
      secondItem.setQuantity(console.nextInt());

      //calculate total costs
      int firstTotalCost = firstItem.getQuantity() * firstItem.getPrice();
      int secondTotalCost = secondItem.getQuantity() * secondItem.getPrice();
      int totalCost = firstTotalCost + secondTotalCost;

      //display total costs
      System.out.println("\nTOTAL COST");

      System.out.print(firstItem.getName() + " " + firstItem.getQuantity() + " @ $");
      System.out.println(firstItem.getPrice() + " = $" + firstTotalCost);

      System.out.print(secondItem.getName() + " " + secondItem.getQuantity() + " @ $");
      System.out.println(secondItem.getPrice() + " = $" + secondTotalCost);

      System.out.println("\nTotal: $" + totalCost);
   }
}
