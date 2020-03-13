/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/27/20
// Description: This program performs two layers of encryption on a user-specified message using
// a user-specified alphabetic shift amount. Then it displays the resulting first-level and
// second-level encrypted messages.
/* ---------------------------------------------------------------------------------------------- */

import java.util.*;

public class TwoLevelEncryption {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      String sentinel = "Y";     //sentinel value that determines if program runs again
      String message;            //message to be encrypted

      //rerun program until sentinel value entered
      while (sentinel.equalsIgnoreCase("Y")) {
         message = getMessage(keyboard);  //message to be encrypted
         int shift = getShift(keyboard);  //alphabetic shift amount

         //perform first and second levels of encryption
         String firstLevelEncoded = firstLevelEncoding(message, shift);
         String secondLevelEncoded = secondLevelEncoding(firstLevelEncoded);

         //display first-level and second-level encrypted messages
         printEncoding("first", firstLevelEncoded);
         printEncoding("second", secondLevelEncoded);

         //ask if user wants to run program again
         System.out.print("\nAgain? (Y/N)? ");
         sentinel = keyboard.next();
         keyboard.nextLine();
      }
   }

   /**
    * This method prompts for and returns the message to be encrypted.
    *
    * @param console access to user input
    * @return message to be encrypted
    */
   public static String getMessage(Scanner console) {
      String message = "";

      //validate message input
      while (message.equals("")) {
         System.out.println("Enter the message you want to encode:");
         message = console.nextLine().trim();

         //reprompt if trimmed message is empty
         if (message.equals("")) {
            System.out.print("Message is required. ");
         }
      }
      return message;
   }

   /**
    * This method prompts for and returns the alphabetic shift number.
    *
    * @param console access to user input
    * @return shift number between -26 and 26 inclusive
    */
   public static int getShift(Scanner console) {
      int shift = 27;

      //validate shift amount
      while (!(shift >= -26 && shift <= 26)) {
         System.out.println("Enter the secret shift amount:");
         shift = console.nextInt();

         //reprompt if shift not within valid range
         if (!(shift >= -26 && shift <= 26)) {
            System.out.print("Shift must be between -26 and 26 inclusive. ");
         }
      }
      System.out.println();

      return shift;
   }

   /**
    * This method shifts the letters in the message by the user-specified shift number and
    * returns the resulting first-level encrypted message.
    *
    * @param text  message to be encrypted
    * @param shift shift number
    * @return first-level encrypted message
    */
   public static String firstLevelEncoding(String text, int shift) {
      text = text.toLowerCase();

      //shift letters in message
      for (char ch = 'a'; ch <= 'z'; ++ch) {
         char newCh = (char) (ch + shift);   //shift each letter in alphabet

         if (newCh > 'z') {
            newCh = (char) (newCh - 26);
         } else if (newCh < 'a') {
            newCh = (char) (newCh + 26);
         }

         //replace each letter in message with shifted letter
         text = text.replace(ch, Character.toUpperCase(newCh));
      }

      return text.toLowerCase();
   }

   /**
    * This method converts the letters in the first-level encrypted message to their corresponding
    * ASCII numbers, separates them into four-digit groups, and returns the resulting
    * second-level encrypted message.
    *
    * @param origEncoding first-level encrypted message
    * @return second-level encrypted message
    */
   public static String secondLevelEncoding(String origEncoding) {
      origEncoding = origEncoding.toUpperCase();
      String asciiSequence = "";    //final encrypted sequence of four digit decimals

      for (int i = 0; i < origEncoding.length(); i = i + 2) {
         int charToDecimal = 0;   //temp for each four-digit decimal to be added to sequence

         //convert every two letters in message into four digit decimal
         for (int j = i; j < i + 2; ++j) {
            int newCh = 0;    //temp for each two-digit decimal val for each letter in message

            if (j != origEncoding.length()) {
               newCh = origEncoding.charAt(j);
            }

            charToDecimal = (charToDecimal * 100) + newCh;  //create four digit decimal
         }

         asciiSequence += charToDecimal + " ";   //add four digit group to final encrypted message
      }

      return asciiSequence.trim();
   }

   /**
    * This method displays an encrypted message and its corresponding level of encryption.
    *
    * @param whichLevel     level of encryption (first or second)
    * @param encodedMessage encrypted message corresponding to level of encryption
    */
   public static void printEncoding(String whichLevel, String encodedMessage) {
      System.out.println("After " + whichLevel + " level encoding the secret message is:" +
            " " + encodedMessage);
   }
}
