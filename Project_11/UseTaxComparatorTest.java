import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the usetaxcomparator.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */

public class UseTaxComparatorTest {

   private Car car1, car2;

   /** Fixture initialization (common initialization
    *  for all tests). 
    * @throws NegativeValueException to make cars.
    */
   @Before public void setUp() 
      throws NegativeValueException {
   
      car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
   
   }


   /**
    * Testing the compareTo.
    */
   @Test public void compareToTest()
   {
   
      Assert.assertEquals(9, car1.compareTo(car2));
      
      Assert.assertEquals(0, car1.compareTo(car1));
      
      Assert.assertEquals(-9, car2.compareTo(car1));
      
   }
}
