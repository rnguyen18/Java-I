import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the VehiclesPart2.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */

public class VehiclesPart3Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /**
    * Tests the main.
    **/
   @Test public void mainTest() 
   {
      
      String[] args = new String[0];
      VehiclesPart3 vPart3Obj = new VehiclesPart3();
      VehiclesPart3.main(args);
      Vehicle.resetVehicleCount();
      args = new String[1];
      args[0] = "vehicles2.txt";
      VehiclesPart3.main(args);
      Assert.assertEquals(8, Vehicle.getVehicleCount());
      
      args[0] = "hahanofileheredumbo.txt";
      
      VehiclesPart3.main(args);
   
   }
}
