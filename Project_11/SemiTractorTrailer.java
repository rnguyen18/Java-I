import java.text.DecimalFormat;

/**
 * Creates SemiTractorTrailer objects.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */

public class SemiTractorTrailer extends Truck
{

   protected int axles = 0;
   static final DecimalFormat FORM = new DecimalFormat("$#,##0.00#");
   
   /**
    * Constant for axles tax rate.
    */
   public static final double PER_AXLE_TAX_RATE = 0.005;
      
   /**
    * Constructs the SemiTractorTrailer objects.
    * @param ownerIn changes the owner.
    * @param yearMakeModelIn changes the yearMakeModel.
    * @param valueIn changes the value.
    * @param altFuelIn changes the altFuel.
    * @param tonageIn changes the tonage.
    * @param axlesIn changes the axles.
    * @throws NegativeValueException so axles not neg.
    */

   public SemiTractorTrailer(String ownerIn, String yearMakeModelIn,
      double valueIn, boolean altFuelIn, double tonageIn, int axlesIn) 
      throws NegativeValueException {
   
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn, tonageIn);
      
      if (axlesIn >= 0)
      {
      
         axles = axlesIn;
      
      } else {
      
         vehicleCount--;
         throw new NegativeValueException();
      
      }
      
   }
   
   /**
    * Returns the variable axles.
    * @return the value for variable axles.
    */
   public int getAxles()
   {
   
      return axles;
   
   }
   
   /**
    * Changes the variable axles's value.
    * @param axlesIn value axles is changed to.
    */
   public void setAxles(int axlesIn)
   {
   
      axles = axlesIn;
   
   }
   
   /**
    * Calculates the amount of dollars owed for tax.
    * @return the amount of dollars for tax
    */
   public double useTax()
   {
   
      return super.useTax() 
         + (value * PER_AXLE_TAX_RATE * axles);
      
   }
   
   /**
    * Override for the toString method.
    * @return the string equivalent of the object.
    */
   public String toString()
   {
   
      return super.toString()
         + " Axle Tax Rate: " + (PER_AXLE_TAX_RATE * axles);
   
   }

}
