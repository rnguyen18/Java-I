import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
 * Tests the UseTaxList.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */

public class UseTaxListTest {

   private UseTaxList taxList;
   private double delta = 0.00001;

   /** Fixture initialization (common initialization
    *  for all tests). 
    * @throws FileNotFoundException for reading files.
    **/
   @Before public void setUp() 
      throws FileNotFoundException {
   
      Vehicle.resetVehicleCount();
      
      taxList = new UseTaxList();
      
      taxList.readVehicleFile("vehicles1.txt");
         
   }
   
   /**
    * Testing the getterSetter Methods.
    * @throws NegativeValueException  to make cars
    */
   @Test public void getterSetters() 
      throws NegativeValueException {
      
      Assert.assertEquals("Tax District 52", 
         taxList.getTaxDistrict());
      taxList.setTaxDistrict("Le, Peter");
      Assert.assertEquals("Le, Peter", taxList.getTaxDistrict());
      
      taxList.addVehicle(
         new Car("Jon, Frank", "Ryan Mobile", 12315, true));
      Assert.assertEquals("Jon, Frank", 
         taxList.getVehicleList()[8].getOwner());
      
      Assert.assertTrue(
         taxList.excludedRecordsList().contains("Body, Abel; 2015 GMC FE250;"));
      taxList.addExcludedRecord("2004 Ford Mustang");
      Assert.assertEquals("2004 Ford Mustang", 
         taxList.getExcludedRecords()[2]);
      
   }
   
   /**
    * Testing the printlns.
    * @throws NegativeValueException to make cars
    */
   @Test public void printlns()
      throws NegativeValueException {
      
      taxList.addVehicle(
         new Car("Jon, Frank", "Ryan Mobile", 1, true));
      taxList.addVehicle(
         new Car("Jon, Frank", "Ryan Mobile", 1, true));
      Assert.assertTrue(taxList.summary().contains(""));
      Assert.assertTrue(taxList.listByOwner().contains(""));
      Assert.assertTrue(taxList.listByUseTax().contains(""));
      Assert.assertTrue(taxList.excludedRecordsList().contains(""));
   
   }
   
}
