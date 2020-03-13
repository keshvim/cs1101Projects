/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/20/2020
// Description: This program prompts the user to enter a sentence then replaces any SMS
//              texting abbreviations with their non-abbreviated forms and outputs the new
//              sentence.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;

public class SMSExpander {

   // non-abbreviated phrases corresponding to abbreviations
   private static final String BEST_FRIEND_FOREVER = "best friend forever";   //BFF
   private static final String BLOW_THE_EXAM = "blow the exam";   //BTE
   private static final String I_DONT_KNOW = "I don't know";   //IDK
   private static final String SPILL_THE_TEA = "spill the tea";   //STE

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String sentence, expandedSentence;  //abbreviated text, non-abbreviated text

      //get and translate abbreviated message
      sentence = getText(scnr);
      expandedSentence = expandAbbreviation(sentence);

      printExpanded(expandedSentence);   // display non-abbreviated message
   }

   /**
    * This method gets and returns the abbreviated text message to be decoded from the user input.
    *
    * @param scnr allows access to user input
    * @return abbreviated text message input
    */
   public static String getText(Scanner scnr) {
      System.out.println("Input the text you'd like to decode below followed by the enter key:");
      String text = scnr.nextLine();

      return text;
   }

   /**
    * This method decodes the abbreviated text message and returns the expanded version.
    *
    * @param userString abbreviated text message
    * @return decoded text message
    */
   public static String expandAbbreviation(String userString) {
      String expandedText = userString;
      System.out.println();

      //check message for each abbreviated form and replace with non-abbreviated form
      if (expandedText.contains("BFF")) {
         expandedText = expandedText.replace("BFF", BEST_FRIEND_FOREVER);
         System.out.println("Replacing \"BFF\" with \"best friend forever\"");
      }
      if (expandedText.contains("BTE")) {
         expandedText = expandedText.replace("BTE", BLOW_THE_EXAM);
         System.out.println("Replacing \"BTE\" with \"blow the exam\"");
      }
      if (expandedText.contains("IDK")) {
         expandedText = expandedText.replace("IDK", I_DONT_KNOW);
         System.out.println("Replacing \"IDK\" with \"I don't know\"");
      }
      if (expandedText.contains("STT")) {
         expandedText = expandedText.replace("STT", SPILL_THE_TEA);
         System.out.println("Replacing \"STT\" with \"spill the tea\"");
      }
      if (expandedText.equals(userString)) {    //checks if no changes have been made to OG text
         System.out.println("Could not find any SMS abbreviations I know to expand.");
      }
      System.out.println();

      return expandedText;
   }

   /**
    * This method displays the expanded / non-abbreviated text message.
    *
    * @param result decoded text message
    */
   public static void printExpanded(String result) {
      System.out.println("Expanded: " + result);
   }
}
