/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 03/29/20
// Description: This program reads from an input file containing several records, each of which
// contains a date. It reformats and displays the valid dates and displays an error message for
// each invalid date.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;
import java.io.*;

public class FileInputParseDates {

   private static final String INPUT_FILENAME = "pa08InputFileDates.txt";  //input filename

   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);

      //prompt user for path
      System.out.println("Enter the path for the input file:");
      String path = console.nextLine().trim();
      File file = new File(path + INPUT_FILENAME);
      System.out.println("Looking for " + path + INPUT_FILENAME);

      //validate path input
      while (!file.exists()) {
         System.out.println("Cannot find " + INPUT_FILENAME + ". Make sure file exists and path " +
               "is correct.");

         System.out.println("\nEnter path for input file:");
         path = console.nextLine().trim();
         file = new File(path + INPUT_FILENAME);
      }

      System.out.println(INPUT_FILENAME + " successfully found. Processing will continue.\n");

      //create secondary scanner that points to input file
      Scanner fileScan = new Scanner(file);

      //get and display number of invalid records in input file
      int numInvalidRecs = processInputFile(fileScan);
      System.out.println("Total invalid records found: " + numInvalidRecs);
   }

   /**
    * processInputFile -
    * Validates an entire input file line by line
    *
    * @param fileScan -- Scanner object pointing to input file
    * @return -- int value representing the number of invalid records in the file
    */
   public static int processInputFile(Scanner fileScan) {
      int invalidRecsCount = 0;  //number of invalid records in input file

      while (fileScan.hasNextLine()) {
         String record = fileScan.nextLine();

         if (!validInputLine(record)) {   //check if a record is invalid
            ++invalidRecsCount;
         }
      }

      return invalidRecsCount;
   }

   /**
    * validInputLine -
    * Validates a single record
    *
    * @param inputLine -- String representing a line from input file
    * @return -- boolean value representing whether or not the record is valid input
    */
   public static boolean validInputLine(String inputLine) {
      Scanner recordScan = new Scanner(inputLine);    //scanner pointing to line from input file
      boolean isValidRecord = true;                   //false if record is invalid
      String dayStr = "", yearStr = "";
      int monthInt = 0, dayInt = 0, yearInt = 0;
      String errorMsg = "";                           //error message generated during validation

      //validate record input
      //validate month
      if (!recordScan.hasNext()) {  //check if missing first token
         errorMsg = "no first token";

      } else {
         monthInt = getMonthAsInt(recordScan.next());

         if (monthInt == -1) {   //check if invalid month
            errorMsg = "bad month";

            //validate day
         } else if (!recordScan.hasNext()) { //check if missing second token
            errorMsg = "no second token";

         } else {
            dayStr = recordScan.next();

            if (dayStr.charAt(dayStr.length() - 1) != ',') {   //check if missing comma
               errorMsg = "missing comma";

            } else {
               dayInt = convertStrToInt(dayStr.substring(0, dayStr.length() - 1));

               //check if day is not integer or not in valid range
               if (dayInt == -1 || !(dayInt >= 1 && dayInt <= 31)) {
                  errorMsg = "bad day";

                  //validate year
               } else if (!recordScan.hasNext()) {    //check if third token missing
                  errorMsg = "no third token";

               } else {
                  yearStr = recordScan.next();
                  yearInt = convertStrToInt(yearStr);

                  if (yearStr.length() != 4 || yearInt == -1) {   //check if year is not 4 digits
                     errorMsg = "bad year";
                  }
               }
            }
         }
      }

      if (!errorMsg.equals("")) {   //check if error message was generated during validation
         isValidRecord = false;

         //print error message
         System.out.print("***Skipping invalid record (" + errorMsg + "): ");
         System.out.println("\"" + inputLine + "\" ***");

      } else {    //if record input is valid

         //print original and reformatted records
         System.out.println("Original date: " + inputLine);
         System.out.println("Reformatted date: " + monthInt + "/" + dayInt + "/" + yearInt);
      }
      System.out.println();

      return isValidRecord;
   }

   /**
    * convertStrToInt -
    * Converts a String that holds all digit characters to an int value
    *
    * @param someString -- String value representing input that possibly holds an integer value
    * @return -- int value representing integer extracted from String input
    */
   public static int convertStrToInt(String someString) {
      int parsed = -1;

      if (hasAllDigits(someString)) {  //check if String contains valid integer
         parsed = Integer.parseInt(someString);
      }

      return parsed;    //-1 if not valid integer
   }

   /**
    * hasAllDigits -
    * Checks if a given String contains only digits
    *
    * @param someString -- String value representing input that possibly only contains digits
    * @return -- boolean value representing whether the String contains only digit characters
    */
   public static boolean hasAllDigits(String someString) {
      boolean isInt = true;

      if (someString.length() == 0) {
         isInt = false;
      } else {

         //check if each character is a digit
         for (int i = 0; i < someString.length(); ++i) {
            if (!Character.isDigit(someString.charAt(i))) {
               isInt = false;
            }
         }
      }

      return isInt;  //false if does not contain all digits
   }

   /**
    * getMonthAsInt –
    * Determines the numerical representation of the month (e.g., January = 01)
    * Preconditions:
    *
    * @param monthString --  String representing a month from input file
    * @return -- int value representing the month
    */
   public static int getMonthAsInt(String monthString) {
      int monthInt; //holds month converted to an integer

      // switch/case statement
      switch (monthString) {
         case "January":
            monthInt = 1;
            break;
         case "February":
            monthInt = 2;
            break;
         case "March":
            monthInt = 3;
            break;
         case "April":
            monthInt = 4;
            break;
         case "May":
            monthInt = 5;
            break;
         case "June":
            monthInt = 6;
            break;
         case "July":
            monthInt = 7;
            break;
         case "August":
            monthInt = 8;
            break;
         case "September":
            monthInt = 9;
            break;
         case "October":
            monthInt = 10;
            break;
         case "November":
            monthInt = 11;
            break;
         case "December":
            monthInt = 12;
            break;
         default:
            monthInt = -1;  //invalid month
      }
      return monthInt;
   } //end method
}