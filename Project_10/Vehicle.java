import java.text.DecimalFormat;

/**
 * Setting up vehicle abstract class.
 * Project 10
 * @author Ryan Nguyen
 * @version 11/29/17
 */

public abstract class Vehicle implements Comparable<Vehicle>
{
   protected String owner = "";
   protected String yearMakeModel = "";
   protected double value = 0;
   protected boolean altFuel = false;
   private static int vehicleCount = 0;
   static final DecimalFormat FORM = new DecimalFormat("$#,##0.00#");
   /**
    * Sets up vehicle abstract class.
    * @param ownerIn changes the owner.
    * @param yearMakeModelIn changes the yearMakeModel.
    * @param valueIn changes the value.
    * @param altFuelIn changes the altFuel.
    */

   public Vehicle(String ownerIn, String yearMakeModelIn,
      double valueIn, boolean altFuelIn) 
   {
   
      owner = ownerIn;
      yearMakeModel = yearMakeModelIn;
      value = valueIn;
      altFuel = altFuelIn;
      
      vehicleCount++;
      
   }
   
   /**
    * Returns the owner of the vehicle.
    * @return Returns the owner variable.
    */
   public String getOwner()
   {
   
      return owner;
   
   }
   
   /**
    * Sets the owner of the vehicle.
    * @param ownerIn changes the owner.
    */
   public void setOwner(String ownerIn)
   {
   
      this.owner = ownerIn;
   
   }
   
   /**
    * Returns the YearMakeModel of the vehicle.
    * @return Returns the YearMakeModel variable.
    */
   public String getYearMakeModel()
   {
   
      return yearMakeModel;
   
   }
   
   /**
    * Sets the YearMakeModel of the vehicle.
    * @param yearMakeModelIn changes the YearMakeModel.
    */
   public void setYearMakeModel(String yearMakeModelIn)
   {
   
      yearMakeModel = yearMakeModelIn;
   
   }
   
   /**
    * Returns the value of the vehicle.
    * @return Returns the value variable.
    */
   public double getValue()
   {
   
      return value;
   
   }
   
   /**
    * Sets the value of the vehicle.
    * @param valueIn changes the value.
    */
   public void setValue(double valueIn)
   {
   
      value = valueIn;
   
   }
   
   /**
    * Returns the AlternativeFuel of the vehicle.
    * @return Returns the altFuel variable.
    */
   public boolean getAlternativeFuel()
   {
   
      return altFuel;
   
   }
   
   /**
    * Sets the AlternativeFuel of the vehicle.
    * @param altFuelIn changes the altFuel.
    */
   public void setAlternativeFuel(boolean altFuelIn)
   {
   
      altFuel = altFuelIn;
   
   }
   
   /**
    * Returns the vehicleCount of the vehicle.
    * @return Returns the vehicleCount variable.
    */
   public static int getVehicleCount()
   {
   
      return vehicleCount;
   
   }
   
   /**
    * Sets the vehicleCount variable to 0.
    */
   public static void resetVehicleCount()
   {
   
      vehicleCount = 0;
   
   }
    
   /**
    * Compares two vehicles.
    * @param vehicleIn the vehicle to compare with.
    * @return An int based on the comparison result.
    */
   public int compareTo(Vehicle vehicleIn)
   {
    
      return this.getOwner().compareTo(vehicleIn.getOwner());
    
   }
   
   /**
    * abstract class for using tax.
    * @return returns the amount in tax owed.
    */
   public abstract double useTax();
   
   /**
    * Returns the string equivalent of this object.
    * @return returns the string of the object.
    */
    
   public String toString()
   {
   
      return owner + ": " + this.getClass().getName() 
         + " " + yearMakeModel 
         + (altFuel ? " (Alternative Fuel)" : "") 
         + "\nValue: " + FORM.format(value);
   
   }

}