import java.io.FileNotFoundException;


/**
 * Main file to run UseTaxList.
 * Project 10
 * @author Ryan Nguyen
 * @version 11/27/17
 */

public class VehiclesPart2 
{

   /**
    * Runs the Usetax List.
    * @param args Command line arguments (not used).
    * @throws FileNotFoundException in order to read files.
    */

   public static void main(String[] args) 
      throws FileNotFoundException {
      
      UseTaxList t = new UseTaxList();
      t.readVehicleFile("vehicles1.txt");
      System.out.println(t.summary() + "\n");
      System.out.println(t.listByOwner() + "\n");
      System.out.println(t.listByUseTax() + "\n");
      System.out.println(t.excludedRecordsList());
      
   }


}