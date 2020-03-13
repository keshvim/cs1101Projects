/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/27/20
// Description: This program performs a series of validations based on user input.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;

public class ValidateMe {

   private static final double TOLERANCE = 0.0001;    //tolerance for validating class avg

   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);

      //get and display valid student test score
      int score = getValidIntScore(keyboard);
      System.out.println("You entered a valid test score of: " + score);

      //get and display valid student name
      String name = getValidStrName(keyboard);
      System.out.println("You entered the student: " + name);


      //get and display valid class avg
      double classAvg = getValidDoubleClassAvg(keyboard);
      System.out.printf("You entered a valid avg: %.2f\n", classAvg);

      //get and display student letter grade
      char letterGrade = getValidCharGrade(keyboard);
      System.out.println("You entered a valid grade: " + letterGrade);
   }

   /**
    * This method prompts the user for a student test score and reprompts until a score within
    * the valid range is entered, then returns the test score.
    *
    * @param scnr allows access to user input
    * @return student test score between 0 and 100 (inclusive) entered
    */
   public static int getValidIntScore(Scanner scnr) {
      int score = -1;   //student test score to be returned

      System.out.println("Enter an integer test score between 0-100 inclusive:");

      //validate student test score input
      while (!(score >= 0 && score <= 100)) {
         score = scnr.nextInt();

         //reprompt if test score is NOT between 0 and 100 inclusive
         if (!(score >= 0 && score <= 100)) {
            System.out.println("Test score must be a value between 0-100 inclusive. Enter the " +
                  "test score:");
         }
      }
      scnr.nextLine();  //flush leftover newline from input stream
      return score;
   }

   /**
    * This method prompts the user for a student name and reprompts until a valid name is
    * entered, then returns the name.
    *
    * @param scnr allows access to user input
    * @return non-empty and non-blank student name entered
    */
   public static String getValidStrName(Scanner scnr) {
      String name = "";    //student name to be returned

      System.out.println("Enter student's full name:");

      //validate student name input
      while (name.equals("")) {
         name = scnr.nextLine().trim();

         //reprompt if trimmed name is empty
         if (name.equals("")) {
            System.out.println("Name must be non-empty and non-blank. Enter the student's full " +
                  "name:");
         }
      }
      return name;
   }

   /**
    * This method prompts the user for a class average and reprompts until an average within the
    * valid range is entered, then returns the class average rounded to two decimal places.
    *
    * @param console allows access to user input
    * @return class average between 0 and 100 (inclusive) rounded to two decimal places
    */
   public static double getValidDoubleClassAvg(Scanner console) {
      double classAvg = -1.0;    //class avg to be returned

      System.out.println("Enter class average 0-100 inclusive:");

      //validate class avg input
      while (!((classAvg > 0 && classAvg < 100) || (Math.abs(classAvg - 0) <= TOLERANCE ||
            Math.abs(classAvg - 100) <= TOLERANCE))) {
         classAvg = console.nextDouble();

         //reprompt if avg is NOT between 0 and 100 inclusive
         if (!((classAvg > 0 && classAvg < 100) || (Math.abs(classAvg - 0) <= TOLERANCE ||
               Math.abs(classAvg - 100) <= TOLERANCE))) {
            System.out.println("Class average must be a value between 0 - 100 inclusive. Enter " +
                  "the class average:");
         }
      }
      console.nextLine();  //flush leftover newline from input stream

      return Math.round(classAvg * 100.0) / 100.0;    //round avg to two decimal places
   }

   /**
    * This method prompts the user for a student letter grade and reprompts until a valid
    * character is entered, then returns the letter grade.
    *
    * @param keyboard allows access to user input
    * @return student letter grade (one of A, B, C, D, F) entered
    */
   public static char getValidCharGrade(Scanner keyboard) {
      String letterGrade = "";   //student letter grade to be converted to Character then returned

      System.out.println("Enter the student grade (A, B, C, D, F):");

      //validate student letter grade input
      while (!("ABCDF".contains(letterGrade) && letterGrade.length() == 1)) {
         letterGrade = keyboard.next().trim();

         //reprompt if trimmed input is NOT both a single character AND one of A,B,C,D,F
         if (!("ABCDF".contains(letterGrade) && letterGrade.length() == 1)) {
            System.out.println("Grade must be one of: A, B, C, D, F. Enter the student grade:");
         }
      }
      return letterGrade.charAt(0);    //convert String to Character
   }
}
