import java.text.DecimalFormat;

/**
 * Creates Truck objects.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */

public class Truck extends Vehicle
{

   protected double tonage = 0;
   static final DecimalFormat FORM = new DecimalFormat("$#,##0.00#");
   
   /**
    * Constant for tax rate.
    */
   public static final double TAX_RATE = 0.02;
   
   /**
    * Constant for alternative fuel tax rate.
    */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.01;
   
   /**
    * Constant for large truck tons threshold.
    */
   public static final double LARGE_TRUCK_TONS_THRESHOLD = 2.0;
   
   /**
    * Constant for large truck tax rate.
    */
   public static final double LARGE_TRUCK_TAX_RATE = 0.03;
      
   /**
    * Constructs the Car objects.
    * @param ownerIn changes the owner.
    * @param yearMakeModelIn changes the yearMakeModel.
    * @param valueIn changes the value.
    * @param altFuelIn changes the altFuel.
    * @param tonageIn changes the tonage.
    * @throws NegativeValueException so tonage not neg.
    */

   public Truck(String ownerIn, String yearMakeModelIn,
      double valueIn, boolean altFuelIn, double tonageIn) 
      throws NegativeValueException {
   
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
   
      if (tonageIn >= 0)
      {
         
         tonage = tonageIn;
         
      } else {
         
         vehicleCount--;
         throw new NegativeValueException();
         
      }
   
      
   }
   
   /**
    * Returns the variable tonage.
    * @return the value for variable tonage.
    */
   public double getTons()
   {
   
      return tonage;
   
   }
   
   /**
    * Changes the variable tonage's value.
    * @param tonageIn value tonage is changed to.
    */
   public void setTons(double tonageIn)
   {
   
      tonage = tonageIn;
   
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
      
      if (this.tonage > LARGE_TRUCK_TONS_THRESHOLD)
      {
      
         totalTaxRate += LARGE_TRUCK_TAX_RATE;
      
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
         + (this.tonage > LARGE_TRUCK_TONS_THRESHOLD 
            ? " Large Truck Tax Rate: " + LARGE_TRUCK_TAX_RATE : "");
   
   }

}
