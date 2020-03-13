/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/04/2020
// Description: This program prompts the user for a month and day and displays the season in
//              which that date occurs.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;     // access to utilities class

public class Seasons {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);

      // month name and day number
      String month;
      int day;

      String season;    // name of season containing date

      // get month and day from user input
      month = getMonth(keyboard);
      day = getDay(keyboard);

      if (validInput(month, day)) {
         season = calcSeason(month, day);    // get season
         displaySeason(season);
      } else {
         System.out.println("\nInvalid date. Program cannot continue");
      }
   }

   // ************************************************************************
   // DESCRIPTION - getMonth() - prompts and returns month name
   // PARAMETERS:
   //      Scanner keyboard - access to input scanner
   // RETURNS: String month name entered by user
   // ************************************************************************
   public static String getMonth(Scanner keyboard) {
      System.out.println("Enter the month:");
      String month = keyboard.nextLine().trim();

      return month;
   }

   // ************************************************************************
   // DESCRIPTION - getDay() - prompts and returns day number
   // PARAMETERS:
   //      Scanner keyboard - access to input scanner
   // RETURNS: int day number entered by user
   // ************************************************************************
   public static int getDay(Scanner keyboard) {
      int day = 0;
      System.out.println("Enter day:");
      day = keyboard.nextInt();

      return day;
   }

   // ************************************************************************
   // DESCRIPTION - validInput() - determines whether or not the date input by the user is valid
   // PARAMETERS:
   //      String inputMonth - month name from user input
   //      int inputDay - day number from user input
   // RETURNS: boolean indicating whether or not the user input is valid
   // ************************************************************************
   public static boolean validInput(String inputMonth, int inputDay) {
      boolean isValidInput = false;

      // checks if day is between 1 and 31 (inclusive) for months of Jan,Mar,May,Jul,Aug,Oct,Dec
      if (inputMonth.equalsIgnoreCase("January") || inputMonth.equalsIgnoreCase("March") ||
            inputMonth.equalsIgnoreCase("May") || inputMonth.equalsIgnoreCase("July") ||
            inputMonth.equalsIgnoreCase("August") || inputMonth.equalsIgnoreCase("October") ||
            inputMonth.equalsIgnoreCase("December")) {
         if (inputDay >= 1 && inputDay <= 31) {
            isValidInput = true;
         }
      }

      // checks if day is between 1 and 30 (inclusive) for months of Apr, Jun, Sept, Nov
      else if (inputMonth.equalsIgnoreCase("April") || inputMonth.equalsIgnoreCase("June") ||
            inputMonth.equalsIgnoreCase("September") ||
            inputMonth.equalsIgnoreCase("November")) {
         if (inputDay >= 1 && inputDay <= 30) {
            isValidInput = true;
         }
      }

      // checks if day is between 1 and 28 (inclusive) for month of Feb
      else if (inputMonth.equalsIgnoreCase("February")) {
         if (inputDay >= 1 && inputDay <= 28) {
            isValidInput = true;
         }
      }

      return isValidInput;
   }

   // ************************************************************************
   // DESCRIPTION - calcSeason() - determines which season contains the date with the given
   //                              month and day
   // PARAMETERS:
   //      String inputMonth - month name from user input
   //      int inputDay - day number from user input
   // RETURNS: String season name
   // ************************************************************************
   public static String calcSeason(String inputMonth, int inputDay) {
      String season = "";

      // sets season as Winter if date is December 21 - March 19, inclusive
      if ((inputMonth.equalsIgnoreCase("December") && inputDay >= 21) ||
            inputMonth.equalsIgnoreCase("January") || inputMonth.equalsIgnoreCase("February") ||
            (inputMonth.equalsIgnoreCase("March") && inputDay <= 19)) {
         season = "Winter";
      }

      // sets season as Spring if date is March 20 - June 20, inclusive
      else if ((inputMonth.equalsIgnoreCase("March") && inputDay >= 20) ||
            inputMonth.equalsIgnoreCase("April") || inputMonth.equalsIgnoreCase("May") ||
            (inputMonth.equalsIgnoreCase("June") && inputDay <= 20)) {
         season = "Spring";
      }

      // sets season as Summer if date is June 21 - September 20, inclusive
      else if ((inputMonth.equalsIgnoreCase("June") && inputDay >= 21) ||
            inputMonth.equalsIgnoreCase("July") || inputMonth.equalsIgnoreCase("August") ||
            (inputMonth.equalsIgnoreCase("September") && inputDay <= 20)) {
         season = "Summer";
      }

      // sets season as Fall if date is September 21 - December 20, inclusive
      else if ((inputMonth.equalsIgnoreCase("September") && inputDay >= 21) ||
            inputMonth.equalsIgnoreCase("October") || inputMonth.equalsIgnoreCase("November") ||
            (inputMonth.equalsIgnoreCase("December") && inputDay <= 20)) {
         season = "Fall";
      }

      return season;
   }

   // ************************************************************************
   // DESCRIPTION - displaySeason() - prints out the season that contains the date input by the user
   // PARAMETERS:
   //      String season - name of the season that contains the date input by user
   // ************************************************************************
   public static void displaySeason(String season) {
      System.out.println("\nThis date occurs during the season of: " + season);
   }
}
