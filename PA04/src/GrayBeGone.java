/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/03/2020
// Description: This program prompts the user to enter integer values for red, green, and blue then
// removes the gray part and displays the resulting RGB color values.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;     // access to utilities class

public class GrayBeGone {
   public static void main(String[] args) {
      int red, green, blue;                     // red, green, blue color values from input
      int minVal;                               // smallest RGB value from input

      Scanner scnr = new Scanner(System.in);

      // assign red, green, and blue color values
      System.out.println("Enter the RGB values for red, green and blue each separated by a space");
      red = scnr.nextInt();
      green = scnr.nextInt();
      blue = scnr.nextInt();

      // assign smallest RGB input value to minVal
      minVal = red;
      if (green < minVal) {
         minVal = green;
      }
      if (blue < minVal) {
         minVal = blue;
      }

      // subtract smallest value, minVal, from each RGB value
      red -= minVal;
      green -= minVal;
      blue -= minVal;

      // display updated RGB color values
      System.out.println("\nThe RGB values with the gray gone are: " + red + " " + green + " " +
            blue);
   }
}
