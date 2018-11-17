import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the SemiTractorTrailer class.
 * Project 09
 * @author Ryan Nguyen
 * @version 11/17/17
 */
public class SemiTractorTrailerTest {

   private SemiTractorTrailer semiTractorTrailer1; // , semiTractorTrailer2;
   private double delta = 0.00001;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   
      Vehicle.resetVehicleCount();
      
      semiTractorTrailer1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy", 45000, false, 5.0, 4);
      
      /*
      semiTractorTrailer2 = new SemiTractorTrailer("Williams, Sam", 
         "2010 Chevy Mack", 40000, true, 1.5, 4);
      */
         
   }
   
   /**
    * Testing the getterSetter Methods.
    */
   @Test public void getterSetters() 
   {
      
      Assert.assertEquals(4, semiTractorTrailer1.getAxles());
      semiTractorTrailer1.setAxles(3);
      Assert.assertEquals(3, semiTractorTrailer1.getAxles());
      
   }
   
   /**
    * Testing the useTax.
    */
   @Test public void useTax() 
   {
   
      Assert.assertEquals(3150, semiTractorTrailer1.useTax(), delta);
         
      // Assert.assertEquals(1600.00, semiTractorTrailer2.useTax(), delta);
      
   }

   /**
    * Testing the toString.
    */
   @Test public void toStringTest() 
   {
     
      Assert.assertEquals("Williams, Pat: SemiTractorTrailer 2012 International"
                  + " Big Boy\nValue: $45,000.00 Use Tax: $3,150.00"
                  + "\nwith Tax Rate: 0.02 Large Truck "
                  + "Tax Rate: 0.03 Axle Tax Rate: 0.02", 
                  semiTractorTrailer1.toString());
        
      /*    
      Assert.assertEquals(
      "Williams, Sam: Truck 2010 Chevy Mack (Alternative Fuel)"
               + "\nValue: $40,000.00 Use Tax: $1,600.00"
               + "\nwith Tax Rate: 0.01 Large Truck Tax Rate: 0.03 ", 
               semiTractorTrailer2.toString());
      */
      
   }
}
