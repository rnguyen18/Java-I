import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Truck class.
 * Project 09
 * @author Ryan Nguyen
 * @version 11/17/17
 */
public class TruckTest {

   private Truck truck1, truck2;
   private double delta = 0.00001;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   
      Vehicle.resetVehicleCount();
      
      truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);
      
      truck2 = new Truck("Williams, Sam", "2010 Chevy Mack",
         40000, true, 2.5);
         
         
   }
   
   /**
    * Testing the getterSetter Methods.
    */
   @Test public void getterSetters() 
   {
      
      Assert.assertEquals(1.5, truck1.getTons(), delta);
      truck1.setTons(3);
      Assert.assertEquals(3, truck1.getTons(), delta);
      
   }
   
   /**
    * Testing the useTax.
    */
   @Test public void useTax() 
   {
   
      Assert.assertEquals(600.00, truck1.useTax(), delta);
         
      Assert.assertEquals(1600.00, truck2.useTax(), delta);
      
   }

   /**
    * Testing the toString.
    */
   @Test public void toStringTest() 
   {
     
      Assert.assertEquals("Williams, Jo: Truck 2012 Chevy Silverado"
            + "\nValue: $30,000.00 Use Tax: $600.00"
            + "\nwith Tax Rate: 0.02", 
            truck1.toString());
      
      
      Assert.assertEquals("Williams, Sam: " 
               + "Truck 2010 Chevy Mack (Alternative Fuel)"
               + "\nValue: $40,000.00 Use Tax: $1,600.00"
               + "\nwith Tax Rate: 0.01 Large Truck Tax Rate: 0.03", 
               truck2.toString());
      
   }
}
