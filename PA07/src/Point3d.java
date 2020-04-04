// Name:  Dan Arena
// Class: CS 1101 - Vanderbilt University
// Date: 3/3/2020
// Description:  Point3d is a simple class to allow students to work with x, y and z coordinates in the Baby Yoda PA

public class Point3d {
   // Private variables
   private int x; // x coordinate; no restrictions
   private int y; // y coordinate; no restrictions
   private int z; // z coordinate; no restrictions

   //default constructor
   public Point3d() {
      x = 0;
      y = 0;
      z = 0;
   }

   //overloaded constructor
   public Point3d(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   //accessor methods for x, y, z
   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }

   public int getZ() {
      return z;
   }

   // mutator methods for x, y, z
   public void setX(int value) {
      x = value;
   }

   public void setY(int value) {
      y = value;
   }

   public void setZ(int value) {
      z = value;
   }

   //increase the current x, y, z by coordinates by the values supplied
   public Point3d add(int a, int b, int c) {
      this.x = x + a;
      this.y = y + b;
      this.z = z + c;
      return this;
   }

   //override equals method so .equals() command works properly
   public boolean equals(Object other) {
      if (other instanceof Point3d) {
         Point3d otherObj = (Point3d) other;
         return ((this.x == otherObj.x) && (this.y == otherObj.y) && (this.z == otherObj.z));
      } else {
         return false; //objects not equal or not comparable
      }
   }

   //override toString to have an easy way to print Baby Yoda's position
   public String toString() {
      return ("(" + this.x + ", " + this.y + ", " + this.z + ")");
   }

} //end class