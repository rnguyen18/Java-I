import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Motorcycle class.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */
public class MotorcycleTest {

   private Motorcycle motorcycle1, motorcycle2;
   private double delta = 0.00001;

   /** Fixture initialization (common initialization
    *  for all tests). 
    * @throws NegativeValueException to make motos.
    */
   @Before public void setUp() 
      throws NegativeValueException {
   
      Vehicle.resetVehicleCount();
      
      motorcycle1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster",
         14000, false, 750);
   
      motorcycle2 = new Motorcycle("Williams, Sam", 
         "2010 Chevy Mack", 40000, true, 300);
         
   }
   
   /**
    * Testing the getterSetter Methods.
    */
   @Test public void getEngineSize() 
   {
      
      Assert.assertEquals(750, motorcycle1.getEngineSize(), delta);
      motorcycle1.setEngineSize(500);
      Assert.assertEquals(500, motorcycle1.getEngineSize(), delta);
      
   }
   
   /**
    * Testing the useTax.
    */
   @Test public void useTax() 
   {
   
      Assert.assertEquals(280.00, motorcycle1.useTax(), delta);
      System.out.println(motorcycle2.useTax());
      // Assert.assertEquals(1600.00, semiTractorTrailer2.useTax(), delta);
      
   }
   
   /**
    * Testing the negvalue.
    * @throws NegativeValueException to make a truck.
    */
   @Test public void negvalue() 
      throws NegativeValueException {
   
      Vehicle.resetVehicleCount();
      
      int count = Vehicle.getVehicleCount();
      
      try
      {
         Motorcycle motorcycle3 = new Motorcycle(
            "Farlow, Max", "Triumph Bonneville", -40000, true, 300);
      }
      catch (NegativeValueException e)
      {
      
         Assert.assertTrue(true);
      
      }
      
   }

   /**
    * Testing the toString.
    */
   @Test public void toStringTest() 
   {
     
      Assert.assertEquals("Brando, Marlon: Motorcycle 1964 "
               + "Harley-Davidson Sportster"
                  + "\nValue: $14,000.00 Use Tax: $280.00"
                  + "\nwith Tax Rate: 0.005 "
                  + "Large Bike Tax Rate: 0.015", 
               motorcycle1.toString());
        
        
      Assert.assertEquals(
         "Williams, Sam: Motorcycle 2010 Chevy Mack (Alternative Fuel)"
               + "\nValue: $40,000.00 Use Tax: $100.00"
               + "\nwith Tax Rate: 0.0025", 
               motorcycle2.toString());
      
      
   }
}
