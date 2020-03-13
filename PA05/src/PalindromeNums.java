/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/20/20
// Description: This program prompts for an integer value between 1-999 (inclusive), checks
// whether the input value is in the specified range, and determines whether or not the value
// entered is a numeric palindrome if it is in the specified range.
/* ---------------------------------------------------------------------------------------------- */

import java.util.Scanner;  //allows for access to user input

public class PalindromeNums {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      int num = getNumber(keyboard);   // get and assign number from user input

      //validates user input
      if (num >= 1 && num <= 999) { //checks if input is between 1 and 999, inclusive

         //displays whether input is a numeric palindrome or not
         if (isNumericPal(num)) {
            System.out.println("\n" + num + " is a numeric palindrome.");
         } else {
            System.out.println("\n" + num + " is not a numeric palindrome.");
         }

      } else { //displays error message if invalid input
         System.out.println("\nInput must be 1-999. Program cannot continue.");
      }
   }

   /**
    * This method gets and returns a number from user input.
    *
    * @param scnr allows access to user input
    * @return number value from user input
    */
   public static int getNumber(Scanner scnr) {
      System.out.println("Enter your integer number (1-999) on the line below:");
      int num = scnr.nextInt();

      return num;
   }

   /**
    * This method checks and returns whether a given number is a numeric palindrome.
    *
    * @param userNum number to be checked
    * @return whether the number is a palindrome or not
    */
   public static boolean isNumericPal(int userNum) {
      boolean isPalindrome = false;
      int remainder;
      int reversedNum = 0;    //reversed number input
      int temp = userNum;

      //reverse the digit order of number input, assign resulting value to reversedNum
      while (temp > 0) {
         remainder = temp % 10;                          //isolate end (rightmost) digit of temp
         reversedNum = (reversedNum * 10) + remainder;   //place digit in ones place of reversedNum
         temp /= 10;                                     //remove end (rightmost) digit from temp
      }

      if (userNum == reversedNum) { //checks if reversed number is equal to original number
         isPalindrome = true;
      }

      return isPalindrome;
   }
}