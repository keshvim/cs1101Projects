/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/04/2020
// Description: This program prompts the user to enter an SMS texting abbreviation then displays
// its non-abbreviated form, if it is known. Otherwise it displays the appropriate message.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;     // access to utilities class

public class SMSTranslator {

   // SMS translations corresponding to the SMS abbreviations: BFF, BTE, STT
   private static final String BEST_FRIENDS_FOREVER = "Best Friends FOREVER!!! :-)";
   private static final String BLEW_THE_EXAM = "Blew The Exam :-(";
   private static final String SPILL_THE_TEA = "Spill The Tea ;-)";

   public static void main(String[] args) {
      String abbreviatedText, decodedText;    // hold abbreviated and translated SMS messages
      Scanner keyboard = new Scanner(System.in);

      // get abbreviated and translated messages
      abbreviatedText = getAbbreviation(keyboard);
      decodedText = decodeAbbreviation(abbreviatedText);

      printAbbreviation(decodedText);     // display translated message
   }

   // ************************************************************************
   // DESCRIPTION - getAbbreviation() - prompts and returns SMS abbreviation
   // PARAMETERS:
   //      Scanner scnr - access to input scanner
   // RETURNS: String abbreviated text message
   // ************************************************************************
   public static String getAbbreviation(Scanner scnr) {
      System.out.println("Input the SMS abbreviation and I'll decode it for you: ");
      String abbreviation = scnr.next();

      return abbreviation;
   }

   // ************************************************************************
   // DESCRIPTION - decodeAbbreviation() - translates SMS abbreviation and returns translation
   // PARAMETERS:
   //      String userString - abbreviated SMS message
   // RETURNS: String translated SMS message
   // ************************************************************************
   public static String decodeAbbreviation(String userString) {
      String decoded = "";
      if (userString.equalsIgnoreCase("BFF")) {
         decoded = BEST_FRIENDS_FOREVER;
      } else if (userString.equalsIgnoreCase("BTE")) {
         decoded = BLEW_THE_EXAM;
      } else if (userString.equalsIgnoreCase("STT")) {
         decoded = SPILL_THE_TEA;
      } else {
         decoded = "I'm sorry. I don't know that abbreviation yet.";
      }

      return decoded;
   }

   // ************************************************************************
   // DESCRIPTION - printAbbreviation() - displays SMS translation
   // PARAMETERS:
   //      Scanner scnr - access to input scanner
   // ************************************************************************
   public static void printAbbreviation(String result) {
      System.out.println("Translation: " + result);
   }
}
