import java.text.DecimalFormat;

/**
 * Creates Car objects.
 * Activity 5
 * @author Ryan Nguyen
 * @version 9/11/17
 */

public class Car extends Vehicle
{
   
   /**
    * Constant for tax rate.
    */
   public static final double TAX_RATE = 0.01;
   
   /**
    * Constant for alternative fuel tax rate.
    */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.005;
   
   /**
    * Constant for luxury threshold.
    */
   public static final double LUXURY_THRESHOLD = 50000;
   
   /**
    * Constant for luxury tax rate.
    */
   public static final double LUXURY_TAX_RATE = 0.02;
   
   static final DecimalFormat FORM = new DecimalFormat("$#,##0.00#");
   
   /**
    * Constructs the Car objects.
    * @param ownerIn changes the owner.
    * @param yearMakeModelIn changes the yearMakeModel.
    * @param valueIn changes the value.
    * @param altFuelIn changes the altFuel.
    */

   public Car(String ownerIn, String yearMakeModelIn,
      double valueIn, boolean altFuelIn) 
      throws NegativeValueException {
      
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
      
   }
   
   /**
    * Calculates the amount of dollars owed for tax.
    * @return the amount of dollars for tax
    */
   public double useTax()
   {
   
      double totalTaxRate = TAX_RATE;
      
      if (this.altFuel)
      {
      
         totalTaxRate = ALTERNATIVE_FUEL_TAX_RATE;
      
      }
      
      if (this.value > LUXURY_THRESHOLD)
      {
      
         totalTaxRate += LUXURY_TAX_RATE;
      
      }
      
      return totalTaxRate * value;
      
      
   }
   
   /**
    * Override for the toString method.
    * @return the string equivalent of the object.
    */
   public String toString()
   {
   
      return super.toString() 
         + " Use Tax: " + FORM.format(this.useTax())
         + "\nwith Tax Rate: " 
         + (altFuel ? ALTERNATIVE_FUEL_TAX_RATE : TAX_RATE) 
         + (this.value > LUXURY_THRESHOLD 
            ? " Luxury Tax Rate: " + LUXURY_TAX_RATE : "");
   
   }

}
