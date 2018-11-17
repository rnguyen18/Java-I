import org.junit.Assert;
// import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the car class aswell as the vehicle class.
 * Project 11
 * @author Ryan Nguyen
 * @version 12/6/17
 */

public class CarTest {

   private Car car1, car2, car3, car4;
   private double delta = 0.00001;

   /** Fixture initialization (common initialization
    *  for all tests). 
    * @throws NegativeValueException to make cars.
    */
   @Before public void setUp() 
      throws NegativeValueException {
   
      Vehicle.resetVehicleCount();
      
      car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe",
         110000, false);
      car4 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
         110000, true);
         
   }
   
   /**
    * Testing the getterSetter Methods.
    */
   @Test public void getterSetters() 
   {
      
      Assert.assertEquals("Jones, Sam", car1.getOwner());
      car1.setOwner("Le, Peter");
      Assert.assertEquals("Le, Peter", car1.getOwner());
      
      Assert.assertEquals("2017 Honda Accord", car2.getYearMakeModel());
      car2.setYearMakeModel("2004 Ford Mustang");
      Assert.assertEquals("2004 Ford Mustang", car2.getYearMakeModel());
      
      Assert.assertEquals(110000, car3.getValue(), delta);
      car3.setValue(25000);
      Assert.assertEquals(25000, car3.getValue(), delta);
      
      Assert.assertTrue(car4.getAlternativeFuel());
      car4.setAlternativeFuel(false);
      Assert.assertFalse(car4.getAlternativeFuel());
   }

   /**
    * Testing the VehicleCount Methods.
    * @throws NegativeValueException to make car.
    */
   @Test public void vehicleCount() 
      throws NegativeValueException {
      
      Assert.assertEquals(4, Vehicle.getVehicleCount());
      
      Car car5 = new Car("Wietlake, Tyler", "Jaguar XKSS", 58000000, false);
     
      Assert.assertEquals(5, Vehicle.getVehicleCount());
      
      Vehicle.resetVehicleCount();
      
      Assert.assertEquals(0, Vehicle.getVehicleCount());
      
      try 
      {
      
         Car car6 = new Car("Farlow, Maxwell", "Hudson Hornet", -100.00, true);
      
      }
      
      catch (NegativeValueException e)
      {
      
         Assert.assertTrue(true);
      
      }
   }
   
   /**
    * Testing the useTax.
    */
   @Test public void useTax() 
   {
   
      Assert.assertEquals(220.00, car1.useTax(), delta);
         
      Assert.assertEquals(110.00, car2.useTax(), delta);
            
      Assert.assertEquals(3300.00, car3.useTax(), delta);
   
      Assert.assertEquals(2750.00, car4.useTax(), delta);
      
   }

   /**
    * Testing the toString.
    */
   @Test public void toStringTest() 
   {
   
      Assert.assertEquals("Jones, Sam: Car 2017 Honda Accord" 
         + "\nValue: $22,000.00 Use Tax: $220.00" 
         + "\nwith Tax Rate: 0.01", car1.toString());
         
      Assert.assertEquals("Jones, Jo: Car 2017 Honda Accord (Alternative Fuel)"
            + "\nValue: $22,000.00 Use Tax: $110.00"
            + "\nwith Tax Rate: 0.005", car2.toString());
            
      Assert.assertEquals("Smith, Pat: Car 2015 Mercedes-Benz Coupe"
            + "\nValue: $110,000.00 Use Tax: $3,300.00"
            + "\nwith Tax Rate: 0.01 Luxury Tax Rate: 0.02", car3.toString());
   
      Assert.assertEquals("Smith, Jack: Car 2015 Mercedes-Benz Coupe "
            + "(Alternative Fuel)\nValue: $110,000.00 Use Tax: $2,750.00"
            + "\nwith Tax Rate: 0.005 Luxury Tax Rate: 0.02", car4.toString());
      
   }
   
   /**
    * Tests the equals method.
    */
   @Test public void equalsTest()
   {
      
      Assert.assertFalse(car1.equals(car2));
      
      Assert.assertTrue(car1.equals(car1));
      
      Assert.assertFalse(car1.equals("MAX IS COOL!"));
      
      Assert.assertEquals(0, car1.hashCode());
   
   }
}
