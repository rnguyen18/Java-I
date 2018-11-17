import java.text.DecimalFormat;

/**
 * Creates Motorcycle objects.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */

public class Motorcycle extends Vehicle
{
   
   protected double engineSize = 0;
   
   /**
    * Constant for tax rate.
    */
   public static final double TAX_RATE = 0.005;
   
   /**
    * Constant for alternative fuel tax rate.
    */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.0025;
   
   /**
    * Constant for large bike cc threshold.
    */
   public static final double LARGE_BIKE_CC_THRESHOLD = 499;
   
   /**
    * Constant for large bike tax rate.
    */
   public static final double LARGE_BIKE_TAX_RATE = 0.015;
   
   static final DecimalFormat FORM = new DecimalFormat("$#,##0.00#");
   
   /**
    * Constructs the Motorcycle objects.
    * @param ownerIn changes the owner.
    * @param yearMakeModelIn changes the yearMakeModel.
    * @param valueIn changes the value.
    * @param altFuelIn changes the altFuel.
    * @param engineSizeIn changes the engineSize.
    * @throws NegativeValueException so engineSize not neg.
    */
   public Motorcycle(String ownerIn, String yearMakeModelIn,
      double valueIn, boolean altFuelIn, double engineSizeIn) 
      throws NegativeValueException {
      
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
      
      if (engineSizeIn >= 0)
      {
         
         engineSize = engineSizeIn;
         
      } else {
         
         vehicleCount--;
         throw new NegativeValueException();
         
      }
      
   }
   
   /**
    * Returns the variable engineSize.
    * @return the value for variable engineSize.
    */
   public double getEngineSize()
   {
   
      return engineSize;
   
   }
   
   /**
    * Changes the variable axles's value.
    * @param engineSizeIn value axles is changed to.
    */
   public void setEngineSize(double engineSizeIn)
   {
   
      engineSize = engineSizeIn;
   
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
      
      if (this.engineSize > LARGE_BIKE_CC_THRESHOLD)
      {
      
         totalTaxRate += LARGE_BIKE_TAX_RATE;
      
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
         + (this.engineSize > LARGE_BIKE_CC_THRESHOLD 
            ? " Large Bike Tax Rate: " + LARGE_BIKE_TAX_RATE : "");
   
   }

}
