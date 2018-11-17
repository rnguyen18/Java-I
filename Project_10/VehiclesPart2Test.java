import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
 * Tests the VehiclesPart2.
 * Project 10
 * @author Ryan Nguyen
 * @version 11/27/17
 */

public class VehiclesPart2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /**
    * Tests the main.
    * @throws FileNotFoundException for reading files.
    **/
   @Test public void mainTest() 
      throws FileNotFoundException {
   
      VehiclesPart2 vPart2Obj = new VehiclesPart2(); // test constructor
      Vehicle.resetVehicleCount();
      String[] args = {"vehicles1.txt"};
      VehiclesPart2.main(args);
      Assert.assertEquals(8, Vehicle.getVehicleCount());
   
   }
}
