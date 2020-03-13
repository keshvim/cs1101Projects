/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/27/20
// Description: This program displays an upside down right triangle along with its hypotenuse
// based on a user-specified height and character.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;

public class UpsideDownRightTriangle {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);

      //get triangle height
      System.out.print("Enter height of right triangle: ");
      int triangleHeight = console.nextInt();

      console.nextLine();     //flush leftover newline from input stream

      //get triangle character
      System.out.print("Enter a character for the right triangle: ");
      char triangleChar = console.next().trim().charAt(0);

      drawTriangle(triangleHeight, triangleChar);     //display triangle

      //calculate and display hypotenuse
      double hypotenuse = Math.sqrt(2) * triangleHeight;
      System.out.printf("\nThe hypotenuse = %.3f\n", hypotenuse);
   }

   /**
    * This method outputs an upside down right triangle of user-specified height and character to
    * the console.
    *
    * @param triangleHeight height entered by user
    * @param triangleChar   character entered by user
    */
   public static void drawTriangle(int triangleHeight, char triangleChar) {
      System.out.println("\nHere is your triangle:\n");

      for (int row = 0; row < triangleHeight; ++row) {   //print (triangleHeight) rows

         //print character followed by a space (triangleHeight - row) times for each row
         for (int i = triangleHeight - row; i > 0; --i) {
            System.out.print(triangleChar + " ");
         }

         System.out.println();
      }
   }
}
