/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/27/20
// Description: This program displays a scalable ASCII graphic of a dumbbell based on a
// user-specified scale.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;

public class ScalableDumbbell {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      int scale = 0;    //size of ASCII dumbbell

      System.out.println("Enter an integer 2-6 for the scale:");

      //validate scale input
      while (!(scale >= 2 && scale <= 6)) {
         scale = console.nextInt();

         //reprompt if scale is NOT between 2 and 6 inclusive
         if (!(scale >= 2 && scale <= 6)) {
            System.out.println("Scale must be a value between 2-6 inclusive. Enter the scale:");
         }
      }

      drawDumbbell(scale);    //display dumbbell
   }

   /**
    * This method outputs the scaled top half of a dumbbell sphere to the console.
    *
    * @param scale scale between 2 and 6 (inclusive) entered by user
    */
   public static void drawTopHalfSphere(int scale) {

      for (int row = 0; row < scale; ++row) {   //print (scale) rows of top half of sphere

         //indent each row of top half of sphere
         for (int k = 0; k < 2 * (scale - (row + 1)); ++k) {
            System.out.print(" ");
         }

         //print characters for each row of top half of sphere
         System.out.print("/=\\");
         for (int j = 0; j < (2 * row) + scale; ++j) {
            System.out.print("/\\");
         }
         System.out.println("/=\\");
      }

      //print the two horizontal lines in middle of sphere
      for (int m = 0; m < 2; ++m) {
         for (int n = 0; n < (6 * scale) + 3; ++n) {
            System.out.print("=");
         }
         System.out.println();
      }
   }

   /**
    * This method outputs the scaled bottom half of a dumbbell sphere to the console.
    *
    * @param scale scale between 2 and 6 (inclusive) entered by user
    */
   public static void drawBottomHalfSphere(int scale) {

      for (int row = 0; row < scale; ++row) {   //print (scale) rows of bottom half of sphere

         //indent each row of bottom half of sphere
         for (int k = 0; k < 2 * row; ++k) {
            System.out.print(" ");
         }

         //print characters for each row of bottom half of sphere
         System.out.print("\\=/");
         for (int i = 0; i < 2 * (scale - (row + 1)) + scale; ++i) {
            System.out.print("\\/");
         }
         System.out.println("\\=/");
      }
   }

   /**
    * This method outputs a scaled dumbbell bar to the console.
    *
    * @param scale scale between 2 and 6 (inclusive) entered by user
    */
   public static void drawBar(int scale) {

      for (int row = 0; row < Math.pow(scale, 2); ++row) {  //print (scale^2) rows of bar

         //indent each row of bar
         for (int j = 0; j < (2 * scale) + 1; ++j) {
            System.out.print(" ");
         }

         //print characters for each row of bar
         for (int k = 0; k < 2; ++k) {
            System.out.print("|");
            for (int m = 0; m < scale - 2; ++m) {
               System.out.print("X");
            }
            System.out.print("|");
         }

         System.out.println();
      }
   }

   /**
    * This method outputs a scaled ASCII dumbbell to the console.
    *
    * @param scale scale between 2 and 6 (inclusive) entered by user
    */
   public static void drawDumbbell(int scale) {

      //draw top dumbbell sphere
      drawTopHalfSphere(scale);
      drawBottomHalfSphere(scale);

      //draw dumbbell bar
      drawBar(scale);

      //draw bottom dumbbell sphere
      drawTopHalfSphere(scale);
      drawBottomHalfSphere(scale);
   }
}
