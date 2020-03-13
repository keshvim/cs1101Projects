/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/20/2020
// Description: This program prompts the user for a monthly payment amount between 250-850
// (inclusive), checks if the input is within this range, and displays a mortgage schedule, the
// payoff amount for the final month, and the total paid and total interest paid over 24 months
// if the input is valid.
/* ---------------------------------------------------------------------------------------------- */

import java.util.Scanner;  //allows access to user input

public class GreatPlainsLoanCalculator {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      double monthly = getMonthlyPayment(keyboard);   //gets and assigns monthly payment amount

      //validates input for monthly payment amount
      if (monthly >= 250 && monthly <= 850) {
         printMortgageSchedule(monthly);        //displays mortgage schedule, final payment, etc.
      } else {
         System.out.println("Monthly payment must be $250-$850. Program cannot continue.");
      }
   }

   /**
    * This method gets and returns the monthly payment amount from user input.
    *
    * @param scnr allows access to user input
    * @return monthly payment amount
    */
   public static double getMonthlyPayment(Scanner scnr) {
      System.out.println("Enter the amount you will pay every month on the line below:");
      double monthly = scnr.nextDouble();
      return monthly;
   }

   /**
    * This method displays the payment report heading.
    */
   public static void printReportHeading() {
      System.out.println("\nMortgage Payment Schedule");
      System.out.println("--------------------------");
      System.out.println("Amount borrowed: $5000\n");
   }

   /**
    * This method displays the final payoff amount for the loan, as well as the total amount paid
    * and total interest paid over 24 months.
    *
    * @param remainingDue        payoff amount for the final month
    * @param interestForTheMonth interest for the final month
    * @param totalInterest       total interest paid over 24 months
    * @param totalPaid           total amount paid over 24 months
    */
   public static void printFinalPayment(double remainingDue, double interestForTheMonth,
                                        double totalInterest, double totalPaid) {
      System.out.printf("\nFinal payment: $%,8.2f\n", remainingDue);
      System.out.printf("Total paid over 24 months: $%,8.2f\n", totalPaid);
      System.out.printf("Total interest paid: $%,8.2f\n", totalInterest);
      System.out.println("\nThank you for your business...at Great Plains Loans, we treat you " +
            "like family!");
   }

   /**
    * This method displays the payment report heading, a table of scheduled payments, and the
    * last payoff amount due as well as the total amount paid and the total interest paid over 24
    * months.
    *
    * @param amount monthly payment amount
    */
   public static void printMortgageSchedule(double amount) {
      double interestForTheMonth = 0, balance = 0, remainingDue = 5000;
      double totalInterest = 0, totalPaid = 0;  //total amount paid, interest paid over 24 months

      //display payment report heading and table column headings
      printReportHeading();
      System.out.println("Month\t\tInt.\t\tBalance\t\t\tPayment\t\t\tRemaining");

      //calculate table values and display table
      for (int i = 1; i <= 24; i++) {
         interestForTheMonth = (2 * remainingDue) / 12;  //calculate interest for the month
         balance = remainingDue + interestForTheMonth;   //add interest to current balance
         totalInterest += interestForTheMonth;           //sum up monthly interests

         System.out.printf("%3d", i);     //display row number

         if (i != 24) {
            remainingDue = balance - amount;    //subtract monthly payment from balance
            totalPaid += amount;                //sum up monthly payments

            System.out.printf("\t\t%,9.2f", interestForTheMonth);
            System.out.printf("\t\t%,9.2f", balance);
            System.out.printf("\t\t%6.2f", amount);
            System.out.printf("\t\t%,9.2f\n", remainingDue);
         } else {
            remainingDue = balance;    //final payoff amount = final balance
            totalPaid += balance;      //add final payment to sum of monthly payments

            System.out.println("\t\tSee final payment info below");
         }
      }

      //display final payoff amount, total amount paid, total interest paid
      printFinalPayment(remainingDue, interestForTheMonth, totalInterest, totalPaid);
   }
}
