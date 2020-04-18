/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 04/11/20
// Description: This program reads and validates an input file of tweets and displays monthly and
// grand totals for tweets mentioning coronavirus.
/* ---------------------------------------------------------------------------------------------- */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TweetAnalytics {

   private static final String INPUT_FILENAME = "TrumpTweetsJanuary-March2020.csv";
   private static final int NUM_FIELDS = 6;

   public static void main(String[] args) throws FileNotFoundException {
      Scanner scnr = new Scanner(System.in);

      //create array to hold tweet fields
      String[] tweetField = new String[NUM_FIELDS];

      //prompt user for path
      System.out.println("Enter path for file \"TrumpTweetsJanuary-March2020.csv\" (e.g., " +
            "iofiles/)?");
      String path = scnr.nextLine().trim();
      File file = new File(path + INPUT_FILENAME);

      //validate path input
      while (!file.exists()) {
         System.out.println("Cannot find file at that location. Please try again");

         System.out.println("\nEnter path for file \"TrumpTweetsJanuary-March2020.csv\" (e.g., " +
               "iofiles/)?");
         path = scnr.nextLine().trim();
         file = new File(path + INPUT_FILENAME);
      }
      System.out.println(INPUT_FILENAME + " successfully found.");

      //create secondary scanner pointing to input file
      Scanner fileScan = new Scanner(file);

      //validate tweets and display stats
      processFile(fileScan, tweetField);
   }

   /**
    * getMonth -
    * Returns the month of a tweet.
    *
    * @param dateStr -- String representing the date and time of the tweet
    * @return -- int value representing the month of the tweet
    */
   public static int getMonth(String dateStr) {
      String[] dateField = dateStr.split("/");

      return Integer.parseInt(dateField[0]);
   }

   /**
    * isValidTweetID -
    * Returns whether a tweet ID number is valid.
    *
    * @param tweetID -- String representing tweet ID number
    * @return -- boolean value representing whether or not the tweet ID number is valid
    */
   public static boolean isValidTweetID(String tweetID) {
      boolean isValidID = true;

      if (tweetID.length() == 0) {
         isValidID = false;
      } else {

         //check if each character is a digit
         for (int i = 0; i < tweetID.length(); ++i) {
            if (!Character.isDigit(tweetID.charAt(i))) {
               isValidID = false;
            }
         }
      }

      return isValidID;  //false if does not contain all digits
   }

   /**
    * mentionsCorona -
    * Returns whether a tweet mentions coronavirus.
    *
    * @param tweet -- String representing tweet message
    * @return boolean value representing whether or not the tweet mentions coronavirus
    */
   public static boolean mentionsCorona(String tweet) {
      boolean containsCovid = false;
      tweet = tweet.toLowerCase();     //convert tweet to lowercase

      //check if tweet mentions coronavirus
      if (tweet.contains("virus") || tweet.contains("corona") || tweet.contains("covid")) {
         containsCovid = true;
      }

      return containsCovid;
   }

   /**
    * displayMonthTotals -
    * Displays the total number of tweets, number of tweets mentioning coronavirus, and percent of
    * tweets mentioning coronavirus for each month.
    *
    * @param month      -- int value representing month of tweets
    * @param tweetCount -- int value representing number of tweets in month
    * @param covidCount -- int value representing number of tweets mentioning coronavirus in month
    */
   public static void displayMonthTotals(int month, int tweetCount, int covidCount) {
      System.out.println("Month (1-12): " + month);
      System.out.println("Number of Tweets: " + tweetCount);
      System.out.println("Number of virus/covid/corona tweets: " + covidCount);

      //calculate and display percent of tweets mentioning coronavirus
      double percentCovid = (double) covidCount / tweetCount * 100.0;
      System.out.printf("Percentage of mentions: %4.2f%s", percentCovid, "%\n\n");
   }

   /**
    * Displays the total # of tweets, most retweeted tweet, and highest # of retweets.
    *
    * @param totalTweets   -- int value representing total number of tweets
    * @param mostRetweeted -- String array holding the tweet with the most retweets
    */
   public static void displayGrandTotals(int totalTweets, String[] mostRetweeted) {
      System.out.println("Total tweets = " + totalTweets);
      System.out.println("Max retweet: " + mostRetweeted[2] + " Count: " + mostRetweeted[4]);
   }

   /**
    * processFile -
    * Validates the input file of tweets and displays monthly and grand total stats
    *
    * @param fileScan   -- Scanner object pointing to input file
    * @param tweetField -- String array for holding all fields of a tweet
    */
   public static void processFile(Scanner fileScan, String[] tweetField) {
      int tweetCount = 0, covidTweetCount = 0, totalTweets = 0;
      int month = 0;

      tweetField = fileScan.nextLine().split(",");    //get fields of first in file

      int savedMonth = getMonth(tweetField[3]);
      String[] mostRetweeted = tweetField;            //initialize mostRetweeted to first tweet

      //check if tweet ID is numeric
      if (isValidTweetID(tweetField[1])) {
         ++tweetCount;
         ++totalTweets;

         //check if tweet mentions coronavirus
         if (mentionsCorona(tweetField[2])) {
            ++covidTweetCount;
         }
      }

      //process input file
      while (fileScan.hasNextLine()) {
         tweetField = fileScan.nextLine().split(",");    //update array of tweet fields

         month = getMonth(tweetField[3]);

         //update month and display totals
         if (savedMonth != month) {          //check if new month reached
            displayMonthTotals(savedMonth, tweetCount, covidTweetCount);
            tweetCount = 0;
            covidTweetCount = 0;
            savedMonth = month;
         }

         //update total number of tweets
         if (isValidTweetID(tweetField[1])) {   //check if tweet ID is numeric
            ++tweetCount;
            ++totalTweets;

            //check if tweet mentions coronavirus
            if (mentionsCorona(tweetField[2])) {
               ++covidTweetCount;
            }

            //update mostRetweeted
            if (Integer.parseInt(mostRetweeted[4]) < Integer.parseInt(tweetField[4])) {
               mostRetweeted = tweetField;
            }
         }
      }

      displayMonthTotals(month, tweetCount, covidTweetCount);  //print monthly totals of last month
      displayGrandTotals(totalTweets, mostRetweeted);
   }
}