/* ---------------------------------------------------------------------------------------------- */
// Name: Keshvi Mahalingam
// VUnetID: mahalikj
// Email: keshvi.j.mahalingam@vanderbilt.edu
// Honor statement: I have not given or received unauthorized aid on this assignment.
// Date: 04/11/20
// Description: This is a class representing a store item to be purchased.
/* ---------------------------------------------------------------------------------------------- */

/**
 * A class representing a store item to be purchased.
 */
public class ItemToPurchase {

   private String itemName;      //name of item
   private int itemPrice;        //price of item
   private int itemQuantity;     //quantity of item

   /**
    * Default constructor initializing all fields as empty or 0
    */
   public ItemToPurchase() {
      itemName = "";
      itemPrice = 0;
      itemQuantity = 0;
   }

   /**
    * Returns the name of an item
    *
    * @return -- String representing the item name
    */
   public String getName() {
      return itemName;
   }

   /**
    * Sets the name of an item
    *
    * @param itemName -- String representing the item name
    */
   public void setName(String itemName) {
      this.itemName = itemName;
   }

   /**
    * Returns the price of an item
    *
    * @return -- int value representing the item price
    */
   public int getPrice() {
      return itemPrice;
   }

   /**
    * Sets the price of an item
    *
    * @param itemPrice -- int value representing the item price
    */
   public void setPrice(int itemPrice) {
      this.itemPrice = itemPrice;
   }

   /**
    * Returns the quantity of an item
    *
    * @return -- int value representing the item quantity
    */
   public int getQuantity() {
      return itemQuantity;
   }

   /**
    * Sets the quantity of an item
    *
    * @param itemQuantity -- int value representing the item quantity
    */
   public void setQuantity(int itemQuantity) {
      this.itemQuantity = itemQuantity;
   }
}
