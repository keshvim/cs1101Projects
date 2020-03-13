/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 02/18/20
// Description: This program is a practice exercise for using IntelliJ.
/* ---------------------------------------------------------------------------------------------- */

public class Practice {
   public static void main(String[] args) {

      //TODO: Copy this comment into your class
      for (int i = 1; i <= 4 * (5 + 4); i += 6) {
         System.out.println("Bret?");
         System.out.println(
               "Present");
         for (int j = 0; j < i / 5; j++) {
            System.out.println("Yay repetition");
         }
         int
               somenumber = 0;
         for (int y = 9; y > 5; y--) {
            somenumber++;
         }
         System.out.println(somenumber);
      }
      System.out.println("done");

      int max = findMax(6, 9, 2);
   }

   /**
    * This method serves as an example for Java documentation.
    *
    * @param a              - int a
    * @param b              - int b
    * @param c              - double c
    * @param name           - String name
    * @param isBowieInSpace - boolean isBowieInSpace
    * @return - whether the first letter of the name is capitalized AND either a does not equal b
    * OR truncated c equals b AND isBowieInSpace is not true
    */
   public static boolean javadocExampleMethod(int a, int b, double c, String name,
                                              boolean isBowieInSpace) {
      return (name.charAt(0) == name.toUpperCase().charAt(0)) && ((a != b) || ((int) c == b))
            && !isBowieInSpace;
   }

   /**
    * This method is supposed to find the maximum of three int parameters and prints out that
    * value. However, there are some bugs!
    *
    * @param y - int y
    * @param x - int x
    * @param z - int z
    * @return - the max of the three parameters
    */
   public static int findMax(int y, int x, int z) {

      if ((x >= y && y >= z) && (x >= z && z >= y)) {    //FIXME: change '&&' to '||'
         System.out.println("The max is " + x + "!");
         return x;
      } else if ((y >= x && x <= z) || (y >= z && z >= x)) {
         System.out.println("The max is " + y + "!");
         return y;
      } else {
         System.out.println("The max is " + z + "!");
         return z;
      }
   }
}
